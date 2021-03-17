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
import pageObjects.SearchPage;

public class TC02_search_for_deal {
	
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
	public void searchDeals() {
		
		String searchWord;
		
		// Launch browser and navigate to URL
		driver.get("https://slickdeals.net/");
		String homePageTitle = driver.getTitle();
			
		HomePage homePage = new HomePage(driver);
				
		// Verify home page is opened
		Assert.assertTrue(homePage.isPageOpened());
		
		// Enter "laptops" in search test box
		searchWord = "laptops";
		homePage.enterSearchBox(searchWord);
		
		SearchPage searchPage = new SearchPage(driver);
		
		// Get number of search results
		String strNumResults = searchPage.getNumResults();
		System.out.println("");
		System.out.printf("Number of results for %s: %s", searchWord, strNumResults);
		
		int numResults = Integer.parseInt(strNumResults.replaceAll(",", ""));
		
		// Verify number of results is not 0
		Assert.assertNotEquals(numResults, 0);
		
		// Enter "tv" in search test box
		searchWord="tv";
		homePage.enterSearchBox(searchWord);
	
		searchPage = new SearchPage(driver);
				
		// Get number of search results
		strNumResults = searchPage.getNumResults();
		System.out.println("");
		System.out.printf("Number of results for %s: %s", searchWord, strNumResults);
				
		numResults = Integer.parseInt(strNumResults.replaceAll(",", ""));
				
		// Verify number of results is not 0
		Assert.assertNotEquals(numResults, 0);
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
