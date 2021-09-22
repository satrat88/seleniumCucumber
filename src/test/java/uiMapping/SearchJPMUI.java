package uiMapping;

import org.openqa.selenium.By;

public class SearchJPMUI {
	
	public static final By googleSearchBox = By.xpath("//input[@name='q' and @title='Search']");
	public static final By firstLinkSelection = By.xpath("(//div[@id='search']//a)[1]");
	public static final By jpmLogo = By.xpath("//img[contains(@class,'first-logo')]");	
	public static final By dropDownOption = By.xpath("(//ul[@role='listbox']//li[@role='presentation'])[1]");
}
