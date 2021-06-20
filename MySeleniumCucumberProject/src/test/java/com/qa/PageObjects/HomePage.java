package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Utilities.UtilComman;

public class HomePage extends BasePageObjects {

	private WebDriver hdriver;

	// Initialize the page objects
	public HomePage(WebDriver rdriver) {
		hdriver = rdriver;
		PageFactory.initElements(hdriver, this);
		act = new Actions(hdriver);
		utilComn = new UtilComman(hdriver);
	}

	// Page-Factory -- Object Repository:
	@FindBy(xpath = "//div[normalize-space()='My Naukri']")
	@CacheLookup
	WebElement myNaukriLink;

	@FindBy(xpath = "//a[text()='Logout']")
	@CacheLookup
	WebElement logoutLink;

	@FindBy(xpath = "//a[text()='Edit Profile']")
	@CacheLookup
	WebElement editProfileLink;

	@FindBy(xpath = "//em[text()='Edit']")
	@CacheLookup
	WebElement editpencil;

	@FindBy(xpath = "//input[@id='name']")
	@CacheLookup
	WebElement updateName;

	@FindBy(xpath = "//input[@id='mob_number']")
	@CacheLookup
	WebElement updateMobileNumber;

	@FindBy(xpath = "//button[@id='saveBasicDetailsBtn']")
	@CacheLookup
	WebElement saveBtn;

	@FindBy(xpath = "//input[@id='attachCV']")
	@CacheLookup
	WebElement uploadResumeLink;

	// Action methods:
	public String validatePageTitle() {
		String lActTitle = hdriver.getTitle();
		return lActTitle;
	}

	public LoginPage clickOnLogout() throws InterruptedException {
		act.moveToElement(myNaukriLink).build().perform();
		logoutLink.click();
		Thread.sleep(5000);
		return new LoginPage(hdriver);
	}

	public String updateProfile() throws InterruptedException {
		act.moveToElement(myNaukriLink).build().perform();
		Thread.sleep(3000);
		editProfileLink.click();
		Thread.sleep(2000);
		String actTitle = hdriver.getTitle();
		return actTitle;
	}

	public void updateName(String update_name) {
		updateName.clear();
		updateName.sendKeys(update_name);
	}

	public void updatePhoneNo(String update_MOBNO) {
		updateMobileNumber.clear();
		updateMobileNumber.sendKeys(update_MOBNO);
	}

	public boolean saveChnages() throws InterruptedException {
		Thread.sleep(3000);
		saveBtn.click();
		Thread.sleep(5000);
		boolean flag = false;
		if ((hdriver.getTitle()).equalsIgnoreCase("Profile | Mynaukri")) {
			flag = true;
		}
		return flag;
	}

	public boolean clickOnUpdateResume() throws InterruptedException {
		uploadResumeLink
				.sendKeys("ENTER_YOUR_RESUME_LOCATION");
		Thread.sleep(3000);
		/*
		 * boolean flag =
		 * hdriver.getPageSource().contains("Resume has been updated successfully");
		 * Assert.assertTrue(flag);
		 */
		boolean flag_1 = false;
		if ((hdriver.getTitle()).equalsIgnoreCase("Profile | Mynaukri")) {
			flag_1 = true;
		}
		return flag_1;
	}

	public void updateNameMOBNO() throws InterruptedException {
		editpencil.click();
		Thread.sleep(3000);
	}

	public UtilComman getUtilComn() {
		return utilComn;
	}

	public void setUtilComn(UtilComman utilComn) {
		this.utilComn = utilComn;
	}
}
