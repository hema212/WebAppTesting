package giveRecognitionPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvitesPageObject {
	public WebDriver driver;

	By bulkIconXpath = By.xpath("//button[@aria-label='Bulk Invite']");
	By inviteTeamText = By.tagName("h5");
	By inviteeEmailField = By.id("fullName");
	By invalidEmailErrorMessage = By.xpath("//label[@for='fullName']");
	By sendButton = By.xpath("//span[contains(text(), 'Send')]");
	By cancelButton = By.xpath("//span[contains(text(), 'Cancel')]");

	public InvitesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBulkIconXpath() {
		return this.driver.findElement(bulkIconXpath);
	}

	public WebElement getInviteTeamText() {
		return this.driver.findElement(inviteTeamText);
	}

	public WebElement getInviteeEmailField() {
		return this.driver.findElement(inviteeEmailField);
	}

	public WebElement getInvalidEmailErrorMessage() {
		return this.driver.findElement(invalidEmailErrorMessage);
	}

	public WebElement getSendButton() {
		return this.driver.findElement(sendButton);
	}

	public WebElement getCancelButton() {
		return this.driver.findElement(cancelButton);
	}

}
