package testnaukari;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class NaukariLogin 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver" , "G:\\Javaprogramming\\Selenium\\Selenium Setup\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.naukri.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String parent= driver.getWindowHandle();
		System.out.println("Parent id=" + parent);
		String ParentTitle = driver.getTitle();
		Set<String>allwindow= driver.getWindowHandles();
		for(String child: allwindow)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		
		driver.findElement(By.xpath(".//a[@id='login_Layer']")).click();
		WebElement we= driver.findElement(By.name("email"));
		we.click();
		we.sendKeys("paragborawake81@gmail.com");	
		driver.findElement(By.xpath(".//*[@id='pLogin'][@name='PASSWORD']")).sendKeys("borawake81");
		driver.findElement(By.xpath(".//button[@value='Login']")).click();
		driver.findElement(By.xpath("//div[@id='compDetail']/div[4]/div/button/div/b")).click();
		driver.findElement(By.xpath(".//*[@id='rPanel']/div/div[1]/div[2]/h1/a")).click();
		driver.findElement(By.xpath(".//button[@value='Save Changes']")).click();
		Thread.sleep(2000);
		WebElement msg = driver.findElement(By.xpath("//span[contains( text(),'Your profile has been updated successfully')]"));
		String Actual = msg.getText();
		String Expected = "Your profile has been updated successfully";
		Assert.assertEquals(Actual, Expected);
		System.out.println("Page is updated");
		WebElement MyNaukari= driver.findElement(By.xpath("//div[contains(text(), 'My Naukri')]"));
		Actions act = new Actions(driver);
		act.moveToElement(MyNaukari).perform();
		WebElement logout= driver.findElement(By.xpath(".//a[@title ='Log Out']"));
		logout.click();
		String Actual1  = driver.getTitle();
		String Expected1 = "My Naukri";	
		Assert.assertEquals(Actual1, Expected1);
		System.out.println("testcase completed");
		
		driver.close();
		//driver.findElement(By.xpath("//a[@id='mainHeader']/div/div/ul[2]/li[2]/div/ul/li[5]/a")).click();
		
	}
}
