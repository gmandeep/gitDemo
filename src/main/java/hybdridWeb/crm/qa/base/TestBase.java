package hybdridWeb.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import hybdridWeb.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase()  //constructor
	{
	 try {
		 prop = new Properties();
		 FileInputStream ip = new FileInputStream("/Users/mandeep/eclipse-workspace/hybridWeb/src/main/java/hybridWeb/crm/qa/config/config.properties");
		 prop.load(ip);	 
			 
	 }
		catch(FileNotFoundException e)
	 {
		e.printStackTrace();	
	 }
	 catch(IOException e) {
		 e.printStackTrace();
	 }
	}
	
	@SuppressWarnings("deprecation")
	public static void initialization()
	{
		String BrowserName = prop.getProperty("browser");
		if (BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/Users/mandeep/Documents/chromedriver");
			driver = new ChromeDriver();
			
		}
		//if (BrowserName.equals("firefox"))
		//{
		//	System.setProperty("webdriver.gecko.driver","/Users/mandeep/Documents/geckodriver");
		//	driver = new FirefoxDriver();
			
		//}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
	}
}

