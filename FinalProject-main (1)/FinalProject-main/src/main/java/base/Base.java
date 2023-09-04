package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import report.ExtentReport;

public class Base {

	public WebDriver driver;
	public ExtentReports report = ExtentReport.getReportInstance();
	public ExtentTest logger;
	public Properties prop;
	

	@BeforeClass
	public void openBrowser() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/resources/properties/config.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (prop.getProperty("browserName").matches("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("browserName").matches("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	}

	// Method to show the failed test cases in the report
	public void reportFail(String report) {
		logger.log(Status.FAIL, report);
		Assert.fail(report);
	}

	// Method to show the passed test cases in the report
	public void reportPass(String report) {
		logger.log(Status.PASS, report);
	}

	public void screenShot(String filename) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/resources/screenshot/" + filename + ".png");

		try {
			FileUtils.copyFile(src, dest);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/resources/screenshot/" + filename + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void closeBrowser() {
		report.flush();
		driver.close();
		driver.quit();
	}
}
