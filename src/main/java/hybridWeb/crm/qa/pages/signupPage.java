package hybridWeb.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hybdridWeb.crm.qa.base.TestBase;



public class signupPage extends TestBase {

	public  signupPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Sign Up Here!")
	WebElement signuplink;
	
	@FindBy(name = "name")
	WebElement name;
	
	@FindBy(xpath = "//*[@class='styles__DropdownWrapper-sc-1a1lst-0 kmxCFb']")
	WebElement gradedp;
	
	@FindBy(xpath = "//div[@value=\"1\"]")
	WebElement grd;
	
	@FindBy(xpath = "//input[@type= \"tel\"]")
	WebElement mobileno;
	
	@FindBy(xpath = "//input[@type= 'email' and @name= 'email']")
	WebElement EmailID;
	
	@FindBy(xpath = "//*[@class=\"styles__ButtonComp-sc-hsk1iv-0 dKtbia\"]")
	WebElement submitbtn;
	
	
	public void Signupdata(String uname, String mob, String emailid)
	{
	
		name.sendKeys(uname);
		gradedp.click();
		grd.click();
		mobileno.sendKeys(mob);
		EmailID.sendKeys(emailid);
		submitbtn.click();
		
	}
	
	
	
	
	
}
