package biz.module2;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import biz.basepackage.baseinit;
import biz.utility.mylibrary;

public class selectmanufacturer extends baseinit {
	@BeforeTest
	public void setup() throws IOException
	{
		startup();
		
	}
	@Test
	public void testselectmanufacturer()
	{
		WebElement manufacturer=iselementpresent("dd_manufacturer_name");
		List<WebElement> menuvalues=manufacturer.findElements(By.tagName("option"));
		for(int count=1;count<menuvalues.size();count++)
		{
			String menutext=menuvalues.get(count).getText();
			if(menutext.equalsIgnoreCase("intel core"))
			{
			menuvalues.get(count).click();
			mylibrary.getscreenshot("2", driver);
			logs.info(driver.getTitle()+"-->"+driver.getCurrentUrl());
			break;
			}
		}
	}								
}
