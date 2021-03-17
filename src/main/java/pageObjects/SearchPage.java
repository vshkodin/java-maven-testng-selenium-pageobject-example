package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	private WebDriver driver;
	
	// ----------------------------------------------------
    // Objects
    // ----------------------------------------------------
	
	// Heading
	@FindBy(xpath = "/html/head/title")
	private WebElement heading;
	
	// Number of results
	@FindBy(xpath = "//*[@id=\"topInfo\"]/div[1]/span[1]")
	private WebElement txtNumResults;
	

	// ----------------------------------------------------
    // Constructor
    // ----------------------------------------------------
	public SearchPage (WebDriver driver){
	    this.driver=driver;
	    //Initialize Elements
	    PageFactory.initElements(driver, this);
	}
	
	
	// ----------------------------------------------------
    // Methods
    // ----------------------------------------------------
	
	// Boolean to check if page is opened
	public boolean isPageOpened(String searchWord){
	    return driver.getTitle().contains("Slickdeals: Searching for "+searchWord+"");
	}
	
	public String getNumResults() {
		return txtNumResults.getText();
	}
	

}
