package giveRecognitionPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	public WebDriver driver;

	// Header links
	By headerNavLink = By.xpath("//ul[@class='topbar-nav nav']/li");
	By homeLink = By.xpath("//ul[@class='topbar-nav nav']/li[1]/a");
	By featuresLink = By.xpath("//ul[@class='topbar-nav nav']/li[2]/a");
	By planLink = By.xpath("//ul[@class='topbar-nav nav']/li[3]/a");
	By blogLink = By.xpath("//ul[@class='topbar-nav nav']/li[4]/a");
	By userEmail = By.xpath("//input[@type='email']");
	By tryForFreeButton = By.xpath("//button[contains(text(),'Try')]");
	By listAllLinks = By.xpath("//a");
	By captureErrorMessage = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]");
	By header = By.tagName("h5");
	By emailOne = By.xpath("//form[@method='post']/div[1]/input[1]");
	By tryAssemblyForFree = By.xpath("//div[@class='topbar-right']/div/a[2]");
	By signInButton = By.xpath("//div[@class='topbar-right']/div/a[1]");
	By headernavLinkContent = By.tagName("h2");
	By homeHeader = By.tagName("h1");
	By featureSideNavList = By.xpath("//ul[@class='nav nav-vertical']/li");
	By featureRecognitionList = By.xpath("//ul[@class='nav nav-vertical']/li[1]/a");
	By birthdayAnniversary = By.xpath("//ul[@class='nav nav-vertical']/li[2]/a");
	By requestDemoButton = By.xpath("//a[contains(text(), 'request a demo')]");
	By selectDemoTime = By.xpath("//div[@role='checkbox']");
	By demoIframe = By.xpath("//div[@class='meetings-iframe-container']/iframe");
	By firstName = By.xpath("//input[@name='firstName']");
	By lastName = By.xpath("//input[@name='lastName']");
	By demoEmail = By.xpath("//input[@name='email']");
	By messageTextarea = By.tagName("textarea");
	By confirmButton = By.xpath("//button/span/i18n-string");
	By bookingConfirmedMessage = By.xpath("//h2/i18n-string");
	By bookingTiming = By.xpath("//div[@class='m-x-4 p-y-11 p-x-3 text-center']/h4");
	By closeModal = By.xpath("//button[@class='close']");

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> headerNavLink() {
		return this.driver.findElements(headerNavLink);

	}

	public WebElement homeLink() {
		return this.driver.findElement(homeLink);

	}

	public WebElement featuresLink() {
		return this.driver.findElement(featuresLink);

	}

	public WebElement planLink() {
		return this.driver.findElement(planLink);

	}

	public WebElement blogLink() {
		return this.driver.findElement(blogLink);

	}

	public List<WebElement> userEmail() {
		return this.driver.findElements(userEmail);

	}

	public List<WebElement> tryForFreeButton() {
		return this.driver.findElements(tryForFreeButton);

	}

	public List<WebElement> listAllLinks() {
		return this.driver.findElements(listAllLinks);

	}

	public WebElement captureErrorMessage() {
		return this.driver.findElement(captureErrorMessage);

	}

	public WebElement header() {
		return this.driver.findElement(header);

	}

	public WebElement emailOne() {
		return this.driver.findElement(emailOne);

	}

	public WebElement tryAssemblyForFree() {
		return this.driver.findElement(tryAssemblyForFree);

	}

	public WebElement signInButton() {
		return this.driver.findElement(signInButton);

	}

	public WebElement headernavLinkContent() {
		return this.driver.findElement(headernavLinkContent);

	}

	public WebElement homeHeader() {
		return this.driver.findElement(homeHeader);

	}

	public List<WebElement> featureSideNavList() {
		return this.driver.findElements(featureSideNavList);

	}

	public List<WebElement> featureRecognitionList() {
		return this.driver.findElements(featureRecognitionList);

	}

	public WebElement birthdayAnniversary() {
		return this.driver.findElement(birthdayAnniversary);

	}

	public WebElement requestDemoButton() {
		return this.driver.findElement(requestDemoButton);

	}

	public WebElement selectDemoTime() {
		return this.driver.findElement(selectDemoTime);

	}

	public WebElement demoIframe() {
		return this.driver.findElement(demoIframe);

	}

	public WebElement firstName() {
		return this.driver.findElement(firstName);

	}

	public WebElement lastName() {
		return this.driver.findElement(lastName);

	}

	public WebElement demoEmail() {
		return this.driver.findElement(demoEmail);

	}

	public WebElement messageTextarea() {
		return this.driver.findElement(messageTextarea);

	}

	public WebElement confirmButton() {
		return this.driver.findElement(confirmButton);

	}

	public WebElement bookingConfirmedMessage() {
		return this.driver.findElement(bookingConfirmedMessage);

	}

	public WebElement bookingTiming() {
		return this.driver.findElement(bookingTiming);

	}

	public WebElement closeModal() {
		return this.driver.findElement(closeModal);

	}
}
