package AppCharge.TestCases;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;


public class BuyProductTest extends Base.TestBase {

    @Test(dataProvider = "getData")
    public void BuyOffer(String Email, String CardNumber, String Expiry, String CVC) {


        System.setProperty("org.uncommons.reportng.escape-output", "false");

        WebDriverWait wait1 = new WebDriverWait(driver, 100);


        driver.findElement(By.className("accept")).click();

        WebElement LoginBtn = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("LoginBtn"))));//login
        LoginBtn.click();

        WebElement LoginCred = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("LoginCred"))));
        LoginCred.sendKeys("1wqd");

        driver.findElement(By.xpath(OR.getProperty("LoginBtn1"))).click();

        WebElement offerItem = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("Offer"))));
        offerItem.click();

        WebElement frame=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("iframe")));
        driver.switchTo().frame(driver.findElement(By.className("iframe")));

        WebElement element6=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div[3]/form/div[1]/div[2]/div[1]/div/div/iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/form/div[1]/div[2]/div[1]/div/div/iframe")));


        //Filling the payment form
        WebElement element5=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
        element5.sendKeys(Email);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement((By.xpath("/html/body/div[2]/div[2]/div/div[3]/form/div[1]/div[2]/div[2]/div/div/iframe"))));
        driver.findElement(By.name("number")).sendKeys(CardNumber);
        driver.findElement(By.name("expiry")).sendKeys(Expiry);
        driver.findElement(By.name("cvc")).sendKeys(CVC);
        driver.switchTo().parentFrame();
        driver.findElement((By.xpath("//*[@id=\"submit\"]"))).click();


        logger.info("Submitting the form");
        //Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("SearchBtn"))), "Clicking successfull");
        //Assert.fail(" not successful");
        Reporter.log("submitting form successfully executed");
        Reporter.log("<a target = \'_blank\' href=''>Screenshot</a>");
        Reporter.log("<br>");
       // Reporter.log("<a target = \'_blank\' href=''><img src='"' height=200 width=200></img></a>");


    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        String sheetname = "CardCredentials";
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
