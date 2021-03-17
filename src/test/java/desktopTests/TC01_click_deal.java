package desktopTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC01_click_deal {
	
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		// Check if parameter from TestNG is firefox
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/jon/geckodriver/geckodriver");
			driver = new FirefoxDriver();
		} 
		// Check if parameter from TestNG is chrome
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/jon/chromedriver/chromedriver");
			driver = new ChromeDriver();
		}
		// Check if parameter from TestNG is edge
		else if(browser.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		// If no browser passed then throw an exception
		else {
			throw new Exception("No browser has been passed!");
		}
		
	}
	
	@Test
	public void clickDeal() {
		
		// Launch browser and navigate to URL
		driver.get("https://slickdeals.net/");
		String homePageTitle = driver.getTitle();
	
		HomePage homePage = new HomePage(driver);
		
		// Verify home page is opened
		Assert.assertTrue(homePage.isPageOpened());
		
		// Click on first Featured Deal
		homePage.clickDealItem();
		
		// Verify no longer on home page
		Assert.assertTrue(homePageTitle!=driver.getTitle());
		
		// Click on SD logo in top left corner
		homePage.clickSDLogo();
		
		System.out.printf("Home page title: %s, Actual page title: %s", homePageTitle, driver.getTitle());
		
		// Verify navigate back to home page
		Assert.assertEquals(homePageTitle,driver.getTitle());
	}
	
	
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
