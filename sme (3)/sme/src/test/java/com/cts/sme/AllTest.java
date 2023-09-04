package com.cts.sme;




import java.io.IOException;


import org.testng.annotations.Test;

import Pages.ChennaiUsedCars;
import Pages.HondaDetails;
import Pages.LoginPage;



public class AllTest {

		@Test(priority=1)
		public void driverCall()
		{
			
			Base.driverSetup();
		}
		@Test(priority=2)
		public void openingUrl() throws IOException {
			Base.openUrl();
		}

	//First Case
	@Test(priority=3)
		public void clickingUpcomingBikes() throws IOException {
		HondaDetails.clickUpcomingBikes();
	}
	@Test(priority=4)
	public void selectingManufacturer() throws IOException {
		HondaDetails.selectManufacturer();
	}
	@Test(priority=5)
	public void clickViewMore() throws IOException {
		HondaDetails.viewMore();
	}
	@Test(priority=6)
	public void printingDetails() throws IOException {
		HondaDetails.printDetails();
	}

	//Second Case
	@Test(priority=8)
	public void clickingUsedCars() throws IOException
	{
		ChennaiUsedCars.clickUsedCars();
	}
	
	@Test(priority=9)
	public void clickingPopularModels() throws InterruptedException, IOException {
		ChennaiUsedCars.clickPopularModels();

	}

	//Third Case
	@Test(priority=10)
	public void clickLogIn() throws IOException
	{
		Base.openUrl();
		LoginPage.clickLogin();
	}
	@Test(priority=11)
	public void clickSignIn() throws InterruptedException, IOException {
		LoginPage.clickGoogleSignIn();
	}
	@Test(priority=12)
	public void errorMessageDisplay() throws IOException {
//		Thread.sleep(1000);
		LoginPage.captureErrorMessage();
	}
	@Test(priority=13)
	public void capturingScreenShot() throws IOException {
//		Thread.sleep(1000);
		Base.captureScreenshot();
	}
	@Test(priority=14)
	public void driverClose()
	{
		Base.closeBrowser();
	}

}