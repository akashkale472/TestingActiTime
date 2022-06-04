package testPacke;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import browser.Base;
import pomClass.ApplicationHeaders;
import pomClass.LoginPage;
import utilityesss.Utilessss;



public class VerifyHeaderOfApplication {
	WebDriver driver;
	LoginPage loginPage;
	ApplicationHeaders applicationHeaders;
	int testID;
@Parameters ("browser")	
@BeforeTest
public void lanuchBrowser(String browserName){
	if(browserName.equals("Chrome"))
		System.out.println(browserName);
	{
	   driver =Base.openChromeBrowser();
	}
//	if(browserName.equals("Firefox"))
//	{
//	   driver =Base.openFirefoxBrowser();
//	}
//	if(browserName.equals("Microsoftedge"))
//	{
//	   driver =Base.openMicrosoftedgeBrowser();
//	}
	   driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
}
@BeforeClass
public void createPomObject() {
	loginPage = new LoginPage(driver);
	 applicationHeaders=new ApplicationHeaders(driver);	
}
// public void lanuchBrowser(){
// System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver.exe" ) ;
//
// //driver=new ChromeDriver();
//
//     driver =Base.openChromeBrowser();
// 
//driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
//driver.get("https://online.actitime.com/infosys5/login.do");
////System.out.println("before Class");
//	}
	
@BeforeMethod
public void loginToApplication() throws InterruptedException, EncryptedDocumentException, IOException {
	
	driver.get("https://online.actitime.com/infosys5/login.do");

     
//	LoginPage loginpage= new LoginPage(driver);
   String  data=Utilessss.getExcelSheetData("Sheet3", 1, 0);
	loginPage.sendUserName(data);
	
	 data=Utilessss.getExcelSheetData("Sheet3", 1, 1);
	loginPage.sendPassWordName(data);
	
	loginPage.selectkeepMeLOginName();		
	loginPage.sendloginButtonName()	;
	Thread.sleep(10000);
			
	 applicationHeaders=new ApplicationHeaders(driver);		
	 	
	}	
 @Test(priority =1)  //1st test case
public void verifyTaskButton() {
	 testID=100;
	applicationHeaders.openTaskPage();		
	
	String url= driver.getCurrentUrl();
	String title=driver.getTitle();
			
	if(url.equals("https://online.actitime.com/infosys5/tasks/tasklist.d")&& title.equals("actiTIME - Task List"))		
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	Assert.fail();
 }
 
@Test(priority =2) //2nd test case
public void verifyReportButton() throws InterruptedException {
	testID=200;
	applicationHeaders.openReportPage();		
	
	String url= driver.getCurrentUrl();
	String title=driver.getTitle();
	
	Thread.sleep(10000);	
	if(url.equals("https://online.actitime.com/infosys5/reports/dashboard.")&& title.equalsIgnoreCase("actiTIME - reports dashboard"))	
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
		
	}

}

@Test(priority =3) //3rd test case
public void verifyUserButton() {
	testID=300;
	applicationHeaders.openUserlist();		
	
	String url= driver.getCurrentUrl();
	String title=driver.getTitle();
	
	 if(url.equals("https://online.actitime.com/infosys5/administration/userlist.do")&& title.equalsIgnoreCase("actiTIME - User List"))	
	   {
	   	System.out.println("pass");
	   }
	   else
	   {
	   	System.out.println("fail");
	   	
	   }
}
@AfterMethod
public void logoutToApplication(ITestResult result) throws IOException, InterruptedException {
	
	if(ITestResult.FAILURE == result.getStatus())
	{
	{
		Utilessss.CaptureScreenShot(driver, testID);
	}
	
	Thread.sleep(5000);
	
	System.out.println("After Method");
	Thread.sleep(5000);
	applicationHeaders.clickOnLogout();
	
}}
@AfterClass
public void clearObject() {
	
	applicationHeaders=null;
	loginPage=null;
}

@AfterTest
public void closeBrowser () {
	driver.quit();
	driver=null;
	
	System.gc();   //garbage collector
}
}
