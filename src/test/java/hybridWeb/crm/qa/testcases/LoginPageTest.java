package hybridWeb.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hybdridWeb.crm.qa.base.TestBase;
import hybridWeb.crm.qa.pages.dashboardPage;
import hybridWeb.crm.qa.pages.loginPage;

public class LoginPageTest extends TestBase {

	loginPage lp;
	dashboardPage dashboard;
	
	public LoginPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		lp = new loginPage();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	@Test
	public void login() 
	{
	
	dashboard =lp.senddate(prop.getProperty("username"),prop.getProperty("password"));
	//homepage =lp.senddate("testingraptors@gmail.com","mand@1234");
	
	
	}
	
	
}
