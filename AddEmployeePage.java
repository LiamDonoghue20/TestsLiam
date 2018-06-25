package liamGroupID.DemoQAFunctions;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;




public class AddEmployeePage 
{

	//all the various input fields for creating a new employee

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	public WebElement userFirstName;
	@FindBy(xpath="//*[@id=\"middleName\"]")
	public WebElement userSecondName;
	@FindBy(xpath="//*[@id=\"lastName\"]")
	public WebElement userSurname;
	

	
	@FindBy(xpath="//*[@id=\"systemUser_password\"]")
	public WebElement userPasswordInput;
	@FindBy(xpath="//*[@id=\"systemUser_confirmPassword\"]")
	private WebElement userPasswordConfirm;
	@FindBy(xpath = "//*[@id=\"chkLogin\"]")
	private WebElement checkBox;
	@FindBy(xpath="//*[@id=\"user_name\"]")
	public WebElement usernameInput;
	@FindBy(xpath="//*[@id=\"user_password\"]")
	public WebElement passwordInput;
	@FindBy(xpath= "//*[@id=\"re_password\"]")
	WebElement passwordConfirm;
	@FindBy(xpath="//*[@id=\"btnSave\"]")
	private WebElement saveBtn;
	
	
	public void createEmployee() {
		
		//inputting info into the first few fields
		userFirstName.click();
		userFirstName.sendKeys("Liam");
		
		userSecondName.click();
		userSecondName.sendKeys("Anthony");
		
		userSurname.click();
		userSurname.sendKeys("Donoghue");
		
		
	}
	
public void createLoginDetails() {
		
		//inputting the information into the other fields
		
		checkBox.click();
		usernameInput.click();
		usernameInput.sendKeys("Liam123");
		
		passwordInput.click();
		passwordInput.sendKeys("liamsp4ssw0rd123");
		
		passwordConfirm.click();
		passwordConfirm.sendKeys("liamsp4ssw0rd123");
		
		
	}
	
	public void clickSave() {
	
		saveBtn.click();
	}
	
	
	
	



}
