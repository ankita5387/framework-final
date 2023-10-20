package biz.utility;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import biz.basepackage.baseinit;

public class mylibrary extends baseinit{
	public static void signin(String email,String password)
	{
		iselementpresent("lnk_logyourselfin_linktext").click();
		iselementpresent("ip_emailaddress_name").sendKeys(email);
		iselementpresent("ip_password_name").sendKeys(password);
		iselementpresent("btn_signin_id").click();

	}
	public static void signout()
	{
		iselementpresent("lnk_loggof_linktext").click();

	}
public static String getscreenshot(String imagename,WebDriver driver)
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File scrFile=ts.getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+imagename+System.currentTimeMillis()+".png";
	File destination=new File(path);
	try {
		FileHandler.copy(scrFile, destination);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	System.out.println(e.getMessage());
			
	}
	return path;
}
}
