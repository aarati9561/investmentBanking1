package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_HealthPlanPage 
{
@FindBy(className="next-btn") private WebElement nextButton;
	
	
	//Constructor
	public CoverFox_HealthPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Method
	public void nextButtonClickHealthPlan()
	{
		nextButton.click();
	}

	
}
