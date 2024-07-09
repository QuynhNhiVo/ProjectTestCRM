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
    public void TC_FlowCusTomerPageMoreData(Hashtable<String, String> data){
        loginPage.loginCRM()
                .goToCustomerPage()
                .addNewCustomer(data)
                .verifyDataCustomer(data)
                .addNewTask(data);
    }

    @Test
    @Parameters({"row"})
    public void TC_FlowSalesPage(@Optional("1") int row){
        loginPage.loginCRM()
                .goToSalesPage()
                .goProposals()
                .addProposals(row)
                .goToSalesPage()
                .addItems(row)
                .addInvoices(row);
    }

    @Test
    @Parameters({"row"})
    public void TC_FlowContractssPage(@Optional("1") int row){
        loginPage.loginCRM()
                .goContractsPage()
                .addContract(row)
                .search(row)
                .editContract(row)
                .search(row)
                .verifyContract(row);

    }
}
