package testCRM.testcases;

import common.BaseTest;
import dataprovider.DataProviderCustomers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testCRM.pages.LoginPage;

import java.util.Hashtable;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void CustomerTest() {
        loginPage = new LoginPage();
    }

    @Test()
    @Parameters({"row"})
    public void TC_AddNewSpecifiedCustomerExcel(@Optional("1") int row) {
        loginPage.loginCRM()
                .goToCustomerPage()
                .addNewCustomer(row);
    }

    @Test(dataProvider = "data_add_customers", dataProviderClass = DataProviderCustomers.class)
    public void TC_AddNewCustomersExcel(Hashtable<String, String> data) {
        loginPage.loginCRM()
                .goToCustomerPage()
                .addNewCustomer(data);
    }

    @Test
    @Parameters({"row"})
    public void TC_verifySpecifiedDataCustomer(@Optional("1") int row){
        loginPage.loginCRM()
                .goToCustomerPage()
                .verifyDataCustomer(row);
    }

    @Test(dataProvider = "data_add_customers", dataProviderClass = DataProviderCustomers.class)
    public void TC_verifyDataCustomer(Hashtable<String, String> data){
        loginPage.loginCRM()
                .goToCustomerPage()
                .verifyDataCustomer(data);
    }

    @Test
    @Parameters({"row"})
    public void TC_verifySpecifiedAddNewTask(@Optional("1")int row){
        loginPage.loginCRM()
                .goToCustomerPage()
                .addNewTask(row);
    }

    @Test(dataProvider = "data_add_customers", dataProviderClass = DataProviderCustomers.class)
    public void TC_verifyAddNewTask(Hashtable<String, String> data){
        loginPage.loginCRM()
                .goToCustomerPage()
                .addNewTask(data);
    }

}
