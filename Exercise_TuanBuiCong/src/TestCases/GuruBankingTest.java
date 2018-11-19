package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM.CreateAccountPage;
import POM.CreateUserPage;
import POM.DepositPage;
import POM.LoginPage;
import utilities.StringUtil;

public class GuruBankingTest {
	private WebDriver driver;
	private String baseUrL;
	private WebDriverWait wait;
	CreateUserPage createCus;
	LoginPage login;
	CreateAccountPage createAcc;
	DepositPage depo;
	String cusID;
	String accID;

	@Test(priority = 1)
	public void testCreateCustomer() throws Exception {
		createCus.clickCreateCustomer();
		createCus.setCustomerName("Tuan Bui");
		createCus.clickCustomerGender("male");
		createCus.setDateOfBirth("271995");
		createCus.setCustomerAddress("Etown 364 Cong Hoa");
		createCus.setCustomerCity("Ho Chi Minh");
		createCus.setCustomerState("SouthesAsia");
		createCus.setCustomerPIN("123456");
		createCus.setCustomerPhone("0909090909");
		createCus.setCustomerEmail(StringUtil.randomString(8) + "@gmail.com");
		createCus.setCustomerPassword("123456789");
		createCus.clickSubmitButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='heading3']")));
		String message = driver.findElement(By.xpath("//p[@class='heading3']")).getText();
		assertEquals(message, "Customer Registered Successfully!!!", "Verify User Creation");
		cusID = driver.findElement(By.xpath("//table[@id='customer']//tr[4]//td[2]")).getText();

	}

	@Test(priority = 2)
	public void testCreateAccount() throws Exception {
		createAcc.clickNewAccount();
		createAcc.setCustomerID(cusID);
		createAcc.setDepositNumber("12345");
		createAcc.clickSubmit();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='heading3']")));
		String messageAccount = driver.findElement(By.xpath("//p[@class='heading3']")).getText();
		assertEquals(messageAccount, "Account Generated Successfully!!!", "Verify Account Creation");
		accID = driver.findElement(By.xpath("//table[@id='account']//tr[4]//td[2]")).getText();
	}

	@Test(priority = 3)
	public void testDeposit() throws Exception {
		depo.clickDeposit();
		depo.setAccountNo(accID);
		depo.setAmount("123456");
		depo.setDescription("Deposit Message");
		depo.clickSubmit();
		String messageDepo = driver.findElement(By.xpath("//p[@class='heading3']")).getText();
		String expectedDepo = "Transaction details of Deposit for Account " + "" + accID;
		assertEquals(messageDepo, expectedDepo, "Verify Deposit Function");
	}

	@BeforeClass
	public void beforeClass() {
		baseUrL = "http://demo.guru99.com/v4/";
		System.getProperty("webdriver.chrome.driver", "//resource//chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		createCus = new CreateUserPage(driver);
		createAcc = new CreateAccountPage(driver);
		depo = new DepositPage(driver);
		login = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrL);
		login.loginGuruBanking();
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
