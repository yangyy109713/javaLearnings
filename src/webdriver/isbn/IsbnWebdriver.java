package webdriver.isbn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class IsbnWebdriver {

	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver_new.exe");
	    driver = new ChromeDriver();
	    baseUrl = "http://172.16.129.192:8080/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testIsbn() throws Exception {
	    driver.get(baseUrl + "ExerciseBookManager/web/auth/login");
	    Thread.sleep(1000);
	    driver.manage().window().maximize();//窗口最大化
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
	    driver.findElement(By.xpath("//div[@id='main-menu-inner']/ul/li/ul/li/a/span")).click();
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
	    new Select(driver.findElement(By.name("type"))).selectByVisibleText("暑期作业");
	    new Select(driver.findElement(By.name("subject"))).selectByVisibleText("科学");
	    new Select(driver.findElement(By.name("grade"))).selectByVisibleText("三年级");
	    new Select(driver.findElement(By.name("term"))).selectByVisibleText("上册");
	    new Select(driver.findElement(By.name("edition"))).selectByVisibleText("苏教版");
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
	    driver.findElement(By.id("cover-file-input-0")).sendKeys("F:\\FastStone\\00.jpg");
	    new Select(driver.findElement(By.name("hasAnswer"))).selectByVisibleText("否");
	    driver.findElement(By.id("save-info-67669")).click();
	    assertEquals("你确定需要保存数据？", closeAlertAndGetItsText());
	    driver.findElement(By.id("search-btn")).click();
	    driver.findElement(By.linkText("处理")).click();
	    new Select(driver.findElement(By.id("workflowOp"))).selectByVisibleText("已购买");
	    driver.findElement(By.cssSelector("option[value=\"100200100000\"]")).click();
	    new Select(driver.findElement(By.id("nextUserId"))).selectByVisibleText("yangyyhandle");
	    new Select(driver.findElement(By.name("workflowOpTreatmentId"))).selectByVisibleText("购买含答案纸质书");
	    driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
	    assertEquals("您确定需要提交该处理？", closeAlertAndGetItsText());
	    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-cog")).click();
	    new Select(driver.findElement(By.id("workflowOp"))).selectByVisibleText("已到货");
	    new Select(driver.findElement(By.id("nextUserId"))).selectByVisibleText("yangyyhandle");
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
