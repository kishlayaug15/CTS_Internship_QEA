package beCognizantPage;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeCognizantPage {

	WebDriverWait wait;
	
	public BeCognizantPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "loginfmt")
	WebElement emailid;
	@FindBy(id = "idSIButton9")
	WebElement next;
	@FindBy(name = "passwd")
	WebElement pass;
	
	public void sendUserDetails(Properties prop,WebDriver driver) throws InterruptedException{
		
		driver.get(prop.getProperty("URL"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(emailid));
		emailid.sendKeys(prop.getProperty("email"));
		next.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(pass));
		pass.sendKeys(prop.getProperty("password"));
		next.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(next));
		
		next.click();
	}
	
	
	@FindBy(className = "nvEhuDKzSmREBsqaIaOhu")
	WebElement profile;
	public void openProfile(WebDriver driver) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(profile));
		profile.click();
		Thread.sleep(1000);
	}
	
	@FindBy(id = "mectrl_currentAccount_primary")
	WebElement userName;
	
	@FindBy(id = "mectrl_currentAccount_secondary")
	WebElement email;
	
	public void details() {
		System.out.println(userName.getText());
		System.out.println(email.getText()+"\n");
	}
	
	@FindBy(className = "mectrl_topHeader")
	WebElement closeprofile;
	public void closeProfile() {
		closeprofile.click();
	}
	
	@FindBy(xpath = "//div[text()='OneCognizant']")
	WebElement oneCognizant;
	public void clickonecognizant(WebDriver driver) throws InterruptedException {
		
		driver.navigate().refresh();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.SPACE).perform();
		Thread.sleep(2000);
		oneCognizant.click();
	}
	
}
