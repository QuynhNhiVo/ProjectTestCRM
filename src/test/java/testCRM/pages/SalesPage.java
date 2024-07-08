package testCRM.pages;

import static keywords.WebUI.*;
import org.openqa.selenium.By;

public class SalesPage extends CommonPage{
    private By menuSales = By.xpath("//span[contains(normalize-space(),'Sales') and @class='menu-text']");
    private By subProposals = By.xpath("//li[@class='menu-item-sales active']//ul//span[contains(text(),'Proposals')]");
    private By subInvoices = By.xpath("//li[@class='menu-item-sales active']//ul//span[contains(text(),'Invoices')]");
    private By subItems = By.xpath("//li[@class='menu-item-sales active']//ul//span[contains(text(),'Items')]");

    private String titleProposal = "Proposals";
    private By newProposal = By.xpath("//a[normalize-space()='New Proposal']");
    private By inputSubject = By.xpath("//input[@id='subject']");
    private By buttonRelated = By.xpath("//label[@for='rel_type']/following-sibling::div//button/span");
    private By dropdownRelated = By.xpath("//select[@id='rel_type']");
    private By inputTo = By.xpath("//input[@id='proposal_to']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By save = By.xpath("//button[@type='button'][normalize-space()='Save']");

    private String titleInvoices = "Invoices";
    private By newInvoices = By.xpath("//a[normalize-space()='Create New Invoice']");
    private By buttonCustomer = By.xpath("//label[@for='clientid']/following-sibling::div//button/span");
    private By dropdownCustomer = By.xpath("//select[@id='clientid']");

    private String titleItems = "Invoice Items";
    private By newItems = By.xpath("//a[normalize-space()='New Item']");
    private By inputDescription = By.xpath("//input[@id='description']");
    private By inputRate = By.xpath("//input[@id='rate']");
    private By saveItems = By.xpath("//button[normalize-space()='Save']");


    public SalesPage navaigateSubmanu(){
        clickElement(subProposals);
        sleep(2);
        clickElement(subInvoices);
        sleep(2);
        clickElement(subItems);
        sleep(2);
        return this;
    }

    public SalesPage goProposals(){
        clickElement(subProposals);
        softAssertContain(getURLPage(), titleProposal.toLowerCase());
        softAssertEqual(getTitlePage(), titleProposal);
        return this;
    }

    public SalesPage goInvoices(){
        clickElement(subInvoices);
        softAssertContain(getURLPage(), titleInvoices.toLowerCase());
        softAssertEqual(getTitlePage(), titleInvoices);
        return this;
    }

    public SalesPage goItems(){
        clickElement(subItems);
        softAssertContain(getURLPage(), titleItems.toLowerCase());
        softAssertEqual(getTitlePage(), titleItems);
        return this;
    }

    public SalesPage addProposals(){
        clickElement(newProposal);
        setText(inputSubject, );
        chooseDropdown(buttonRelated, dropdownRelated, "text", );
        setText(inputTo, );
        setText(inputEmail, );
        clickElement(save);
        return this;
    }

    public SalesPage addInvoices(){
        clickElement(newInvoices);
        chooseDropdown(buttonCustomer, dropdownCustomer, "text", );
        clickElement(save);
        return this;
    }

    public SalesPage addItems(){
        clickElement(newItems);
        setText(inputDescription, );
        setText(inputRate, );
        clickElement(saveItems);
        return this;
    }
}
