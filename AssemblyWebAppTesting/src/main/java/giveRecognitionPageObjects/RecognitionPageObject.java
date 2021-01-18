package giveRecognitionPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecognitionPageObject {

	public WebDriver driver;

	// sounds good button
	By closePopUp = By.xpath("//button[@onclick='closePopup()']");

	// Left side 1st half Xpaths for giving recognition
	By searchForCoWorkerField = By.id("integration-downshift-multiple");
	By noOneJoinedText = By.xpath("//div[@class='jss513 justify-content-between align-items-center']/div");
	By giveRecognitionText = By.xpath("//div[@class='MuiTabs-flexContainer MuiTabs-centered']/button/span");
	By getUserChip = By.xpath("//div[@role='button']/span[@class='MuiChip-label jss115']");
	By sendInvitesButton = By.xpath("//span[contains(text(), 'SEND INVITES')]");
	By dropdownMemberList = By.xpath("//div[@class='MuiPaper-root jss111 MuiPaper-elevation1']/li");
	By getTextNoTrophies = By.xpath("//div[@class='MuiFormControl-root jss130']/div");
	By giveRecognitionButton = By.xpath("//div[@class='gc-button__div shoutout-give-button']/button");
	By addTrophiesDropdown = By.id("mui-component-select-impactValue");
	By disabledDropdownTextOnHover = By.xpath("//div[@class='MuiFormControl-root jss130']/div");
	By addThirtyThropies = By.xpath("//ul[@role='listbox']/div[4]");
	By addTwentyThropies = By.xpath("//ul[@role='listbox']/div[2]");
	By addTenTrophies = By.xpath("//ul[@role='listbox']/div[1]");
	By enterCustomTrophy = By.xpath("//div[contains(text(), '+ Enter a custom amount')]");
	By giveUptoTrophyText = By.xpath("//input[@placeholder='Enter custom amount...']/following-sibling::p");
	By customAmountTextField = By.xpath("//input[@placeholder='Enter custom amount...']");
	By enterbutton = By.xpath("//span[contains(text(), 'Enter')]");
	By customTrophyTitle = By.tagName("h5");
	By addMessage = By.xpath("//div[@class='DraftEditor-editorContainer']/div");
	By addbadge = By.xpath("//button[@aria-label='Add Badge']");
	By addEmoji = By.xpath("//button[@aria-label='Add Emoji']");
	By selectThumbsupEmoji = By.xpath("//ul[@class='emoji-mart-category-list']/li");
	By addImage = By.xpath("//input[@type='file']");
	By allowUploadImage = By.xpath("//span[contains(text(), 'Done')]");
	By addGif = By.xpath("//button[@aria-label='Add Gif']");
	By enterTextInGif = By.xpath("//input[@placeholder='Search GIFs']");
	By selectGif = By.xpath("//div[@role='listbox']/div[1]");
	By selectIdeaMakerBadge = By.xpath("//div[contains(text(), 'Idea Maker')]");
	By successToast = By.xpath("//span[@id='client-snackbar']");
	By feedCarrotTime = By.xpath("//span[@class='feed-carrot-time']");
	By messageFeed = By.xpath("//div[@class='feed-card-message']");

	// Left side 2nd half Xpaths for giving recognition
	By likeButton = By.xpath("//div[@class='feed-action__div']/div/div[1]/div[1]");
	By likeCount = By.xpath("//div[@class='users-list-container__div']");
	By commentIconButton = By.xpath("//div[@class='feed-action__div']/div/div[1]/div[2]");
	By enterComments = By.xpath("//div[@class='col-md-11']/div[1]/div/div[2]/div");
	By postComment = By.xpath("//span[contains(text(), 'POST')]");
	By deletePostThreedots = By.xpath("//span[@class='MuiButtonBase-root MuiIconButton-root']");
	By deletePostFromPage = By.xpath("//li[contains(text(), 'Delete Post')]");
	By selectDropDownToHandleTrophies = By.xpath("//div[@id='standard-full-width']");
	By selectGiveBackTrophiesToSender = By.xpath("//li[1]");
	By allowReceiverToKeepTrophies = By.xpath("//li[2]");
	By deleteCommentOrPost = By.xpath("//span[contains(text(), 'Delete')]");
	By cancelDeletingPost = By.xpath("//span[contains(text(), 'Cancel')]");
	By removeImageOrGifList = By.xpath("//div[@class='jss74']/li[1]");
	By captutreAlertText = By.id("alert-title");
	By cancelRemovingImageOrGif = By.xpath("//span[contains(text(), 'Cancel')]");
	By removeImageOrGif = By.xpath("//span[contains(text(), 'Remove')]");
	By checkImageIsdisplayed = By.xpath("//div[@class='feed-image__div']/img");
	By checkGifIsDisplayed = By.xpath("//div[@class='feed-media__div']/img");
	By deleteCommentThreedots = By.xpath("//div[@class='comment-action__div']/div/div[2]/span");
	By deleteComment = By.xpath("//li[contains(text(), 'Delete Comment')]");
	By commentDropdownSelectTrophies = By.xpath("//span[@role='menuitem']");
	By commentDropdown = By.xpath("//div[@class='gc-drop-div']/div");
	By commentThreeDots = By.xpath("//div[@class='comment-action__div']/div/div[2]");
// By scrollRightSideContent = By.xpath("//div[@class='MuiCollapse-wrapper']");

	// Right side Xpaths for trophy count
	By givingAllowanceTab = By.xpath("//span[contains(text(), 'Giving Allowance')]");
	By earnedBalanceTab = By.xpath("//span[contains(text(), 'Earned Balance')]");
	By givingCarrotBalance = By.xpath("//div[@class='redeem__div']/div[1]/div[1]");
	By earnedCarrotBalance = By.xpath("//div[@class='redeem__div']/div/div");
	By refreshesOnDate = By.xpath("//div[@class='redeem__div']/div[2]/div[2]");
	By topReceiverTrophyHolderName = By
			.xpath("//div[@class='top-receivers-name__div top-receivers-name-clickable__div']");
	By topReceiverTrophyCount = By.xpath("//div[@class='top-receivers-carrots-text__div ']");
	By topBadgeName = By.xpath("top-receivers-name__div ");
	By topBadgeCount = By.xpath("//div[@class='top-receivers-carrots-text__div top-receivers-carrots']");

	public RecognitionPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement closePopUp() {
		return this.driver.findElement(closePopUp);
	}

	public WebElement getSearchCoworker() {
		return this.driver.findElement(searchForCoWorkerField);
	}

	public WebElement getNoOneJoinedText() {
		return this.driver.findElement(noOneJoinedText);
	}

	public WebElement getUserChip() {
		return this.driver.findElement(getUserChip);
	}

	public WebElement getSendInviteButtonText() {
		return this.driver.findElement(sendInvitesButton);
	}

	public WebElement getTextNoTrophies() {
		return this.driver.findElement(getTextNoTrophies);
	}

	public List<WebElement> getdropdownMemberList() {
		return this.driver.findElements(dropdownMemberList);
	}

	public WebElement disabledDropdownTextOnHover() {
		return this.driver.findElement(disabledDropdownTextOnHover);
	}

	public WebElement getGiveRecognitionButton() {
		return this.driver.findElement(giveRecognitionButton);
	}

	public WebElement getAddTrophiesDropdown() {
		return this.driver.findElement(addTrophiesDropdown);
	}

	public WebElement getAddThirtyThropies() {
		return this.driver.findElement(addThirtyThropies);
	}

	public WebElement getAddTenTrophies() {
		return this.driver.findElement(addTenTrophies);
	}

	public WebElement getAddTwentyThropies() {
		return this.driver.findElement(addTwentyThropies);
	}

	public WebElement enterCustomTrophy() {
		return this.driver.findElement(enterCustomTrophy);
	}

	public WebElement customTrophyTitle() {
		return this.driver.findElement(customTrophyTitle);
	}

	public WebElement giveUptoTrophyText() {
		return this.driver.findElement(giveUptoTrophyText);
	}

	public WebElement customAmountTextField() {
		return this.driver.findElement(customAmountTextField);
	}

	public WebElement enterbutton() {
		return this.driver.findElement(enterbutton);
	}

	public WebElement giveRecognitionText() {
		return this.driver.findElement(giveRecognitionText);
	}

	public WebElement addMessage() {
		return this.driver.findElement(addMessage);
	}

	public WebElement getAddbadge() {
		return this.driver.findElement(addbadge);
	}

	public WebElement getAddEmoji() {
		return this.driver.findElement(addEmoji);
	}

	public WebElement getAddImage() {
		return this.driver.findElement(addImage);
	}

	public WebElement getAddGif() {
		return this.driver.findElement(addGif);
	}

	public WebElement getIdeaMakerBadge() {
		return this.driver.findElement(selectIdeaMakerBadge);
	}

	public WebElement getSuccessSendRecognitionToast() {
		return this.driver.findElement(successToast);
	}

	public WebElement feedCarrotTime() {
		return this.driver.findElement(feedCarrotTime);
	}

	public WebElement messageFeed() {
		return this.driver.findElement(messageFeed);
	}

	public WebElement allowUploadImage() {
		return this.driver.findElement(allowUploadImage);
	}

	public WebElement selectThumbsupEmoji() {
		return this.driver.findElement(selectThumbsupEmoji);
	}

	public WebElement enterTextInGif() {
		return this.driver.findElement(enterTextInGif);
	}

	public WebElement selectGif() {
		return this.driver.findElement(selectGif);
	}

	public WebElement likeButton() {
		return this.driver.findElement(likeButton);
	}

	public WebElement likeCount() {
		return this.driver.findElement(likeCount);
	}

	public WebElement commentIconButton() {
		return this.driver.findElement(commentIconButton);
	}

	public WebElement enterComments() {
		return this.driver.findElement(enterComments);
	}

	public WebElement postComment() {
		return this.driver.findElement(postComment);
	}

	public WebElement deletePostThreedots() {
		return this.driver.findElement(deletePostThreedots);
	}

	public WebElement deletePostFromPage() {
		return this.driver.findElement(deletePostFromPage);
	}

	public WebElement selectDropDownToHandleTrophies() {
		return this.driver.findElement(selectDropDownToHandleTrophies);
	}

	public WebElement selectGiveBackTrophiesToSender() {
		return this.driver.findElement(selectGiveBackTrophiesToSender);
	}

	public WebElement deleteCommentOrPost() {
		return this.driver.findElement(deleteCommentOrPost);
	}

	public WebElement cancelDeletingPost() {
		return this.driver.findElement(cancelDeletingPost);
	}

	public WebElement allowReceiverToKeepTrophies() {
		return this.driver.findElement(allowReceiverToKeepTrophies);
	}

	public WebElement removeImageOrGifList() {
		return this.driver.findElement(removeImageOrGifList);
	}

	public WebElement getCaptutreAlertText() {
		return this.driver.findElement(captutreAlertText);
	}

	public WebElement cancelRemovingImageOrGif() {
		return this.driver.findElement(cancelRemovingImageOrGif);
	}

	public WebElement removeImageOrGif() {
		return this.driver.findElement(removeImageOrGif);
	}

	public WebElement checkImageIsdisplayed() {
		return this.driver.findElement(checkImageIsdisplayed);
	}

	public WebElement checkGifIsDisplayed() {
		return this.driver.findElement(checkGifIsDisplayed);
	}

	public WebElement deleteCommentThreedots() {
		return this.driver.findElement(deleteCommentThreedots);
	}

	public WebElement deleteComment() {
		return this.driver.findElement(deleteComment);
	}

	public WebElement commentDropdown() {
		return this.driver.findElement(commentDropdown);
	}

	public WebElement commentDropdownSelectTrophies() {
		return this.driver.findElement(commentDropdownSelectTrophies);
	}

	public WebElement commentThreeDots() {
		return this.driver.findElement(commentThreeDots);
	}

	// Right side content
	public WebElement givingAllowanceTabClick() {
		return this.driver.findElement(givingAllowanceTab);
	}

	public WebElement earnedBalanceTabClick() {
		return this.driver.findElement(earnedBalanceTab);
	}

	public WebElement givingCarrotBalance() {
		return this.driver.findElement(givingCarrotBalance);
	}

	public WebElement earnedCarrotBalance() {
		return this.driver.findElement(earnedCarrotBalance);
	}

	public WebElement refreshesOnDate() {
		return this.driver.findElement(refreshesOnDate);
	}

	public WebElement topReceiverTrophyHolderName() {
		return this.driver.findElement(topReceiverTrophyHolderName);
	}

	public WebElement topReceiverTrophyCount() {
		return this.driver.findElement(topReceiverTrophyCount);
	}

	public WebElement topBadgeName() {
		return this.driver.findElement(topBadgeName);
	}

	public WebElement topBadgeCount() {
		return this.driver.findElement(topBadgeCount);
	}
}
