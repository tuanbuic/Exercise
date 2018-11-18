package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	private WebElement cusAcc;
	@FindBy(name = "cusid")
	private WebElement cusID;
	@FindBy(name = "selaccount")
	private WebElement cusAccType;
	@FindBy(name = "inideposit")
	private WebElement cusInDepo;
	@FindBy(name = "button2")
	private WebElement btnSubmit;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickNewAccount() {
		cusAcc.click();
	}

	public void setCustomerID(String cusIDNum) {
		cusID.sendKeys(cusIDNum);
	}

	public void setDepositNumber(String DepoNum) {
		cusInDepo.sendKeys(DepoNum);
	}

	public void clickSubmit() {
		btnSubmit.click();
	}
}
