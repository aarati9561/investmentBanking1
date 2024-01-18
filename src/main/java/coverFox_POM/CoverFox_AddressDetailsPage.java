package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFox_AddressDetailsPage 
{
	@FindBy(xpath = "(//input[@type='number'])[1]") private WebElement pincode;
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement mobileNumber;
	@FindBy(xpath = "//div[text()='Continue']") private WebElement addressContinueButton;
	@FindBy(xpath = "//Div[contains(text(),'valid mobile no')]") private WebElement errormessagedispaly;
	
	//constructor
	public CoverFox_AddressDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Method
	public void enterPincode(String pin)
	{
		pincode.sendKeys(pin);
	}
	
	public void enterMobileNumber(String number)
	{
		mobileNumber.sendKeys(number);
	}
	
	public void continueAddress()
	{
		addressContinueButton.click();
	}
	
	public boolean messagevalidation()
	{
		boolean message = errormessagedispaly.isDisplayed();
		return message;
	}
	
	public String actualResult()
	{
		String returnedMessage = errormessagedispaly.getText();
		Reporter.log("Actual Message is "+returnedMessage, true);
		return returnedMessage;

	}
	public String ExpectedResult()
	{
		String expval ="Please enter a valid mobile no.";
		return expval;

	}
}
