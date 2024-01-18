package coverFox_Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BaseClass 
{
	static protected WebDriver driver;
	
	public void launchCoverFox() throws InterruptedException
	{
		driver=new ChromeDriver();
		Reporter.log("Launching Browser", true);
		driver.get("https://www.coverfox.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
	}
	
	
	public void closeCoverFox() throws InterruptedException
	{
		Reporter.log("Closing coverfox Browser", true);
		Thread.sleep(1000);
		driver.close();
	}
	

}
