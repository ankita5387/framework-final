package biz.module1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import biz.basepackage.baseinit;
import biz.utility.mylibrary;

public class validateuser extends baseinit {
	
		@BeforeTest
		public void setup() throws IOException
		{
			startup();
			
		}
		@Test
		public void testvalidateuser()
		{
			mylibrary.signin(sitedata.getProperty("email"),sitedata.getProperty("password"));
			System.out.println("logged in");
			try
			{
				iselementpresent("lnk_loggof_linktext").isDisplayed();
			System.out.println("user logged in successfully");
			System.out.println("logged in");
			logs.info("user logged in successfully");
			mylibrary.signout();
			}
			catch(Exception e)
			{
				driver.findElement(By.linkText("Home")).click();
				System.out.println("invalid email adrres or password");
			logs.info("invalid email adrres or password");
			}
		}

}
