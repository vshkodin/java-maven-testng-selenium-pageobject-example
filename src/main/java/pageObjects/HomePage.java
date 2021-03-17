package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	private WebDriver driver;
	
	// ----------------------------------------------------
    // Objects
    // ----------------------------------------------------
	
	// Heading
	@FindBy(xpath = "/html/head/title")
	private WebElement heading;
	
	// SD Logo in upper left corner of home page which goes to home page when clicked
	@FindBy(xpath = "//*[@id=\"globalBar\"]/div/div[1]/a")
	private WebElement linkSDLogo;

	// First deal item in Featured Deals
	@FindBy(xpath= "//*[@class=\"gridCategory featDealsAndCoupons\"]/ul/li[1]/div")
	private WebElement itemFD1;
	
	// Title of first deal item in Featured Deals
	@FindBy(xpath= "//*[@id=\"featDealsAndCoupons\"]/ul/li[1]/div/div/div[1]/div[1]/div/a")
	private WebElement itemTitleFD1;
	
	// Search Box
	@FindBy(xpath = "//*[@id=\"globalSearchBox\"]")
	private WebElement inputSearchBox;
	
	
	// ----------------------------------------------------
    // Constructor
    // ----------------------------------------------------
	public HomePage (WebDriver driver){
	    this.driver=driver;
	    //Initialize Elements
	    PageFactory.initElements(driver, this);
	}
	
	
	// ----------------------------------------------------
    // Methods
    // ----------------------------------------------------
	
	// Boolean to check if page is opened
	public boolean isPageOpened(){
	    return driver.getTitle().contains("Slickdeals");
	}
	   
	// Click on SD Logo to go to home page
	public void clickSDLogo() {
        linkSDLogo.click();
        wait(5000);
	}
	
	// Click on first featured deal
	public void clickDealItem() {
		itemFD1.click();
	}
	
	// Return title of first featured deal
	public String getTitleItemFD1() {
		return itemTitleFD1.getText();
	}
	
	// Enter search information into Search Box
	public void enterSearchBox(String name) {
		inputSearchBox.clear();
		inputSearchBox.sendKeys(name);
		inputSearchBox.sendKeys(Keys.ENTER);
		wait(5000);
	}
	
	private void wait(int seconds) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
