package liamGroupID.DemoQAFunctions;

import org.openqa.selenium.chrome.ChromeDriver;


public class Home 
{
	ChromeDriver myDriver;
	
	public void testCurrentPage(ChromeDriver myDriver){

        myDriver.get("http://opensource.demo.orangehrmlive.com/index.php/dashboard");
        
        
}
}