package webdriver.cookie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
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

public class CookieTest implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private WebDriver driver;
	private String baseUrl;
	private String homeUrl;
	private String cookiePath;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	/*
	 * 方法名 setUp()
	 * 加载chrome浏览器的驱动文件
	 * 初始化chrome浏览器配置信息
	 * 设置默认访问baseUrl = "http://172.16.129.192:8080/";
	 */
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
		homeUrl = baseUrl+"ExerciseBookManager/web/home";
		cookiePath = "cookie.data";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void saveCookieTest() throws FileNotFoundException, InterruptedException, IOException{
		//saveCookieNew("yangyy","123456","cookie.data");
		getCookieLogin(homeUrl,cookiePath);
	}
	
	public void getCookieLogin(String url,String cookiePath){
		driver.get(url);
		sleep(3000);
		File file = new File(cookiePath);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine())!= null){
				StringTokenizer st = new StringTokenizer(line,";");
				while(st.hasMoreTokens()){
					String name = st.nextToken();
					//System.out.println("name:"+name);//for test
					String value = st.nextToken();
					//System.out.println("value:"+value);//for test
					String domain = st.nextToken();
					//System.out.println("domain:"+domain);//for test
					String path = st.nextToken();
					
					//System.out.println("path:"+path);//for test
					Date expiry = null;//cookie的失效时间，默认存在浏览器打开期间
					String expiryString = st.nextToken();
					/*if(!(expiryString.equals(null)&& expiryString.equals("false")))
                    {
						expiry = (Date)st.nextElement();//编译报错java.lang.String cannot be cast to java.util.Date
						System.out.println("expiry:"+expiryString);//for test
                    }*/
					boolean isSecure = new Boolean(st.nextToken()).booleanValue();
					//System.out.println("isSecure:"+isSecure);//for test
					
					Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
					//System.out.println(ck.toString());//for test
					driver.manage().addCookie(ck);
				}
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(url);
		sleep(60000);
	}
	
	/**
	 * 分别打印cookie信息
	 * 使用BufferedWriter和FileWriter对象保存cookies到指定文件中
	 * 保存格式:name;value;domain;expires;isSecure
	 * @param username
	 * @param password
	 * @param cookiepath
	 * @throws IOException
	 */
	public void saveCookieNew(String username,String password,String cookiepath) {
		driver.get(baseUrl+"ExerciseBookManager/web/auth/login");
		sleep(1000);
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys(username);
		sleep(1000);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		sleep(2000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		sleep(5000);
		//driver.get(baseUrl+"ExerciseBookManager/web/home");
		
		//获取cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("cookie_size:"+cookies.size());
		File file = new File(cookiepath);
		file.delete();
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Cookie ck : cookies){
				bw.write(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 分别打印cookie信息
	 * 使用ObjectOutputStream和FileOutputStream对象保存cookies到指定文件中
	 * @param username
	 * @param password
	 * @param savecookiepath
	 * @throws InterruptedException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
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
		driver.quit();//关闭浏览器
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	//等待时间
	public void sleep(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
