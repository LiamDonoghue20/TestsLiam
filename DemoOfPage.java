package liamGroupID.DemoQAFunctions;

import static org.junit.Assert.assertEquals;

import java.io.Console;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;




public class DemoOfPage 
{

	//finding the droppable menu button and setting it to a webElement variable
	@FindBy(xpath="//*[@id=\"menu-item-141\"]")
	private WebElement droppableButton;
	
	//selecting the draggable view object (to complete droppable) and setting it to a webElement variable
	@FindBy(xpath="//*[@id=\"draggableview\"]")
	private WebElement droppableObj;
	
	//finding the selectable menu button and setting as a web variable
	@FindBy(xpath="//*[@id=\"menu-item-142\"]/a")
	private WebElement selectableButton;
	
	//finding the "selectable" buttons class and setting it as a webElement 
	@FindBy(id="selectable")
	private WebElement widgetSelectable;
	
	@FindBy(xpath="//*[@id=\"menu-item-144\"]")
	private WebElement accordionBtn;
	
	@FindBy(id="accordion")
	private WebElement accordionSelect;
	
	@FindBy(xpath = "//*[@id=\"menu-item-145\"]/a")
	private WebElement autoCompleteBtn;
	
	@FindBy(xpath ="//*[@id=\"tagss\"]")
	private WebElement inputBar;
	
	@FindBy(xpath ="//*[@id=\"ui-id-7\"]")
	private WebElement dropDownBar;
	
	@FindBy (xpath = "//*[@id=\"menu-item-146\"]/a")
	private WebElement datePickerBtn;
	
	public void accordionClick() {
		accordionBtn.click();
	}
	
	
	//method to click the droppable button web element that was set earlier
	public void droppableClick() {
		droppableButton.click();	
	}
	
	//method to click the selectable button web element that was set earlier
	public void selectableClick() {
		selectableButton.click();	
	}
	
	public void autoCompleteClick() {
		autoCompleteBtn.click();
	}
	
	public void datePickerClick(){
		datePickerBtn.click();
	}
	
	
	//action to move the droppable button onto the target area
	public void drop(WebDriver myWebdriver) {
		Actions action = new Actions(myWebdriver);
		action.moveToElement(droppableObj).clickAndHold().moveByOffset(200, 20).release().perform();;	
	}
	 
	
	//action to click the all the selectable buttons
	public void select(WebDriver myWebdriver) {
		widgetSelectable.click();
		//change this
		 assertEquals(widgetSelectable.isSelected(),myWebdriver.findElement(By.id("selectable")).isSelected());	
		 
	}
	
	public void accordion(WebDriver myWebdriver) {
		accordionSelect.click();
		assertEquals(accordionSelect.isSelected(),myWebdriver.findElement(By.id("accordion")).isSelected());
		/* code for using buttons here */ 
	}

	 public void autoComplete(WebDriver myWebdriver, String text) {
		 
	
		 Actions action = new Actions(myWebdriver);
		inputBar.click();
		inputBar.sendKeys(text);
		action.moveToElement(dropDownBar).click().perform();
		
		//assertEquals("appleScript", inputBar.getText());
		
	} 
	 
	 public boolean hasListedItem() {
		 assertEquals("appleScript",dropDownBar.getText());
		 return true;
	 }
	 
	public void datePicker(WebDriver myWebdriver) {
		
		
	}

}
