package liamGroupID.DemoQAFunctions;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.Test;
public class SelectableTest {
	
	WebDriver myDriver;
	static ExtentReports extent;
	
	
	@BeforeClass
	public static void init() {
		//loading up web driver and report
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extentSelectable.html", true);
	}
	
	@Before
	public void setUp() {
		//loading up a new web page 
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://demoqa.com/";
		myDriver.get(url);
	}
	
	@Test
	public void testSomething() {
		
		ExtentTest test = extent.startTest("The selectable test has been completed!");
		
		try {
		//loading up a new instance of the page class
		 DemoOfPage page = PageFactory.initElements(myDriver, DemoOfPage.class);
		//running the method to click the "selectable" link
		 page.selectableClick();
		 assertEquals("http://demoqa.com/selectable/",myDriver.getCurrentUrl());
		 //running the "select" method on the page
		 page.select(myDriver);
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "the test hasn't worked!");
		} finally {
			test.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
			extent.endTest(test);
		}
			 
	}
	
	@After
	public void tearDown() {
		myDriver.close();
		extent.flush();
	}
	
}
