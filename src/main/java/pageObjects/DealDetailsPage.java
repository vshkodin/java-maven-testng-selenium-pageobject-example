package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealDetailsPage {
	private WebDriver driver;
	
	// ----------------------------------------------------
    // Objects
    // ----------------------------------------------------
	
	// Heading
	@FindBy(xpath = "/html/head/title")
	private WebElement heading;
	
	// Deal title
	@FindBy(xpath = "//*[@id=\"dealTitle\"]/h1")
	private WebElement dealTitle;
	

	// ----------------------------------------------------
    // Constructor
    // ----------------------------------------------------
	public DealDetailsPage (WebDriver driver){
	    this.driver=driver;
	    //Initialize Elements
	    PageFactory.initElements(driver, this);
	}
	
	
	// ----------------------------------------------------
    // Methods
    // ----------------------------------------------------
	
	// Boolean to check if page is opened
	public boolean isPageOpened(String title){
	    return heading.getText().toString().contains(title);
	}
	
	// Get deal title
	public String getDealTitle() {
		return dealTitle.getText();
	}

}
