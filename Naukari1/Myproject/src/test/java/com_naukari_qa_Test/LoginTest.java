package com_naukari_qa_Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_naukari_qa_Base.TestBase;
import com_naukari_qa_POM.LoginPage;
import com_naukari_qa_util.TestUtil;



public class LoginTest  extends TestBase
{
	String sheetname = "NaukariData";
	
	LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	  public void setup() 
	  {
		TestBase.Initallization();
		TestUtil.switchWindow();
	
	  }
		
		   
	
	
	
	@DataProvider
	public Object[][] getNaukariTestData()
	{
		Object[][]data= TestUtil.getTestData(sheetname);
		return data;
		
	}
	@Test(priority= 1)
	public void ClickonLogin() throws Exception
	{
		Thread.sleep(2000);
		LoginPage.VerifyLoginPage();
	}
	
	@Test(priority=2, dataProvider="getNaukariTestData")
	public void Logintest(String uname,String pass)
	{
		LoginPage.LogintoNaukari(uname, pass);
	}
	
	 @AfterMethod
	  public void Teardown()
	  {
		  driver.quit();

	  }
}
