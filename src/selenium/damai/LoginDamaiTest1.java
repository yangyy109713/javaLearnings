package selenium.damai;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDamaiTest1 {
	public static void main(String[]args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver_new.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.damai.cn/hz/");
		driver.manage().window().maximize();//当前窗口最大化
		driver.findElement(By.linkText("登录")).click();
		Thread.sleep(500);
		//Set<String> windows;//窗口Set集合
		List<String> list;
		list = new ArrayList<String>(driver.getWindowHandles());//将获得的所有窗口的set转换成list（driver.getWindowHandles()得到的是Set集合，所以需要转换）
		driver.switchTo().window(list.get(1));
		Thread.sleep(500);
	    driver.findElement(By.id("login_email")).sendKeys("18056574693");
	    driver.findElement(By.id("login_email")).sendKeys(Keys.TAB);
	    Thread.sleep(500);
	    driver.findElement(By.id("login_pwd")).clear();
	    driver.findElement(By.id("login_pwd")).sendKeys("y10203040000");
	    Thread.sleep(500);
	    driver.findElement(By.id("subbtn")).click();
	    driver.findElement(By.id("login_pwd")).clear();
	    driver.findElement(By.id("login_pwd")).sendKeys("y10203040000");
	    //driver.findElement(By.cssSelector("div.clickCaptcha_img > img")).click();
	    Thread.sleep(500);
	    driver.findElement(By.id("subbtn")).click();
	    Thread.sleep(1000);
	    list = new ArrayList<String>(driver.getWindowHandles());//将获得的所有窗口的set转换成list（driver.getWindowHandles()得到的是Set集合，所以需要转换）
		driver.switchTo().window(list.get(2));
		Thread.sleep(500);
	    driver.findElement(By.id("chengshi_hz_fldh_spfl_002")).click();
	    driver.findElement(By.linkText("爱乐汇·“天空之城”久石让 宫崎骏动漫作品视听音乐会·惠民专场")).click();
	    driver.findElement(By.linkText("2017-06-04 周日 14:00")).click();
	    driver.findElement(By.linkText("180")).click();
	    driver.findElement(By.cssSelector("#cartList > div.ct > ul.lst > li.itm")).click();
	    driver.findElement(By.id("btnBuyNow")).click();
	    Thread.sleep(500);
	    list = new ArrayList<String>(driver.getWindowHandles());//将获得的所有窗口的set转换成list（driver.getWindowHandles()得到的是Set集合，所以需要转换）
		driver.switchTo().window(list.get(3));
		Thread.sleep(500);
	    driver.findElement(By.linkText("新建配送地址")).click();
	    driver.findElement(By.xpath("//div[@id='addAddress']/form/div/div/div/div")).click();
	    driver.findElement(By.id("addAddress")).click();
	    driver.findElement(By.xpath("//div[@id='addAddress']/form/div/div/div/div")).click();
	    driver.findElement(By.xpath("//div[@id='sizzle1495681362908']/div/div/div/dl/dd/ol/li[33]")).click();
	    driver.findElement(By.cssSelector("div.inp-bd.z-show > div.itm > dl > dd > ol > li")).click();
	    driver.findElement(By.xpath("//div[@id='sizzle1495681362908']/div/div[3]/div/dl/dd/ol/li[10]")).click();
	    driver.findElement(By.xpath("(//textarea[@name=''])[3]")).clear();
	    driver.findElement(By.xpath("(//textarea[@name=''])[3]")).sendKeys("xiyu一路");
	    driver.findElement(By.cssSelector("div.invoice-cnt > div.itm > div.ipt > input.u-ipt.u-ipt-lg")).clear();
	    driver.findElement(By.cssSelector("div.invoice-cnt > div.itm > div.ipt > input.u-ipt.u-ipt-lg")).sendKeys("远远杨");
	    driver.findElement(By.xpath("(//input[@type='text'])[10]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("18056574693");
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("1233");
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("");
	    driver.findElement(By.cssSelector("form > a.close")).click();
	    Thread.sleep(30000);
	    driver.close();
	}
}
