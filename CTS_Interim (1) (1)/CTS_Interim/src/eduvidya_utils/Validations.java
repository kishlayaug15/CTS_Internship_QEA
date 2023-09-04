// Importing necessary Packages

package eduvidya_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Performing the validation to check whether search button is displayed or not 
public class Validations {
	WebDriver driver;
	public Validations(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean checkSearchDisplay()
	{
		WebElement validate_search = driver.findElement(By.xpath("//input[@type='submit']"));
			return validate_search.isDisplayed();
	}
}
