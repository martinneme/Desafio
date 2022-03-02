package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory{
    private static String browser;
    public static WebDriver driver;
    public static String pathDriver = "src/main/resources/drivers/";



    public static WebDriver getWebDriverBrowser(){

        browser = PropertiesFile.getProperty("browser");
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",pathDriver + "chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equals("edge")){
            System.setProperty("webdriver.edge.driver", pathDriver + "msedgedriver.exe");
            driver = new EdgeDriver();
        }else if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", pathDriver +"geckofriver.exe");
            driver = new FirefoxDriver();
        };


        return driver;
    }

    public static class PropertiesFile {
        static Properties prop = new Properties();

        public static String getProperty(String data) {
            try{
                InputStream input = new FileInputStream("./src/main/resources/data.properties");
                prop.load(input);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return prop.getProperty(data);
        }
    }
}
