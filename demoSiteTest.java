package liamGroupID.liamArtifactID;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class demoSiteTest {
	
	static ExtentReports extent;
	ChromeDriver myDriver;
	
	@BeforeClass
	public static void init() {
		//sets the webdriver to the one stored on my system path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extent.html", true);
	}
	
	@Before
	public void setup() {
		//loads up a new instance of the web browser
		myDriver = new ChromeDriver();
		//maximise the window
		myDriver.manage().window().maximize();
		
		//sends the browser to the following URL
		String url = "http://thedemosite.co.uk";
		myDriver.navigate().to(url);
		
	}
	

	
	@Test
	public void createUserLogin() {
		
		ExtentTest test = extent.startTest("new user logged in!");
		
		try {
		
		//checks that the URL is correct?
		assertEquals("http://thedemosite.co.uk/",myDriver.getCurrentUrl());
		//clicks onto the "add user" link on the web page
		myDriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
		//checks that the correct URL has been accessed
		assertEquals("http://thedemosite.co.uk/addauser.php", myDriver.getCurrentUrl());

		//clicking on the "username" field and entering a new username
		myDriver.findElementByName("username").click();
		myDriver.findElementByName("username").sendKeys("liam");
		
		//clicking on the "password" field and entering a new password
		myDriver.findElementByName("password").click();
		myDriver.findElementByName("password").sendKeys("password");
		
		//clicking the submit button
		myDriver.findElement(By.cssSelector("p > input[type=\"button\"]")).click();

		//clicking on the "login" link on the top of the page
		myDriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		//checking that the right URL has been accessed
		assertEquals("http://thedemosite.co.uk/login.php", myDriver.getCurrentUrl());
		
		//entering the new user information into the login fields
		myDriver.findElementByName("username").click();
		myDriver.findElementByName("username").sendKeys("liam");
		myDriver.findElementByName("password").click();
		myDriver.findElementByName("password").sendKeys("password");
		//clicking the submit button
		myDriver.findElement(By.cssSelector("p > input[type=\"button\"]")).click();
		assertEquals("**Successful Login**",myDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
		test.log(LogStatus.PASS, "The login worked fine!");
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
