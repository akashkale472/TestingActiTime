package utilityesss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilessss {
	
	public static void CaptureScreenShot(WebDriver driver,int testID) throws IOException {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	File dest = new File("test-output"+File.separator+"testScreenshots"+File.separator+"Test_"+testID+"Date and Time"+".jpg");
	//	FileHandler.copy(source, dest);
		
		
		
		
		//screen shot
//		TakesScreenshot t=  (TakesScreenshot)driver;	
//		
//		File source=t.getScreenshotAs(OutputType.FILE);
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter format= DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss");
		File dest=new File("E:\\SCREENSHOT\\test-"+testID+"  "+now.format(format)+".jpeg")	;
		FileHandler.copy(source, dest);
	}
	//excel sheet
public static String getExcelSheetData(String sheetName,int rowNo,int columnNo) throws EncryptedDocumentException, IOException {
			String data=null;
			String path="C:\\Users\\Dell\\Desktop\\Book1.xlsx"	;
			FileInputStream file =new FileInputStream(path);
			
			Workbook book=WorkbookFactory.create(file);
			try {
		    data=book.getSheet("Sheet3").getRow(rowNo).getCell(columnNo).getStringCellValue();
			}
			catch(IllegalStateException e) {
double value=book.getSheet("Sheet3").getRow(rowNo).getCell(columnNo).getNumericCellValue();
			data=String.valueOf(value);
			}
			return data;
		}


	
}	

