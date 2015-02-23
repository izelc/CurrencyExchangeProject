


import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class  indexHtmlTest  {
	
	private WebDriver driver;
	   private String baseUrl;
	   @Before
	   public void setUp() throws Exception {
	      driver = new FirefoxDriver();
	      baseUrl = "http://localhost:8080/MoneyExchangeWeb/index.html";
	      driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	   }
	   
	   @Test
	   public void testConvertionIsDoneRight() throws Exception {
		 driver.get(baseUrl );
	      driver.findElement(By.id("amountTextBox")).sendKeys("10");
	      Select select = new Select(driver.findElement(By.id("fromCurrencyComboBox")));
	      select.selectByValue("EUR");
	      Select select2 = new Select(driver.findElement(By.id("toCurrencyComboBox")));
	      select2.selectByValue("USD");
	     driver.findElement(By.id("calculateButton")).click();
	     String result=driver.findElement(By.id("resultTextBox")).getAttribute("value");
	     
	      
	    double expected=10*getParity(getDocument("EURJPY"), findParticularCssPath(1));
	     
	    
	     assertEquals(expected, result);
	   }
  
	  @Test
	   public void testCalculateButtonEventsWorksProperly() throws Exception {
	      driver.get(baseUrl );
	      driver.findElement(By.id("amountTextBox")).sendKeys("10");
	      Select select = new Select(driver.findElement(By.id("fromCurrencyComboBox")));
	      select.selectByValue("USD");
	      Select select2 = new Select(driver.findElement(By.id("toCurrencyComboBox")));
	      select2.selectByValue("USD");
	     driver.findElement(By.id("calculateButton")).click();
	     String result=driver.findElement(By.id("resultTextBox")).getAttribute("value");
	      assertEquals("10.0", result);
	   }
	  
	  
	 @Test
	public void resultTextBoxIsReadOnly() throws Exception {
		    driver.get(baseUrl );
		    WebElement element = driver.findElement(By.id("resultTextBox"));
		    String readonly = element.getAttribute("readonly");
		    assertNotNull(readonly);
	}
	 
	 @Test
	    public void testIntegerAreasDontAcceptNonNumericCharacters() {
		 driver.get(baseUrl );
		  driver.findElement(By.id("amountTextBox")).sendKeys("asdasdsad");
		  String result=driver.findElement(By.id("amountTextBox")).getAttribute("value");

	  assertEquals(result, "");

	}
	 
	 
	
	 
	 
	 public double getParity(Document doc, String cssPath) {
			/*
			 * Connects document to find related parity. Returns the parity that we
			 * search as double.
			 */
			return convertCurrencyDataToDouble(doc.select(cssPath).text());

		}
	 
	 public String findParticularCssPath(int index) {
			String cssPath = "#gf-viewc > div > div > div.g-section.g-tpl-right-1 > div:nth-child(2) > div:nth-child(2) > div.sfe-section > table > tbody > tr:nth-child("
					+ index + ") > td:nth-child(2)";
			return cssPath;
		}

		/**
		 * @param q
		 *            It provides related section of <a
		 *            href='https://www.google.com/finance?q='>google finance</a>
		 * @return the document that contains parities
		 */
		public Document getDocument(String q) {

			String site = "https://www.google.com/finance?q=" + q;
			Document document = null;
			try {
				document = Jsoup.connect(site).get();
			} catch (IOException e) {
      e.printStackTrace();
			}
			return document;
		}

		/**
		 * Removes all non numeric characters in data and then converts data to
		 * double.
		 * 
		 * @param str
		 *            {@link String} that contains both numeric and non numeric
		 *            values.
		 * @return String that cleaned from non numeric values and converted to
		 *         double.
		 */
		public double convertCurrencyDataToDouble(String str) {
			/*
			 * removes all non numeric characters in data and then converts data to
			 * double
			 */
			str = str.replaceAll("[^\\d.]", "");
			return Double.parseDouble(str);
		}

}
