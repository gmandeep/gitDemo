package hybridWeb.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import hybdridWeb.crm.qa.base.TestBase;

public class loginPage extends TestBase {

	// initialization
/*	WebDriver driver;


	public void loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
*/
	
	public loginPage(){
		PageFactory.initElements(driver, this);
	}
	
	// page factory or object repository
	@FindBy(xpath = "//*[contains(text(),'Login to Dashboard')]")
	WebElement dashboard;

	@FindBy(xpath = "//button[contains(text(),'Login via Password Instead')]")
	WebElement loginvia;

	@FindBy(xpath = "//input[@name='email' and @type='email']")
	WebElement username;

	@FindBy(xpath = "//input[@name=\"password\" and @type=\"password\"]")
	WebElement password;

	
	@FindBy(xpath = "//button[contains(text(),\"Login with Password\")]")
	WebElement login;
	
	// actions
	public dashboardPage senddate(String name, String pwd) {
		dashboard.click();
		loginvia.click();
		username.sendKeys(name);
		password.sendKeys(pwd);
		login.click();
		return new dashboardPage();
	}

}
