package Pages;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import com.cts.sme.Base;


public class LoginPage extends Base {
	static By login = By.id("des_lIcon");
	static By googleSignIn = By.xpath("//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[2]/div[4]/div[2]");
	static By email = By.xpath("(//input[@type='email'])");
	static By submit = By.xpath("//span[text()='Next']");
	static By error = By.xpath("(//div[@class='o6cuMc Jj6Lae'])");
	public static void clickLogin() throws IOException // Method to click Login button
	{
		exttest = report.createTest("To Click on the Login Button");
	try {
		driver.findElement(login).click();
		String sign = driver.findElement(By.xpath("//span[contains(text(),'Login/Register')]")).getText();
		if (sign.contains("Login/Register")) {
			reportPass("Clicked on Login");
		}
	} catch (Exception e) {
		reportFail(e.getMessage());
	}
	}

	public static void clickGoogleSignIn() throws InterruptedException , IOException  // Method For Signin Check of Google 
	{
		exttest = report.createTest("To Click on the Google Signin");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(googleSignIn).click();
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}
		driver.manage().window().maximize();
		driver.findElement(email).sendKeys("xyz@gml.com");
		driver.findElement(submit).click();
		reportPass("Successfully Clicked the Login");

	}

	public static void captureErrorMessage() throws IOException // Method to capture error message
	{
		exttest = report.createTest("To Capture the Error Message");
	try {
		System.out.println("*******************************************************");
		System.out.println("              Error Obtained during Signup:");
		System.out.println("*******************************************************");
		String errorMessage = driver.findElement(error).getText();
		System.out.println("Error Message = " + errorMessage);
		
		if (errorMessage.contains("Google Account")) {
		reportPass("Successfully Captured the Error Message");
		}
		}catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

}