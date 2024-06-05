package testCRM.testcases;

import common.BaseTest;
import org.testng.annotations.Test;
import testCRM.pages.DashboardPage;
import testCRM.pages.LoginPage;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    public DashboardTest() {
        loginPage = new LoginPage();
    }

    @Test
    public void TC_Logout() {
        loginPage.loginCRM()
            .logout()
            .verifyLogout();
    }

    @Test
    public void TC_ComponentInDashboard() {
        loginPage.loginCRM()
            .verifyOptionsQuickStatistics();
    }

    @Test
    public void TC_NavigateToCustomers() {
        loginPage.loginCRM()
            .verifyOptionsQuickStatistics()
            .logout()
            .verifyLogout()
            .loginCRM()
            .goToCustomerPage()
            .verifyCustomersPage();
    }

    @Test
    public void TC_NavigateToProjects() {
        loginPage.loginCRM()
            .goToProjectPage()
            .verifyProjectsPage();
    }

}
