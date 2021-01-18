package slackPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SlackAppPageObjects {
	public WebDriver driver;

	By launchSlackButton = By.id("nav_work_btn");
	By joinAssembly21Text = By.xpath("//span[contains(text(), 'Joinassembly+21')]");
	By inputTextField = By.xpath("//div[@data-qa='message_input']/div[@spellcheck='true']");
	By inputTextEnterButton = By.xpath("//div[@data-qa='message_input']");
	By sendButton = By.xpath("//button[@aria-label='Send message']");
	By continueWithoutAuthorizationButton = By.xpath("//span[contains(text(), 'Continue without authorization')]");
	By selectTeamMember = By.xpath("//input[@placeholder='Give to one or more team members']");
	By recogSentHeader = By.xpath("//div[@data-qa='wizard_modal_header']/h1/div/div/span[1]");
	By closeButton = By.xpath("//span[contains(text(), 'Close')]");
	By timeStamp = By.xpath("//span[@class='c-timestamp__label']");
	By amountDropdown = By.xpath("//div[@class='c-select_input__content']");
	By customAmountText = By.xpath("//span[contains(text(), 'Enter custom')]");
	By customInputField = By.xpath("//input[@name='SHOUTOUT_MODAL_CUSTOM_AMOUNT_INPUT']");
	By messageInputField = By.xpath("//textarea[@placeholder='Write a meaningful message']");
	By coreValueDropdown = By.xpath("//div[@data-qa='SHOUTOUT_MESSAGE_SELECT_CORE_VALUE-input-content']");
	By empathyTextSelect = By.xpath("//span[contains(text(), 'We Are Empathetic')]");
	By giveRecognitionButton = By.xpath("//button[@data-qa='wizard_modal_next']");
	By AlertText = By.xpath("//span[@class='c-inline_alert__text']/span");

	// add user xpaths
	By addUser = By.xpath("//i[@type='add-user']");
	By addUserIframe = By.xpath("//iframe[@id='gantry-auth']");
	By addUserEmailInputField = By.xpath("//input[@id='channel_invite_modal_select']");
	By addButton = By.xpath("//button[contains(text(), 'Add')]");
	By FinishedButton = By.xpath("//button[contains(text(), 'Finished')]");

	// remove user xpaths
	By viewAllMemberButton = By.xpath("//span[@class='p-avatar_stack']/button");
	By removeVijayButton = By.xpath(
			"//div[@class='c-virtual_list__item'][3]/div[@class='p-members_dialog_item']/button[contains(text(), 'Remove')]");
	By removeModalHeader = By.xpath("//h1[@class='c-dialog__title overflow_ellipsis']");
	By yesRemoveButton = By.xpath("//button[contains(text(), 'Yes, remove them')]");

	public SlackAppPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement launchSlackButton() {
		return this.driver.findElement(launchSlackButton);
	}

	public WebElement joinAssembly21Text() {
		return this.driver.findElement(joinAssembly21Text);
	}

	public WebElement inputTextField() {
		return this.driver.findElement(inputTextField);
	}

	public WebElement inputTextEnterButton() {
		return this.driver.findElement(inputTextEnterButton);
	}

	public WebElement sendButton() {
		return this.driver.findElement(sendButton);
	}

	public WebElement continueWithoutAuthorizationButton() {
		return this.driver.findElement(continueWithoutAuthorizationButton);
	}

	public WebElement selectTeamMember() {
		return this.driver.findElement(selectTeamMember);
	}

	public WebElement recogSentHeader() {
		return this.driver.findElement(recogSentHeader);
	}

	public WebElement closeButton() {
		return this.driver.findElement(closeButton);
	}

	public List<WebElement> timeStamp() {
		return this.driver.findElements(timeStamp);
	}

	public WebElement amountDropdown() {
		return this.driver.findElement(amountDropdown);
	}

	public WebElement customAmountText() {
		return this.driver.findElement(customAmountText);
	}

	public WebElement customInputField() {
		return this.driver.findElement(customInputField);
	}

	public WebElement messageInputField() {
		return this.driver.findElement(messageInputField);
	}

	public WebElement coreValueDropdown() {
		return this.driver.findElement(coreValueDropdown);
	}

	public WebElement empathyTextSelect() {
		return this.driver.findElement(empathyTextSelect);
	}

	public WebElement giveRecognitionButton() {
		return this.driver.findElement(giveRecognitionButton);
	}

	public WebElement AlertText() {
		return this.driver.findElement(AlertText);
	}

	public WebElement addUser() {
		return this.driver.findElement(addUser);
	}

	public WebElement addUserIframe() {
		return this.driver.findElement(addUserIframe);
	}

	public WebElement addUserEmailInputField() {
		return this.driver.findElement(addUserEmailInputField);
	}

	public WebElement addButton() {
		return this.driver.findElement(addButton);
	}

	public WebElement FinishedButton() {
		return this.driver.findElement(FinishedButton);
	}

	public WebElement viewAllMemberButton() {
		return this.driver.findElement(viewAllMemberButton);
	}

	public WebElement removeVijayButton() {
		return this.driver.findElement(removeVijayButton);
	}

	public WebElement removeModalHeader() {
		return this.driver.findElement(removeModalHeader);
	}

	public WebElement yesRemoveButton() {
		return this.driver.findElement(yesRemoveButton);
	}
}
