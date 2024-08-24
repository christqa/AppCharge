package Base;



import AppCharge.Utilities.ExcelReader;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;





 public class TestBase {


  public static WebDriver driver;
  public static Properties config = new Properties();
  public static Properties OR = new Properties();
  public static FileInputStream fis;
  public static ExcelReader excel = new ExcelReader(
          System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\AddCredentials.xlsx");


  public static final Logger logger = LogManager.getLogger(TestBase.class);


  public static void setDriver(WebDriver driver) {
   TestBase.driver = driver;
  }


  @BeforeSuite
  public void setUp() {

   if (driver == null) {

    PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");
    try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties")) {
     config.load(fis);
     BasicConfigurator.configure();
     logger.info("config file loaded");
    } catch
    (IOException e) {
     e.printStackTrace();
    }

    try (FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties")) {

     OR.load(fis1);
    } catch
    (IOException e) {
     e.printStackTrace();
    }
    if (config.getProperty("browser").equals("firefox")) {
     driver = new FirefoxDriver();
    } else if (config.getProperty("browser").equals("chrome")) {
     System.setProperty("webdriver.chrome.driver", "C:\\Projects\\chromedriver.exe");
     driver = new ChromeDriver();


    }


   }
   driver.get(config.getProperty("testsiteurl"));
   driver.manage().window().maximize();

  }

  public boolean isElementPresent(By by) {

   try {

    driver.findElement(by);
    return true;

   } catch (NoSuchElementException e) {

    return false;

   }
  }


 @AfterSuite
 public void TDown() {


  if (driver!=null) {

   driver.quit();

  }


 }
}
