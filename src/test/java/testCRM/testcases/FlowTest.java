package testCRM.testcases;

import dataprovider.DataProviderCustomers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testCRM.pages.LoginPage;

import java.util.Hashtable;

public class FlowTest {
    LoginPage loginPage;

    @BeforeMethod
    public void FlowTest() {
        loginPage = new LoginPage();
    }

    @Test
    @Parameters({"row"})
    public void TC_FlowCusTomerPage(@Optional("1") int row){
        loginPage.loginCRM()
                .goToCustomerPage()
                .addNewCustomer(row)
                .verifyDataCustomer(row)
                .addNewTask(row);
    }

    @Test(dataProvider = "data_add_customers", dataProviderClass = DataProviderCustomers.class)
    public void TC_FlowCusTomerPage(Hashtable<String, String> data){
        loginPage.loginCRM()
                .goToCustomerPage()
                .addNewCustomer(data)
                .verifyDataCustomer(data)
                .addNewTask(data);
    }
}
