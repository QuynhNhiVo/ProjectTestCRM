package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import contants.ConfigData;
import helpers.PropertiesHelper;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    public synchronized static ExtentReports getExtentReports() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            if (ConfigData.EXTENT_REPORT.equals("true")) {
                ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extentreport/extentreport.html");
                reporter.config().setReportName(PropertiesHelper.getValue("FRAMEWORK"));
                extentReports.attachReporter(reporter);
                extentReports.setSystemInfo("Framework Name", PropertiesHelper.getValue("FRAMEWORK"));
                extentReports.setSystemInfo("Author", PropertiesHelper.getValue("AUTHOR"));
            } else {
                extentReports = null;
            }
        }
        return extentReports;
    }
}
