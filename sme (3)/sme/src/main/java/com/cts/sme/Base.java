package com.cts.sme;

// Importing the Packages
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


// Defining the Variables within class
public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentHtmlReporter exthtml;
	public static ExtentTest exttest;
	public static ExtentReports report;

// Setting up the Driver for Automating the WebBrowser
	public static void driverSetup() {
		
//		ExtentReports for better Interactive view
		exthtml = new ExtentHtmlReporter("Report\\Report.html");
		report = new ExtentReports();
		report.attachReporter(exthtml);
		
		exttest = report.createTest("Setting Up the Driver");
		prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/java/Config/Config.properties")); // Loading the properties
		} catch (Exception e) {
			e.printStackTrace();
		}
			if (prop.getProperty("browserName").matches("chrome")) {
//				System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (prop.getProperty("browserName").matches("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		driver.manage().window().maximize(); // To maximize the window
		System.out.println("Driver Launched:");
	}

	public static void openUrl() throws IOException // Method to open URL
	{
		exttest = report.createTest("Launching the URL");
		System.out.println("Page Launched:");
	try {
		driver.get(prop.getProperty("url"));
		reportPass("URL opened, URL is :" + prop.getProperty("url"));
	}catch(Exception e) {
			reportFail(e.getMessage());
	}
	}
	
	// Function to show the failed test cases in the report
		public static void reportFail(String report) throws IOException {
			exttest.log(Status.FAIL, report);
			captureScreenshot();
		}

		// Function to show the passed test cases in the report
		public static void reportPass(String report) {
			exttest.log(Status.PASS, report);
		}

	public static void captureScreenshot() throws IOException // Capturing the ScreenShot of Error
	{
		exttest = report.createTest("Capturing the Screenshot");
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot screen=(TakesScreenshot)driver;
		File source=screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshot/"+timeStamp+"_screenshot.png"));
		System.out.println("Screenshot is successfully captured");
	}
	

	public static void refreshPage() // method to Refresh the page
	{
		exttest = report.createTest("Refreshing the Page");
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void closeBrowser() // method to close the browser
	{
		exttest = report.createTest("Closing the Page");
		System.out.println("Driver Closed:");
		driver.quit(); // To close the browser
		report.flush();
	}
}