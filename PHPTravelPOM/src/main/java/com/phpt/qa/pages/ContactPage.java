package com.phpt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phpt.qa.base.TestBase;

public class ContactPage extends TestBase {

	@FindBy(xpath = "//input[@name='contact_name']")
	WebElement txtContactName;

	@FindBy(xpath = "//input[@name='contact_email']")
	WebElement txtContactEmail;

	@FindBy(xpath = "//input[@name='contact_subject']")
	WebElement txtContactSubject;

	@FindBy(xpath = "//textarea[@name='contact_message']")
	WebElement txtContactMessage;

	@FindBy(xpath = "//input[@name='submit_contact']")
	WebElement btnContactSubmit;

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public void submitAContact(String name, String email, String subject, String msg) {
		txtContactName.sendKeys(name);
		txtContactEmail.sendKeys(email);
		txtContactSubject.sendKeys(subject);
		txtContactMessage.sendKeys(msg);
		btnContactSubmit.click();
	}

}
