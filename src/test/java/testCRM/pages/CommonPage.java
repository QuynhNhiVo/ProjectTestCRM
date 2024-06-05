package testCRM.pages;

import org.openqa.selenium.By;

import static keywords.WebUI.*;

public class CommonPage {
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public CustomersPage customersPage;
    public ProjectsPage projectsPage;

    private By iconDropdown = By.xpath("//li[@class='icon header-user-profile']");
    private By optionLogout = By.xpath("//a[@href='#' and text()='Logout']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProject = By.xpath("//span[normalize-space()='Projects']");


    public LoginPage logout(){
        clickElement(iconDropdown);
        clickElement(optionLogout);
        return new LoginPage();
    }

    public CustomersPage goToCustomerPage(){
        clickElement(menuCustomers);
        return new CustomersPage();
    }

    public ProjectsPage goToProjectPage(){
        clickElement(menuProject);
        return new ProjectsPage();
    }

    public LoginPage getLoginPage(){
        if(loginPage==null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public DashboardPage getDashboardPagePage(){
        if(dashboardPage==null){
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public CustomersPage getCustomersPagePage(){
        if(customersPage==null){
            customersPage = new CustomersPage();
        }
        return customersPage;
    }

    public ProjectsPage getProjectsPagePage(){
        if(projectsPage==null){
            projectsPage = new ProjectsPage();
        }
        return projectsPage;
    }
}
