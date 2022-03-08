package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	
	protected static WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/datepicker");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public static void tearDown()
	{
		//driver.quit();
	}

}
