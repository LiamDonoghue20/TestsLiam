package liamGroupID.DemoQAFunctions;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;




public class LoginPage 
{

	
	
	//the 2 inputs in the login page and the enter button

	@FindBy(xpath = "//*[@id=\"txtUsername\"]")
	WebElement usernameInput;
	
	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	WebElement passwordInput;
	
	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	WebElement loginBtn;



	public void login() {
		//inputting the correct text into the inputs
		usernameInput.click();
		usernameInput.sendKeys("Admin");
		
		passwordInput.click();
		passwordInput.sendKeys("admin");
		
		loginBtn.click();
	}
	
	



}
