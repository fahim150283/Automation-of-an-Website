package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
	
public class WebDriverSingleton {
    
    public static WebDriver driver;
    
    public WebDriverSingleton() {}
    
    public static WebDriver getDriver() {
        if (driver == null) {
        	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}
