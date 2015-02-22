


import com.thoughtworks.selenium.*;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class  indexHtmlTest  {
	
	private WebDriver driver;
	   private String baseUrl;
	   private boolean acceptNextAlert = true;
	   private StringBuffer verificationErrors = new StringBuffer();
	   
	@Before
	   public void setUp() throws Exception {
	      driver = new FirefoxDriver();
	      baseUrl = "http://localhost:8080/MoneyExchangeWeb/index.html";
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   }
  
	  @Test
	   public void testClickButtonWorks() throws Exception {
	      driver.get(baseUrl );
	      driver.findElement(By.id("amountTextBox")).sendKeys("10");
	      Select select = new Select(driver.findElement(By.id("fromCurrencyComboBox")));
	      select.selectByValue("USD");
	      Select select2 = new Select(driver.findElement(By.id("toCurrencyComboBox")));
	      select2.selectByValue("USD");
	     driver.findElement(By.id("calculateButton")).click();
	   }
}
