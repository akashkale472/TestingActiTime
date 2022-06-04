package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy  (xpath= "//input[@name='username']")
    private WebElement userName ;
	
	@FindBy  (xpath= "//input[@name='pwd']")
	private WebElement passWord ;
	
	@FindBy  (xpath= "//input[@name='remember']")
	private WebElement keepMeLogin ;
	
	@FindBy  (xpath= "//a[@id='loginButton']")
	private WebElement loginButton ;
	
	public LoginPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	} 
	  public void sendUserName(String user) {
		  userName.sendKeys(user);
	  }  
	  
	  public void sendPassWordName(String pass) {	  
	  passWord.sendKeys(pass);
	  }
	  
	  public void selectkeepMeLOginName() {	  
		keepMeLogin.click(); 
	  }
		  
	  public void sendloginButtonName() {	  
			 loginButton.click();
	}
	  
	//  or
	  
//	  public void loginToApplication() {
//		  userName.(user);  
//		  passWord.sendKeys("SzyJhJtY");
//		  keepMeLogin.click();
//		  loginButton.click();
//	  }
}
