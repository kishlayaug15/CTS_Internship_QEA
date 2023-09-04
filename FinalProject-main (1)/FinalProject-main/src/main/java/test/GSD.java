package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import beCognizantPage.BeCognizantPage;
import liveSupportGsdPage.GsdSupport;
import oneCognizant.OneCognizantPage;
import oneCognizant.WindowHandle;

public class GSD extends Base{

	BeCognizantPage bects ;
	WindowHandle handle;
	OneCognizantPage oneC;
	GsdSupport gsdsup;
	
	@BeforeClass
	public void setPage() {
		bects = new BeCognizantPage(driver);
		handle = new WindowHandle();
		oneC = new OneCognizantPage(driver);
		gsdsup = new GsdSupport(driver);
	}
	
	@BeforeTest
	public void reportInitialize() {
		logger=report.createTest("GSD-Scenario","Test Cases");
	}
	
	//@Test(priority = 0)
	public void infoHomeNetork() throws InterruptedException{
		bects.sendUserDetails(prop,driver);
	}
	
	@Test(priority = 1)
	public void openWebsite() {
		try {
			driver.get(prop.getProperty("URL"));
			reportPass("Open Website");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	
	@Test(priority = 2)
	public void userProfile(){
		try {
			bects.openProfile(driver);
			reportPass("Profile opened");
			bects.details();
			reportPass("Information fetched");
			bects.closeProfile();
			reportPass("Profile closed");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@Test(priority = 3)
	public void openOneCognizant(){
		try {
			bects.clickonecognizant(driver);
			reportPass("OneCognizant opened");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@Test(priority = 4)
	public void handleWindow(){
		try {
			String window[]=handle.manageWindows(driver);
	        String parent = window[0];
	        String child = window[1];
	        driver.switchTo().window(child);
	        reportPass("Window handled. Swiched to OneCognizant");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@Test(priority = 5)
	public void verifyTitleonects() {
		oneC.onectsTitle(driver);
	}
	
	@Test(priority = 6)
	public void getGsd(){
		try {
			oneC.getGsd(prop);
			reportPass("GSD result fetched in console");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@Test(priority = 7)
	public void verifyTitleMessage() {
		try {
			gsdsup.verifyTitle(driver);
			reportPass("Title message verified");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@Test(priority = 8)
	public void getLanguage() {
		try {
			gsdsup.getLanguages();
			reportPass("Language result fetched in console");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@Test(priority = 9)
	public void printIndiaGSDSupport() {
		try {
			gsdsup.getIndiaSupportList();
			reportPass("Support list for India fetched in console");
			screenShot("indiaList");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@Test(priority = 10)
	public void randomFirstCountrySelect(){
		try {
			gsdsup.getCountrySupport(driver);
			reportPass("Support list for first country fetched in console");
			screenShot("firstcountryList");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@Test(priority = 11)
	public void randomSecondCountrySelect(){
		try {
			gsdsup.getCountrySupport(driver);
			reportPass("Support list for second country fetched in console");
			screenShot("secondcountryList");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
}
