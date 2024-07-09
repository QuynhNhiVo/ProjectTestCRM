package testCRM.pages;

import static keywords.WebUI.*;

import contants.ConfigData;
import helpers.ExcelHelper;
import org.openqa.selenium.By;

import java.util.Hashtable;

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
    private By inputEmail = By.xpath("//input[@id='email']");
    private By buttonItemP = By.xpath("//a[@data-toggle='modal']");
    private By submit = By.xpath("//button[@type='submit']");
    private By inputDiscount = By.xpath("//input[@name='discount_percent']");
    private By inputAdj = By.xpath("//input[@name='adjustment']");
    private By warningForgot = By.xpath("//div[@id='items-warning']/i");
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

    private final ExcelHelper excelHelper;

    public SalesPage() {
        excelHelper = new ExcelHelper();
        excelHelper.setExcelFile(ConfigData.FILE_EXCEL, "Sales");
    }

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

    public SalesPage addProposals(int row){
        clickElement(newProposal);
        setText(inputSubject, excelHelper.getCellData("P_SUBJECT", row));
        chooseDropdown(buttonRelated, dropdownRelated, "text", excelHelper.getCellData("RELATED", row).split(", "));
        setText(inputEmail, excelHelper.getCellData("EMAIL", row));
        clickElement(buttonItemP);
        setText(inputDescription, excelHelper.getCellData("DESCRIPTION_I", row));
        setText(inputRate, excelHelper.getCellData("RATE", row));
        clickElement(submit);
        setText(inputDiscount, excelHelper.getCellData("DISCOUNT", row));
        setText(inputAdj, excelHelper.getCellData("ADJUSTMENT", row));
        clickElement(save);
        clickElement(warningForgot);
        clickElement(save);
        return this;
    }

    public SalesPage addProposals(Hashtable<String, String> data){
        clickElement(newProposal);
        setText(inputSubject, data.get("P_SUBJECT"));
        chooseDropdown(buttonRelated, dropdownRelated, "text", data.get("RELATED").split(", "));
        setText(inputEmail, data.get("EMAIL"));
        clickElement(buttonItemP);
        setText(inputDescription, data.get("DESCRIPTION_I"));
        setText(inputRate, data.get("RATE"));
        clickElement(submit);
        setText(inputDiscount, data.get("DISCOUNT"));
        setText(inputAdj, data.get("ADJUSTMENT"));
        clickElement(save);
        clickElement(warningForgot);
        clickElement(save);
        return this;
    }

    public SalesPage addInvoices(int row){
        clickElement(newInvoices);
        chooseDropdown(buttonCustomer, dropdownCustomer, "text", excelHelper.getCellData("CUSTOMER", row).split(", "));
        clickElement(buttonItemP);
        setText(inputDescription, excelHelper.getCellData("DESCRIPTION_I", row));
        setText(inputRate, excelHelper.getCellData("RATE", row));
        clickElement(submit);
        setText(inputDiscount, excelHelper.getCellData("DISCOUNT", row));
        setText(inputAdj, excelHelper.getCellData("ADJUSTMENT", row));
        clickElement(save);
        clickElement(warningForgot);
        clickElement(save);
        return this;
    }

    public SalesPage addInvoices(Hashtable<String, String> data){
        clickElement(newInvoices);
        chooseDropdown(buttonCustomer, dropdownCustomer, "text", data.get("CUSTOMER").split(", "));
        clickElement(buttonItemP);
        setText(inputDescription, data.get("DESCRIPTION_I"));
        setText(inputRate, data.get("RATE"));
        clickElement(submit);
        setText(inputDiscount, data.get("DISCOUNT"));
        setText(inputAdj, data.get("ADJUSTMENT"));
        clickElement(save);
        clickElement(warningForgot);
        clickElement(save);
        return this;
    }

    public SalesPage addItems(int row){
        clickElement(newItems);
        setText(inputDescription, excelHelper.getCellData("DESCRIPTION_I", row));
        setText(inputRate, excelHelper.getCellData("RATE", row));
        clickElement(saveItems);
        return this;
    }

    public SalesPage addItems(Hashtable<String, String> data){
        clickElement(newItems);
        setText(inputDescription, data.get("DESCRIPTION_I"));
        setText(inputRate, data.get("RATE"));
        clickElement(saveItems);
        return this;
    }
}
