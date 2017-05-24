package selenium.tgedu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTgEdu {
	public static void main(String []args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "lib\\ChromeDriverServer.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.helpedu.com/");//登录通关教育
		WebElement ele = driver.findElement(By.xpath("body > div.g-bd > div:nth-child(1) > div > a.d-ico.d-btn2.j-role"));
		Thread.sleep(500);
		ele.click();
		ele = driver.findElement(By.xpath("body > div.g-bd > div:nth-child(2) > div > a.d-ico.d-btn5.j-oldlogin"));
		Thread.sleep(500);
		ele.click();
		ele = driver.findElement(By.className("j-username"));
		Thread.sleep(500);
		ele.sendKeys("yangyy5");
		ele = driver.findElement(By.className("j-pwd"));
		Thread.sleep(500);
		ele.sendKeys("123456");
		ele = driver.findElement(By.id("login"));
		ele.click();
		Thread.sleep(5000);
		driver.close();//关闭浏览器
		Thread.sleep(2000);
		driver.quit();//停止后台服务
	}
}
