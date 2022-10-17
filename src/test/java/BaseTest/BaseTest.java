package BaseTest;

import ConfigReader.ConfigFileReader;
import Enums.BrowserType;
import Enums.RunEnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;


public abstract class BaseTest {

    public WebDriver driver;
    public ConfigFileReader configFileReader;

    String browser;
    String env;



    public void initialize(){
        configFileReader = new ConfigFileReader();
        browser = configFileReader.getBrowser();
        env = configFileReader.getEnvironmentValue();

        if(browser != null && env.equalsIgnoreCase(String.valueOf(RunEnvironmentType.LOCAL))){

            if(browser.equalsIgnoreCase(String.valueOf(BrowserType.CHROME))){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

            if(browser.equalsIgnoreCase(String.valueOf(BrowserType.FIREFOX))){
                WebDriverManager.firefoxdriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

            if(browser.equalsIgnoreCase(String.valueOf(BrowserType.SAFARI))){
                WebDriverManager.safaridriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

            if(browser.equalsIgnoreCase(String.valueOf(BrowserType.IE))){
                WebDriverManager.iedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
        }



    }



}
