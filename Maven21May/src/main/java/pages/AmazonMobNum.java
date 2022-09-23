package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMobNum {

	//private variable WebElements
	@FindBy(xpath="//input[@id='ap_email']")
	private  WebElement userName;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continues;
	

	
	//public constructor
	
	public AmazonMobNum(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	}
	
	//public methods 
	
	public void senduserName() {
		userName.sendKeys("8412859400");
	}
	
	public void sendcontinues() {
		continues.click();
	}
	
}
	
	

