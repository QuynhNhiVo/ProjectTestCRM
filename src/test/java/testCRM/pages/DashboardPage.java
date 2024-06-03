package testCRM.pages;

import org.openqa.selenium.By;
import static keywords.WebUI.*;

public class DashboardPage {

    private String subdirLogin = "/admin/authentication";
    private By iconDropdown = By.xpath("//li[@class='icon header-user-profile']");
    private By optionLogout = By.xpath("//a[@href='#' and text()='Logout']");


    private By buttonDashboardOptions = By.xpath("//div[normalize-space()='Dashboard Options']");
    private By invoicesAwaitingPayment = By.xpath("(//span[contains(.,'Invoices Awaiting Payment')])/parent::div/following-sibling::span");
    private By convertedLeads = By.xpath("(//span[contains(.,'Converted Leads')])/parent::div/following-sibling::span");
    private By projectsInProgress = By.xpath("(//span[contains(.,'Projects In Progress')])/parent::div/following-sibling::span");
    private By tasksNotFinished = By.xpath("(//span[contains(.,'Tasks Not Finished')])/parent::div/following-sibling::span");
    private By checkboxQuickStatistics = By.xpath("//input[@id='widget_option_top_stats']");
    private By sectionQuickStatistics = By.xpath("//div[@id='widget-top_stats']");

    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");

    public LoginPage logout(){
        clickElement(iconDropdown);
        clickElement(optionLogout);
        waiForPageLoad();
        verifyContain(getURLPage(), subdirLogin, "Logout Failed. Can not redirect to Login page.");
        return new LoginPage();
    }

}
