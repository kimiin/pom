package com.phpt.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phpt.qa.base.TestBase;
import com.phpt.qa.pages.FlightPage;
import com.phpt.qa.pages.HomePage;
import com.phpt.qa.pages.HotelPage;
import com.phpt.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	// TestUtil testUtil;
	HotelPage hotelPage;
	FlightPage flightPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		// testUtil = new TestUtil();
		// hotelPage = new HotelPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		Assert.assertEquals(homePage.verifyHomePageTitle(), "My Account");
	}

	@Test(priority = 2)
	public void verifyCorrectUserName() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifyHotelLinkTest() {
		hotelPage = homePage.clickOnHotelsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
