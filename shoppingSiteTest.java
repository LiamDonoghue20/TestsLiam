package liamGroupID.liamArtifactID;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class shoppingSiteTest {
	
	static ExtentReports extent;
	ChromeDriver myDriver;
	
	@BeforeClass
	public static void init() {
		//sets the webdriver to the one stored on my system path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\extent.html", true);
	}
	
	@Before
	public void setup() {
		//loads up a new instance of the web browser
		myDriver = new ChromeDriver();
		//maximise the window
		myDriver.manage().window().maximize();
		
		//sends the browser to the following URL
		String url = "http://automationpractice.com/index.php";
		myDriver.navigate().to(url);
		
	}
	

	
	@Test
	public void search() {
		
		ExtentTest test = extent.startTest("Correct search results found!");
		
		try {
		
		//sets the searchbar to a web element variable
		WebElement searchbar = myDriver.findElementById("search_query_top");
		//enters the search terms into the bar
		searchbar.click();
		searchbar.clear();
		searchbar.sendKeys("Dress");
		//click the search button
		myDriver.findElementByCssSelector("#searchbox > button").click();
		//checking that "7 results have been found" shows up in the "heading-counter" element
		assertEquals("7 results have been found.", myDriver.findElementByClassName("heading-counter").getText());
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "the test hasn't worked!");
			
		} finally {
			test.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
			extent.endTest(test);
		}
		
		}
	
	
	@After
	public void tearDown() {
		//closes the web browser
		myDriver.close();
		extent.flush();
	}

}
