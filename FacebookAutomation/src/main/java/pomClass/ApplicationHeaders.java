package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationHeaders {


@FindBy  (xpath= "//a[@class='content tasks']")
private WebElement tasks ;

@FindBy  (xpath= "//div[@id='container_reports']")
private WebElement reports ;

@FindBy  (xpath= "//div[@id='container_users']")
private WebElement users ;


@FindBy  (xpath= "//a[@class='logout']")
private WebElement logout ;

WebDriver driver;

public ApplicationHeaders(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver= driver;
}

public void openTaskPage() {
	WebDriverWait wait=new WebDriverWait(driver,20);
	
	wait.until(ExpectedConditions.visibilityOf(tasks));
	tasks.click();
}

public void openReportPage() {
	reports.click();
}

public void openUserlist() {
	users.click();
}
public void clickOnLogout() {
	logout.click();	
}

}