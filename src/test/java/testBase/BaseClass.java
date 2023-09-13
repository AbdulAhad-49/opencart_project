package testBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // logging
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.Date;

public class BaseClass {
	
	public ResourceBundle rb;
	public static WebDriver driver;
	public Logger logger;  // for logging
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters("browser")  // getting browser parameter from testng.xml
	public void setup(String br) {
		rb=ResourceBundle.getBundle("config");// Load config.properties
		logger=LogManager.getLogger(this.getClass());  //logging
		
//		ChromeOptions options=new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"}); //for Removing test under script
		
		if(br.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();		
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appUrl"));
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() {
		String generatedString2=RandomStringUtils.randomNumeric(10);
		return generatedString2;
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	public String captureScreen(String tname) {
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshots=(TakesScreenshot) driver;
		File source=takesScreenshots.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		}
		catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
