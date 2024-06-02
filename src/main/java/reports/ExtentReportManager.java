package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import contants.ConfigData;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extentreport/extentreport.html");
        reporter.config().setReportName(ConfigData.FRAMEWORK);
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", ConfigData.FRAMEWORK);
        extentReports.setSystemInfo("Author", ConfigData.AUTHOR);
        return extentReports;
    }
}
