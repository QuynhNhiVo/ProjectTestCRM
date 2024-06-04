package testCRM.pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static keywords.WebUI.*;

public class DashboardPage {

    private String subdirLogin = "/admin/authentication";
    private String subdirCustomers = "/admin/clients";
    private String subdirProjects = "/admin/projects";

    private By iconDropdown = By.xpath("//li[@class='icon header-user-profile']");
    private By optionLogout = By.xpath("//a[@href='#' and text()='Logout']");
    private By buttonDashboardOptions = By.xpath("//div[normalize-space()='Dashboard Options']");
    private By labelQuickStatistics = By.xpath("//label[normalize-space()='Quick Statistics']");
    private By invoicesAwaitingPayment = By.xpath("(//span[contains(.,'Invoices Awaiting Payment')])/parent::div/following-sibling::span");
    private By convertedLeads = By.xpath("(//span[contains(.,'Converted Leads')])/parent::div/following-sibling::span");
    private By projectsInProgress = By.xpath("(//span[contains(.,'Projects In Progress')])/parent::div/following-sibling::span");
    private By tasksNotFinished = By.xpath("(//span[contains(.,'Tasks Not Finished')])/parent::div/following-sibling::span");
    private By checkboxQuickStatistics = By.xpath("//input[@id='widget_option_top_stats']");
    private By sectionQuickStatistics = By.xpath("//div[@id='widget-top_stats']");

    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProject = By.xpath("//span[normalize-space()='Projects']");

    private void checkQuickStatics(){
        clickElement(buttonDashboardOptions);
        checkElementIsSelectedAndClick(checkboxQuickStatistics);
    }

    public LoginPage logout(){
        clickElement(iconDropdown);
        clickElement(optionLogout);
        waiForPageLoad();
        verifyContain(getURLPage(), subdirLogin, "Logout Failed. Can not redirect to Login page.");
        return new LoginPage();
    }

    public void verifyOptionsQuickStatistics(){
        checkQuickStatics();
        sleep(1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getTextElement(invoicesAwaitingPayment), "3 / 3","Total Invoices Awaiting Payment not match");
        softAssert.assertEquals(getTextElement(convertedLeads), "6 / 11","Total Converted Leads not match");
        softAssert.assertEquals(getTextElement(projectsInProgress), "5 / 5","Total Projects In Progress not match");
        softAssert.assertEquals(getTextElement(tasksNotFinished), "7 / 8","Total Tasks Not Finished not match");
        softAssert.assertAll();
    }

    public CustomersPage goCustomersPage(){
        clickElement(menuCustomers);
        verifyContain(getURLPage(), subdirCustomers, "URL not True");
        return new CustomersPage();
    }

    public ProjectsPage goProjectsPage(){
        clickElement(menuProject);
        verifyContain(getURLPage(), subdirProjects, "URL not True");
        return new ProjectsPage();
    }
}
