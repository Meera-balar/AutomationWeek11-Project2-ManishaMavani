package orangehrmlivetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {
    //Main method declaration
    public static void main(String[] args) {
        // orangehrm URL stored in variable baseUrl
        String baseUrl = "https://opensource-demo.orangehrmlive.com/";
        // setup key-value for Chrome browser
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Launch the URL or Get the URL
        driver.get(baseUrl);
        //Maximise Window
        driver.manage().window().maximize();
        //We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get the title of page by using getTitle method
        System.out.println("Page title is : " + driver.getTitle());

        //Get the current Url
        System.out.println("Current URL is : " + driver.getCurrentUrl());

        //Get the page source
        System.out.println("Page source is : " + driver.getPageSource());

        //Find the username field element
        WebElement usernameField = driver.findElement(By.name("username"));
        //Enter username to username field
        usernameField.sendKeys("Admin");

        //Find the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        //Enter password field element
        passwordField.sendKeys("admin123");

        //Close the browser
        driver.quit();




    }

}
