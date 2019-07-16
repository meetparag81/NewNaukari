package com_naukari_qa_POM;

import org.testng.annotations.Test;

import loginnaukari.NaukariLogin;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class VerifyNaukariLogin {
  @Test
  public void verifyLogin() throws Exception 
  {
	  System.setProperty("webdriver.gecko.driver" , "G:\\Javaprogramming\\Selenium\\Selenium Setup\\geckodriver.exe");  
	  WebDriver driver = new FirefoxDriver();
	  driver.get("https://www.naukri.com/");
	  driver.manage().window().maximize();
	  NaukariLogin login = new NaukariLogin();
	  login.clickLogin();
	  Thread.sleep(2000);
	  login.username();
	  login.passord();
	  login.clickOnLogin();
	  Thread.sleep(4000);
	  login.Update();
	  login.clickEdit();
	  login.clickSave();
	  String Expected = driver.getTitle();
	  String Actual= "UpdateProfile|Mynaukari";
	  if(Actual==Expected)
	  {
		  System.out.println("Pass");
	  }
	  else
	  {
		  System.out.println("Fail");
		  System.out.println(Expected);
	  }
	  driver.close();
	  
  }
  
 
  @BeforeTest
  public void beforeTest()
  {
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
