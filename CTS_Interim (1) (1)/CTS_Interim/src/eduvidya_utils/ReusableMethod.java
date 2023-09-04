// Importing necessary Packages

package eduvidya_utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class ReusableMethod {

	WebDriver driver;
	public ReusableMethod(WebDriver driver) {
	this.driver = driver;
	}
	
//	To get the suggested site(url) from the File
	public void getApplicationURL() {
		try{
			String Url=DriverSetup.prop.getProperty("url");
			driver.get(Url);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Invalid URL");
			}
		}
	
//	To get the Title of the particular suggested site
	public String getTitleOfApp() {
		return driver.getTitle();
		}
//	To get the current URL of the suggested site
	public String getTheURL() {
		return driver.getCurrentUrl();
		}
	
//	Title Verification
	public void verifyTitle() {
		String actual_title="Colleges|Schools|Universities|Exams|Courses|Distance Education|India|Eduvidya.com|";
		String expected_title=driver.getTitle();
		if(actual_title.equals(expected_title)) {
			System.out.println("Title is Matched! ===> Test Case Passed");
		}else {
			System.out.println("Title not matched ===> Test case Failed");
			}
	}
	
//	URL Verification
	public void verifyURL() {
		String actual_URL="https://www.eduvidya.com/";
		String expected_URL=driver.getCurrentUrl();
		if(actual_URL.equals(expected_URL)) {
			System.out.println("URL is Matched! ===> Test Case Passed");
		}else 
		{
	System.out.println("URL not matched ===> Test case Failed");
	}
	}
	
//	Navigating to College WebPage through LinkText in-built method
	public void clickColleges() {
		driver.findElement(By.linkText("Colleges")).click();
	
	}
	
//	Selection from the given dropdown courses
	public void selectCourse() {
		Select course = new Select(driver.findElement(By.id("ddl_Category")));
		course.selectByVisibleText("Science");
	}
	
//	Selection from the given dropdown cities
	public void selectCity() {
		Select city = new Select(driver.findElement(By.id("ddl_City")));
		city.selectByVisibleText("Chennai");
	}
	
//	Perform the Searching operations
	public void search() {
		driver.findElement(By.id("btnSearch")).click();
	}
}
