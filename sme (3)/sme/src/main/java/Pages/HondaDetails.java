package Pages;

import com.cts.sme.*;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class HondaDetails extends Base {
	static By viewButton = By.xpath("//span[@class='zw-cmn-loadMore']");
	static By BikeNames = By.xpath("//strong[@class='lnk-hvr block of-hid h-height']");
	static By BikePrices = By.xpath("//div[@class='b fnt-15']");
	static By BikeLaunch = By.xpath("//div[@class='clr-try fnt-14']");
	static int count = 0;
	int count1 = 0;

	public static void clickUpcomingBikes() throws IOException // Method to click Upcoming_bikes
	{
		exttest = report.createTest("Clicking on the Upcoming Bikes");
	try {
		driver.findElement(By.xpath("//span[contains(text(),'New Bikes')]"));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'New Bikes')]"))).perform();
		driver.findElement(By.xpath("//span[contains(text(),'Upcoming Bikes')]")).click();
		String str = driver.findElement(By.xpath("//h1[contains(text(),'Upcoming Bikes in India')]")).getText();
		if (str.contains("Upcoming Bikes"))
			reportPass("Upcoming bikes has been opened");
	} catch (Exception e) {
		reportFail(e.getMessage());
	}
	}

	public static void selectManufacturer() throws IOException // Method to select the Manufacturer
	{
		exttest = report.createTest("Select the Manufacturer");
	try {
		WebElement drop = driver.findElement(By.id("makeId"));
		Select select = new Select(drop);
		select.selectByValue("53");
		String str1 = driver.findElement(By.xpath("//h1[contains(text(),'Honda Upcoming Bikes in India')]")).getText();
		if (str1.contains("Honda"))
			reportPass("Manufacturer is HONDA");
		}catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static void viewMore() throws IOException // Method to click viewmore
	{
		exttest = report.createTest("To view the Arguments");
		try {
			WebElement element = driver.findElement(viewButton);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			reportPass("View More is clicked");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public static void printDetails() throws IOException // Method to print details on the console
	{
		exttest = report.createTest("To obtain the upcoming Bike details under 4Lac ");
		List<WebElement> bikeNames = driver.findElements(BikeNames);
		List<WebElement> bikePrices = driver.findElements(BikePrices);
		List<WebElement> bikeLaunch = driver.findElements(BikeLaunch);
		count = bikeNames.size();
		String priceTxt;
		System.out.println("*******");
		System.out.println("              Upcoming Bike Details:");
		System.out.println("*******");
		
		try {
		for (int i = 0; i < count; i++) {
			priceTxt = bikePrices.get(i).getText();
			float price =0;
			if(priceTxt.contains(","))
			{
				price = Float.parseFloat(priceTxt.replaceAll("Rs. ", "").replaceAll(" Lakh", "").replaceAll(",",""));
				price = price/100000;
			}
			else
			{
				price = Float.parseFloat(priceTxt.replaceAll("Rs. ", "").replaceAll(" Lakh", ""));
			}
			if ( price < 4) {
				System.out.println(bikeNames.get(i).getText() + "\t" + bikePrices.get(i).getText() + "\t"
						+ bikeLaunch.get(i).getText());
				
			}
		}
		reportPass("Bike Prices are Obtained");
		} catch (Exception e){
			reportFail(e.getMessage());
			}
		}
	}

		
	
