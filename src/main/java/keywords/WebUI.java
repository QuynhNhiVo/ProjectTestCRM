package keywords;

import contants.ConfigData;
import drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LogUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebUI {

    public static WebDriver getDriver(){
        return DriverManager.getDriver();
    }

    public static WebElement getWebElement(By by){
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> getWebElements(By by){
        return getDriver().findElements(by);
    }

    @Step("Open URL: {0}")
    public static void openURL(String URL){
        DriverManager.getDriver().get(URL);
        waiForPageLoad();
        LogUtils.info("Open URL: " + URL);
    }

    @Step("Get current URL")
    public static String getURLPage(){
        LogUtils.info("Current URL: " + getDriver().getCurrentUrl());
        return getDriver().getCurrentUrl();
    }

    @Step("Get title page")
    public static String getTitlePage(){
        LogUtils.info("Title page: " + getDriver().getTitle());
        return getDriver().getTitle();
    }

    @Step("Click Element: {0}")
    public static void clickElement(By by){
        waitForElementClickable(by);
        getWebElement(by).click();
        LogUtils.info("Click Element: " + by.toString());
    }

    @Step("Set text : {1} For Element: {0} ")
    public static void setText(By by, String text){
        waitForElementVisible(by);
        getWebElement(by).sendKeys(text);
        LogUtils.info("Set text:" + text + " - For Element: " + by);
    }

    @Step("Set text :{ 1} And Key: {2} - For Element: {0}")
    public static void setTextAndKey(By by, String text, Keys keys){
        waiForPageLoad();
        getWebElement(by).sendKeys(text, keys);
        LogUtils.info("Set text:" + text+ " - And Key: " + keys + " - For Element: " + by);
    }

    @Step("Send key: {1} - For Element: {0}")
    public static void sendKey(By by, Keys keys){
        waiForPageLoad();
        getWebElement(by).sendKeys(keys);
        LogUtils.info("Send key:" + keys + " - For Element: " + by);
    }

    @Step("Get text of element {0}")
    public static String getTextElement(By by){
        waitForElementVisible(by);
        LogUtils.info("Text of Element: " + by + " - Is: " + getWebElement(by).getText());
        return getWebElement(by).getText();
    }

    @Step("Get list text of elements {0}")
    public static List<String> getTextListElement(By by){
        waiForPageLoad();
        List<WebElement> list = getWebElements(by);
        List<String> text = new ArrayList<>();
        for (WebElement i : list){
            text.add(i.getText());
        }
        return text;
    }

    @Step("Get attribute {1} of element {0}")
    public static String getAttributeElement(By by, String atb){
        return getWebElement(by).getAttribute(atb);
    }

    @Step("Clear placeholder on Element: {0}")
    public static void clearTextElement(By by){
        getWebElement(by).clear();
        LogUtils.info("Clear placeholder on element: " + by );
    }

    @Step("Clear placeholder on Element: {0} - set text {1}")
    public static void clearAndSetTextElement(By by, String text) {
        waitForElementVisible(by);
        getWebElement(by).clear();
        getWebElement(by).sendKeys(text);
        LogUtils.info("Clear placeholder and Set text on Element: " + by + " - Text: " + text);
    }


////VERIFY///////////////////////////////////////////////////////////////////////////////
    @Step("Verify visible of element {0}")
    public static boolean verifyElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigData.TIMEOUT), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            LogUtils.info("Verify element visible: " + by);
            return true;
        } catch (Exception e) {
            LogUtils.error(ConfigData.TIMEOUT + "(s) Element is Not visible. " + e.getMessage());
            Assert.fail(ConfigData.TIMEOUT + "(s) Element is Not visible. " + e.getMessage());
            return false;
        }
    }

    @Step("Verify visible of element {0} in {1}s")
    public static boolean verifyElementVisible(By by, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            LogUtils.info("Verify element visible: " + by);
            return true;
        } catch (Exception e) {
            LogUtils.error(timeout + "(s) Element is Not visible. " + e.getMessage());
            Assert.fail(timeout + "(s) Element is Not visible. " + e.getMessage());
            return false;
        }
    }

    @Step("Verify visible of element {0}")
    public static boolean verifyElementVisible(By by, String message){
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigData.TIMEOUT), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            LogUtils.info("Verify element visible: " + by);
            return true;
        }catch (Exception e){
            if(message.isEmpty() || message == null){
                LogUtils.error(ConfigData.TIMEOUT + "(s) Element is Not visible. " + e.getMessage());
                Assert.fail(ConfigData.TIMEOUT + "(s) Element is Not visible. " + e.getMessage());
            }else {
                LogUtils.error(message + " :" + by);
                Assert.fail(message + " :" + by);
            }
            return false;
        }
    }

    @Step("Verify visible of element {0} in {1}s")
    public static boolean verifyElementVisible(By by, int timeout, String message){
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            LogUtils.info("Verify element visible: " + by);
            return true;
        }catch (Exception e){
            if(message.isEmpty() || message == null){
                LogUtils.error(timeout + "(s) Element is Not visible. " + e.getMessage());
                Assert.fail(timeout + "(s) Element is Not visible. " + e.getMessage());
            }else {
                LogUtils.error(message + " :" + by);
                Assert.fail(message + " :" + by);
            }
            return false;
        }
    }

    @Step("Verify present of element {0}")
    public static boolean verifyElementPresent(By by){
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigData.TIMEOUT), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            LogUtils.info("Verify Element present: " + by);
            return true;
        }catch (Exception e){
            LogUtils.error(ConfigData.TIMEOUT + "(s) Element is Not present. " + e.getMessage());
            Assert.fail(ConfigData.TIMEOUT + "(s) Element is Not present. " + e.getMessage());
            return false;
        }
    }

    @Step("Verify present of element {0} in {1}s")
    public static boolean verifyElementPresent(By by, int timeout){
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            LogUtils.info("Verify Element present: " + by);
            return true;
        }catch (Exception e){
            LogUtils.error(timeout + "(s) Element is Not present. " + e.getMessage());
            Assert.fail(timeout + "(s) Element is Not present. " + e.getMessage());
            return false;
        }
    }

    @Step("Verify present of element {0}")
    public static boolean verifyElementPresent(By by, String message) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigData.TIMEOUT), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            LogUtils.info("Verify Element present: " + by);
            return true;
        } catch (Exception e) {
            if (message.isEmpty() || message == null) {
                LogUtils.error(ConfigData.TIMEOUT + "(s) Element is Not present. " + e.getMessage());
                Assert.fail(ConfigData.TIMEOUT + "(s) Element is Not present. " + e.getMessage());
            } else {
                LogUtils.error(message + " :" + by);
                Assert.fail(message + " :" + by);
            }
            return false;
        }
    }

    @Step("Verify present of element {0} in {1}s")
    public static boolean verifyElementPresent(By by, int timeout, String message) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            LogUtils.info("Verify Element present: " + by);
            return true;
        } catch (Exception e) {
            if (message.isEmpty() || message == null) {
                LogUtils.error(timeout + "(s) Element is Not present. " + e.getMessage());
                Assert.fail(timeout + "(s) Element is Not present. " + e.getMessage());
            } else {
                LogUtils.error(message + " :" + by);
                Assert.fail(message + " :" + by);
            }
            return false;
        }
    }

    @Step("Verify clickable of element {0}")
    public static boolean verifyElementClickable(By by){
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigData.TIMEOUT), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            LogUtils.info("Verify Element clickable: " + by);
            return true;
        }catch (Exception e){
            LogUtils.error(ConfigData.TIMEOUT + "(s) Element is Not clickable. " + e.getMessage());
            Assert.fail(ConfigData.TIMEOUT + "(s) Element is Not clickable. " + e.getMessage());
            return false;
        }
    }

    @Step("Verify clickable of element {0} in {1}s")
    public static boolean verifyElementClickable(By by, int timeout){
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            LogUtils.info("Verify Element clickable: " + by);
            return true;
        }catch (Exception e){
            LogUtils.error(timeout + "(s) Element is Not clickable. " + e.getMessage());
            Assert.fail(timeout + "(s) Element is Not clickable. " + e.getMessage());
            return false;
        }
    }

    @Step("Verify clickable of element {0}")
    public static boolean verifyElementClickable(By by, String message) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigData.TIMEOUT), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            LogUtils.info("Verify Element clickable: " + by);
            return true;
        } catch (Exception e) {
            if (message.isEmpty() || message == null) {
                LogUtils.error(ConfigData.TIMEOUT + "(s) Element is Not clickable. " + e.getMessage());
                Assert.fail(ConfigData.TIMEOUT + "(s) Element is Not clickable. " + e.getMessage());
            } else {
                LogUtils.error(message + " :" + by);
                Assert.fail(message + " :" + by);
            }
            return false;
        }
    }

    @Step("Verify clickable of element {0} in {1}s")
    public static boolean verifyElementClickable(By by, int timeout, String message) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(ConfigData.STEP_TIME));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            LogUtils.info("Verify Element present: " + by);
            return true;
        } catch (Exception e) {
            if (message.isEmpty() || message == null) {
                LogUtils.error(timeout + "(s) Element is Not clickable. " + e.getMessage());
                Assert.fail(timeout + "(s) Element is Not clickable. " + e.getMessage());
            } else {
                LogUtils.error(message + " :" + by);
                Assert.fail(message + " :" + by);
            }
            return false;
        }
    }

    @Step("Verify {0} is True")
    public static boolean verifyTrue(boolean condition){
        if(condition){
            LogUtils.info("Verify True expected: " + condition);
        }else {
            LogUtils.error("Verify True expected: " + condition);
        }
        return condition;
    }

    @Step("Verify {0} is True")
    public static boolean verifyTrue(boolean condition, String message){
        if(condition){
            LogUtils.info("Verify True expected: " + condition);
        }else {
            LogUtils.error("Verify True expected: " + condition);
            Assert.assertTrue(condition, message);
        }
        return condition;
    }

    @Step("Verify {0} equal {1}")
    public static boolean verifyEqual(Object value1, Object value2){
        boolean check = value1.equals(value2);
        if(check){
            LogUtils.info("Verify Equal -" + value1 + "- And -" + value2);
        }else {
            LogUtils.error("Verify Equal -" + value1 + "- And -" + value2);
            Assert.assertEquals(value1,value2);
        }
        return check;
    }

    @Step("Verify {0} equal {1}")
    public static boolean verifyEqual(Object value1, Object value2, String message){
        boolean check = value1.equals(value2);
        if(check){
            LogUtils.info("Verify Equal -" + value1 + "- And -" + value2);
        }else {
            LogUtils.error("Verify Equal -" + value1 + "- And -" + value2);
            Assert.assertEquals(value1,value2, message);
        }
        return check;
    }

    @Step("Verify {0} contain {1}")
    public static boolean verifyContain(String value1, String value2){
        boolean check = value1.contains(value2);
        if(check){
            LogUtils.info("Verify Equal -" + value1 + "- And -" + value2);
        }else {
            LogUtils.error("Verify Equal -" + value1 + "- And -" + value2);
            Assert.assertTrue(check);
        }
        return check;
    }

    @Step("Verify {0} contain {1}")
    public static boolean verifyContain(String value1, String value2, String message){
        boolean check = value1.contains(value2);
        if(check){
            LogUtils.info("Verify Contain -" + value1 + "- And -" + value2);
        }else {
            LogUtils.error("Verify Contain -" + value1 + "- And -" + value2);
            Assert.assertTrue(check, message);
        }
        return check;
    }


    ////WAIT///////////////////////////////////////////////////////////////////////////////
    public static void waiForPageLoad(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigData.PAGE_LOAD_TIMEOUT), Duration.ofMillis(ConfigData.STEP_TIME));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");
        if(!jsReady){
            LogUtils.info("Javascript in Not Ready!");
            try {
                wait.until(jsLoad);
            }catch (Throwable e){
                e.printStackTrace();
                Assert.fail("Timeout waiting for page load: " + ConfigData.PAGE_LOAD_TIMEOUT + ". " + e);
            }
        }
    }

    public static void waiForPageLoad(int timeLoad){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeLoad), Duration.ofMillis(ConfigData.STEP_TIME));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");
        if(!jsReady){
            LogUtils.info("Javascript in Not Ready!");
            try {
                wait.until(jsLoad);
            }catch (Throwable e){
                e.printStackTrace();
                Assert.fail("Timeout waiting for page load: " + timeLoad + ". " + e);
            }
        }
    }

    public static WebElement waitForElementVisible(By by){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigData.TIMEOUT), Duration.ofMillis(ConfigData.STEP_TIME));
            boolean check = verifyElementVisible(by);
            if(check){
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }else {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
        }catch (Throwable e){
            LogUtils.error("Time out waiting for element visible. " + e.getMessage());
            Assert.fail("Time out waiting for element visible. " + e.getMessage());
        }
        return null;
    }

    public static WebElement waitForElementVisible(By by, int timeout){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(ConfigData.STEP_TIME));
            boolean check = verifyElementVisible(by);
            if(check){
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }else {
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
        }catch (Throwable e){
            LogUtils.error("Time out waiting for element visible. " + e.getMessage());
            Assert.fail("Time out waiting for element visible. " + e.getMessage());
        }
        return null;
    }

    public static WebElement waitForElementPresent(By by){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigData.TIMEOUT), Duration.ofMillis(ConfigData.STEP_TIME));
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Throwable e){
            LogUtils.error("Element Not present: " + e.getMessage());
            Assert.fail("Element Not present: " + e.getMessage());
        }
        return null;
    }

    public static WebElement waitForElementPresent(By by, int timeout){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(ConfigData.STEP_TIME));
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Throwable e){
            LogUtils.error("Element Not present: " + e.getMessage());
            Assert.fail("Element Not present: " + e.getMessage());
        }
        return null;
    }

    public static WebElement waitForElementClickable(By by){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(ConfigData.TIMEOUT), Duration.ofMillis(ConfigData.STEP_TIME));
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Throwable e){
            LogUtils.error("Timeout waiting for the element ready to click. " + e.getMessage());
            Assert.fail("Timeout waiting for the element ready to click. " + e.getMessage());
        }
        return null;
    }

    public static WebElement waitForElementClickable(By by, int timeout){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(ConfigData.STEP_TIME));
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Throwable e){
            LogUtils.error("Timeout waiting for the element ready to click. " + e.getMessage());
            Assert.fail("Timeout waiting for the element ready to click. " + e.getMessage());
        }
        return null;
    }

    public static void sleep(double time){
        try{
            Thread.sleep((long) (time * 1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
