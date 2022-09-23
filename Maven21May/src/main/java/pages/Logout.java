package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	private WebDriver driver;
	
	@FindBy(xpath="//a[@data-nav-role='signin']")
	private WebElement myAccount;
	
	@FindBy(xpath="//a[@id='nav-item-signout']")
	private WebElement singout;
	
	public Logout(WebDriver driver) {	
	PageFactory.initElements(driver, this);
	this.driver=driver;
	}
	
	public void clickToMyAccount() {
		Actions act=new Actions(driver);
		act.moveToElement(myAccount).build().perform();
	}

	public void clickToSignout() {
		singout.click();	
	}
}
