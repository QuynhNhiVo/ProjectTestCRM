package dataprovider;

import contants.ConfigData;
import helpers.ExcelHelper;
import helpers.SystemHelper;
import org.testng.annotations.DataProvider;
import utils.LogUtils;

public class DataProviderCustomers {
    @DataProvider(name="data_add_customers")
    public Object[][] dataCustomers(){
        ExcelHelper excelHelper = new ExcelHelper();
        LogUtils.info("Get file data customer: " + SystemHelper.getCurrentDir() + ConfigData.FILE_EXCEL_CUSTOMERS);
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + ConfigData.FILE_EXCEL_CUSTOMERS, "Customers", 1, 2);
        return data;
    }
}
