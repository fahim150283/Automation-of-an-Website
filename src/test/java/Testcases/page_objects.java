package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class page_objects {
	public static WebDriver driver;
    
//    private By usernameInput = By.id("username");
//    private By passwordInput = By.id("password");
//    private By loginButton = By.id("login-button");
    
    public page_objects(WebDriver driver) {
        page_objects.driver = driver;
    }
    
    public static void alertsFrameWindowsButton(String s) {
        WebElement element = driver.findElement(By.xpath(s));
        element.click();
    }
    
    public static void alertsButton(String s) {
        WebElement element = driver.findElement(By.xpath(s));
        element.click();
    }
    
    public static void alertButton(String s) {
        WebElement element = driver.findElement(By.id(s));
        element.click();
    }
    
    public static void On_button_click_confirm_box_will_appear(String s) {
        WebElement element = driver.findElement(By.id(s));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }
    
    public static void promtButton(String s) {
        WebElement element = driver.findElement(By.id(s));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }
    
    public static void nestedframes(String s) {
        WebElement element = driver.findElement(By.cssSelector(s));
        element.click();
    }
    
    public static void framesbutton(String s) {
        WebElement element = driver.findElement(By.cssSelector(s));
        element.click();
    }
    
    public static void elements_and_webtable(String s) {
        WebElement element = driver.findElement(By.cssSelector(s));
        element.click();
    }
    
    public static void add_button(String s) {
        WebElement element = driver.findElement(By.id(s));
        element.click();
    }
    
    public static void send_values(String id, String s) {
        WebElement element = driver.findElement(By.id(id));
        element.click();
        element.sendKeys(s);
    }
    
    public static void submit_button(String s) {
        WebElement element = driver.findElement(By.id(s));
        element.click();
    }
    
    public static void delete_user(String s) {
        WebElement element = driver.findElement(By.cssSelector(s));
        element.click();
    }
    
    public static void browser_window(String s) {
        WebElement element = driver.findElement(By.cssSelector(s));
        element.click();
    }
    
    public static void tabButton(String s) {
        WebElement element = driver.findElement(By.id(s));
        element.click();
    }

	public static void button_with_xpath(String xpath) {
		// TODO Auto-generated method stub
		 WebElement element = driver.findElement(By.xpath(xpath));
	        element.click();
	}
}
