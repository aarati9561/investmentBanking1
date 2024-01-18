package listenersPackage;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenersPackage.ITestListenerClass.class)
public class ListenersClass 
{
	@Test
	public void first()
	{
		Reporter.log("Running first method", true);
	}
	
	@Test(dependsOnMethods = "third")
	public void second()
	{
		Reporter.log("Running second method", true);
	}
	
	@Test
	public void third()
	{
		Assert.fail();
		Reporter.log("Running third method", true);
	}
	
	@Test
	public void fourth()
	{
		Reporter.log("Running fourth method", true);
	}
}
