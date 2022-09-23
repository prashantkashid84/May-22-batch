package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Babyproduct {
	
	@FindBy(xpath="//a[@data-csa-c-content-id='nav_cs_baby']")
	private WebElement babyProducts;
	
	public Babyproduct(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	}
	
	public void babyProductClicked() {
		babyProducts.click();
	}

}
