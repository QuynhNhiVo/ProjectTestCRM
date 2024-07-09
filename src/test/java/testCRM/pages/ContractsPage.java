package testCRM.pages;

import contants.ConfigData;
import helpers.ExcelHelper;
import org.openqa.selenium.By;

import java.util.Hashtable;

import static keywords.WebUI.*;

public class ContractsPage extends CommonPage{

    private By addContracts = By.xpath("//a[normalize-space()='New Contract']");
    private By buttonCustomers = By.xpath("//label[@for='clientid']/following-sibling::div//button/span");
    private By dropdownCustomers = By.xpath("//select[@id='clientid']");
    private By inputSubjects = By.xpath("//input[@id='subject']");
    private By inputContracts = By.xpath("//div[@id='tab_content']//div[2]//span");
    private By save = By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]");

    private By search = By.xpath("//input[@class='form-control input-sm']");
    private By firstResult = By.xpath("//tbody//tr[1]//td[2]");
    private By view = By.xpath("//tr[@class='has-row-options odd']//a[contains(text(),'View')]");
    private By edit = By.xpath("//tr[@class='has-row-options odd']//a[contains(text(),'Edit')]");
    private By description = By.xpath("//form[@id='contract-form']//textarea[@id='description']");
    private By saveEdit = By.xpath("//div[@class='btn-bottom-toolbar text-right']//button[@type='submit'][normalize-space()='Save']");

    private By nameContract = By.xpath("//div[@class='top']//h4");
    private By contentContract = By.xpath("(//div[@class='row'])[4]/div[1]//span");

    private final ExcelHelper excelHelper;

    public ContractsPage(){
        excelHelper = new ExcelHelper();
        excelHelper.setExcelFile(ConfigData.FILE_EXCEL, "Contracts");
    }

    public ContractsPage addContract(int row){
        clickElement(addContracts);
        sendkeyDropdown(buttonCustomers, dropdownCustomers, excelHelper.getCellData("CUSTOMER", row).split(", "));
        setText(inputSubjects, excelHelper.getCellData("SUBJECTS", row));
        clickElement(save);
        return this;
    }

    public ContractsPage addContract(Hashtable<String, String> data){
        clickElement(addContracts);
        sendkeyDropdown(buttonCustomers, dropdownCustomers, data.get("CUSTOMER").split(", "));
        setText(inputSubjects, data.get("SUBJECTS"));
        clickElement(save);
        return this;
    }

    public ContractsPage search(int row){
        goContractsPage();
        clearSetText(search, excelHelper.getCellData("CUSTOMER", row));
        return this;
    }

    public ContractsPage search(Hashtable<String, String> data){
        goContractsPage();
        clearSetText(search, data.get("CUSTOMER"));
        return this;
    }

    public ContractsPage editContract(int row) {
        moveTo(firstResult);
        clickElement(edit);
        moveTo(firstResult);
        setText(description, excelHelper.getCellData("DESCRIPTION", row));
        clickElement(saveEdit);
        return this;
    }

    public ContractsPage editContract(Hashtable<String, String> data) {
        moveTo(firstResult);
        clickElement(edit);
        moveTo(firstResult);
        setText(description, data.get("DESCRIPTION"));
        clickElement(saveEdit);
        return this;
    }

    public ContractsPage verifyContract(int row) {
        sleep(2);
        moveTo(firstResult);
        clickElement(view);
        sleep(2);
        softAssertEqual(getTextElement(nameContract).toLowerCase(), excelHelper.getCellData("SUBJECTS", row));
        softAssertEqual(getTextElement(contentContract), excelHelper.getCellData("CONTENT", row));
        closeTab();
        return this;
    }

}
