package com_naukari_qa_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_naukari_qa_Base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(xpath="//a[@title= 'Jobseeker Login' ][@id='login_Layer']") static WebElement Loginbutton;
	@FindBy(name= "email") static WebElement username;
	@FindBy(xpath="//input[@name='PASSWORD'][@id ='pLogin']") static WebElement password;
	@FindBy(xpath= "//div[@class='ensureNew']") static WebElement message;
	@FindBy(xpath= "//button[@type='submit']")static WebElement submitbutton;
	
	// create constructor to initalize the elements
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public static void VerifyLoginPage() 
	{
		//System.out.println( "LoginButton is displayed"+ Loginbutton.isDisplayed());
		//System.out.println("LoginButton is enabled"+Loginbutton.isEnabled());
		//Loginbutton.click();	
		driver.findElement(By.xpath("//a[@title= 'Jobseeker Login' ][@id='login_Layer']")).click();
	}
	
		
	public static  void LogintoNaukari(String un, String pwd)
	{
		driver.findElement(By.name("email")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='PASSWORD'][@id ='pLogin']")).sendKeys(pwd);
		//username.sendKeys(un);
		//password.sendKeys(pwd);
		submitbutton.click();
	}
}
