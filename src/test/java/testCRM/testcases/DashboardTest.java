package testCRM.testcases;

import common.BaseTest;
import org.testng.annotations.Test;
import testCRM.pages.DashboardPage;
import testCRM.pages.LoginPage;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void TC_Logout(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        dashboardPage.logout();
    }
}
