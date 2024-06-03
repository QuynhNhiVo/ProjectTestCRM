package testCRM.testcases;

import common.BaseTest;
import org.testng.annotations.Test;
import testCRM.pages.DashboardPage;
import testCRM.pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void TC_LoginSuccess(){
        loginPage = new LoginPage();
        loginPage.loginCRM();
    }

    @Test
    public void TC_LoginFailWithEmailInvalid(){
        loginPage = new LoginPage();
        loginPage.loginWithEmailInvalid("asd@email.com");
    }

    @Test
    public void TC_LoginFailWithPasswordInvalid(){
        loginPage = new LoginPage();
        loginPage.loginWithPasswordInvalid("123");
    }
}
