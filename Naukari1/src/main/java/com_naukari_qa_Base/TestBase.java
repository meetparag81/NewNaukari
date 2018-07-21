package com_naukari_qa_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com_naukari_qa_util.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("G:\\Javaprogramming\\Naukari\\src\\main\\java\\com_naukari_qa_config\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Initallization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","G:\\Javaprogramming\\Selenium\\Selenium Setup\\geckodriver.exe");
			driver = new FirefoxDriver();		
		}	
		else if(browsername.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver" ,"G:\\Javaprogramming\\Selenium\\Selenium Setup\\chromedriver\\chromedriver.exe");
				driver = new ChromeDriver(); 
		 }
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitwait , TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
	}
	

}
	

