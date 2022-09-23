package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sport {
	
	@FindBy(xpath="//a[@data-csa-c-slot-id='nav_cs_5']")
	private WebElement sportProducts;
	
	public Sport(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	}
	
	public void sportProductClicked() {
		sportProducts.click();
	}

}
