package coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CoverFox_MemberDetailsPage 
{
	@FindBy(id="Age-You") private WebElement age;
	@FindBy(className="next-btn") private WebElement nextButton;
	
	//constructor
	public CoverFox_MemberDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void ageSelection(String yourAge)
	{
		Select s=new Select(age);
		s.selectByValue(yourAge+"y");
	}
	
	public void nextButtonClickMemberDetails()
	{
		nextButton.click();
	}
	
}

