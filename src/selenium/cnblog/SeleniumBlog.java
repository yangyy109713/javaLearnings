package selenium.cnblog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBlog {
	public static void main(String []args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "lib\\ChromeDriverServer.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.get("http://passport.cnblogs.com/user/signin");//博客园登录
		WebElement ele = driver.findElement(By.id("input1"));
		Thread.sleep(500);
		ele.sendKeys("迷情109713");
		ele = driver.findElement(By.id("input2"));
		Thread.sleep(500);
		ele.sendKeys("y10203040@y");
		ele = driver.findElement(By.id("signin"));
		ele.click();
		Thread.sleep(5000);
		driver.close();//关闭浏览器
		Thread.sleep(2000);
		driver.quit();//停止后台服务
	}
}
