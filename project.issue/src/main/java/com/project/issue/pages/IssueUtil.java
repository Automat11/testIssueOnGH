package com.project.issue.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IssueUtil {

	protected WebDriver driver;
	
	
	// konstruktor
	public IssueUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	// czekanie aż element będzie klikalny
	public void waitUntilElementIsClickable (By locator, int time, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	// klikanie na przycisk
	public void clickElement (By element) {
		waitUntilElementIsClickable(element, 10, driver);
		driver.findElement(element).click();
	}
	

	// wpisanie tekstu 
	public void sendText (By element, String text) {
		waitUntilElementIsClickable(element, 10, driver);
		driver.findElement(element).click();
		driver.findElement(element).sendKeys(text);
		
	}
	
	
	
	

}

