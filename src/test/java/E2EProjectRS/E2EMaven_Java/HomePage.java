package E2EProjectRS.E2EMaven_Java;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base
{
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String username, String password, String text) throws Exception
	{
		driver=initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		LandingPage lp = new LandingPage(driver);
		lp.closePopup().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		lp.getLogin().click();
		
		LoginPage log = new LoginPage(driver);
		log.getemail().sendKeys(username);
		log.getPassword().sendKeys(password);
		System.out.println(text);
		log.submit().click();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@email.com";
		data[0][1] = "123456";
		data[0][2] = "Non Restricted User";
		
		data[1][0] = "restricteduser@email.com";
		data[1][1] = "123456";
		data[1][2] = "Restricted User";
		
		return data;
	}
}
