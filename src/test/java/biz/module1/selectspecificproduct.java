package biz.module1;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import biz.basepackage.baseinit;


public class selectspecificproduct extends baseinit {
	
	
		@BeforeTest
		public void setup() throws IOException
		{
			startup();
			
		}
	@Test	
	public void testselectspecificproduct()
	{
		
		driver.findElement(By.linkText("smartwatch")).click();
		List<WebElement> prodlinks=driver.findElements(By.xpath("//div[@id='content']/div/div/div/div/div[2]/table/tbody/tr/td[2]/a"));
		List<WebElement> buynowbuttons=driver.findElements(By.xpath("//div[@id='content']/div/div/div/div/div[2]/table/tbody/tr/td[4]/span/a"));
		System.out.println("loop entry");
				for(int count=0;count<prodlinks.size();count++)
				{
					String prodtext=prodlinks.get(count).getText();
					if(prodtext.equalsIgnoreCase("Apple Ipad"))
							{
						buynowbuttons.get(count).click();
						System.out.println("fount");
						break;
							}
				}
					
	}
}

