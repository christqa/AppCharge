package AppCharge.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil  extends Base.TestBase {

    public static String screenshotPath;
    public static String screenshotName;

    public static void captureScreenshot() throws IOException {

        File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        screenshotName="error";
        FileUtils.copyFile(srcFile, new File( "C:\\source\\AppCharge\\error.jpg"));



    }







}

