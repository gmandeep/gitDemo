package hybridWeb.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hybdridWeb.crm.qa.base.TestBase;

public class curriculumPage extends TestBase {

	public  curriculumPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='css-12awtiv']")
	WebElement Gradebutton;
	
	@FindBy(xpath = "//*[@class=\"download_curriculum_btn css-6vydt2\"]")
	WebElement curriculmdownload;
	
	@FindBy(css = "button[class='css-12awtiv'] span")
	WebElement grade;
	
	
	@FindBy(xpath = "//*[@class=\"active_section\"]")
	WebElement pvtClass;
	
	@FindBy(css= "input.css-1gy22ay[value=\"MONTHLY\"]")
	WebElement paymonthRadBtn;
	
	
	public String verifycurrPagetitle()
	{
		return driver.getTitle();
	}
	
	public void Downloadcurriculum()
	{
		curriculmdownload.click();
	}
	
	public String checkGrade()
	{
		return grade.getText();
	}
	
	public boolean checkradiopaymonthly()
	{
		paymonthRadBtn.click();
		return paymonthRadBtn.isEnabled();
	}
	
}
