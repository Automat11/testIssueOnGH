package com.project.issue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/* Klasa <TestBaseR> jest klasą z adnotacjami do wykonania przed i po teście. 
 * Zawieta elementy konfiguracyjne takie jak:
 * A) Przed:
 *  wskazanie webdrivera, wywołaniu adresu 
 * przeglądarki, usunięciu ciasteczek z przeglądarki, maksymalizacja okna,
 * ustawienie globalnego czasu na oczekiwanie na element, oraz czasu na załadowanie się strony.
 * B) Po:
 *  zamknięcie przeglądarki i bezpiecznie kończy sesje 
 * 
 */

public class TestBaseR {

	protected WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	// warunki początkowe
	@BeforeMethod
	public void invokeBrowser() {
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get("https://github.com/");
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
