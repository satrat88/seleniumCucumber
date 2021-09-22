package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import supportLibraries.*;
import uiMapping.*;

import org.junit.Assert;

public class SearchJPMGoogle extends DriverScript{
	
	WebDriverWait wait = new WebDriverWait(driver,30);

	public SearchJPMGoogle()
	{
		super();
	}	

	@Given("User launch browser and navigate to Google.com")
	public void navigateToUrl() throws Exception{

		driver.get(properties.getProperty("LaunchURL"));
		
	}

	@Then("^User search with company name as (.*)$")
	public void searchCompany(String companyName) throws Exception {

		driver.findElement(SearchJPMUI.googleSearchBox).sendKeys(companyName);
		driver.findElement(SearchJPMUI.googleSearchBox).sendKeys(Keys.ENTER);
	}

	@And("User click's on the first results returned in the search")
	public void i_click_first_page_in_search_results() throws Exception {

		driver.findElement(SearchJPMUI.firstLinkSelection).click();
	}


	@When("^The page user clicked loads successfully with (.*) and (.*) (.*)$")
	public void verifyPageLoaded(String pageTitle, String pageUrl, String testFlag) throws Exception {

		Assert.assertEquals(driver.getTitle().contains(pageTitle),Boolean.parseBoolean(testFlag));
		Assert.assertEquals(driver.getCurrentUrl().contains(pageUrl),Boolean.parseBoolean(testFlag));
	}

	@Then("^User validate the (.*) logo displayed (.*)$")
	public void validateCompanyLogoPresent(String logoDetails, String testFlag) throws Exception {

		String logoText = driver.findElement(SearchJPMUI.jpmLogo).getAttribute("alt");
		Assert.assertEquals(logoText.contains(logoDetails),Boolean.parseBoolean(testFlag));
	}

	@Then("^User search with company name (.*) and selelct from AutoSuggestion$")
	public void searchCompanySelectDropDown(String companyName) throws Exception {

		driver.findElement(SearchJPMUI.googleSearchBox).sendKeys(companyName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchJPMUI.dropDownOption));
		driver.findElement(SearchJPMUI.dropDownOption).click();
	}

	@After
	public void closeBrowser()
	{
		driver.quit();
	}


}
