package giveRecognitionPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageObjects {
	public WebDriver driver;

	By email = By.id("email");
	By password = By.id("password");
	By signin = By.xpath("//button[@type='submit']");
	By headervalue = By.xpath("//h5");
	By invalidcred = By.xpath("//div[@class='MuiFormControl-root jss26'][1]/label");
	By validErrorMessage = By.xpath("//label");
	By slackSSOHeader = By.xpath("//h5");

	// Get started Flow Xpaths
	By getStarted = By.xpath("//a[@href='/create-account']");
	By confirmButton = By.xpath("//span[contains(text(), 'Confirm')]");
	By accountExistsErrorMessage = By.xpath("//h4");
	By goBackToSignInButton = By.xpath("//a[@role='button']");

	public loginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsernameObject() {
		return this.driver.findElement(email);
	}

	public WebElement getPasswordObject() {
		return this.driver.findElement(password);
	}

	public WebElement signinObject() {
		return this.driver.findElement(signin);
	}

	public WebElement getHeader() {
		return this.driver.findElement(headervalue);
	}

	public WebElement getInvalidCredText() {
		return this.driver.findElement(invalidcred);
	}

	public WebElement validErrorMessage() {
		return this.driver.findElement(validErrorMessage);
	}

	public WebElement SlackSSOHeader() {
		return this.driver.findElement(slackSSOHeader);
	}

	public WebElement getStarted() {
		return this.driver.findElement(getStarted);
	}

	public WebElement confirmButton() {
		return this.driver.findElement(confirmButton);
	}

	public WebElement accountExistsErrorMessage() {
		return this.driver.findElement(accountExistsErrorMessage);
	}

	public WebElement goBackToSignInButton() {
		return this.driver.findElement(goBackToSignInButton);
	}
}
