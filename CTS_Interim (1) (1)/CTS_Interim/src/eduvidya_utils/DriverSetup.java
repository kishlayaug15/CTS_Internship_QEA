// Importing necessary Packages

package eduvidya_utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

// Setting the Web Browser from a File

public class DriverSetup {

	static WebDriver driver;
	static File f;
	static FileInputStream fis;
	static Properties prop;
	
	
	public static WebDriver invokeBrowser() throws IOException {
		f = new File("config.properties");
		fis = new FileInputStream(f);
		prop = new Properties();
		
		prop.load(fis);
		String browserName = prop.getProperty("browserName");
		
//		Launch the Chrome Browser
		if(browserName.equals("Chrome")) {
//			System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome browser is launched!");
		}
		
//		Launch the Edge Browser
		else if(browserName.equals("Edge")) {
//			System.setProperty("webdriver.edge.driver", "drivers//edgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			System.out.println("Edge browser is launched!");
		}
		else {
	System.out.println("Invalid Browser!");
	}
		return driver;
}
	
//	For closing the Browser
	
	public static void closeBrowser() {
		driver.close();
}

}
