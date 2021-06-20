package com.qa.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Utilities.UtilComman;

public class LoginPage extends BasePageObjects {

	private WebDriver ldriver;

	// Initialize the page objects
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		utilComn = new UtilComman(ldriver);

	}

	// Page-Factory -- Object Repository:
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	@CacheLookup
	WebElement loginLink;

	@FindBy(xpath = "//input[@type='text']")
	@CacheLookup
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement loginBtn;

	@FindBy(id = "block")
	@CacheLookup
	WebElement geoLocationLink;

	@FindBy(xpath = "//button[text()='GOT IT']")
	@CacheLookup
	WebElement cookiePermissionlink;

	// Action methods:
	public void initialize() throws InterruptedException {

		ldriver.manage().window().maximize();
		ldriver.manage().deleteAllCookies();
		ldriver.get("https://www.naukri.com/");
		ldriver.manage().timeouts().pageLoadTimeout(UtilComman.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		ldriver.manage().timeouts().implicitlyWait(UtilComman.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		utilComn.closeWindowPopUps();
		cookiePermissionlink.click();
		geoLocationLink.click();
		loginLink.click();
		Thread.sleep(3000);
	}

	public void setUsername(String uname) {
		username.clear();
		username.sendKeys(uname);
	}

	public void setPassword(String upwd) {
		password.clear();
		password.sendKeys(upwd);
	}

	public HomePage clickOnLogin() throws InterruptedException {
		loginBtn.click();
		Thread.sleep(5000);
		return new HomePage(ldriver);
	}

	public String validatePageTitle() {
		String lActTitle = ldriver.getTitle();
		return lActTitle;
	}

	public void closeBrowser() {
		ldriver.quit();
	}

}
