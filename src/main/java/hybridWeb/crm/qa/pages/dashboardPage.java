package hybridWeb.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hybdridWeb.crm.qa.base.TestBase;

public class dashboardPage extends TestBase {
	
	public dashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[@class = \"css-i2p92k\"]")
	WebElement DashText;
	
	@FindBy(css = ".css-1ww79u8")
	WebElement user;
	
	@FindBy(xpath = "(//*[@class=\"css-1qatrc2\"])[1]")
	WebElement Streak;
	
	@FindBy(xpath  = "//a[@href = \"/curriculum\"]")
	WebElement curriculum;
	
	
	public String verifyDashboardPageTitle()
	{
		return driver.getTitle();
	}
	
	public String checkDashText()
	{
		return DashText.getText();
	}
	
	public String CheckDashuser()
	{
		return user.getText();
				
	}

	public curriculumPage curriculumlink()
	{
		curriculum.click();
		return new curriculumPage();
	}
}
