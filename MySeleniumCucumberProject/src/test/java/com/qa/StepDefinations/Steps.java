package com.qa.StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.PageObjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BaseSteps {

	// Steps for LoginPage........
	@Given("User launch chrome browser and opens URL , clicks on login link")
	public void user_launch_chrome_browser_and_opens_url_clicks_on_login_link() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginPg = new LoginPage(driver);
		loginPg.initialize();
	}

	@When("User Enters the username as {string} and password as {string}")
	public void user_enters_the_username_as_and_password_as(String uname, String pwd) {
		loginPg.setUsername(uname);
		loginPg.setPassword(pwd);
	}

	@When("User click on login button")
	public void user_click_on_login_button() throws InterruptedException {
		homePg = loginPg.clickOnLogin();
	}

	@Then("User lands on homepage")
	public void user_lands_on_homepage() {
		String actTitle = homePg.validatePageTitle();
		Assert.assertEquals(actTitle, "Home | Mynaukri");
	}

	@When("User clicks on Logout link, user lands on Login page")
	public void user_clicks_on_logout_link_user_lands_on_login_page() throws InterruptedException {
		loginPg = homePg.clickOnLogout();
		String actTitile = loginPg.validatePageTitle();
		Assert.assertEquals(actTitile, "Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com");
	}

	@Then("User Close the browser")
	public void user_close_the_browser() {
		loginPg.closeBrowser();
	}

	// Steps for HomePage........
	@When("User clicks on EDIT PROFILE under MY NAUKRI Link")
	public void user_clicks_on_edit_profile_under_my_naukri_link() throws InterruptedException {
		String actTitle = homePg.updateProfile();
		Assert.assertEquals(actTitle, "Profile | Mynaukri");
	}

	@Then("User enters name as {string} and mobile number as {string}")
	public void user_enters_name_as_and_mobile_number_as(String update_name, String update_MOBNO)
			throws InterruptedException {
		homePg.updateNameMOBNO();
		homePg.updateName(update_name);
		homePg.updatePhoneNo(update_MOBNO);
	}

	@Then("User Clicks on save")
	public void user_clicks_on_save() throws InterruptedException {
		boolean flag = homePg.saveChnages();
		Assert.assertTrue(flag);
		System.out.println("YOUR NAUKRI PROFILE UPDATED SUCCESSFULLY!!");
	}

	@Then("User uploads new resume by clicking on UPDATE RESUME button")
	public void user_uploads_new_resume_by_clicking_on_update_resume_button() throws InterruptedException {
		boolean flag = homePg.clickOnUpdateResume();
		Assert.assertTrue(flag);
		System.out.println("YOUR NAUKRI RESUME UPDATED SUCCESSFULLY!!");
	}
}
