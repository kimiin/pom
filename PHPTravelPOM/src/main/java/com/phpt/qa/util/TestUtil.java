package com.phpt.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.phpt.qa.base.TestBase;

public class TestUtil extends TestBase {

	private static final String TESTDATA_PATH = ".\\src\\main\\java\\com\\phpt\\qa\\testdata\\testData.xlsx";
	public static int PAGE_LOAD_TIME_OUT = 30;
	public static int IMPLICIT_WAIT = 10;
	public static int SHORT_WAIT_TO_CONTROL = 30;
	public static int MEDIUM_WAIT_TO_CONTROL = 45;
	public static int LONG_WAIT_TO_CONTROL = 60;

	public static void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}

	public static void waitUntilClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, MEDIUM_WAIT_TO_CONTROL);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static Object[][] getTestData(String sheetName) {

		Workbook book = null;
		Sheet sheet;
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;

	}

	public static void waitToAppear(WebElement e, int seconds) {
		Timer timer = new Timer();
		timer.start();
		while (!timer.expired(seconds))
			if (e.isDisplayed())
				break;
		if (timer.expired(seconds) && !e.isDisplayed())
			throw new AssertionError("Element " + e + " failed to appear within " + seconds + " seconds");
	}

	public static void waitToDisappear(WebElement e, int seconds) {
		Timer timer = new Timer();
		timer.start();
		while (!timer.expired(seconds))
			if (!e.isDisplayed())
				break;
		if (timer.expired(seconds) && e.isDisplayed())
			throw new AssertionError("Element " + e + " failed to disappear within " + seconds + " seconds");
	}

	public static void takeScreenshotAtEndOfTest() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
