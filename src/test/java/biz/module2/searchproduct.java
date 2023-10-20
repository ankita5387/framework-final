package biz.module2;


import java.io.IOException;

import org.openqa.selenium.Keys;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import biz.basepackage.baseinit;
import biz.utility.ExcelFileReader;
import biz.utility.mylibrary;

public class searchproduct extends baseinit 
{
	@BeforeTest
	public void setup() throws IOException 
	{
		startup();
		
	}
	@Test
	public void testsearchproduct() throws InterruptedException
	{
		ExcelFileReader data=new ExcelFileReader("./src/test/java/files/test.xlsx");
		try
		{
		
		iselementpresent("ip_keywords_name").sendKeys("hgbsg",Keys.ENTER);
		data.setData("Sheet1" ,5,1, "testing of ");
		Thread.sleep(2000);
		
		mylibrary.getscreenshot("samsung", driver);
		logs.info(driver.getTitle()+"-->"+driver.getCurrentUrl());
		driver.close();
		}
		catch(Exception e)
		{
		
		}
		}
		
	
	
	




}





	

