package testCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

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
    private By billingShipping = By.xpath("//a[normalize-space()='Billing & Shipping']");
    private By buttonSavenContact = By.xpath("//button[contains(.,'Save and create contact')]");
    private By buttonSave = By.xpath("//button[@class='btn btn-primary only-save customer-form-submiter']");

    private By inputSearch = By.xpath("//input[@class='form-control input-sm']");
    private By firstResult = By.xpath("//tbody/tr[1]/td[3]/a");


    private void chooseGroups(String[] groups){
        clickElement(buttonGroup);
        handleDropdown(dropdownGroup, "value", groups);
    }

    private void chooseCurrency(String[] currency){
        clickElement(buttonCurrency);
        handleDropdown(dropdownCurrency, "text", currency);
    }

    private void infoCustomer(String company, String vat, String phone, String web, String[] groups, String[] currency, String address){
        setText(inputCompany, company);
        setText(vatNumber, vat);
        setText(inputPhone, phone);
        setText(website, web);
        clickElement(buttonGroup);
        chooseGroups(groups);
        chooseCurrency(currency);
        setText(inputAddress, address);
        clickElement(billingShipping);
    }

    public CustomersPage verifyCustomersPage(){
        verifyContain(getURLPage(), subdirCustomers, "URL not True");
        return new CustomersPage();
    }

    public CustomersPage addNewCustomer(String company, String vat, String phone, String web, String[] groups, String[] currency, String address){
        clickElement(newCustomer);
        sleep(2);
        setText(inputCompany, company);
        setText(vatNumber, vat);
        setText(inputPhone, phone);
        setText(website, web);
        chooseGroups(groups);
        chooseCurrency(currency);
        setText(inputAddress, address);
//        clickElement(billingShipping);
        sleep(3);
//        clickElement(buttonSave);
        return this;
    }

    public CustomersPage searchCustomer(String company){
        setTextAndKey(inputSearch, company, Keys.ENTER);
        clickElement(firstResult);
        return this;
    }
//
//    public CustomersPage verifyDataCustomer(){
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(getAttributeElement(inputCompany, "value").toLowerCase(),);
//        softAssert.assertEquals(getAttributeElement(vatNumber, "value").toLowerCase(),;
//        softAssert.assertEquals(getAttributeElement(inputPhone, "value").toLowerCase(),);
//        softAssert.assertEquals(getAttributeElement(website, "value").toLowerCase(),);
//        softAssert.assertAll();
//
//        return this;
//    }
}
