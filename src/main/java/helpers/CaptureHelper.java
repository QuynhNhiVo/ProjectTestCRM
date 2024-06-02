package helpers;

import contants.ConfigData;
import drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import utils.LogUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureHelper {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    public static void takeScreenShot(String screenshotName){
        try {
            TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            File theDir = new File(SystemHelper.getCurrentDir() + ConfigData.SCREENSHOT_PATH);

            if (!theDir.exists()) {
                LogUtils.error("Folder not Exist. Create new folder: " + theDir);
                theDir.mkdirs();
            }

            FileHandler.copy(source, new File(SystemHelper.getCurrentDir() + ConfigData.SCREENSHOT_PATH + File.separator + screenshotName + "_" + dateFormat.format(new Date()) + ".png"));
            LogUtils.info("Screenshot taken: " + screenshotName);
            LogUtils.info("Screenshot taken current URL: " + DriverManager.getDriver().getCurrentUrl());
        } catch (Exception e) {
            LogUtils.info("Exception while taking screenshot: " + e.getMessage());
        }
    }
}
