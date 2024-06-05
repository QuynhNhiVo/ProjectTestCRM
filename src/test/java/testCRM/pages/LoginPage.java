package testCRM.pages;

import contants.ConfigData;
import org.openqa.selenium.By;
import static keywords.WebUI.*;

public class LoginPage extends CommonPage{

    private String subdirLogin = "/admin/authentication";
    private String subdirDashboard = "/admin/";
    private String title = "Perfex CRM | Anh Tester Demo - Login";
    private String msgEmailRequired = "The Email field is required.";
    private String msgPasswordRequired = "The Password field is required.";
    private String msgInvalid = "Invalid email or password";

    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By checkboxremember = By.xpath("//input[@id='remember']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By errorMessage = By.xpath("//div[contains(@class,'alert alert-danger')]");
    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");

    private void openWeb(){
        openURL(ConfigData.URL);
    }

    private void clickBTNLogin(){
        clickElement(buttonLogin);
    }

    private void sendEmail(String email){
        setText(inputEmail, email);
    }

    private void sendPassword(String password){
        setText(inputPassword, password);
    }

    public LoginPage verifyLogout(){
        verifyContain(getURLPage(), subdirLogin, "Logout Failed. Can not redirect to Login page.");
        return new LoginPage();
    }

    public DashboardPage loginCRM(){
        openWeb();
        waiForPageLoad();
        verifyContain(getURLPage(), subdirLogin, "URL Login page Not contain valid subdirectory");
        verifyEqual(getTitlePage(), title, "Title page not match");
        sendEmail(ConfigData.EMAIL);
        sendPassword(ConfigData.PASSWORD);
        clickBTNLogin();
        waiForPageLoad();
        verifyContain(getURLPage(), subdirDashboard, "Login failed. Can not redirect to Dashboard page.");
        return new DashboardPage();
    }

    public DashboardPage loginWithEmailInvalid(String email){
        openWeb();
        waiForPageLoad();
        verifyContain(getURLPage(), subdirLogin, "URL Login page Not contain valid subdirectory");
        verifyEqual(getTitlePage(), title, "Title page not match");
        sendEmail(email);
        sendPassword(ConfigData.PASSWORD);
        clickBTNLogin();
        waiForPageLoad();
        waitForElementVisible(errorMessage);
        verifyEqual(getTextElement(errorMessage), msgInvalid, "Message Invalid not match.");
        return new DashboardPage();
    }

    public DashboardPage loginWithPasswordInvalid(String password){
        openWeb();
        waiForPageLoad();
        verifyContain(getURLPage(), subdirLogin, "URL Login page Not contain valid subdirectory");
        verifyEqual(getTitlePage(), title, "Title page not match");
        sendEmail(ConfigData.EMAIL);
        sendPassword(password);
        clickBTNLogin();
        waiForPageLoad();
        waitForElementVisible(errorMessage);
        verifyEqual(getTextElement(errorMessage), msgInvalid, "Message Invalid not match.");
        return new DashboardPage();
    }

    public DashboardPage loginWithEmailNull(){
        openWeb();
        waiForPageLoad();
        verifyContain(getURLPage(), subdirLogin, "URL Login page Not contain valid subdirectory");
        verifyEqual(getTitlePage(), title, "Title page not match");
        sendEmail(null);
        sendPassword(ConfigData.PASSWORD);
        clickBTNLogin();
        waiForPageLoad();
        waitForElementVisible(errorMessage);
        verifyEqual(getTextElement(errorMessage), msgInvalid, "Message Invalid not match.");
        return new DashboardPage();
    }

    public DashboardPage loginWithPasswordNull(){
        openWeb();
        waiForPageLoad();
        verifyContain(getURLPage(), subdirLogin, "URL Login page Not contain valid subdirectory");
        verifyEqual(getTitlePage(), title, "Title page not match");
        sendEmail(ConfigData.EMAIL);
        sendPassword(null);
        clickBTNLogin();
        waiForPageLoad();
        waitForElementVisible(errorMessage);
        verifyEqual(getTextElement(errorMessage), msgInvalid, "Message Invalid not match.");
        return new DashboardPage();
    }
}
