package com.phpt.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phpt.qa.base.TestBase;
import com.phpt.qa.pages.HomePage;
import com.phpt.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {

		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login");
	}

	@Test(priority = 2)
	public void imagePHPTest() {
		Assert.assertTrue(loginPage.validatePHPImage());
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
