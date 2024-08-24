package AppCharge.TestCases;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class BundleTest extends Base.TestBase {


    @Test(dataProvider = "getData")
    public void AddProducts(String Name, String Sku) {

        WebDriverWait wait2 = new WebDriverWait(driver, 20);

        driver.get("https://dashboard-sandbox.appcharge.com");
        driver.findElement(By.xpath(OR.getProperty("EmailField"))).sendKeys("chsargsyan@gmail.com");
        driver.findElement(By.xpath(OR.getProperty("Password"))).sendKeys("christineTest22!");
        driver.findElement(By.xpath(OR.getProperty("Login"))).click();
        WebElement Products = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("Bundles"))));
        Products.click();
        driver.findElement(By.xpath(OR.getProperty("AddNewBundle"))).click();


        //Submitting the form
        WebElement render = wait2.until(ExpectedConditions.elementToBeClickable(By.className("MuiOutlinedInput-input")));
        render.sendKeys(Name);
        driver.findElement(By.name("publisherOfferId")).sendKeys(Sku);
        driver.findElement(By.id("mui-component-select-offerUiId")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-offerUiId\"]/div[3]/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"mui-component-select-name\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"menu-name\"]/div[3]/ul/li[2]")).click();
        WebElement Quantity=driver.findElement(By.xpath("//*[@id=\":rp:\"]"));
        Quantity.sendKeys(Keys.CONTROL + "a"); // Select all text (Windows)
        Quantity.sendKeys(Keys.BACK_SPACE);   // Delete selected text
        Quantity.sendKeys("-1");
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div[1]/div/div[5]/div[2]/div/div/div/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/button")).click();

    }

        @DataProvider(name = "getData")
        public Object[][] getData() {
            String sheetname = "AddProduct";
            int rows = excel.getRowCount(sheetname);
            int columns = excel.getColumnCount(sheetname);
            Object[][] data = new Object[rows - 1][columns];
            for (int rowNum = 2; rowNum <= rows; rowNum++) {
                for (int colNum = 0; colNum < columns; colNum++) {
                    data[rowNum - 2][colNum] = excel.getCellData(sheetname, colNum, rowNum);
                }


            }
            return data;
        }


    }
























