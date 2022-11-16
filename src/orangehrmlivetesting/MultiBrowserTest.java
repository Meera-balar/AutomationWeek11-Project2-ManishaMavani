package orangehrmlivetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowserTest {
    //orangehrm URL stored in variable baseUrl
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;
    //Main method declaration
    public static void main(String[] args) {
        //Scanner declaration to take input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter browser name :  ");
        String browser = scanner.next();
        //scanner close
        scanner.close();
        //try block
        try{
            if(browser.equalsIgnoreCase("chrome")){
                //setup key-value for Chrome browser
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
                driver = new ChromeDriver(); //object creation
            }else if(browser.equalsIgnoreCase("firefox")){
                //setup key-value for firefox browser
                System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                //setup key-value for edge browser
                System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            }else{
                System.out.println("Wrong Browser Name");
            }
            //Launch the URL or Get the URL
            driver.get(baseUrl);
            //Maximise Window
            driver.manage().window().maximize();
            //implicit time is given to driver
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            //Get the title of page by using getTitle method
            System.out.println("Page title is : " + driver.getTitle());

            //Get the current Url
            System.out.println("Current Url is : " + driver.getCurrentUrl());

            //Get the page source
            System.out.println("page source is : " + driver.getPageSource());

            //Find the username field element
            WebElement usernameField = driver.findElement(By.name("username"));
            //Enter username to username field
            usernameField.sendKeys("Admin");

            //Find the password field element
            WebElement passwordField = driver.findElement(By.name("password"));
            //Enter password to password field
            passwordField.sendKeys("admin123");



        }catch(Exception e){ // Catch block to handle nullpointerException
            System.out.println("No such browser you can entered please enter correct "+ e);
            System.exit(0);
        }
        //close the browser
        driver.quit();
    }

}
