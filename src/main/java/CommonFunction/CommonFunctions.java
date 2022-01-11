package CommonFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonFunctions
{
    public static WebDriver driver=null;
    public static Properties properties=null;
    public static Properties loadPropertyFile() throws IOException
    {
        FileInputStream fileInputStream=new FileInputStream("Config.properties");
        properties=new Properties();
        properties.load(fileInputStream);
        return properties;
    }
    @BeforeTest
    public void launchBrowser() throws IOException
    {
        loadPropertyFile();
        PropertyConfigurator.configure("Log4j.properties");
        String browser=properties.getProperty("browser");
        String url=properties.getProperty("url");
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();

        }
        else if (browser.equalsIgnoreCase("fireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("InternetExplorer")){
            WebDriverManager.edgedriver().setup();
            driver= new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterTest
    public void close(){
        driver.quit();
    }

}