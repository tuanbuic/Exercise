package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage {
	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	private WebElement cusTab;
	@FindBy(name = "name")
	private WebElement cusName;
	@FindBy(name = "rad1")
	private WebElement cusGender1;
	@FindBy(name = "rad2")
	private WebElement cusGender2;
	@FindBy(id = "dob")
	private WebElement cusDOB;
	@FindBy(name = "addr")
	private WebElement cusAddress;
	@FindBy(name = "city")
	private WebElement cusCity;
	@FindBy(name = "state")
	private WebElement cusState;
	@FindBy(name = "pinno")
	private WebElement cusPIN;
	@FindBy(name = "telephoneno")
	private WebElement cusPhone;
	@FindBy(name = "emailid")
	private WebElement cusEmail;
	@FindBy(name = "password")
	private WebElement cusPass;
	@FindBy(name = "sub")
	private WebElement subBtn;

	public CreateUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCreateCustomer() {
		cusTab.click();
	}

	public void setCustomerName(String value) {
		cusName.sendKeys(value);
	}

	public void clickCustomerGender(String value) {
		if (value == "male") {
			cusGender1.click();
		} else if (value == "female") {
			cusGender2.click();
		}
	}

	public void setDateOfBirth(String value) {
		cusDOB.sendKeys(value);
	}

	public void setCustomerAddress(String value) {
		cusAddress.sendKeys(value);
	}

	public void setCustomerCity(String value) {
		cusCity.sendKeys(value);
	}

	public void setCustomerState(String value) {
		cusState.sendKeys(value);
	}

	public void setCustomerPIN(String value) {
		cusPIN.sendKeys(value);
	}

	public void setCustomerPhone(String value) {
		cusPhone.sendKeys(value);
	}

	public void setCustomerEmail(String value) {
		cusEmail.sendKeys(value);
	}

	public void setCustomerPassword(String value) {
		cusPass.sendKeys(value);
	}

	public void clickSubmitButton() {
		subBtn.click();
	}
}
