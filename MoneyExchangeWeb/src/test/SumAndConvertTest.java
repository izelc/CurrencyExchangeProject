


import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class  SumAndConvertTest  {
	
	private WebDriver driver;
	   private String baseUrl;
	   
	@Before
	   public void setUp() throws Exception {
	      driver = new FirefoxDriver();
	      baseUrl = "http://localhost:8080/MoneyExchangeWeb/convert-and-sum.html";
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   }
  
	  @Test
	   public void testClickAddButtonWorks() throws Exception {
	      driver.get(baseUrl );
	      driver.findElement(By.id("addentAmountTextBox1")).sendKeys("10");
	      driver.findElement(By.id("addentAmountTextBox2")).sendKeys("10");
	      Select select = new Select(driver.findElement(By.id("addentCurrencyComboBox1")));
	      select.selectByValue("USD");
	      Select select1 = new Select(driver.findElement(By.id("addentCurrencyComboBox2")));
	      select1.selectByValue("USD");
	      Select select2 = new Select(driver.findElement(By.id("resultCurrencyComboBox")));
	      select2.selectByValue("USD");
	     driver.findElement(By.id("addButton")).click();
	     String result=driver.findElement(By.id("resultTextBox")).getAttribute("value");
	      assertEquals("20,00 USD", result);
	   }
	  
		 @Test
			public void resultTextBoxIsReadOnly() throws Exception {
				    driver.get(baseUrl );
				    WebElement element = driver.findElement(By.id("resultTextBox"));
				    String readonly = element.getAttribute("readonly");
				    assertNotNull(readonly);
			}
}
