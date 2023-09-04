package oneCognizant;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OneCognizantPage {

	public OneCognizantPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void onectsTitle(WebDriver driver) {
		if(driver.getTitle().equals("OneCognizant")) {
			System.out.println("Title Page verified for oneCognizant");
		}
	}
	
	@FindBy(xpath = "//input[@id='oneC_searchAutoComplete']")
	WebElement searchBox;
	
	@FindBy(xpath = "//div[@class='searchInputIcon']")
	WebElement searchbutton; 
	
	@FindBy(xpath = "//div[@class='appsResultText']")
	WebElement gsdResult;
	
	public void getGsd(Properties prop) throws InterruptedException {
		searchBox.sendKeys(prop.getProperty("search"));
		searchbutton.click();
		Thread.sleep(1000);
		gsdResult.click();
	}
	
}
