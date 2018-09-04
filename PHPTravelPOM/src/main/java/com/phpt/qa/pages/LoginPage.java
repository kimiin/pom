package com.phpt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phpt.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit' and contains(@class,'loginbtn')]")
	WebElement login;

	@FindBy(xpath = "//a[normalize-space(text())='Sign Up' and contains(@class,'btn')]")
	WebElement signup;

	@FindBy(xpath = "//a[contains(@class,'navbar-brand')]/img[contains(@src,'logo.png')]")
	WebElement phpImage;

	// Initializing the Page Object:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validatePHPImage() {
		return phpImage.isDisplayed();
	}

	public HomePage login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		login.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage();
	}
}
