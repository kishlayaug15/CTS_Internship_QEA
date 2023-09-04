package Pages;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cts.sme.Base;



public class ChennaiUsedCars extends Base
{
	static By list=By.tagName("li");
	static By usedcars=By.xpath("//a[contains(text(),'Used Cars')]");
	static By selectCity=By.xpath("//span[@city = 'Chennai']");
	static By checkreport=By.xpath("//h1[@id='usedcarttlID']");
	static By popularmodels=By.xpath("//ul[contains(@class,'usedCarMakeModelList')]");
	

	public static void clickUsedCars() throws IOException  // Method to click used_cars
	{
		try {
		exttest = report.createTest("Select the Cars used");
		driver.findElement(usedcars);
		System.out.println("Moved to Used Cars");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(usedcars)).perform();
		
		//Selecting Chennai
		driver.findElement(selectCity).click();
		System.out.println("Clicked on Chennai");

		String usedCars = driver.findElement(checkreport).getText();
		if (usedCars.contains("Used Cars in Chennai")) 
			reportPass("Used Cars in chennai are displayed");
	} catch (Exception e) {
		reportFail(e.getMessage());
	}

	}
	public static void clickPopularModels() throws InterruptedException, IOException  // Method to click popular_models
	{
		exttest = report.createTest("Select the Popular Models");
//		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		try {
		WebElement model=driver.findElement(popularmodels);
		System.out.println("*******");
		System.out.println("            Popular Used Cars in Chennai:");
		System.out.println("*******");
		List<WebElement> ls= model.findElements(list);
		for(int i=0;i<10;i++)
		{
			System.out.println(ls.get(i).getText());
		}
		reportPass("Popular models are printed");
		} catch(Exception e) {
			reportFail(e.getMessage());
		}
	}


}