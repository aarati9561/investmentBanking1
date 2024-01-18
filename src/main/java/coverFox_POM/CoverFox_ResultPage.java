package coverFox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_ResultPage
{
	@FindBy(xpath = "//div[contains (text(),'matching Health')]")private WebElement resultText;
	@FindBy(id  ="plans-list") private List<WebElement>planlist1; 
	@FindBy(xpath = "//div[text()='Sort Plans']") private WebElement sortPlansField;

	//constructor
	public CoverFox_ResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
  public int TestngResultinString1()
  {
	 String myText = resultText.getText();
	 String ar[]=myText.split(" ");
	 String numberOfResultsInString = ar[0];
	int numberOfResultsInInteger = Integer.parseInt(numberOfResultsInString); 
	return numberOfResultsInInteger;
	
  }
  
  public int availablePlanNumbersFromBox1()
  {
	 
	  int numberOfPlansInList1 = planlist1.size();
	
	  return numberOfPlansInList1;
  }
  
  public boolean SortPlansFieldVerification() 
  {
	boolean displayedVerification = sortPlansField.isDisplayed();
	return displayedVerification;
  }
}
