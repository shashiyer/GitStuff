package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage
{
	public WebDriver driver;
	
	By signin = By.xpath("//span[contains(text(),'Login')]");
	By popup = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	By title = By.xpath("//div[@class='text-center']/h2");
	
	By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']/li");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement closePopup()
	{
		return driver.findElement(popup);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}

	public WebElement getNavbar()
	{
		return driver.findElement(navbar);
	}
}
