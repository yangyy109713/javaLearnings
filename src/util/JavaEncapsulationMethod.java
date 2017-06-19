package util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;

public class JavaEncapsulationMethod {
	private WebElement element = null;
	
	public String getCurrentSystemTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
	public void errorScreenshot(WebDriver driver , String path , String pictureFormat) throws Exception{
		String pictureName = getCurrentSystemTime() + pictureFormat;
		File jpg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(jpg, (new File(path + pictureName)));
	}
	
	public WebElement elementException(WebDriver driver , By by , String elementName , String className) throws Exception{
		Logger logger = LogManager.getLogger(className);
		//DOMConfiguration.configure("log4j.xml");
		try{
			element = driver.findElement(by);
			element.isDisplayed();
			logger.info("the element is visible");
			return element;
		}catch(Exception e){
			logger.error(element + " is not visible , please look the screenshot and check!");
			errorScreenshot(driver , "F:\\FastStone\\" , "jpg");
			driver.close();
			throw(e);
		}
	}
}
