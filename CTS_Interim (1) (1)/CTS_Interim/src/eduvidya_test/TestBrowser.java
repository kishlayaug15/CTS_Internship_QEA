// Loading necessary Packages
package eduvidya_test;


import java.io.IOException;

import org.openqa.selenium.WebDriver;

import eduvidya_utils.DriverSetup;
import eduvidya_utils.ReusableMethod;
import eduvidya_utils.Validations;

// Creating class for browser testing & performing the specified steps. 
public class TestBrowser{
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		driver = DriverSetup.invokeBrowser(); 
		ReusableMethod rMethod= new ReusableMethod(driver);
		rMethod.getApplicationURL();
		String current_title=rMethod.getTitleOfApp();
		System.out.println("------------------------------------");
		System.out.println("Title of the Application:"+current_title);
		System.out.println("------------------------------------");
		String current_URL=rMethod.getTheURL();
		System.out.println("Current URL of the application:"+ current_URL);
		System.out.println("------------------------------------");
		rMethod.verifyTitle();
		System.out.println("------------------------------------");
		rMethod.verifyURL();
		System.out.println("------------------------------------");
		rMethod.clickColleges();
		System.out.println("Colleges link clicked Successfully");
		rMethod.selectCourse();
		System.out.println("--------------------------------------");
		System.out.println("Courses selected Successfully");
		rMethod.selectCity();
		System.out.println("--------------------------------------");
		System.out.println("City selected Successfully");
		rMethod.search();
		System.out.println("--------------------------------------");
		System.out.println("Searching the Data Provided");
		System.out.println("--------------------------------------");
		Validations validate = new Validations(driver);
		boolean isSearchDisplay = validate.checkSearchDisplay();
		System.out.println("Is Search button displayed true/false::"+ isSearchDisplay);
		Thread.sleep(3000);
		DriverSetup.closeBrowser();
		System.out.println("----------------------------------------");
		System.out.println("Browser Closed Successfully");
		}
}

/*
STEPS INVOLVED AFTER LAUNCHING THE BROWSER

Click on "Colleges" link in the Menu bar
Click on "Course" dropdown and select a course (ex: Science)
Click on "City" dropdown and select “Chennai” as city
Click on "Search" button
Verify Search results is displayed or not
Close the browser
 */ 
