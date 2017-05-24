package selenium.damai;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class LoginVerifyExample {
	public static void main(String[]args){
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver");//手动配置浏览器驱动
		WebDriver chromeDriver = new ChromeDriver();//实例化一个chrome浏览器驱动对象
		chromeDriver.get("https://secure.damai.cn/login.aspx?ru=https://www.damai.cn/hz/");//打开大麦网的登录
		
		//判断是否存在滑块验证
		try{
			chromeDriver.findElement(By.id("dom_id")).click();//dom_id为滑块出现时的div元素的id
			System.out.println("滑块元素已出现!");//此处可用logger代替
			Actions action = new Actions(chromeDriver);
			
			//获取滑动滑块的页面标签元素
			WebElement source = chromeDriver.findElement(By.id("nc_1_n1z"));
			
			//确保每次拖动的像素不同，因此使用随机数
			action.clickAndHold(source).moveByOffset((int)(Math.random()*200)+80, 0);
			Thread.sleep(2000);
			action.clickAndHold(source).moveByOffset((int)(Math.random()*200)+80, 0);
			Thread.sleep(2000);
			action.clickAndHold(source).moveByOffset((int)(Math.random()*200)+80, 0);
			Thread.sleep(2000);
			action.clickAndHold(source).moveByOffset((int)(Math.random()*200)+80, 0);
			Thread.sleep(2000);
			
			//拖动完释放鼠标
			action.moveToElement(source).release();
			//组织完一系列的步骤，开始真实执行操作
			Action action1 = action.build();
			action1.perform();//执行所有Actions中存储的行为
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
