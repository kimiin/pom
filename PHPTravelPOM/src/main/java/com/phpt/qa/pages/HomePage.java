package com.phpt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phpt.qa.base.TestBase;
import com.phpt.qa.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//h3[contains(text(),'Johny Smith')]")
	@CacheLookup
	WebElement lblUserName;

	@FindBy(xpath = "//a[@title='Hotels']")
	WebElement lnkHotels;

	@FindBy(xpath = "//a[@title='Flights']")
	WebElement lnkFlights;

	@FindBy(xpath = "//footer[@id='footer']//ul[contains(@class,'footer')]//a[contains(text(),'Contact')]")
	WebElement lnkContact;

	// Initializing the Page Object:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public HotelPage clickOnHotelsLink() {
		lnkHotels.click();
		return new HotelPage();
	}

	public FlightPage clickOnFilghtsLink() {
		lnkFlights.click();
		return new FlightPage();
	}

	public ContactPage clickOnContactLink() {
		TestUtil.waitToAppear(lnkContact, TestUtil.SHORT_WAIT_TO_CONTROL);
		lnkContact.click();
		return new ContactPage();
	}

	public ContactPage navigateToContactLink() {
		driver.get("https://www.phptravels.net/contact-us");
		return new ContactPage();
	}

	public boolean verifyCorrectUserName() {
		return lblUserName.isDisplayed();
	}

}
