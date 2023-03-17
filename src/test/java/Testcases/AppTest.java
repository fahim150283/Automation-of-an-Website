package Testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AppTest 
{
    public WebDriver driver;
	String[] returnedarray = read_json_config.getarray();
	public String url = returnedarray[0];
	public String name = returnedarray[1];
	public String age = returnedarray[2];
	public String city = returnedarray[3];
	public String firstname = returnedarray[4];
	public String lastname = returnedarray[5];
	public String email = returnedarray[6];
	public String salary = returnedarray[7];
	public String department = returnedarray[8];
	public String random_name = random_name_generator.getStaticValue();
	public String id;
	public String xpath;
	public String cssSelector;
	

	@BeforeMethod
	public void driver_setup() {
		driver = WebDriverSingleton.getDriver();
		driver.manage().window().maximize();
		page_objects page_objects = new page_objects(driver);
		BrowserUtils.getdriver(driver);
		}
	
	@Test(priority = 1)
	public void test1() {    //   A L E R T S (Test Scenario 1)
		driver.get(url);
		
		//wait 
		id = "app";
		BrowserUtils.waitForPageToLoadById(id);
		
		//scroll 30% of the page
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight * 0.3)");
		
		//click 'Alerts, Frame & Windows' button
		xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]";
		page_objects.alertsFrameWindowsButton(xpath);
			
		//click alert button of the side menu
		xpath = "//span[text()='Alerts']";
		page_objects.alertsButton(xpath);
		//wait for the alert button to load
		BrowserUtils.waitForPageToLoadByxpath(xpath);
		
		
		//click the alert button
		id = "alertButton";
		page_objects.alertButton(id);
		
		//click ok on the alert box
		driver.switchTo().alert().accept();
		
		//click the On button click, confirm box will appear
		id = "confirmButton";
		//wait
		BrowserUtils.waitForPageToLoadById(id);
		page_objects.On_button_click_confirm_box_will_appear(id);
		
		//click ok on the alert box
		driver.switchTo().alert().accept();
		
		//click the on button click prompt box will appear  button
		id = "promtButton";
		//wait
		BrowserUtils.waitForPageToLoadById(id);
		WebElement on_button_click_prompt_box_will_appear = driver.findElement(By.id(id));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", on_button_click_prompt_box_will_appear);
		//send text on the alert box
		driver.switchTo().alert().sendKeys(random_name);
		driver.switchTo().alert().accept();
	}	
	
	@Test(priority = 2)
	public void test2() {		//   I   F R A M E (Test Scenario 2)
		driver.get(url);
		//driver.get("https://demoqa.com/");
		//wait 
		id = "app";
		BrowserUtils.waitForPageToLoadById(id);

		//scroll 30% of the page
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight * 0.3)");
		//click 'Alerts, Frame & Windows' button
		xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]";
		page_objects.alertsFrameWindowsButton(xpath);
		
		//click the nestedframes button
		cssSelector = ".show #item-3 > .text";
		page_objects.nestedframes(cssSelector);
		//click the frames button from the left menu
		cssSelector = ".show #item-2 > .text";
		page_objects.framesbutton(cssSelector);
	}
	
	
	
	@Test(priority = 3)
	public void test3() {  		//  T A B L E S     SCENARIO 3
		driver.get(url);
		//wait to load
		id = "app";
		BrowserUtils.waitForPageToLoadById(id);

		//scroll 30% of the page
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight * 0.3)");
		//click elements
		cssSelector = ".card:nth-child(1) path";
		page_objects.elements_and_webtable(cssSelector);
	    //click webtable
		cssSelector = ".show #item-3 > .text";
		page_objects.elements_and_webtable(cssSelector);
	    //wait
		BrowserUtils.waitForPageToLoadByCssSelector(cssSelector);
	    //click add button
		id = "addNewRecordButton";
	    page_objects.add_button(id);
	    
	    //enter the values
	    
	    id = "firstName";	    
	    page_objects.send_values(id,firstname);
	    id = "lastName";	    
	    page_objects.send_values(id,lastname);
	    id = "userEmail";	    
	    page_objects.send_values(id,email);
	    id = "age";	    
	    page_objects.send_values(id,age);
	    id = "salary";	    
	    page_objects.send_values(id,salary);
	    id = "department";	    
	    page_objects.send_values(id,department);
	    
	    //click the  submit button
	    id = "submit";
	    page_objects.submit_button(id);
	
	    //delete the user no
	    cssSelector = "#delete-record-4 path";
	    page_objects.delete_user(cssSelector);

	}
	
	@Test(priority = 4)
	private void test4() {		//  H A N D L E S	SCENARIO 4
		driver.get(url);
		//wait 
		id = "app";
		BrowserUtils.waitForPageToLoadById(id);
		
		//scroll 30% of the page
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight * 0.3)");
		
		//click 'Alerts, Frame & Windows' button
		xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]";
		page_objects.alertsFrameWindowsButton(xpath);
		
		//click Browser windows button from menu
		cssSelector = ".show #item-0";
		page_objects.browser_window(cssSelector);
		//click new tab button
		id = "tabButton";
		page_objects.tabButton(id);
		// Get all the window handles
		Set<String> handles = driver.getWindowHandles();

		// Switch to the new tab
		String mainWindowHandle = driver.getWindowHandle();
		for (String handle : handles) {
		    driver.switchTo().window(handle);
		    if (!handle.equals(mainWindowHandle)) {
		        break;
		    }
		}

		// Close the new tab
		driver.close();

		// Switch to the main window
		driver.switchTo().window(mainWindowHandle);
		//wait
		xpath = "//a[text()='Element']";
		BrowserUtils.waitForPageToLoadByxpath(xpath);
		// Click Element button
		page_objects.button_with_xpath(xpath);

		// Click Links button
		xpath ="//span[text()='Links']";
		page_objects.button_with_xpath(xpath);

		// Click Home button
		xpath ="//a[text()='Home']";
		page_objects.button_with_xpath(xpath);

		// Switch to the previous tab
		driver.switchTo().window(mainWindowHandle);
	}
	
	@AfterMethod 
    public void quitDriver() { 
       driver.quit();
    }
}