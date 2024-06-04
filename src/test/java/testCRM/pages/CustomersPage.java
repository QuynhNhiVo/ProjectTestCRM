package testCRM.pages;

import org.openqa.selenium.By;

public class CustomersPage {
    private String subdirCustomers = "/admin/clients";
    private String totalResult = "///div[@id='clients_info']";

    private By newCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By ipCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By ActiveCustomers = By.xpath("(//h4[normalize-space()='Customers Summary']/following-sibling::div)//div//span[normalize-space()='Active Customers']");
    private By inputSearch = By.xpath("//input[@class='form-control input-sm']");
    private By company = By.xpath("//input[@id='name']");
    private By vatNumber = By.xpath("//input[@id='name']");
    private By dropdownBillingType = By.xpath("//select[@id='billing_type']");
    private By startDate = By.xpath("//input[@id='start_date']");
    private By checkboxProgress = By.xpath("//input[@id='progress_from_tasks']");
    private By buttonSavenContact = By.xpath("//button[contains(.,'Save and create contact')]");
    private By buttonSave = By.xpath("//button[@group='submit']");
}
