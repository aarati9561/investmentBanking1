package listenersPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFox_Utility.UtilityClass;



public class ITestListenerClass implements ITestListener
{
@Override
	public void onTestStart(ITestResult result) 
	{
	Reporter.log("Tc "+result.getName()+" exicution started", true);
	}



@Override
	public void onTestSkipped(ITestResult result)
	{
	Reporter.log("Tc "+result.getName()+" exicution Skipped", true);
	}

@Override
	public void onTestSuccess(ITestResult result) 
	{
	Reporter.log("Tc "+result.getName()+" exicution Successful", true);
	}
}
