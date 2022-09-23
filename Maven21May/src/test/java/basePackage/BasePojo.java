package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasePojo {
	
	public static WebDriver openChromeDriver() 
	{
		
		 System.setProperty("webdriver.chrome.driver", "C:\\selenium\\New chrome\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver= new ChromeDriver(); // launch the browser
		 return null;
	}
	
	public static WebDriver openEdgeDriver() 
	{
		
		System.setProperty("webdriver.edge.driver", "C:\\selenium\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver= new EdgeDriver(); 
		 return null;
	}

}
