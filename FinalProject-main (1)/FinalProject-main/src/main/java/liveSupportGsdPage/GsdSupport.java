package liveSupportGsdPage;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GsdSupport {

	public GsdSupport(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//p[@class='Welcome-automated-text']")
	WebElement TitlePage;
	public void verifyTitle(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().frame("appFrame");
		String title = TitlePage.getText();
		if(title.equalsIgnoreCase("Welcome to the all-in-one Live Support!"))
			System.out.println("\n---Welcome Message Verified---");
	}
	
	
	@FindBy(xpath = "//button[@id='menu3']")
	WebElement languageBox;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu langList show']//li")
	List<WebElement> language;
	public void getLanguages() {
		languageBox.click();
		System.out.println("\n---All the Languages present in GSD---");
		for(int i =0;i<language.size();i++) {
			System.out.println(language.get(i).getText());
		}
		languageBox.click();
	}
	
	@FindBy(xpath = "//div[@class='d-flex flex-row titles-row']")
	List<WebElement> support;
	public void getIndiaSupportList() {
		System.out.println("\n---All the Support Present in India's GSD---");
		for(WebElement i:support){
			System.out.println(i.getText());
		}
	}
	
	int max = 55;
	Random random=new Random();
	
	@FindBy(xpath = "//button[@id='menu4']")
	WebElement countryDropdown;
	
	@FindBy(xpath = "(//span[@class='optionCountrySelected'])[3]")
	WebElement countryName;
	public void getCountrySupport(WebDriver driver) throws InterruptedException{
		int a=random.nextInt(max);
		countryDropdown.click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement c1=driver.findElement(By.xpath("(//span[@class='countryFlag'])["+a+"]"));
		jse.executeScript("arguments[0].click();", c1);
		Thread.sleep(1000);

		System.out.println("\n---All the Support Present in "+countryName.getText()+"'s GSD---");
		for(WebElement i:support){
			System.out.println(i.getText());
		}
	}
	
}
