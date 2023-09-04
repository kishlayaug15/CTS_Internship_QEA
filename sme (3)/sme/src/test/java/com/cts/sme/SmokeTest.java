package com.cts.sme;


import java.io.IOException;

import org.testng.annotations.Test;

import Pages.HondaDetails;

// Checking Basic Functionalities

public class SmokeTest extends Base
{
	@Test(priority=1)
	public void driverrCall()
	{	
		Base.driverSetup();
	}
	@Test(priority=2)
	public void openingUrl() throws IOException {
		Base.openUrl();
	}
	@Test(priority=3)
	public void clickUpcomingBikes() throws IOException {
		HondaDetails.clickUpcomingBikes();
	}
	@Test(priority=4)
	public void selectManufacturer() throws IOException {
		HondaDetails.selectManufacturer();
	}
	@Test(priority=5)
	public void closingBrowser() {
		Base.closeBrowser();
	}

}
