package com.project.issue.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StartPageGitHub extends IssueUtil {

	// lokalizatory
	public static final By SIGN_IN_BUTTON = By.xpath("//a[contains(text(),'Sign in')]");
	
	public static final By INPUT_USERNAME_LOGIN = By.xpath("//input[@id='login_field']");
	public static final By INPUT_PASS_LOGIN = By.xpath("//input[@id='password']");
	public static final By BUTTON_SUBMIT = By.xpath("//input[@value='Sign in']");
	
	public static final By MAIN_MENU_USER = By.xpath("//img[@class='avatar-user avatar avatar-small']");
	public static final By MAIN_MENU_USER_LOG_OUT = By.xpath("//button[@type='submit' and contains(text(),'Sign out')]");
	
	// konstruktor
	public StartPageGitHub(WebDriver driver) {
		super(driver);
	}
	
	
	// logowanie
	public void logIn (String username, String pass) {
		// asercja na strone główną -- wyjątkowo przed
		String expectedTitle = "GitHub: Where the world builds software · GitHub";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle);
        System.out.println("Stona");
        // log
		clickElement(SIGN_IN_BUTTON);
		sendText(INPUT_USERNAME_LOGIN, username);
		sendText(INPUT_PASS_LOGIN, pass);
		clickElement(BUTTON_SUBMIT);
		// asercja na stronę po zalogowaniu
	}
	

	// wylogowanie
	public void logOut () {
		clickElement(MAIN_MENU_USER);
		clickElement(MAIN_MENU_USER_LOG_OUT);
	}
}