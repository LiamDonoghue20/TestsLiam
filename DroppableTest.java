package liamGroupID.DemoQAFunctions;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.Test;
public class DroppableTest {
	
	WebDriver myDriver;
	static ExtentReports extent;
	
	
	@BeforeClass
	public static void init() {
		//loading up driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		//loading up extent report
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extentDroppable.html", true);
	}
	
	@Before
	public void setUp() {
		//loading up chrome window
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		String url = "http://demoqa.com/";
		myDriver.get(url);
	}
	
	@Test
	public void testSomething() {
		
		ExtentTest test = extent.startTest("The droppable function has been completed!");
		
		try {
		//loading up a new instance of the page
		 DemoOfPage page = PageFactory.initElements(myDriver, DemoOfPage.class);
		 
		 //calling the droppable click method onto the page
		 page.droppableClick();
		 //making sure the right URL has been accessed
		 assertEquals("http://demoqa.com/droppable/",myDriver.getCurrentUrl());
		 //confirming that the success message has been displayed to show the object has been dropped correctly
		 page.drop(myDriver);
		 assertEquals("Dropped!",myDriver.findElement(By.id("droppableview")).findElement(By.xpath("//*[@id=\"droppableview\"]/p")).getText());
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "the test hasn't worked!");
		} finally {
			test.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
			extent.endTest(test);
		}
	}
	//after class
	@After
	public void tearDown() {
		myDriver.close();
		extent.flush();
	}
	
}
