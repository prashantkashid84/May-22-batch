package utilityPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {

	private WebDriver driver;
	
	public static void captureScreenshot(WebDriver driver,String TestID) throws IOException {
		
	
	Date currentdate=new Date();
	
	System.out.println(currentdate);
	
	String datestamp=currentdate.toString().replace(" ", "-").replace(":", "-");
	
	System.out.println(datestamp);

	TakesScreenshot scr=(TakesScreenshot)driver;
	
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File dest=new File("C:\\Users\\prashant kashid\\Desktop\\screenshot\\screenshot"+datestamp+".png");
	
	FileHandler.copy(source, dest);
	
	}
	
	public static String fetchExcelsheetdata(int sheetindex,int row, int cell) throws EncryptedDocumentException, IOException
	{
		try
		{
		String path="C:\\Users\\prashant kashid\\Desktop\\Testing.xlsx";
		
		FileInputStream file=new FileInputStream(path);
		
		String ab= WorkbookFactory.create(file).getSheetAt(sheetindex).getRow(row).getCell(cell).getStringCellValue();
		
		return ab;
		}
		
		catch(IllegalStateException e)
		{
			String path="C:\\Users\\prashant kashid\\Desktop\\Testing.xlsx";
			
			FileInputStream file=new FileInputStream(path);
			
			double ed= WorkbookFactory.create(file).getSheetAt(sheetindex).getRow(row).getCell(cell).getNumericCellValue();
			
			String sh=ed+"";
			return sh;
			
		}
		
		
		
	}
	
	
}
