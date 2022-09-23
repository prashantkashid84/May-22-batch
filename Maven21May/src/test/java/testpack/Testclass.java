package testpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testclass {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver(); // launch the browser
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

	}

}
