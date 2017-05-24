package selenium.damai;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDamai {
	public static void main(String args[]) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver_new.exe");
		WebDriver driver = new ChromeDriver();
		List <WebElement> eleList;
		driver.get("https://www.damai.cn/hz/");//open Damai's URL in chromeBrowser
		Thread.sleep(2000);
		driver.manage().window().maximize();//浏览器最大化
		try{
		driver.findElement(By.className("dm-login")).click();//find login location
		/*Set<String> windows;//获取当前所有窗口
		windows = driver.getWindowHandles();*/
		List<String> list;
		list = new ArrayList<String>(driver.getWindowHandles());//将获得的当前所有打开的windows窗口转换成list
		driver.switchTo().window(list.get(1));//跳转到新窗口
		Thread.sleep(500);
		 /*
	     String url=driver.getCurrentUrl(); //获取新窗口的url
	     System.out.println(url);
		 driver.switchTo().window(it.get(0)); // 返回至原页面
	     */
		driver.findElement(By.id("login_email")).sendKeys("15168475428");//input email/phone
		Thread.sleep(2000);//等待，以防出现验证码
		driver.findElement(By.id("login_email")).sendKeys(Keys.TAB);//按Tab键，如果不做这一操作，会导致无法定位到密码输入框（暂时不知原因）
		//driver.findElement(By.id("login_pwd")).sendKeys("y10203040000");//输入密码，定位方式一
		driver.findElement(By.xpath("//input[@id='login_pwd'][@type='password']")).sendKeys("y10203040000");//输入密码，定位方式二
		Thread.sleep(500);
		driver.findElement(By.id("subbtn")).click();//click login button
		Thread.sleep(1000);
		
		//driver.findElement(By.linkText("音乐会")).click();//音乐会列表
		driver.findElement(By.id("chengshi_hz_fldh_spfl_002")).click();//音乐会列表
		Thread.sleep(1000);
		list = new ArrayList<String>(driver.getWindowHandles());//将获得的当前所有打开的windows窗口转换成list
		driver.switchTo().window(list.get(2));
		Thread.sleep(500);
		
		eleList = driver.findElements(By.xpath("//a[@id='search_log_116923']"));//该id在页面上有2个a标签，全部获取到，然后取需要的
		eleList.get(1).click();//点击商品名称
		
		Thread.sleep(1000);
		list = new ArrayList<String>(driver.getWindowHandles());//将获得的当前所有打开的windows窗口转换成list
		driver.switchTo().window(list.get(3));
		
		Thread.sleep(500);
		driver.findElement(By.id("firstperform")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("180")).click();//通过超链接文本获取元素
		Thread.sleep(500);
		//driver.findElement(By.className("u-btn-buynow"));
		eleList = driver.findElements(By.id("btnBuyNow"));//获取多个有相同id的元素
		eleList.get(0).click();//点击“立即购买”
		Thread.sleep(500);
		
		/*eleList = driver.findElements(By.className("txt-primary"));//获得“新建配送地址”所在的元素
		//driver.findElement(By.linkText("新建配送地址")).click();
		eleList.get(0).click();//点击“新建配送地址”
		 */
		driver.findElement(By.xpath("//div[@class='rbox']/a[1]")).click();//获得“新建配送地址”所在的元素
		
		driver.findElement(By.xpath("//div[@class='m-m-newinp'][3]")).click();//所在地区
		driver.findElement(By.xpath("//ul[@class='inp-hd']/li[1]")).click();//点击“省份”
		driver.findElement(By.xpath("//div[@class='z-show'][5]/div/dl/dd/ol/li[1]")).click();//点击“安徽”
		
		driver.findElement(By.xpath("//ul[@class='inp-hd']/li[2]")).click();//点击“城市”
		driver.findElement(By.xpath("//div[@class='z-show'][5]/div/dl/dd/ol/li[1]")).click();//点击“安徽”
		
		driver.findElement(By.xpath("//ul[@class='inp-hd']/li[3]")).click();//点击“城市”
		driver.findElement(By.xpath("//div[@class='z-show'][5]/div/dl/dd/ol/li[1]")).click();//点击“安徽”
		
		driver.findElement(By.xpath("//div[@class='invoice-cnt'][3]/div[2]/div/textarea[1]")).sendKeys("西湖区西园一路");//街道地区
		driver.findElement(By.xpath("//div[@class='invoice-cnt'][3]/div[3]/div/input[1]")).sendKeys("yangyy");//收货人
		driver.findElement(By.xpath("//div[@class='invoice-cnt'][3]/div[4]/div/input[1]")).sendKeys("15168475428");//手机号码
		driver.findElement(By.xpath("//div[@class='invoice-cnt'][3]/div[5]/div/input[1]")).sendKeys("0571-12345678");//固定电话
		
		driver.findElement(By.xpath("//p[@class='invoice-form'][2]/button[1]")).click();//保存配送地址
		Thread.sleep(2000);
		
		System.out.println(driver.getCurrentUrl());
		}catch(Exception e){
			e.printStackTrace();
			driver.quit();//抛出异常，关闭浏览器
		}
	}
}
