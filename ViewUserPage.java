package liamGroupID.DemoQAFunctions;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;




public class ViewUserPage 
{

	//declaring all the rows on the http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers table

	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]")
	public WebElement usernameRow1;
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]")
	public WebElement userRoleRow1;
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[4]")
	public WebElement employeeNameRow1;
	
	@FindBy(xpath ="//*[@id=\"resultTable\"]/thead/tr/th[5]/a")
	public WebElement userStatusRow1;
	



}
