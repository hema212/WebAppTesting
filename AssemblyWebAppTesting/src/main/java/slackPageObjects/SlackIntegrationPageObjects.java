package slackPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SlackIntegrationPageObjects {
	public WebDriver driver;

	By Avatar = By.xpath("//span[@class='username-drop-down__span']");
	By AdminText = By.xpath("//ul[@class='MuiList-root MuiList-padding']/a[1]");
	By SignoutText = By.xpath("//span[contains(text(), 'Sign Out')]");
	By IntegrationsText = By.xpath("//div[contains(text(), 'Integrations')]");
	By GetStartedButton = By.xpath("//div[contains(text(), 'Get Started')]");
	By AllowButton = By.xpath("//button[contains(text(), 'Allow')]");
	By CreateChannelTab = By.xpath("//span[contains(text(), 'Create Channel')]");
	By SelectChannelTab = By.xpath("//span[contains(text(), 'Select Channel')]");
	By CreateChannelInputField = By.xpath("//input[@type='text']");
	By ChannelErrorMessage = By.xpath("//div[@role='tabpanel'][1]/div[2]");
	By ChannelNextButton = By.xpath("//div[contains(text(), 'Next')]");
	By AlertMessage = By.xpath("//div[@role='alert']");
	By ChannelCancelButton = By.xpath("//div[contains(text(), 'Cancel')]");
	By CustomizeCurrencyInput = By.tagName("input");
	By EmptyCustomTrophyError = By.xpath("//fieldset/../../../../div[2]");
	By PluralCustomTrophy = By.xpath("//h3/../div[2]/div[2]/div/div/input");
	By AnnouncementAndDefaultChannelHeader = By.tagName("h2");
	By CustomizeCurrencyHeader = By.tagName("h3");
	By AssemblySetUpHeader = By.tagName("h2");
	By HeadToMyFeed = By.xpath("//div[contains(text(), 'Head to my feed')]");
	By QuickSettingsArrowDropDown = By.xpath("//span[@data-cy='arrow-dropdown']");

	By FinishSetUpButton = By.xpath("//div[contains(text(), 'Finish Setup')]");
	By SelectChannelDropDown = By.tagName("input");

	By NoAnnouncementRadioButton = By.xpath("//div[@role='radiogroup']/label[2]/span[1]");
	By SeeWelcomeMessageText = By.xpath("//div[@classes]");

	By SaveChanges = By.xpath("//div[contains(text(), 'Save Changes')]");

	public SlackIntegrationPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement AvatarIcon() {
		return this.driver.findElement(Avatar);
	}

	public WebElement AdminText() {
		return this.driver.findElement(AdminText);
	}

	public WebElement SignoutText() {
		return this.driver.findElement(SignoutText);
	}

	public WebElement IntegrationsText() {
		return this.driver.findElement(IntegrationsText);
	}

	public WebElement GetStartedButton() {
		return this.driver.findElement(GetStartedButton);
	}

	public WebElement AllowButton() {
		return this.driver.findElement(AllowButton);
	}

	public WebElement CreateChannelTab() {
		return this.driver.findElement(CreateChannelTab);
	}

	public WebElement SelectChannelTab() {
		return this.driver.findElement(SelectChannelTab);
	}

	public WebElement CreateChannelInputField() {
		return this.driver.findElement(CreateChannelInputField);
	}

	public WebElement ChannelErrorMessage() {
		return this.driver.findElement(ChannelErrorMessage);
	}

	public WebElement ChannelNextButton() {
		return this.driver.findElement(ChannelNextButton);
	}

	public WebElement AlertMessage() {
		return this.driver.findElement(AlertMessage);
	}

	public WebElement ChannelCancelButton() {
		return this.driver.findElement(ChannelCancelButton);
	}

	public WebElement CustomizeCurrencyInput() {
		return this.driver.findElement(CustomizeCurrencyInput);
	}

	public WebElement EmptyCustomTrophyError() {
		return this.driver.findElement(EmptyCustomTrophyError);
	}

	public WebElement PluralCustomTrophy() {
		return this.driver.findElement(PluralCustomTrophy);
	}

	public WebElement AnnouncementAndDefaultChannelHeader() {
		return this.driver.findElement(AnnouncementAndDefaultChannelHeader);
	}

	public WebElement CustomizeCurrencyHeader() {
		return this.driver.findElement(CustomizeCurrencyHeader);
	}

	public WebElement AssemblySetUpHeader() {
		return this.driver.findElement(AssemblySetUpHeader);
	}

	public WebElement HeadToMyFeed() {
		return this.driver.findElement(HeadToMyFeed);
	}

	public WebElement QuickSettingsArrowDropDown() {
		return this.driver.findElement(QuickSettingsArrowDropDown);
	}

	public WebElement FinishSetUpButton() {
		return this.driver.findElement(FinishSetUpButton);
	}

	public WebElement SelectChannelDropDown() {
		return this.driver.findElement(SelectChannelDropDown);
	}

	public WebElement NoAnnouncementRadioButton() {
		return this.driver.findElement(NoAnnouncementRadioButton);
	}

	public WebElement SeeWelcomeMessageText() {
		return this.driver.findElement(SeeWelcomeMessageText);
	}

	public WebElement SaveChanges() {
		return this.driver.findElement(SaveChanges);
	}
}
