package br.ce.gabriel.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static WebDriver driver;

	public DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
//			driver = new ChromeDriver();
			switch (Propriedades.browser) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().setSize(new Dimension(1200, 765));
		}
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
