package orangehrmlivetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class MicrosoftEdgeBrowserTest {
    //Main method Declaration
    public static void main(String[] args) {
        //orangehrm URL stored in variable baseUrl
        String baseUrl = "https://opensource-demo.orangehrmlive.com/";
        //setup key-value for edge browser
        System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        //Launch the URL or Get the URL
        driver.get(baseUrl);
        //Maximize window
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
