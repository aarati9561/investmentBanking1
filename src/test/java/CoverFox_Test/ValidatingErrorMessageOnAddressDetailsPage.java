package CoverFox_Test;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import coverFox_Base.BaseClass;
import coverFox_POM.CoverFox_AddressDetailsPage;
import coverFox_POM.CoverFox_HealthPlanPage;
import coverFox_POM.CoverFox_HomePage;
import coverFox_POM.CoverFox_MemberDetailsPage;
import coverFox_Utility.UtilityClass;

@Listeners(listenersPackage.CoverFoxListenersClass.class)

public class ValidatingErrorMessageOnAddressDetailsPage extends BaseClass

{
	
	public static org.apache.log4j.Logger logger;
	 CoverFox_HomePage hpage;
	 CoverFox_HealthPlanPage hplanPage;
	 CoverFox_MemberDetailsPage mdetailspage;
	 CoverFox_AddressDetailsPage adDetailsPage;
	 
	 
  @BeforeClass
  public void beforeClassExicutions1() throws InterruptedException
  {
	  logger=logger.getLogger("investment_banking1");
	  PropertyConfigurator.configure("log4j.properties");
	  Thread.sleep(1000);
	  
	  logger.info("launching ");
	  launchCoverFox();
	hpage=new CoverFox_HomePage(driver);
	hplanPage=new CoverFox_HealthPlanPage(driver);
	mdetailspage=new CoverFox_MemberDetailsPage(driver);
	adDetailsPage=new CoverFox_AddressDetailsPage(driver);
  }
  
  @BeforeMethod
  public void beforeMethodExicutions() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  Thread.sleep(1000);
	  
	  
	  Reporter.log("Click Female button", true);
	   hpage.genderSelection();
	  
	   Thread.sleep(1000);
	   Reporter.log("Click On Next button from health plan page", true);
	  hplanPage.nextButtonClickHealthPlan();
	   
	  Thread.sleep(1000);
	  
	  Reporter.log("Handlin age drop down from Member details", true);
	  mdetailspage.ageSelection(UtilityClass.myExcelData(2, 1));
	  
	  Thread.sleep(1000);
	  
	  Reporter.log("Click Next button of age drop down", true);
	  mdetailspage.nextButtonClickMemberDetails();
	  
	  
  }
  
  @Test
  public void validateResultvithoutSendingData() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  
	  
	  Thread.sleep(1000);
	  logger.info("Sending pincode to textBox");
	  Reporter.log("Sending pincode to textBox", true);
	  adDetailsPage.enterPincode(UtilityClass.myExcelData(2, 2));
	  
	  logger.info("Click continue button");
	  Reporter.log("Click continue button", true);
	  adDetailsPage.continueAddress();
	  
	  Thread.sleep(3000);
	  logger.info("Vaalidating error message displayed or not");
	  Reporter.log("Vaalidating error message displayed or not", true);
	  boolean displayornot = adDetailsPage.messagevalidation();
	  Assert.assertTrue(displayornot, "Error message is not displayed TC failed");
	  
	  logger.info("Validating expected and actual error message");
	  Reporter.log("Validating expected and actual error message ", true);
	 String act = adDetailsPage.actualResult();
	 String exp = adDetailsPage.ExpectedResult();
	 
	 logger.info("Error message displayed is matching. Tc passed");
	Assert.assertEquals(act, exp,"Error message displayed is not matching. Tc failed ");
}
  
  @AfterMethod
	public void closeCoverFoxBrowsers() throws InterruptedException
	{
		Thread.sleep(6000);
		closeCoverFox();
	}
}