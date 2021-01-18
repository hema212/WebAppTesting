package billingPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPlanPageObjects {
	public WebDriver driver;
	By BillingText = By.xpath("//i[contains(text(), 'account_balance')]");
	By AccountPlanText = By.xpath("//div[contains(text(), 'Account Plan')]");
	// use for assertion
	By BreadcrumText = By.xpath("//span[@class='admin-breadcrumps-secondary__span']");
	By PlanDescriptionText = By.xpath("//div[@class='row']/../div[2]/div/p");
	By ChangePlanText = By.xpath("//a[contains(text(), 'change plan')]");
	By SelectPlanDropdown = By.xpath("//div[@aria-haspopup='listbox']");
	By PlanListOne = By.xpath("//ul[@role='listbox']/li[2]");
	By PlanListTwo = By.xpath("//ul[@role='listbox']/li[3]");
	By PreviewChangesButton = By.xpath("//div[@class='row']/following-sibling::div//div/a[@role='button']");
	By ToastButton = By.xpath("//div[@role='alert']");
	By headerText = By.tagName("h6");

	// Downgrade plan
	By DowngradeBillingSummaryText = By.xpath("//li[1]/p");
	By DowngradeButton = By.xpath("//span[contains(text(), 'Downgrade')]");
	By CancelButton = By.xpath("//span[contains(text(), 'Cancel')]");

	// Free plan
	By AcceptCheckbox = By.xpath("//input[@value='checkedA']");
	By DowngradeToFree = By.xpath("//div[@class='MuiGrid-root MuiGrid-item']/button");
	By KeepPlanButton = By.xpath("//div[@class='MuiGrid-root MuiGrid-item']/a");

	By UpgradeToButton = By.xpath("//span[contains(text(), 'Upgrade to')]");
	By ActivatePlanButton = By.xpath("//span[contains(text(), 'Activate')]");
	By FreePlanHeaderText = By.xpath("//div[@class='row']/following-sibling::div[1]/div[1]/p");

	// Account status + Change card details
	By ChangePaymentText = By.xpath("//a[contains(text(), 'change payment method')]");
	By ChangeCardButton = By.xpath("//span[contains(text(), 'Change Card')]");
	By UpdateCardButton = By.xpath("//span[contains(text(), 'Update card')]");
	By NevermindButton = By.xpath("//span[contains(text(), 'Nevermind')]");

	// Input fields
	By CardNameInputField = By.xpath("//input[@placeholder='Bruce Wayne']");
	By IframeCardNumber = By.xpath("//iframe[@title='Secure card number input frame']");
	By CardNumberInputField = By.xpath("//input[@placeholder='1234 1234 1234 1234']");
	By IframeExpiryDate = By.xpath("//iframe[@title='Secure expiration date input frame']");
	By CardExpiryDateField = By.xpath("//input[@placeholder='MM / YY']");
	By IframeCvcNumber = By.xpath("//iframe[@title='Secure CVC input frame']");
	By CardCvcField = By.xpath("//input[@placeholder='CVC']");
	By PromCodeInputField = By.id("promoCode");
	By ApplyButton = By.xpath("//button[contains(text(), 'APPLY')]");
	By PromocodeHeplerText = By.id("promoCode-helper-text");

	// Set up paid allowance
	By SetupPaidText = By.xpath("//a[contains(text(), 'setup paid allowances')]");
	By CreditCardDetails = By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-align-items-xs-center'][2]");
	By NextButton = By.xpath("//div[@class='bottom-bar-admin-buttons__div']/a[2]");
	By KeepCurrentTrophyButton = By.xpath("//div[@class='bottom-bar-admin-buttons__div']/a[2]");
	By FinishButton = By.xpath("//div[@class='bottom-bar-admin-buttons__div']/button");
	By LaterButton = By.xpath("//span[contains(text(), 'Later')]");
	By TurnOffPaidAllowanceText = By.xpath("//a[contains(text(), 'Turn off paid allowances')]");
	By TurnOffButton = By.xpath("//span[contains(text(), 'TURN OFF')]");

	public AccountPlanPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement BillingText() {
		return this.driver.findElement(BillingText);
	}

	public WebElement AccountPlanText() {
		return this.driver.findElement(AccountPlanText);
	}

	public WebElement BreadcrumText() {
		return this.driver.findElement(BreadcrumText);
	}

	public WebElement PlanDescriptionText() {
		return this.driver.findElement(PlanDescriptionText);
	}

	public WebElement ChangePlanText() {
		return this.driver.findElement(ChangePlanText);
	}

	public WebElement SelectPlanDropdown() {
		return this.driver.findElement(SelectPlanDropdown);
	}

	public WebElement PlanListOne() {
		return this.driver.findElement(PlanListOne);
	}

	public WebElement PlanListTwo() {
		return this.driver.findElement(PlanListTwo);
	}

	public WebElement PreviewChangesButton() {
		return this.driver.findElement(PreviewChangesButton);
	}

	public WebElement ToastButton() {
		return this.driver.findElement(ToastButton);
	}

	public WebElement headerText() {
		return this.driver.findElement(headerText);
	}

	public WebElement DowngradeBillingSummaryText() {
		return this.driver.findElement(DowngradeBillingSummaryText);
	}

	public WebElement DowngradeButton() {
		return this.driver.findElement(DowngradeButton);
	}

	public WebElement CancelButton() {
		return this.driver.findElement(CancelButton);
	}

	public WebElement AcceptCheckbox() {
		return this.driver.findElement(AcceptCheckbox);
	}

	public WebElement DowngradeToFree() {
		return this.driver.findElement(DowngradeToFree);
	}

	public WebElement KeepPlanButton() {
		return this.driver.findElement(KeepPlanButton);
	}

	public WebElement UpgradeToButton() {
		return this.driver.findElement(UpgradeToButton);
	}

	public WebElement ActivatePlanButton() {
		return this.driver.findElement(ActivatePlanButton);
	}

	public WebElement FreePlanHeaderText() {
		return this.driver.findElement(FreePlanHeaderText);
	}

	public WebElement ChangePaymentText() {
		return this.driver.findElement(ChangePaymentText);
	}

	public WebElement ChangeCardButton() {
		return this.driver.findElement(ChangeCardButton);
	}

	public WebElement UpdateCardButton() {
		return this.driver.findElement(UpdateCardButton);
	}

	public WebElement NevermindButton() {
		return this.driver.findElement(NevermindButton);
	}

	public WebElement CardNameInputField() {
		return this.driver.findElement(CardNameInputField);
	}

	public WebElement IframeCardNumber() {
		return this.driver.findElement(IframeCardNumber);
	}

	public WebElement IframeExpiryDate() {
		return this.driver.findElement(IframeExpiryDate);
	}

	public WebElement IframeCvcNumber() {
		return this.driver.findElement(IframeCvcNumber);
	}

	public WebElement CardNumberInputField() {
		return this.driver.findElement(CardNumberInputField);
	}

	public WebElement CardExpiryDateField() {
		return this.driver.findElement(CardExpiryDateField);
	}

	public WebElement CardCvcField() {
		return this.driver.findElement(CardCvcField);
	}

	public WebElement PromCodeInputField() {
		return this.driver.findElement(PromCodeInputField);
	}

	public WebElement ApplyButton() {
		return this.driver.findElement(ApplyButton);
	}

	public WebElement PromocodeHeplerText() {
		return this.driver.findElement(PromocodeHeplerText);
	}

	public WebElement SetupPaidText() {
		return this.driver.findElement(SetupPaidText);
	}

	public WebElement CreditCardDetails() {
		return this.driver.findElement(CreditCardDetails);
	}

	public WebElement NextButton() {
		return this.driver.findElement(NextButton);
	}

	public WebElement KeepCurrentTrophyButton() {
		return this.driver.findElement(KeepCurrentTrophyButton);
	}

	public WebElement FinishButton() {
		return this.driver.findElement(FinishButton);
	}

	public WebElement LaterButton() {
		return this.driver.findElement(LaterButton);
	}

	public WebElement TurnOffPaidAllowanceText() {
		return this.driver.findElement(TurnOffPaidAllowanceText);
	}

	public WebElement TurnOffButton() {
		return this.driver.findElement(TurnOffButton);
	}

}
