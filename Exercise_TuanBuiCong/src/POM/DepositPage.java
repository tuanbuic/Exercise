package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Deposit')]")
	private WebElement cusDepo;
	@FindBy(name = "accountno")
	private WebElement accNo;
	@FindBy(name = "ammount")
	private WebElement depoAmount;
	@FindBy(name = "desc")
	private WebElement depoDesc;
	@FindBy(name = "AccSubmit")
	private WebElement btnDepoSubmit;

	public DepositPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickDeposit() {
		cusDepo.click();
	}

	public void setAccountNo(String accID) {
		accNo.sendKeys(accID);
	}

	public void setAmount(String amountNum) {
		depoAmount.sendKeys(amountNum);
	}

	public void setDescription(String message) {
		depoDesc.sendKeys(message);
	}

	public void clickSubmit() {
		btnDepoSubmit.click();
	}
}
