package biz.basepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class baseinit {
	public static Properties sitedata;
	public static WebDriver driver; 
	public static Logger logs;

	public void startup() throws IOException 
	{
		if(driver==null)
		{
		logs=Logger.getLogger("devpinoyLogger");
		logs.info("Properties file will be loading");
		sitedata = new Properties();
		FileInputStream fi=new FileInputStream("./src/test/resources/propertiesdata/sitedata.properties");
		sitedata.load(fi);
		logs.info("property file loaded successfully");
		logs.info("broser will be launching");
		String browserval=sitedata.getProperty("browser");
		if(browserval.equalsIgnoreCase("chrome"))
		{
			 driver=new ChromeDriver();
			logs.info("chrome browser launched");
		}
		else if(browserval.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			logs.info("firefox browser launched");
		}
		else
		{
			System.out.println("system has not defined any browser file");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(sitedata.getProperty("url"));
		}
	}
	public static WebElement iselementpresent(String propkey)
	{
		try 
		{
			if(propkey.contains("xpath"))
			{
					return driver.findElement(By.xpath(sitedata.getProperty(propkey)));
			}
			else if(propkey.contains("id"))
			{
					return driver.findElement(By.id(sitedata.getProperty(propkey)));
			}
			else if(propkey.contains("linktext"))
			{
					return driver.findElement(By.linkText(sitedata.getProperty(propkey)));
			}
			else if(propkey.contains("name"))
			{
					return driver.findElement(By.name(sitedata.getProperty(propkey)));
			}
			else
			{
				System.out.println("element not found in properties file");
			}
		}
		catch(Exception e)
		{
			
		}
		return null;
		
	}
}



