package testCRM.testcases;

import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testCRM.pages.LoginPage;

public class SalesTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void SalesTest(){
        loginPage = new LoginPage();
    }

    @Test
    public void TC_Navigate(){
        loginPage.loginCRM().goToSalesPage().navaigateSubmanu();
    }


}
