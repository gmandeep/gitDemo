package hybridWeb.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hybdridWeb.crm.qa.base.TestBase;
import hybdridWeb.crm.qa.util.TestUtil;
import hybridWeb.crm.qa.pages.curriculumPage;
import hybridWeb.crm.qa.pages.dashboardPage;
import hybridWeb.crm.qa.pages.loginPage;
import hybridWeb.crm.qa.pages.signupPage;


public class SignUpPageTest extends TestBase {
	
	loginPage lp;

	TestUtil tu;
	String sheetName = "Sheet1";
	signupPage signup;
	
	public SignUpPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		lp = new loginPage();
		tu = new TestUtil();
		signup = new signupPage();	
		WebElement dashboard = driver.findElement(By.xpath("//*[contains(text(),'Login to Dashboard')]"));
		dashboard.click();
		WebElement signuplink = driver.findElement(By.linkText("Sign Up Here!"));
		signuplink.click();
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		System.out.println("testing in progress");
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data = tu.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider = "getTestData" )
	public void verifySignupTest(String name, String mobNo, String email)
	{
		signup.Signupdata(name, mobNo, email);
	}
	
	
}
