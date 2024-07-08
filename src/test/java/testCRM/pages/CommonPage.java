package testCRM.pages;

import org.openqa.selenium.By;

import static keywords.WebUI.*;

public class CommonPage {
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public CustomersPage customersPage;
    public ProjectsPage projectsPage;
    public SalesPage salesPage;
    public ContractsPage contractsPage;

    private By iconDropdown = By.xpath("//li[@class='icon header-user-profile']");
    private By optionLogout = By.xpath("//a[@href='#' and text()='Logout']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProject = By.xpath("//span[normalize-space()='Projects']");
    private By menuSales = By.xpath("//span[contains(normalize-space(),'Sales') and @class='menu-text']");
    private By menuContracts = By.xpath("//span[normalize-space()='Contracts']");

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

    public SalesPage goToSalesPage(){
        clickElement(menuSales);
        return new SalesPage();
    }

    public ContractsPage goContractsPage(){
        clickElement(menuContracts);
        return new ContractsPage();
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

    public SalesPage getSalesPage(){
        if (salesPage == null) {
            salesPage = new SalesPage();
        }
        return salesPage;
    }

    public ContractsPage getContractsPage(){
        if (contractsPage == null) {
            contractsPage = new ContractsPage();
        }
        return contractsPage;
    }
}
