package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EgiftCardsAndSell {

	@FindBy(xpath="(//a[@class='nav-a  '])[3]")
	private WebElement giftCards;
	
	@FindBy(xpath="(//a[@class='nav-a  '])[1]")
	private WebElement sell;
	

	//public constructor
	
	public EgiftCardsAndSell(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	}
	
	public void giftCardsOpen() {
		giftCards.click();
	}
	
	public void sellButtonClicked() {
		sell.click();
	}
}
