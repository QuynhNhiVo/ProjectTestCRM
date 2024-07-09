package dataprovider;

import contants.ConfigData;
import helpers.ExcelHelper;
import helpers.SystemHelper;
import org.testng.annotations.DataProvider;
import utils.LogUtils;

public class DataProviderContracts {
    @DataProvider(name="data_add_contracts")
    public Object[][] dataCustomers(){
        ExcelHelper excelHelper = new ExcelHelper();
        LogUtils.info("Get file data customer: " + SystemHelper.getCurrentDir() + ConfigData.FILE_EXCEL);
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + ConfigData.FILE_EXCEL, "Contracts", 1, 2);
        return data;
    }
}
