package com.mercury.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterDetailsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Contact Information
	@FindBy(name = "firstName")
	private WebElement firstName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "userName")
	private WebElement eMail;

	// Mailing Information
	@FindBy(name = "address1")
	private WebElement address1;

	@FindBy(name = "address2")
	private WebElement address2;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "state")
	private WebElement state;

	@FindBy(name = "postalCode")
	private WebElement postalCode;

	@FindBy(name = "country")
	private WebElement country;

	// User Information
	@FindBy(name = "email")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(name = "confirmPassword")
	private WebElement confirmPassword;

	// Submit Button
	@FindBy(name = "register")
	private WebElement smtBtn;

	public RegisterDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 90);
		PageFactory.initElements(driver, this);
	}

	public void launchRegisterPage() {
		this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
		this.wait.until(ExpectedConditions.visibilityOf(firstName));
	}

	public void enterContactInfo(String firstName, String LastName, String phone, String eMail) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(LastName);
		this.phone.sendKeys(phone);
		this.eMail.sendKeys(eMail);
	}

	public void enterMailingInfo(String address1, String address2, String city, String state, String postalCode,
			String cntry) {
		this.address1.sendKeys(address1);
		this.address2.sendKeys(address2);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.postalCode.sendKeys(postalCode);
		Select select = new Select(country);
		select.selectByVisibleText(cntry);
	}

	public void enterUserInfo(String userName, String password, String confirmPassword) {
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		this.confirmPassword.sendKeys(confirmPassword);
	}

	public void clickSubmit() {
		this.smtBtn.click();
	}

}