package com.selenium.practice;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[aria-controls='country-selector']")
	List<WebElement> languageAndRegionOption;

	@FindBy(css = "#region-0 > span > span.col-12.col-md-9.text-left")
	WebElement region;

	@FindBy(css = "#region0 > div > div:nth-child(18) > div > div > a")
	WebElement country;

	@FindBy(css = "body > div.site-nav > div.d-flex.justify-content-between.align-items-stretch.site-nav__main > button.btn.btn-lg.site-nav__btn.site-nav__btn--search-menu > span.site-nav__btn__label.d-none.d-md-block")
	WebElement homeSearchButton;

	@FindBy(css = "#_185F67BF-1D73-4AEE-9564-FDE5B0EB24D9 > div.CoveoOmnibox.magic-box > div.magic-box-input > form > a")
	WebElement searchButton;

	@FindBy(css = "#_185F67BF-1D73-4AEE-9564-FDE5B0EB24D9 > div.CoveoOmnibox.magic-box > div.magic-box-input > form > input[type=text]")
	WebElement searchInput;

	@FindBy(xpath = "//*[@id='coveo9de96e90']/span[1]")
	WebElement sortSearchResultsByDate;

	@FindBy(css = "#coveo53e11d62\\ sourceFilter > ul > li:nth-child(1) > label > div > div")
	WebElement filterByContentType;

	@FindBy(className = "coveo-list-layout")
	List<WebElement> filteredLinks;

	public WebElement getLanguageAndRegionOption() {
		return languageAndRegionOption.get(0);
	}

	public WebElement getRegion() {
		return region;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getHomeSearchButton() {
		return homeSearchButton;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchInput() {
		return searchInput;
	}

	public WebElement getSortSearchResultsByDate() {
		return sortSearchResultsByDate;
	}

	public WebElement getFilterByContentType() {
		return filterByContentType;
	}

	public List<WebElement> getFilteredLinks() {
		return filteredLinks;
	}
}
