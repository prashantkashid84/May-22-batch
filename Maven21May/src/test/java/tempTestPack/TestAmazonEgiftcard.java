package tempTestPack;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AmazonMobNum;
import pages.AmazonPassword;
import pages.AmazonSelling;
import pages.EgiftCardsAndSell;
import pages.GiftCardsHomepage;
import pages.Logout;

public class TestAmazonEgiftcard {
    private WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\New chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver(); // launch the browser
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26adgrpid%3D55759171661%26ext_vrnc%3Dhi%26gclid%3DCj0KCQjw08aYBhDlARIsAA_gb0fm2ntpQe3epT51KCOdmujMmv19CO8Z4iDSVBNnG_VjmB9svFGQzq0aAiHOEALw_wcB%26hvadid%3D617721279979%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9062114%26hvnetw%3Dg%26hvpone%3D%26hvpos%3D%26hvptwo%3D%26hvqmt%3Db%26hvrand%3D2441067228091321450%26hvtargid%3Dkwd-298479560553%26hydadcr%3D5840_2361992%26ref%3Dpd_sl_7b63n4zle7_b%26tag%3Dgooginhydr1-21%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		
		driver.manage().window().maximize();
		AmazonMobNum amazonMobNum=new AmazonMobNum(driver);
		amazonMobNum.senduserName();
		amazonMobNum.sendcontinues();
		
		Thread.sleep(7000);
		String continueButtonTitle=driver.getTitle();
		System.out.println(continueButtonTitle);
		
	   if(continueButtonTitle.equals("Amazon Sign In"))
		{
			System.out.println("continueButtonTitle is verified");
		}
		else
		{
			System.out.println("continueButtonTitle is not verified");
		}
		
		AmazonPassword amazonPassword=new AmazonPassword(driver);
		amazonPassword.sendpassword();
		amazonPassword.sendsignIn();
		
		Thread.sleep(4000);
		
		String homePageTitle=driver.getTitle();
		
		if(homePageTitle.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
		{
			System.out.println("homePageTitle is verified");
		}
		else
		{
			System.out.println("homePageTitle is not verified");
		}
		
		EgiftCardsAndSell egiftcards=new EgiftCardsAndSell(driver);
		egiftcards.giftCardsOpen();
		
		Thread.sleep(7000);
		String giftcardButtonTitle=driver.getTitle();
		
		if(giftcardButtonTitle.equals("Gifts for Everyone | Amazon.in Gift Finder"))
		{
			System.out.println("giftcardButtonTitle is verified");
		}
		else
		{
			System.out.println("giftcardButtonTitle is not verified");
		}
		
		EgiftCardsAndSell egiftCardsAndSell=new EgiftCardsAndSell(driver);
		egiftCardsAndSell.sellButtonClicked();
		
		String sellButtonTitle=driver.getTitle();
		
		if(sellButtonTitle.equals("Amazon.in: Selling on Amazon - Start Selling Now"))
		{
			System.out.println("sellButtonTitle is verified");
		}
		else
		{
			System.out.println("sellButtonTitle is not verified");
		}
		
		AmazonSelling amazonSell=new AmazonSelling(driver);
		amazonSell.amazonSellingClicked();
		
		String amazonSellingTitle=driver.getTitle();
		if(amazonSellingTitle.equals("Amazon.in: Fruits & Vegetables: Amazon Fresh"))
		{
			System.out.println("vegetableButtonTitle is verified");
		}
		else
		{
			System.out.println("vegetableButtonTitle is not verified");
		}
	
	  Logout logout=new Logout(driver);
	  logout.clickToMyAccount();
	  logout.clickToSignout();

	}
}
