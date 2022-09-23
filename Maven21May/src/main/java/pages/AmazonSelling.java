package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSelling {
	
	
	@FindBy(xpath="//a[@data-csa-c-content-id='nav_cs_sell']")
	private WebElement selling;
	
	public AmazonSelling(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	}
	
	public void amazonSellingClicked() {
		selling.click();
	}
	

}
