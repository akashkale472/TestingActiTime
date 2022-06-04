package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	 public static WebDriver openChromeBrowser(){
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe" ) ;
		WebDriver driver=new ChromeDriver();
		return driver;
}
	 public static WebDriver openFirefoxBrowser(){
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver.exe" ) ;
		WebDriver driver=new FirefoxDriver();
		return driver;
}
	 public static WebDriver openMicrosoftedgeBrowser(){
		 System.setProperty("webdriver.edge.driver","C:\\Users\\Dell\\Downloads\\msedgedriver.exe" ) ;
		WebDriver driver=new EdgeDriver();
		return driver;
}
}