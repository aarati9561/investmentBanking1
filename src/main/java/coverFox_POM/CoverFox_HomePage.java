package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_HomePage 
{

	//variables
	
	@FindBy(xpath = "//div[text()='Female']") private WebElement female;
	@FindBy(xpath = "//button[text()='Get Started']") private WebElement GetStartedButton;
	
	//constructor
	
	public CoverFox_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void genderSelection()
	{
		female.click();
	}
	
	public void getStartedClick()
	{
		GetStartedButton.click();
	}
}
