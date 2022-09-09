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

public class CurriculumPageTest extends TestBase {
	
	loginPage lp;
	dashboardPage dashboard;
	TestUtil tu;
	curriculumPage curiculumPage;
	
	public CurriculumPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		lp = new loginPage();
		tu = new TestUtil();
		
		dashboard =lp.senddate(prop.getProperty("username"),prop.getProperty("password"));
		curiculumPage = dashboard.curriculumlink();
		Thread.sleep(4000);
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
		System.out.println("testing in progress");
	}
	
	@Test(priority= 1)
	public void verfifycuriculumTitleTest()
	{
		String currTitle = curiculumPage.verifycurrPagetitle();
		Assert.assertEquals(currTitle, "Dashboard", "curriculum title not matched");
		
	}
	
	@Test(priority= 2)
	public void verfifygradeTest()
	{
		String grade = curiculumPage.checkGrade();
		Assert.assertEquals(grade, "Grades 5-6", "grade not matched");
		
	}
	@Test(priority= 3)
	public void verifydownloadcurrTest()
	{
		curiculumPage.Downloadcurriculum();
		
	}
	@Test(priority= 4)
	public void verifyPayMonthlyRadioTest()
	{
		
		Assert.assertTrue(curiculumPage.checkradiopaymonthly(), "pay monthly btn not working ");
		
	}
}

	