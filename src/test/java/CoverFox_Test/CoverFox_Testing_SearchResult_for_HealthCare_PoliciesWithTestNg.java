package CoverFox_Test;



import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mongodb.diagnostics.logging.Logger;

import coverFox_Base.BaseClass;
import coverFox_POM.CoverFox_AddressDetailsPage;
import coverFox_POM.CoverFox_HealthPlanPage;
import coverFox_POM.CoverFox_HomePage;
import coverFox_POM.CoverFox_MemberDetailsPage;
import coverFox_POM.CoverFox_ResultPage;
import coverFox_Utility.UtilityClass;

@Listeners(listenersPackage.ITestListenerClass.class)
public class CoverFox_Testing_SearchResult_for_HealthCare_PoliciesWithTestNg extends BaseClass 
{
	public static org.apache.log4j.Logger logger;
	CoverFox_HomePage home;
	CoverFox_HealthPlanPage health;
	CoverFox_MemberDetailsPage members;
	CoverFox_AddressDetailsPage address;
	CoverFox_ResultPage result;
	
	@BeforeClass
	public void launchCoverFoxBrowser() throws InterruptedException
	{
		logger=logger.getLogger("mylogger");
		PropertyConfigurator.configure("log4j.properties");
		
		launchCoverFox();
		home=new CoverFox_HomePage(driver);
		health=new CoverFox_HealthPlanPage (driver);
		members=new CoverFox_MemberDetailsPage (driver);
		address=new	CoverFox_AddressDetailsPage (driver);
		result=new CoverFox_ResultPage (driver);
	}
	
	@BeforeMethod
	public void enterMemberDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("Clicking on gender button", true);
		home.genderSelection();
		Thread.sleep(1000);
		
//		Reporter.log("Clicking on get started button", true);
//		home.getStartedClick();
//		Thread.sleep(1000);
		
		Reporter.log("Clicking on Health plan next button", true);
		health.nextButtonClickHealthPlan();
		Thread.sleep(1000);
		
		Reporter.log("Handling age drop down", true);
		members.ageSelection(coverFox_Utility.UtilityClass.myExcelData(2, 1));
		Reporter.log("Clicking on member details next button", true);
		members.nextButtonClickMemberDetails();
		Thread.sleep(1000);
		
		Reporter.log("Entering pin code", true);
		address.enterPincode(coverFox_Utility.UtilityClass.myExcelData(2, 2));
		Reporter.log("Entering Mobile number", true);
		address.enterMobileNumber(coverFox_Utility.UtilityClass.myExcelData(2, 3));
		Reporter.log("clicking continue button", true);
		
		address.continueAddress();
		Thread.sleep(1000);
	
	}
	@Test
	public void validatetestplansfromTextAndBanners() throws InterruptedException, IOException
	{
		Thread.sleep(6000);
		logger.info("fetching number of details from text");
		Reporter.log("fetching number of details from text", true);
		int textResult1=result.TestngResultinString1();

		Thread.sleep(6000);
		
		logger.info("fetching number of details from banner");
		Reporter.log("fetching number of details from banner", true);
		int bannerResult1=result.availablePlanNumbersFromBox1();
		Thread.sleep(6000);
		
		Assert.assertEquals(textResult1,bannerResult1, "test case failed, results are not matching");
		Reporter.log("Tc passed", true);
		
		Reporter.log("Taking ScreenShot", true);
		UtilityClass.takeScreenShot(driver, "CoverFox_Tc1");
	
	}
	
	@AfterMethod
	public void closeCoverFoxBrowsers() throws InterruptedException
	{
		Thread.sleep(6000);
		closeCoverFox();
	}
  
}

