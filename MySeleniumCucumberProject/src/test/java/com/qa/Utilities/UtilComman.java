package com.qa.Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilComman {

	private WebDriver udriver;
	public static WebDriverWait myWait;
	public static int PAGE_LOAD_TIME = 35;
	public static int IMPLICIT_WAIT_TIME = 10;
	public static int EXPLICIT_WAIT_TIME = 10;

	public UtilComman(WebDriver rdriver) {
		udriver = rdriver;
	}

	public void closeWindowPopUps() {
		Set<String> wndws = udriver.getWindowHandles();
		int windowNos = wndws.size();
		Iterator<String> itr = wndws.iterator();
		if (windowNos >= 2) {
			String parent = itr.next();
			while (itr.hasNext() == true) {
				String s = itr.next();
				udriver.switchTo().window(s).close();
			}
			udriver.switchTo().window(parent);
		}
	}

	public void waitHelper(WebElement ele, Long timeOutInSeconds) {
		myWait = new WebDriverWait(udriver, timeOutInSeconds);
		myWait.until(ExpectedConditions.visibilityOf(ele));
	}

}
