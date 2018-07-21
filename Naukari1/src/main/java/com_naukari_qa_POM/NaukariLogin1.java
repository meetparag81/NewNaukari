package testnaukari;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaukariLogin1 {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver" ,"G:\\Javaprogramming\\Selenium\\Selenium Setup\\chromedriver\\chromedriver.exe");	
		WebDriver  driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		
		String parent = driver.getWindowHandle();
		System.out.println("Parent window id =" + parent);
		Set<String> allwindow = driver.getWindowHandles();
		//ArrayList<String>tabs= new ArrayList<>(allwindow);
		for(String child:allwindow)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.close();
			}
			
		}
		driver.switchTo().window(parent);
		/*driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(2));
		driver.close();
		driver.switchTo().window(tabs.get(0));*/
		System.out.println("Parent window title  is ="+driver.getTitle());
		driver.findElement(By.xpath(".//*[@id='login_Layer']")).click();
		driver.findElement(By.xpath("//input[@name='email'][@id='eLogin']")).sendKeys("paragborawake81@gmail.com");
		driver.findElement(By.xpath(".//*[@id='pLogin']")).sendKeys("borawake81");
		driver.findElement(By.xpath(".//button[@value='Login']")).click();
		/*WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("pLogin"))).sendKeys("paragborawake81@gmail.com");
		driver.findElement(By.id("pLogin")).sendKeys("borawake81");
		driver.findElement(By.xpath(".//button[@value='Login']")).click();*/
		//WebDriverWait wait1 = new WebDriverWait(driver, 50);
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View and Update Profile"))).click();
		driver.findElement(By.xpath(".//*[@id='compDetail']/div[4]/div[1]/button/div")).click();
		driver.findElement(By.linkText("Edit")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rPanel']/div/div/form/div[5]/div/button/div/b"))).click();
		//driver.findElement(By.xpath(".//*[@id='rPanel']/div/div/form/div[5]/div/button/div/b")).click();
		System.out.println(driver.getTitle());
		//driver.close();
	

	}

}
