package hybridWeb.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hybdridWeb.crm.qa.base.TestBase;
import hybdridWeb.crm.qa.util.TestUtil;
import hybridWeb.crm.qa.pages.curriculumPage;
import hybridWeb.crm.qa.pages.dashboardPage;
import hybridWeb.crm.qa.pages.loginPage;

public class dashboardPageTest extends TestBase {
	
	loginPage lp;
	dashboardPage dashboard;
	TestUtil tu;
	curriculumPage curiculumPage;
	
	public dashboardPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		lp = new loginPage();
		tu = new TestUtil();
		curiculumPage = new curriculumPage();
		dashboard =lp.senddate(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(4000);
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
		System.out.println("testing in progress");
	}
	
	@Test(priority= 1)
	public void verfifydashTitleTest()
	{
		String dashTitle = dashboard.verifyDashboardPageTitle();
		Assert.assertEquals(dashTitle, "Dashboard", "dashboard title not matched");
		
	}
	
	@Test(priority= 2)
	public void verifydashTextTest()
	{
		String dashtxt = dashboard.checkDashText();
		Assert.assertEquals(dashtxt, "Your Dashboard", "dashboard text didnt match");
	}
	
	@Test (priority= 3)
	public void verifydashUserTest()
	{
		String dashusr = dashboard.CheckDashuser();
		Assert.assertEquals(dashusr, "Your Dashboard " + prop.getProperty("username"), "username of dashboard didnt match");
	}
	
	@Test(priority= 4)
	public void verifycurriculumLinkTest()
	{
		curiculumPage = dashboard.curriculumlink();
		
	}
	

}
