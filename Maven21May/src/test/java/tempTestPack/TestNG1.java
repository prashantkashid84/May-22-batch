package tempTestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basePackage.BasePojo;
import pages.AmazonMobNum;
import pages.AmazonPassword;
import pages.AmazonSelling;
import pages.EgiftCardsAndSell;
import pages.Logout;

 public class TestNG1 extends BasePojo{
	
	private WebDriver driver;

	private EgiftCardsAndSell egiftcards;
    private AmazonSelling amazonSell;
    private Logout logout;
    private EgiftCardsAndSell egiftCardsAndSell;
    private AmazonMobNum amazonMobNum;
    private AmazonPassword amazonPassword;
	
    
    @Parameters("browser")
    
    @BeforeTest
    public void beforeTest(String browserName)
    {
    	if (browserName.equals("Chrome"))
    	{
    		driver=openChromeDriver();
    	}
    	if(browserName.equals("Edge"))
    	{
    		driver=openEdgeDriver();
    	}
    	
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    }
    
    
    @BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class");
		
		amazonMobNum=new AmazonMobNum(driver);
		amazonPassword=new AmazonPassword(driver);
		egiftcards=new EgiftCardsAndSell(driver);
		egiftCardsAndSell=new EgiftCardsAndSell(driver);
		
	}

	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		System.out.println("Before method");
		
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26adgrpid%3D55759171661%26ext_vrnc%3Dhi%26gclid%3DCj0KCQjw08aYBhDlARIsAA_gb0fm2ntpQe3epT51KCOdmujMmv19CO8Z4iDSVBNnG_VjmB9svFGQzq0aAiHOEALw_wcB%26hvadid%3D617721279979%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9062114%26hvnetw%3Dg%26hvpone%3D%26hvpos%3D%26hvptwo%3D%26hvqmt%3Db%26hvrand%3D2441067228091321450%26hvtargid%3Dkwd-298479560553%26hydadcr%3D5840_2361992%26ref%3Dpd_sl_7b63n4zle7_b%26tag%3Dgooginhydr1-21%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		
		amazonMobNum.senduserName();
		amazonMobNum.sendcontinues();
		
		Thread.sleep(5000);
		
		String continueButtonTitle=driver.getTitle();
		System.out.println(continueButtonTitle);
		
		amazonPassword.sendpassword();
		amazonPassword.sendsignIn();
		
		Thread.sleep(4000);
	
	}

	@Test
	public void test1() throws InterruptedException
	{
		System.out.println("Before test1");
		
		egiftcards.giftCardsOpen();
		
		Thread.sleep(7000);
		String giftcardButtonTitle=driver.getTitle();
		
		Assert.assertEquals(giftcardButtonTitle, "Gifts for Everyone | Amazon.in Gift Finder");
		
//		if(giftcardButtonTitle.equals("Gifts for Everyone | Amazon.in Gift Finder"))
//		{
//			System.out.println("giftcardButtonTitle is verified");
//		}
//		else
//		{
//			System.out.println("giftcardButtonTitle is not verified");
//		}
		
	}

	@Test
	public void test2() throws InterruptedException
	{
		System.out.println("Before test2");
		
		egiftCardsAndSell.sellButtonClicked();
		
		Thread.sleep(3000);
		
		String sellButtonTitle=driver.getTitle();
		
		SoftAssert soft=new SoftAssert();
		
		soft.assertEquals(sellButtonTitle, "Amazon.in: Selling on Amazon - Start Selling Now");
		
		soft.assertAll();
		
//		if(sellButtonTitle.equals("Amazon.in: Selling on Amazon - Start Selling Now"))
//		{
//			System.out.println("sellButtonTitle is verified");
//		}
//		else
//		{
//			System.out.println("sellButtonTitle is not verified");
//		}
		
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException
	{
		  Thread.sleep(4000);
		
		  logout=new Logout(driver);
		  logout.clickToMyAccount();
		  logout.clickToSignout();
	}
	
	@AfterClass
	public void afterClass()
	{
		
		egiftCardsAndSell=null;
		egiftcards=null;
		amazonPassword=null;
		amazonMobNum=null;	
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	

}
