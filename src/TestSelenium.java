package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {
	public static void main(String []args) throws InterruptedException{
		//设置浏览器驱动
		System.setProperty("webdriver.chrome.driver", "lib\\ChromeDriverServer.exe");
		//创建一个浏览器驱动对象
		WebDriver driver = new ChromeDriver();
		//driver.get("http://www.helpedu.com");
		driver.get("http://passport.cnblogs.com/user/signin");//博客园登录地址
		Thread.sleep(500);
		WebElement ele = driver.findElement(By.id("input1"));//获取用户名输入框元素
		ele.sendKeys("迷情109713");//输入用户名
		Thread.sleep(500);
		ele = driver.findElement(By.id("input2"));
		ele.sendKeys("y10203040@y");//输入密码
		Thread.sleep(500);
		ele = driver.findElement(By.id("signin"));
		ele.click();
		Thread.sleep(10000);
		String s = driver.getCurrentUrl();
		System.out.println(s);
		driver.close();//关闭浏览器
		Thread.sleep(500);
		driver.quit();//关闭服务
	}
}
