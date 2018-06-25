package teaTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import liamGroupID.DemoQAFunctions.AddEmployeePage;
import liamGroupID.DemoQAFunctions.AddUserPage;
import liamGroupID.DemoQAFunctions.LoginPage;
import liamGroupID.DemoQAFunctions.ViewUserPage;

public class StepFile {
	

	
	WebDriver myWebDriver;
	static ExtentReports extent;
	LoginPage loginPage = PageFactory.initElements(myWebDriver, LoginPage.class);
	AddUserPage userPage = PageFactory.initElements(myWebDriver, AddUserPage.class);
	//realised it was the "add employee page" under "PIM" I was suppose to use rather than the "add user" page under "ADMIN" with a hour left, sorry :(
	AddEmployeePage employeePage = PageFactory.initElements(myWebDriver, AddEmployeePage.class);
	//as a result this class has the wrong information (looks at the entries on the Admin tab, rather than the PIM tab)
	ViewUserPage viewUsers = PageFactory.initElements(myWebDriver, ViewUserPage.class);
	
	
	

	@Given("^the Add Employee Tab$")
	public void setUp() {
		
		//loading up a new instance of the chrome browser
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extentAssessLogin.html", true);
		myWebDriver = new ChromeDriver();
		myWebDriver.manage().window().maximize();
		String url = "http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		myWebDriver.get(url);
		
		//using the login method to enter login details
		loginPage.login();
		
	}
	
	@When("^I fill out the Employee Details correctly$")
	public void employeeDetails() {
		//enters new employee info
		employeePage.createEmployee();
	}
	
	@When("^I choose to create Login Details$")
	public void createDetails() {
		//clicks the check box on the employee page and enters appropriate details
		employeePage.createLoginDetails();
		
	}
	
	@When("^I fill out the Login Details correctly$")
	public void correctDetails() {
		
		//printing out an extent report onto the desktop which will hold information about whether the data had been entered correctly
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extentCorrectInfo.html", true);
		
		ExtentTest test = extent.startTest("The info has been added correctly!");
		
		try {
		//assert equals to compare what is in the text boxes with what should of been entered
		assertEquals(employeePage.userFirstName.getText(), "Liam");
		assertEquals(employeePage.userSecondName.getText(), "Anthony");
		assertEquals(employeePage.userSurname.getText(), "Donoghue");
		//pass message to be shown in the log if the names are displaying correctly
		test.log(LogStatus.PASS, "the user's has been added correctly");
		} catch (AssertionError e) {
			//catch message to display a failure message if the names haven't been entered correctly
			test.log(LogStatus.FAIL, "the user's name hasn't been added correctly");
		} 
		
		try {
			assertEquals(employeePage.usernameInput.getText(), "Liam123");
			test.log(LogStatus.PASS, "the username has been added correctly");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "the username has not been created properly");
		} 
		try {
			assertEquals(employeePage.passwordInput.getText(), "liamsp4ssw0rd123");
			test.log(LogStatus.PASS, "the password has been added correctly");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "the password has not been created properly");
		} 
		finally {
			test.log(LogStatus.INFO, "Current URL: " + myWebDriver.getCurrentUrl());
			extent.endTest(test);
		} 
		
	}
	
	@When("I click the Save button")
	public void clickSaveBtn() {
		//calls the method in employee class to click the save button
		employeePage.clickSave();
		
	}
	
	@Then("I can see information about the user")
	//this method isnt right now as it compared the results with the ones entered in the ADMIN - > CREATE USER pages rather than the PIM - > ADD EMPLOYEE ones
	public void viewUserInfor() {
		
		//This just compared the first row shown on http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers with the information that should be there.
		extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extentNewUserStored.html", true);
		ExtentTest test = extent.startTest("The user has been stored corretly!");
		
		try {
			assertEquals(viewUsers.usernameRow1.getText(), "aaLiamAccount123");
			test.log(LogStatus.PASS, "the username has been added to the database");
		}catch (AssertionError e) {
			test.log(LogStatus.FAIL, "the username has not been added to the database");
		}
		
		try {
			assertEquals(viewUsers.userRoleRow1.getText(), "Admin");
			test.log(LogStatus.PASS, "the user role has been added to the database");
		}catch (AssertionError e) {
			test.log(LogStatus.FAIL, "the user role has not been added to the database");
		} 
		
		try {
			assertEquals(viewUsers.employeeNameRow1.getText(), "Hannah Flores");
			test.log(LogStatus.PASS, "the user's name has been added to the database");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "the user's name has not been added to the database");
		} 
		
		try {
			assertEquals(viewUsers.userStatusRow1.getText(), "Enabled");
			test.log(LogStatus.PASS, "the user's name has been added to the database");
		}	catch (AssertionError e) {
			test.log(LogStatus.FAIL, "the user's name has not been added to the database");
		} finally {
			test.log(LogStatus.INFO, "Current URL: " + myWebDriver.getCurrentUrl());
			extent.endTest(test);
		} 
		
	}
	
	

	

	
}


