package testCRM.testcases;

import common.BaseTest;
import org.testng.annotations.Test;
import testCRM.pages.DashboardPage;
import testCRM.pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    public LoginTest(){
        loginPage = new LoginPage();
    }

    @Test
    public void TC_LoginSuccess(){
        loginPage.loginCRM();
    }

    @Test
    public void TC_LoginFailWithEmailInvalid(){
        loginPage.loginWithEmailInvalid("asd@email.com");
    }

    @Test
    public void TC_LoginFailWithPasswordInvalid(){
        loginPage.loginWithPasswordInvalid("123");
    }
}
