package supportLibraries;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class DriverScript {
	protected static WebDriver driver;
	protected Properties properties = LoadProperties.getInstance();
	
	/**
	 * Constructor to initiate WebDriver and to get Property values
	 */
	protected DriverScript()
	{
		this.driver = getWebDriver();		
	}
	
		
	/**
	 * Browser Configuration and Driver Initialization settings 
	 * @return
	 */
	
	private static WebDriver getWebDriver()
	{
		try {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");	
		driver = new ChromeDriver(options);
		}catch(Exception e)
		{
			System.out.println("Driver Initialization Issue"+e.getMessage());
		}
		return driver;
	}

}
