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

    @Test
    public void TC_ComponentInDashboard(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyOptionsQuickStatistics();
    }

    @Test
    public void TC_NavigateToCustomers(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        dashboardPage.goCustomersPage();
    }

    @Test
    public void TC_NavigateToProjects(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        dashboardPage.goProjectsPage();
    }
}
