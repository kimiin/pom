package com.phpt.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.phpt.qa.base.TestBase;
import com.phpt.qa.pages.ContactPage;
import com.phpt.qa.pages.HomePage;
import com.phpt.qa.pages.LoginPage;
import com.phpt.qa.util.TestUtil;

public class ContactPageTest extends TestBase {

	// TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		// testUtil = new TestUtil();
		// hotelPage = new HotelPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.navigateToContactLink();
	}

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;
	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void verifySubmitAContact(String name, String email, String subject, String msg) {
		contactPage.submitAContact(name, email, subject, msg);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
