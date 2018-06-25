package liamGroupID.liamArtifactID;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class toolsSiteTest {
	
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
		String url = "http://demoqa.com/";
		myDriver.navigate().to(url);
		
	}
	

	
	@Test
	public void testFunctions() {
		
		Actions action = new Actions(myDriver);
		ExtentTest test = extent.startTest("All functions have been completed!");
		
		
		//checking that the right URL has been accessed
		assertEquals("http://demoqa.com/",myDriver.getCurrentUrl());
		
		//setting the web element variables
		WebElement dragbox =  myDriver.findElementByXPath("//*[@id=\"draggableview\"]/p");
		WebElement target = 	myDriver.findElementByXPath("//*[@id=\"droppableview\"]");
		
		try {
			
		
		
			//clicking on the tab to go on the "droppable" page
			myDriver.findElement(By.xpath("//*[@id=\"menu-item-141\"]/a")).click();
			assertEquals("http://demoqa.com/droppable/", myDriver.getCurrentUrl());
			
			//clicking and moving the draggable view onto the target
			action.moveToElement(dragbox).clickAndHold().moveToElement(target).release().perform();
			
			
			//moving onto the selectable page
			myDriver.findElement(By.xpath("//*[@id=\"menu-item-142\"]/a")).click();
			assertEquals("http://demoqa.com/selectable/", myDriver.getCurrentUrl());
			
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
