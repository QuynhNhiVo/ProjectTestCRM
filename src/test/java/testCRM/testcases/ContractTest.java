package testCRM.testcases;

import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testCRM.pages.LoginPage;

public class ContractTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void ContractsPage(){
        loginPage = new LoginPage();
    }

    @Test
    @Parameters({"row"})
    public void TC_Verify_Contract(@Optional("1") int row){
        loginPage.loginCRM()
                .goContractsPage()
                .verifyContract(row);
    }

    @Test
    @Parameters({"row"})
    public void TC_Add_Contract(@Optional("1") int row){
        loginPage.loginCRM()
                .goContractsPage()
                .addContract(row);
    }
}
