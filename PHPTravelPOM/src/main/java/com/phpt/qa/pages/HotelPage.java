package com.phpt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phpt.qa.base.TestBase;

public class HotelPage extends TestBase {

	@FindBy(xpath = "//form[@name='fCustomHotelSearch']//div/a")
	WebElement txtSearch;

	@FindBy(xpath = "//form[@name='fCustomHotelSearch']//div/button")
	WebElement btnSearch;

	public HotelPage() {
		PageFactory.initElements(driver, this);
	}

	public void search(String searchString) {
		txtSearch.sendKeys(searchString);
		btnSearch.click();
	}

}
