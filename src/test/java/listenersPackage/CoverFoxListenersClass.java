package listenersPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFox_Base.BaseClass;
import coverFox_Utility.UtilityClass;

public class CoverFoxListenersClass extends BaseClass implements ITestListener
{
@Override
public void onTestFailure(ITestResult result) 
{
	Reporter.log("Taking ScreenShot after failure", true);
	try {
		UtilityClass.takeScreenShot( driver, result.getName());
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
