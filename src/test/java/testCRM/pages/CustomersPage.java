package testCRM.pages;

import contants.ConfigData;
import helpers.ExcelHelper;
import org.openqa.selenium.By;

import java.util.Hashtable;

import static keywords.WebUI.*;

public class CustomersPage extends CommonPage{

    private String subdirCustomers = "/admin/clients";
    private String totalResult = "///div[@id='clients_info']";

    private By newCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By ipCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By totalCustomers = By.xpath("(//h4[normalize-space()='Customers Summary']/following-sibling::div)//div//span[.='Total Customers']/preceding-sibling::span");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By vatNumber = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By website = By.xpath("//input[@id='website']");
    private By buttonGroup = By.xpath("//select[contains(@id,'groups_in')]/following-sibling::button");
    private By dropdownGroup = By.xpath("//select[contains(@id,'groups_in')]");
    private By buttonCurrency = By.xpath("//select[@id='default_currency']/following-sibling::button");
    private By dropdownCurrency = By.xpath("//select[@id='default_currency']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputZip = By.xpath("//input[@id='zip']");
    private By inputState = By.xpath("//input[@id='state']");
    private By buttonCountry = By.xpath("//select[@id='country']/following-sibling::button");
    private By dropdownCountry = By.xpath("//select[@id='country']");

    private By billingShipping = By.xpath("//a[normalize-space()='Billing & Shipping']");
    private By buttonSavenContact = By.xpath("//button[contains(.,'Save and create contact')]");
    private By buttonSave = By.xpath("//button[@class='btn btn-primary only-save customer-form-submiter']");

    private By inputSearch = By.xpath("//input[@class='form-control input-sm']");
    private By firstResult = By.xpath("//tbody/tr[1]/td[3]/a");
    private By buttonView = By.xpath("//tbody//tr[1]//td[3]//a[.='View']");

    private By menuTasks = By.xpath("//a[@data-group='tasks']");
    private By createTasks = By.xpath("//a[normalize-space()='New Task']");
    private By inputSubject = By.xpath("//input[@id='name']");
    private By saveTasks = By.xpath("//button[normalize-space()='Save']");

    private final ExcelHelper excelHelper;

    public CustomersPage(){
        this.excelHelper = new ExcelHelper();
        excelHelper.setExcelFile(ConfigData.FILE_EXCEL, "Customers");
    }

    public CustomersPage verifyCustomersPage(){
        verifyContain(getURLPage(), subdirCustomers, "URL not True");
        return this;
    }

    public CustomersPage searchCustomers(int row){
        goToCustomerPage();
        clearSetText(inputSearch, excelHelper.getCellData("COMPANY", row));
        return this;
    }

    public CustomersPage searchCustomers(Hashtable<String, String> data){
        goToCustomerPage();
        clearSetText(inputSearch, data.get("COMPANY"));
        return this;
    }

    public CustomersPage addNewCustomer(int row){
        clickElement(newCustomer);
        sleep(2);
        setText(inputCompany, excelHelper.getCellData("COMPANY", row));
        setText(vatNumber, excelHelper.getCellData("VAT", row));
        setText(inputPhone, excelHelper.getCellData("PHONE", row));
        setText(website, excelHelper.getCellData("WEBSITE", row));
        chooseDropdown(buttonGroup, dropdownGroup, "text", excelHelper.getCellData("GROUPS", row).split(", "));
        chooseDropdown(buttonCurrency, dropdownCurrency, "text", excelHelper.getCellData("CURRENT", row).split(", "));
        setText(inputAddress, excelHelper.getCellData("CURRENT", row));
        setText(inputCity, excelHelper.getCellData("CITY", row));
        setText(inputState, excelHelper.getCellData("STATE", row));
        setText(inputZip, excelHelper.getCellData("ZIPCODE", row));
        chooseDropdown(buttonCountry, dropdownCountry, "text", excelHelper.getCellData("COUNTRY", row).split(", "));
        sleep(5);
        clickElement(buttonSave);
        return this;
    }

    public CustomersPage addNewCustomer(Hashtable<String, String> data){
        clickElement(newCustomer);
        sleep(2);
        setText(inputCompany, ("COMPANY"));
        setText(vatNumber, data.get("VAT"));
        setText(inputPhone, data.get("PHONE"));
        setText(website, data.get("WEBSITE"));
        chooseDropdown(buttonGroup, dropdownGroup, "text", data.get("GROUPS").split(", "));
        chooseDropdown(buttonCurrency, dropdownCurrency, "text", data.get("CURRENT").split(", "));
        setText(inputAddress, data.get("CURRENT"));
        setText(inputCity, data.get("CITY"));
        setText(inputState, data.get("STATE"));
        setText(inputZip, data.get("ZIPCODE"));
        chooseDropdown(buttonCountry, dropdownCountry, "text", data.get("COUNTRY").split(", "));
        sleep(5);
        clickElement(buttonSave);
        return this;
    }

    public CustomersPage verifyDataCustomer(int row){
        searchCustomers(row);
        clickElement(buttonView);
        sleep(2);
        softAssertContain(getAttributeElement(inputCompany, "value"), excelHelper.getCellData("COMPANY", row));
        softAssertContain(getAttributeElement(vatNumber, "value"), excelHelper.getCellData("VAT", row));
        softAssertContain(getAttributeElement(inputPhone, "value"), excelHelper.getCellData("PHONE", row));
        softAssertContain(getAttributeElement(website, "value"), excelHelper.getCellData("WEBSITE", row));
        softAssertContain(getTextElement(dropdownGroup), excelHelper.getCellData("GROUPS", row));
        softAssertContain(getFirstOptionSelected(dropdownCurrency), excelHelper.getCellData("CURRENT", row));
        softAssertContain(getAttributeElement(inputAddress, "value"), excelHelper.getCellData("CURRENT", row));
        softAssertContain(getAttributeElement(inputCity, "value"), excelHelper.getCellData("CITY", row));
        softAssertContain(getAttributeElement(inputState, "value"), excelHelper.getCellData("STATE", row));
        softAssertContain(getAttributeElement(inputZip, "value"), excelHelper.getCellData("ZIPCODE", row));
        softAssertContain(getFirstOptionSelected(dropdownCountry), excelHelper.getCellData("COUNTRY", row));
        return this;
    }

    public CustomersPage verifyDataCustomer(Hashtable<String, String> data){
        searchCustomers(data);
        clickElement(buttonView);
        sleep(2);
        softAssertContain(getAttributeElement(inputCompany, "value"), data.get("COMPANY"));
        softAssertContain(getAttributeElement(vatNumber, "value"), data.get("VAT"));
        softAssertContain(getAttributeElement(inputPhone, "value"), data.get("PHONE"));
        softAssertContain(getAttributeElement(website, "value"), data.get("WEBSITE"));
        softAssertContain(getTextElement(dropdownGroup), data.get("GROUPS"));
        softAssertContain(getFirstOptionSelected(dropdownCurrency), data.get("CURRENT"));
        softAssertContain(getAttributeElement(inputAddress, "value"), data.get("CURRENT"));
        softAssertContain(getAttributeElement(inputCity, "value"), data.get("CITY"));
        softAssertContain(getAttributeElement(inputState, "value"), data.get("STATE"));
        softAssertContain(getAttributeElement(inputZip, "value"), data.get("ZIPCODE"));
        softAssertContain(getFirstOptionSelected(dropdownCountry), data.get("COUNTRY"));
        return this;
    }

    public CustomersPage addNewTask (int row){
        searchCustomers(row);
        clickElement(buttonView);
        clickElement(menuTasks);
        clickElement(createTasks);
        setText(inputSubject, excelHelper.getCellData("TASK", row));
        clickElement(saveTasks);
        return this;
    }

    public CustomersPage addNewTask (Hashtable<String, String> data){
        searchCustomers(data);
        clickElement(buttonView);
        clickElement(menuTasks);
        clickElement(createTasks);
        setText(inputSubject, data.get("TASK"));
        clickElement(saveTasks);
        return this;
    }

}
