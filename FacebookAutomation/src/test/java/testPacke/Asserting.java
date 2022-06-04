package testPacke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomClass.ApplicationHeaders;
import pomClass.LoginPage;

public class Asserting {
	WebDriver driver;
	LoginPage loginPage;
	ApplicationHeaders applicationHeaders;
	
@BeforeClass
 public void lanuchBrowser(){
System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver.exe" ) ;
 driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
driver.get("https://online.actitime.com/infosys5/login.do");
//System.out.println("before Class");
	}
	
@BeforeMethod
public void loginToApplication() throws InterruptedException {
	
	driver.get("https://online.actitime.com/infosys5/login.do");

			
	LoginPage loginpage= new LoginPage(driver);		
	loginpage.sendUserName();		
	loginpage.sendPassWordName();		
	loginpage.selectkeepMeLOginName();		
	loginpage.sendloginButtonName()	;
	Thread.sleep(10000);
			
	 applicationHeaders=new ApplicationHeaders(driver);		
			
	}	
 @Test(priority =1)  //1st test case
public void verifyTaskButton() {
	applicationHeaders.openTaskPage();		
	
	String url= driver.getCurrentUrl();
	String title=driver.getTitle();
	
	Assert.assertEquals(url, "https://online.actitime.com/infosys5/tasks/tasklist.do");
	Assert.assertEquals(title,"actiTIME - Task List");
			
//	if(url.equals("https://online.actitime.com/infosys5/tasks/tasklist.do")&& title.equals("actiTIME - Task List"))		
//	{
//		System.out.println("pass");
//	}
//	else
//	{
//		System.out.println("fail");
//	}
 }
@Test(priority =2) //2nd test case
public void verifyReportButton() throws InterruptedException {
	applicationHeaders.openReportPage();		
	
	String url= driver.getCurrentUrl();
	String title=driver.getTitle();
	
	Assert.assertEquals(url, "https://online.actitime.com/infosys5/reports/dashboard.do");
	Assert.assertEquals(title, "actiTIME - Reports Dashboard");
	Thread.sleep(10000);	
//	if(url.equals("https://online.actitime.com/infosys5/reports/dashboard.")&& title.equalsIgnoreCase("actiTIME - reports dashboard"))	
//	{
//		System.out.println("pass");
//	}
//	else
//	{
//		System.out.println("fail");
//		
//	}

}

@Test(priority =3) //3rd test case
public void verifyUserButton() {
	applicationHeaders.openUserlist();		
	
	String url= driver.getCurrentUrl();
	String title=driver.getTitle();
	
	Assert.assertEquals(url, "https://online.actitime.com/infosys5/administration/userlist.dO");
	Assert.assertEquals(title, "actiTIME - User List");
	
//	 if(url.equals("https://online.actitime.com/infosys5/administration/userlist.do")&& title.equalsIgnoreCase("actiTIME - User List"))	
//	   {
//	   	System.out.println("pass");
//	   }
//	   else
//	   {
//	   	System.out.println("fail");
//	   	
//	   }
}
@AfterMethod
public void logoutToApplication() {
	applicationHeaders.clickOnLogout();	
}
@AfterClass
public void closeBrowser () {
	driver.close();
}
}


