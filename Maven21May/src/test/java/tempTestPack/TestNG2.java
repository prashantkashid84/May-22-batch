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
import pages.Babyproduct;
import pages.Logout;
import pages.Sport;

public class TestNG2 extends BasePojo {
	
	private WebDriver driver;
	private Logout logout;
	private  Sport sport;
	private Babyproduct babyProduct;
	private AmazonMobNum amazonMobNum;
	private AmazonPassword amazonPassword;
	private SoftAssert soft;
	
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
			 babyProduct=new Babyproduct(driver);
			 sport=new Sport(driver);
		}
	   
		@BeforeMethod
		public void beforeMethod() throws InterruptedException
		{
			System.out.println("Before method");
			
	        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26adgrpid%3D55759171661%26ext_vrnc%3Dhi%26gclid%3DCj0KCQjw08aYBhDlARIsAA_gb0fm2ntpQe3epT51KCOdmujMmv19CO8Z4iDSVBNnG_VjmB9svFGQzq0aAiHOEALw_wcB%26hvadid%3D617721279979%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9062114%26hvnetw%3Dg%26hvpone%3D%26hvpos%3D%26hvptwo%3D%26hvqmt%3Db%26hvrand%3D2441067228091321450%26hvtargid%3Dkwd-298479560553%26hydadcr%3D5840_2361992%26ref%3Dpd_sl_7b63n4zle7_b%26tag%3Dgooginhydr1-21%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
			
			driver.manage().window().maximize();

			amazonMobNum.senduserName();
			amazonMobNum.sendcontinues();
			
			Thread.sleep(5000);
			
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
			
			amazonPassword.sendpassword();
			amazonPassword.sendsignIn();
			
			Thread.sleep(4000);
			
			soft=new SoftAssert();
			
		}
		
		
		@Test
		public void test3() throws InterruptedException
	{
		 System.out.println("Before test3");
		 
		 babyProduct.babyProductClicked();
		 
		Thread.sleep(3000);
		
		String babyProductTitle= driver.getTitle();
		
		soft.assertEquals(babyProductTitle, "Baby Products: Buy New Born Baby Products online at best prices in India - Amazon.in");
		soft.assertAll();
		 
//		if(babyProductTitle.equals("Baby Products: Buy New Born Baby Products online at best prices in India - Amazon.in"))
//		{
//			System.out.println("babyProductTitle is verified ");
//		}
//		else
//		{
//			System.out.println("babyProductTitle is not verified ");
//		}
	}
		
		@Test
		public void test4() throws InterruptedException
		{
			 System.out.println("Before test4");
			  
			 sport.sportProductClicked();
			 Thread.sleep(3000);
			 String sportTitle=driver.getTitle();
			 
			
			 
			 soft.assertEquals(sportTitle, "Sports & Fitness Equipment: Buy Sports & Fitness Equipment Online at Low Prices in India - Amazon.in");
			 soft.assertAll();
			 
//			 if(sportTitle.equals("Sports & Fitness Equipment: Buy Sports & Fitness Equipment Online at Low Prices in India - Amazon.in"))
//			 {
//				 System.out.println("sportTitle is verfied");
//			 }
//			 else
//			 {
//				 System.out.println("sportTitle is not verfied"); 
//			 }
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
			System.out.println("After class");
			babyProduct=null;
			sport=null;
			amazonPassword=null;
			amazonMobNum=null;	
		}
		
		@AfterTest
		public void afterTest()
		{
			System.out.println("After test");
			driver.close();
			driver=null;
			System.gc();
		}
}
