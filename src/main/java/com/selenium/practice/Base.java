package com.selenium.practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driverInitialization() {
		Properties properties = null;
		FileInputStream fileInputStream = null;
		String browser = null;
		WebDriver webDriver = null;
		try {
			properties = new Properties();
			fileInputStream = new FileInputStream(".\\src\\main\\resources\\data.properties");
			properties.load(fileInputStream);
			browser = (String) properties.get("browser");
			System.out.println("browser:" + browser);

			if (browser.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", "C:\\\\SeleniumPracticeChandu\\\\chromedriver.exe");
				webDriver = new ChromeDriver();
			} else if (browser.equals("firefox")) {

			} else if (browser.equals("IE")) {

			} else {

			}

			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (Exception e) {
			;
			System.out.println("Exception Message:" + e.getMessage());
			e.printStackTrace();
		}
		return webDriver;
	}
}
