package testCRM.testcases;

import common.BaseTest;
import contants.ConfigData;
import helpers.ExcelHelper;
import org.testng.annotations.Test;
import testCRM.pages.CustomersPage;
import testCRM.pages.DashboardPage;
import testCRM.pages.LoginPage;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;
    public CustomerTest(){
        loginPage = new LoginPage();
    }

//    @Test
//    public void TC_AddNewCustomer(){
//        loginPage.loginCRM()
//            .goToCustomerPage()
//            .verifyCustomersPage()
//            .addNewCustomer("COMPANY",
//                "VAT",
//                "PHONE",
//                "WEBSITE",
//                "VIP",
//                "USD",
//                "HCM");
//    }

    @Test()
    public void TC_AddNewCustomerExcel(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile(ConfigData.FILE_EXCEL_CUSTOMERS, "Customers");
        loginPage.loginCRM()
            .goToCustomerPage()
            .verifyCustomersPage()
            .addNewCustomer(
                excelHelper.getCellData("COMPANY",2),
                excelHelper.getCellData("VAT",2),
                excelHelper.getCellData("PHONE",2),
                excelHelper.getCellData("WEBSITE",2),
                excelHelper.getCellData("GROUPS",2).split(", "),
                excelHelper.getCellData("CURRENCY",2).split(", "),
                excelHelper.getCellData("ADDRESS",2));
    }
}
