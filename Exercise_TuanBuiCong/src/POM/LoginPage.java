package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	@FindBy(name = "uid")
	private WebElement userID;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(name = "btnLogin")
	private WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginGuruBanking() {
		userID.sendKeys("mngr163435");
		password.sendKeys("UvEzEva");
		btnLogin.click();
	}
}
