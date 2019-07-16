package com_naukari_qa_POM;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import loginnaukari.MonstorLogin;



public class VerifyMonsterLogin 
{
	
	
	
  @Test
  public void logIn() throws Exception
  {
	  System.setProperty("webdriver.gecko.driver" , "G:\\Javaprogramming\\Selenium\\Selenium Setup\\geckodriver.exe");
	  WebDriver driver = new FirefoxDriver();
		MonstorLogin login = new MonstorLogin(driver); 
		driver.get("http://www.monsterindia.com");
		String parent = driver.getWindowHandle();
		System.out.println("Parent window id =" + parent);
		Set<String> allwindow = driver.getWindowHandles();
		int count = allwindow.size();
		login.Login();
		for(String child:allwindow)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.close();
			}			
		}
		driver.switchTo().window(parent);
		System.out.println("Parent window title="+ driver.getTitle());
		login.userName();
		
		/*Set<String> allwindows =driver.getWindowHandles();
		int count = allwindows.size();
		ArrayList<String>tabs= new ArrayList<>(allwindows);
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(0));*/		;
		login.Password();
		login.signIn();
		login.Update();
  }
  @BeforeTest
  public void beforeTest()
  {
	
  }

  @AfterTest
  public void afterTest() 
  {
  }

}
