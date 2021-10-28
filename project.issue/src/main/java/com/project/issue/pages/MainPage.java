package com.project.issue.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Klasa <MainPage> jest klasą strony głównej wywołanej z adresu. Zawiera lokatory na danej stronie
 * oraz metody na niej wywoływane. 
 */

public class MainPage extends IssueUtil {

	
	// lokalizatory
	public static final By MAIN_MENU_USER = By.xpath("//img[@class='avatar-user avatar avatar-small']");
	public static final By MAIN_MENU_USER_YOUR_REPOSITORY = By.xpath("//a[contains(text(),'Your repositories')]");
	public static final By LOCATION_REPOSITORY_ISSUE = By.xpath("//a[@itemprop='name codeRepository' and contains(text(),'testIssue')]");
	public static final By TAB_ISSUES = By.xpath("//span[@data-content='Issues']");
	

	
	
	// konstruktor
	public MainPage(WebDriver driver) {
		super(driver);
	}
	

	// METODY
	// wybranie projektu z głównego menu i przejście do zakładki Issues
	public void pickProjectFromRepoAndGoIssue () {
		clickElement(MAIN_MENU_USER);
		clickElement(MAIN_MENU_USER_YOUR_REPOSITORY);
		clickElement(LOCATION_REPOSITORY_ISSUE);
		clickElement(TAB_ISSUES);
	}
	
	
}
