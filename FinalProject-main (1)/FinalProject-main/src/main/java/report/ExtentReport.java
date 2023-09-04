package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	public static ExtentReports report;

	public static ExtentReports getReportInstance() {

		if (report == null) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/resources/report/Report.html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
		}

		return report;
	}
}
