package testCRM.pages;

import org.openqa.selenium.By;

public class LoginPage {

    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class,'alert alert-danger')]");
    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
}
