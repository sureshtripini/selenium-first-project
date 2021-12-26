package com.selenium.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WillisTest {

	@Test
	public void testScenario() {

		WebDriver driver = null;
		int linksCount = 0;
		int linksValidatedCount = 0;

		driver = Base.driverInitialization();

		// Launching website URL
		driver.get("http://www.willistowerswatson.com/ICT");

		// Accepting cookies pop-up window
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("/html/body/div[8]/div[1]/div/div[3]/a[1]")).click();

		// Returning control back to main window
		driver.switchTo().defaultContent();

		// Changing the language and region from top left corner to United States
		// English
		driver.findElement(By.cssSelector(
				"body > div.site-nav > div.d-none.d-md-flex.w-100.justify-content-between.site-nav__utility > nav:nth-child(1) > button > i:nth-child(3)"))
				.click();
		driver.findElement(By.cssSelector("#region-0 > span > span.col-12.col-md-9.text-left")).click();
		driver.findElement(By.cssSelector("#region0 > div > div:nth-child(18) > div > div > a")).click();

		// Click on search box and then search the word "IFRS 17"
		driver.findElement(By.cssSelector(
				"body > div.site-nav > div.d-flex.justify-content-between.align-items-stretch.site-nav__main > button.btn.btn-lg.site-nav__btn.site-nav__btn--search-menu > span.site-nav__btn__label.d-none.d-md-block"))
				.click();
		driver.findElement(By.cssSelector(
				"#_185F67BF-1D73-4AEE-9564-FDE5B0EB24D9 > div.CoveoOmnibox.magic-box > div.magic-box-input > form > input[type=text]"))
				.sendKeys("IFRS 17");
		driver.findElement(By.cssSelector(
				"#_185F67BF-1D73-4AEE-9564-FDE5B0EB24D9 > div.CoveoOmnibox.magic-box > div.magic-box-input > form > a"))
				.click();

		// Sort the results by Date
		driver.findElement(By.xpath("//*[@id=\"coveo9de96e90\"]/span[1]")).click();

		// Filter the results by content type as "Article"
		driver.findElement(By.cssSelector("#coveo53e11d62\\ sourceFilter > ul > li:nth-child(1) > label > div > div"))
				.click();

		// Get all the links displayed in page and check if all the links starts with
		// "https://www.willistowerswatson.com/en-US/"
		List<WebElement> webElements = driver.findElements(By.className("coveo-list-layout"));
		linksCount = webElements.size();
		for (WebElement webElement : webElements) {
			String sLink = webElement.findElement(By.className("CoveoResultLink")).getAttribute("href");
			if (sLink.startsWith("https://www.willistowerswatson.com/en-US/")) {
				linksValidatedCount++;
			}
		}

		Assert.assertEquals(linksCount, linksValidatedCount);
	}

}
