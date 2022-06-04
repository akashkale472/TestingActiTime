package testPacke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClass.ApplicationHeaders;
import pomClass.LoginPage;

public class TestClasse {
public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver.exe" ) ;
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
driver.get("https://online.actitime.com/infosys5/login.do");

//1st test case		
LoginPage loginpage= new LoginPage(driver);		
loginpage.sendUserName();		
loginpage.sendPassWordName();		
loginpage.selectkeepMeLOginName();		
loginpage.sendloginButtonName()	;
Thread.sleep(10000);
		
ApplicationHeaders applicationHeaders=new ApplicationHeaders(driver);		
		
applicationHeaders.openTaskPage();		
		
String url= driver.getCurrentUrl();
String title=driver.getTitle();
		
if(url.equals("https://online.actitime.com/infosys5/tasks/tasklist.do")&& title.equals("actiTIME - Task List"))		
{
	System.out.println("pass");
}
else
{
	System.out.println("fail");
}
applicationHeaders.clickOnLogout();		
		
//2nd Text case
driver.get("https://online.actitime.com/infosys5/login.do");

LoginPage loginPage=new LoginPage(driver);
loginPage.loginToApplication();

 applicationHeaders=new ApplicationHeaders(driver);
 applicationHeaders.openReportPage();
 
  url= driver.getCurrentUrl();
 title=driver.getTitle();
 
 Thread.sleep(10000);	
if(url.equals("https://online.actitime.com/infosys5/reports/dashboard.do")&& title.equalsIgnoreCase("actiTIME - reports dashboard"))	
{
	System.out.println("pass");
}
else
{
	System.out.println("fail");
	
}


   applicationHeaders.clickOnLogout();
//3rd test case
   driver.get("https://online.actitime.com/infosys5/login.do");
  
   loginPage.loginToApplication();
   applicationHeaders.openUserlist();
   
   url= driver.getCurrentUrl();
   title=driver.getTitle();
   
   if(url.equals("https://online.actitime.com/infosys5/administration/userlist.do")&& title.equalsIgnoreCase("actiTIME - User List"))	
   {
   	System.out.println("pass");
   }
   else
   {
   	System.out.println("fail");
   	
   }
   applicationHeaders.clickOnLogout();
   driver.close();
}

}
