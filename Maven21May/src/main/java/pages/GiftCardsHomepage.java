package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardsHomepage {
	
	@FindBy(xpath="//img[@alt='Email gift cards']")
	private WebElement giftCards;
	

	
	//public constructor
	
	public GiftCardsHomepage(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	}
	
	public void giftCardsOpen() {
		giftCards.click();
	}
	

	
	
	

}
