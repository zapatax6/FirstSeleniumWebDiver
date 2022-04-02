import enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.*;
//import java.io.File;

public class BaseTest {
    //private File _chromeDriverFile = new File("C:\\Users\\zapat\\Documents\\Repos\\QAML_git_2022\\chromedriver_win32\\chromedriver");
    //private File _fireFoxDriverFile = new File("C:\\Users\\zapat\\Documents\\Repos\\QAML_git_2022\\chromedriver_win32\\chromedriver");
    //WebDriver _chromeDriver = new ChromeDriver();
    //Comienzo: Declarando variables Globales
    private String _chromeDriverPath = "C:\\Users\\zapat\\Documents\\Repos\\QAML_git_2022\\chromedriver_win32\\chromedriver.exe";
    private String _fireFoxDriverPath = "C:\\Users\\zapat\\Documents\\Repos\\QAML_git_2022\\chromedriver_win32\\chromedriver.exe";

    private WebDriver webDriver = null;
    private WebDriverType _webDriverType = WebDriverType.CHROME;

    //Fin de Variables Globales

    public WebDriver get_webDriver(WebDriverType webDriverType){
        this._webDriverType = webDriverType;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        switch (webDriverType){
            case CHROME:
                System.setProperty("webdriver.chrome.driver",_chromeDriverPath);
                ChromeOptions options =new ChromeOptions();
                options.addArguments("--incognito");
                //options.addArguments("-")
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(desiredCapabilities);
                webDriver = new ChromeDriver(options);
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.diver", _fireFoxDriverPath);
                webDriver = new FirefoxDriver();
                break;

        }
        System.out.println("El WebDriver tipo " + webDriverType + " se ha inicializado con exito. ");
        return webDriver;
    }
    //Annotations
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test en Clase Base Test");
        //webDriver = get_webDriver(WebDriverType.CHROME);
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test en Clase BaseTest.java");
        webDriver.quit();
    }

}
