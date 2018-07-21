package testnaukari;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class NaukariByNG 
{
	WebDriver driver;
  @Test
  public void NaukariLogin() throws Exception
  {
	  driver.get("https://www.naukri.com/");
	  driver.findElement(By.id("login_Layer")).click();
	  String xpath = "html/body/div[9]/div[2]/div[2]/form/div[4]/div[2]/input";
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys("paragborawake81@gmail.com");
	  //driver.findElement(By.xpath(xpath)).sendKeys("paragborawake81@gmail.com");
	  
	  
  }
  @BeforeTest
  public void beforeTest() 
  {
	System.setProperty("webdriver.chrome.driver" ,"G:\\Javaprogramming\\Selenium\\Selenium Setup\\chromedriver\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }

}
