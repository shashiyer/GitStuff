package E2EProjectRS.E2EMaven_Java;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base
{
	@Test
	
	public void basePageNavigation() throws Exception
	{
		
		driver=initializeDriver();
//		driver.get("http://www.qaclickacademy.com");

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		LandingPage lp = new LandingPage(driver);
		lp.closePopup().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//compare the text from the browser with the actual value if there is mismatch then script should fail with error.
		String title = lp.getTitle().getText();
		Assert.assertEquals(title, "FEATURED COURSES");
		
		boolean nav = lp.getNavbar().isDisplayed();
		Assert.assertTrue(nav);
		System.out.println(nav);
		
		
	}
	
}
