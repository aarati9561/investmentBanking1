package coverFox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityClass
{
	public static String myExcelData(int row,int cell) throws EncryptedDocumentException, IOException
	{
		
		Reporter.log("Reading Data from Excel sheet", true);
		FileInputStream myFile=new FileInputStream("C:\\Users\\BusinessComputers.in\\eclipse-workspace\\investment_banking1\\src\\test\\resources\\coverFoxDataSheet.xlsx");
		Sheet mysheet = WorkbookFactory.create(myFile).getSheet("CoverFoxSheet");
		 String mycellvalue = mysheet.getRow(row).getCell(cell).getStringCellValue();
		 return mycellvalue;
	}
	
	public static void takeScreenShot(WebDriver driver,String TCID)throws IOException
	{
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File filesrc=(((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE));
		File filedest=new File("D:\\Automation_Images\\ScreenShots\\coverFox"+TCID+"_"+timeStamp+".png");
		
		Reporter.log("Saved Screenshot at "+filedest, true);
		FileHandler.copy(filesrc,filedest);
		
	}

	
}