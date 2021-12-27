package com.selenium.practice;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WillisTest extends Base {

	// log4j initilisation
	private static Logger log =LogManager.getLogger(WillisTest.class);

	@Test
	public void testScenario() {

		log.info("Entry");

		// Method level variables declaration
		WebDriver driver = null;
		int linksCount = 0;
		int linksValidatedCount = 0;

		// driver initialization
		driver = driverInitialization();

		if (driver != null) {
			log.info("Driver instance initialized successfully.");
			// Launching website URL
			driver.get("http://www.willistowerswatson.com/ICT");

			// Accepting cookies pop-up window
			driver.switchTo().frame(1);
			driver.findElement(By.xpath("/html/body/div[8]/div[1]/div/div[3]/a[1]")).click();

			// Returning control back to main window
			driver.switchTo().defaultContent();

			// Changing the language and region from top left corner to United States
			// English
			SearchPage searchPage = new SearchPage(driver);
			searchPage.getLanguageAndRegionOption().click();
			searchPage.getRegion().click();
			searchPage.getCountry().click();

			// Click on search box and then search the word "IFRS 17"
			searchPage.getHomeSearchButton().click();
			searchPage.getSearchInput().sendKeys("IFRS 17");
			searchPage.getSearchButton().click();

			// Sort the results by Date
			searchPage.getSortSearchResultsByDate().click();

			// Filter the results by content type as "Article"
			searchPage.getFilterByContentType().click();

			// Get all the links displayed in page and check if all the links starts with
			// "https://www.willistowerswatson.com/en-US/"
			List<WebElement> webElements = searchPage.getFilteredLinks();
			linksCount = webElements.size();
			for (WebElement webElement : webElements) {
				String sLink = webElement.findElement(By.className("CoveoResultLink")).getAttribute("href");
				if (sLink.startsWith("https://www.willistowerswatson.com/en-US/")) {
					linksValidatedCount++;
				}
			}

			Assert.assertEquals(linksCount, linksValidatedCount);

		} else {
			log.error("Driver instance failed to initialize.");
		}

		log.info("Exit");
	}

}
