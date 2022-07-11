package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base
{

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws Exception
	{
		//chrome
		//Firefox
		//IE
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Eclipse\\E2EMaven_Java\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			//execute in chrome driver
			System.setProperty("webdriver.chrome.driver", "D:/chrome Driver/100/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName == "firefox")
		{
			System.setProperty("webdriver.firefox.driver", "D:/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName == "IE")
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
