package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPassword {
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	public WebElement signIn;
	
	//public constructor
	
	public AmazonPassword(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	}
	
	public void sendpassword() {
		password.sendKeys("prashant#8412");
	}
	
	public void sendsignIn() {
		signIn.click();
	}
}
