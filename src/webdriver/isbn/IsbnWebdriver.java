package webdriver.isbn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class IsbnWebdriver implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"lib\\chromedriver_new.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");// 让Chrome浏览器窗口最大化
		options.addArguments("--disable-popup-blocking");
		options.addArguments("no-sandbox");
		options.addArguments("disable-extensions");
		options.addArguments("no-default-browser-check");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		baseUrl = "http://172.16.129.192:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void saveCookieTest() throws FileNotFoundException, InterruptedException, IOException{
		saveCookie("yangyy","123456","cookies.ser");//路径默认保存到工程的根目录下，如seleniumTest/cookies.ser
	}
	
	//分别打印cookie信息，并保存cookies到指定文件中
	public void saveCookie(String username,String password,String savecookiepath) throws InterruptedException, FileNotFoundException, IOException {
		driver.get(baseUrl+"ExerciseBookManager/web/auth/login");
		Thread.sleep(1000);
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(5000);
		//driver.get(baseUrl+"ExerciseBookManager/web/home");
		
		//获取cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("cookie_size:"+cookies.size());
		Iterator<Cookie> it = cookies.iterator();
		CookieStore cookieStore = new BasicCookieStore();
		while(it.hasNext()){
			Cookie cookie = it.next();
			BasicClientCookie bcs = new BasicClientCookie(cookie.getName(),cookie.getValue());
			bcs.setDomain(cookie.getDomain());
			bcs.setPath(cookie.getPath());
			System.out.println(cookie.toString());
			cookieStore.addCookie(bcs);
		}
		//将Cookies保存到文件中
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(savecookiepath)));
		oos.writeObject(cookieStore);
		oos.close();
	}
	
	@Test
	//通过cookies登录
	public void loginByCookies() throws Exception{
		//String rememberMe = "YX81wR1nkjjn8BDSzwFbfXUd7DVgp+5yiwEQOnNcYd1hYZcAhOpItP/lHZ91PWe+2O0G8sUdW2OhEsvWhuHRod+xod+a5zS4A2dRbISVP/rz41hQo94l7LaSdVHgOTyK3kipCIO57qRzn2F6IRK6H3Baik3WoXircm3jHrKUBVpA1IU3GvlZ8ail4gJNjl6Erfb1ApZG0lGjet0+0fWm4ytLYhR1VxgHiD+/TNbmdbXASkhJXxCcJw6/0Gn5a10WRb3bUgOzNNX8wJXP6mjK43LVbP5wbYA6h7Mct8MKZe90iWJUCzLv7ho2CS6rHcQDO3lzB9lt8WHKUy/w4OL57aMeenMVZQWn8ZntUVMjHurJ8K3CAKlbPFmGdBOZXsa3ZITryfuQ6/KL+eU294I+xbvk4CzK82eEdy7EMuE2cqcpZrK1GPx5GATNSELU56xfb/wPokRFRfKY5VNNl/Wb8390lTI3lndktpOL6ybCPx8eYnbxhmVn7bt91QJJIxzImfRHL3LuZXeHRz5nBOh91a+lCKMB/saH1LdHEVUvCzc=";
		String rememberMe = "A9PWo+EE9q2RlwpE94mrzDv0HcU3XxkEAMKY136+5J1x7DN02erAIMLZTMAsMqpeGwGZjHuUq2D6DEuADbhSdDvOtbWwEQazTMvUl0JkvKIW0vFZoKJoRwritd8jUpkLe0LZIoSww8slaKPAOpwOlOvtflZWzI65xKNCSTbBmlos7n9Uo5OgocL6b41QjRaBq1KQjN8fUZKxvuyQq8w3WdfT5ONAjCH0k7IuoImixhKmNVuFZ+Vo0QxMnEmQpgW77rMTCqYeFSqCkhGOaHjBgpe0JRcjXIF/c7fXl7BvPFotupKomTSvJqQ8/W3K9MaHZP6fXEMAm03v0O/MLFLmBChTTtIv56n75t/uIunMFzYVk1VeFvwvsU0sXrpJA0D/b2fpVt0KPpf+iLyizrLyH4GtEvyD4k5f+1r+Qk3QftGlk6F8AHZuDU8KeKHavlBZMEQGp++DUx3+AVx/V7phGOaNHUvEn3ZnpijSkr77adwHgKtKXv3hR+w3DSawPvnCacvL+maTRbQ5vN+zg2bCyUlRIxGPjJ8Hbhg9gl53LWk=";
		Date expires = new Date("Thu, 31 May 2018 05:02:10 CST");
		String path1 = "/ExerciseBookManager";
		String domain = "172.16.129.192";
		//String msession = "33081163-fcd1-4b03-aaf1-8724efa6c186";
		String msession ="866963ef-e05e-4c5d-9af1-2c57ba15497d";
		String path2 = "/";
		Cookie cookie = new Cookie(rememberMe,path1,domain,expires);
		driver.manage().addCookie(cookie);
		driver.get(baseUrl+"ExerciseBookManager/web/home");
		Thread.sleep(10000);
		
		//ObjectInputStream使用实例
		/*ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("cookies.ser")));
		Object obj = null;
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("original_cookie_size:"+cookies.size());
		while((obj = ois.readObject())!= null){
			if(obj instanceof Cookie){
				System.out.println(((Cookie)obj).toString());
				cookies.add((Cookie)obj);
				driver.manage().addCookie((Cookie)obj);
			}
		}
		ois.close();
		System.out.println("cookie_size:"+cookies.size());
		driver.get(baseUrl+"ExerciseBookManager/web/home");
		Thread.sleep(5000);*/
	}

	//@Test
	public void testIsbn() throws Exception {
		driver.get(baseUrl + "ExerciseBookManager/web/auth/login");
		Thread.sleep(1000);
		// driver.manage().window().maximize();//窗口最大化
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys("yangyy");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("ISBN管理")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//div[@id='main-menu-inner']/ul/li/ul/li/a/span"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.id("barcode")).clear();
		driver.findElement(By.id("barcode")).sendKeys("7131091234570");
		driver.findElement(By.id("barcode")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.id("search-btn")).click();
		Thread.sleep(10000);
		driver.findElement(By.linkText("新建作业本")).click();
		Thread.sleep(10000);
		assertEquals("确定需要新建作业本？", closeAlertAndGetItsText());
		driver.findElement(By.linkText("编辑")).click();
		List<String> list = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(1000);
		driver.switchTo().window(list.get(1));
		Thread.sleep(1000);
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("樱桃之书");
		new Select(driver.findElement(By.name("type")))
				.selectByVisibleText("暑期作业");
		new Select(driver.findElement(By.name("subject")))
				.selectByVisibleText("科学");
		new Select(driver.findElement(By.name("grade")))
				.selectByVisibleText("三年级");
		new Select(driver.findElement(By.name("term")))
				.selectByVisibleText("上册");
		new Select(driver.findElement(By.name("edition")))
				.selectByVisibleText("苏教版");
		driver.findElement(By.name("press")).clear();
		driver.findElement(By.name("press")).sendKeys("出版社1");
		driver.findElement(By.name("year")).clear();
		driver.findElement(By.name("year")).sendKeys("2017");
		driver.findElement(By.name("month")).clear();
		driver.findElement(By.name("month")).sendKeys("05");
		driver.findElement(By.name("revision")).clear();
		driver.findElement(By.name("revision")).sendKeys("1");
		driver.findElement(By.name("printYear")).clear();
		driver.findElement(By.name("printYear")).sendKeys("2017");
		driver.findElement(By.name("printMonth")).clear();
		driver.findElement(By.name("printMonth")).sendKeys("05");
		driver.findElement(By.name("printRevision")).clear();
		driver.findElement(By.name("printRevision")).sendKeys("1");
		driver.findElement(By.id("save-info-67669")).click();
		assertEquals("你确定需要保存数据？", closeAlertAndGetItsText());
		driver.findElement(By.id("cover-file-input-0")).clear();
		driver.findElement(By.id("cover-file-input-0")).sendKeys(
				"F:\\FastStone\\00.jpg");
		new Select(driver.findElement(By.name("hasAnswer")))
				.selectByVisibleText("否");
		driver.findElement(By.id("save-info-67669")).click();
		assertEquals("你确定需要保存数据？", closeAlertAndGetItsText());
		driver.findElement(By.id("search-btn")).click();
		driver.findElement(By.linkText("处理")).click();
		new Select(driver.findElement(By.id("workflowOp")))
				.selectByVisibleText("已购买");
		driver.findElement(By.cssSelector("option[value=\"100200100000\"]"))
				.click();
		new Select(driver.findElement(By.id("nextUserId")))
				.selectByVisibleText("yangyyhandle");
		new Select(driver.findElement(By.name("workflowOpTreatmentId")))
				.selectByVisibleText("购买含答案纸质书");
		driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
		assertEquals("您确定需要提交该处理？", closeAlertAndGetItsText());
		driver.findElement(By.cssSelector("span.glyphicon.glyphicon-cog"))
				.click();
		new Select(driver.findElement(By.id("workflowOp")))
				.selectByVisibleText("已到货");
		new Select(driver.findElement(By.id("nextUserId")))
				.selectByVisibleText("yangyyhandle");
		driver.findElement(By.xpath("//button[@value='']")).click();
		assertEquals("您确定需要提交该处理？", closeAlertAndGetItsText());
		driver.findElement(By.xpath("//button[@value='']")).click();
		assertEquals("您确定需要提交该处理？", closeAlertAndGetItsText());
		driver.findElement(By.xpath("//button[@value='']")).click();
		assertEquals("您确定需要提交该处理？", closeAlertAndGetItsText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
