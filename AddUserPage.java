package liamGroupID.DemoQAFunctions;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


//this class is no long of use

public class AddUserPage 
{


	@FindBy(xpath = "//*[@id=\"systemUser_userType\"]")
	private WebElement userRoleSelect;
	
	@FindBy(xpath="//*[@id=\"systemUser_employeeName_empName\"]")
	public WebElement employeeNameInput;

	@FindBy(xpath="//*[@id=\"systemUser_userName\"]")
	public WebElement usernameInput;
	
	@FindBy(xpath="//*[@id=\"systemUser_status\"]")
	WebElement userStatusSelect;
	
	@FindBy(xpath="//*[@id=\"systemUser_password\"]")
	public WebElement userPasswordInput;
	
	@FindBy(xpath="//*[@id=\"systemUser_confirmPassword\"]")
	private WebElement userPasswordConfirm;

	@FindBy(xpath="//*[@id=\"btnSave\"]")
	private WebElement saveBtn;
	
	
	public void createUser() {
		
		userRoleSelect.click();
		userRoleSelect.sendKeys(Keys.UP);
		userRoleSelect.sendKeys(Keys.UP);
		
		employeeNameInput.click();
		employeeNameInput.sendKeys("h");
		employeeNameInput.sendKeys(Keys.ENTER);
		
		usernameInput.click();
		usernameInput.sendKeys("aaLiamAccount123");
		
		userPasswordInput.click();
		userPasswordInput.sendKeys("passw0rd!123");
		
		userPasswordConfirm.click();
		userPasswordConfirm.sendKeys("passw0rd!123");
		
		
	}
	
	public void clickSave() {
		saveBtn.click();
	}
	
	
	
	



}
