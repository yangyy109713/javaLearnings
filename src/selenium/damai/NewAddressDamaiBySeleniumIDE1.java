package selenium.damai;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewAddressDamaiBySeleniumIDE1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.damai.cn/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDamai1() throws Exception {
    driver.get(baseUrl + "/hz/");
    driver.findElement(By.linkText("登录")).click();
    driver.findElement(By.id("login_email")).clear();
    driver.findElement(By.id("login_email")).sendKeys("18056574693");
    driver.findElement(By.id("login_pwd")).clear();
    driver.findElement(By.id("login_pwd")).sendKeys("y10203040000");
    driver.findElement(By.id("subbtn")).click();
    driver.findElement(By.id("login_pwd")).clear();
    driver.findElement(By.id("login_pwd")).sendKeys("y10203040000");
    driver.findElement(By.cssSelector("div.clickCaptcha_img > img")).click();
    driver.findElement(By.id("subbtn")).click();
    driver.findElement(By.id("chengshi_hz_fldh_spfl_002")).click();
    driver.findElement(By.linkText("爱乐汇·“天空之城”久石让 宫崎骏动漫作品视听音乐会·惠民专场")).click();
    driver.findElement(By.linkText("2017-06-04 周日 14:00")).click();
    driver.findElement(By.linkText("180")).click();
    driver.findElement(By.cssSelector("#cartList > div.ct > ul.lst > li.itm")).click();
    driver.findElement(By.id("btnBuyNow")).click();
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
