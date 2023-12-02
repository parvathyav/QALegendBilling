package com.QALegendBilling.automationcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static WebDriver testInitialization(String browser) {
		if (browser.equals("chrome")) {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			tlDriver.set(new ChromeDriver(ops));
		} else if (browser.equals("FireFox")) {
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("edge")) {
			tlDriver.set(new EdgeDriver());
		}

		else {
			throw new RuntimeException("Invalid browser");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
