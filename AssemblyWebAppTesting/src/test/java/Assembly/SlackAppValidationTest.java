package Assembly;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import giveRecognitionPageObjects.RecognitionPageObject;
import giveRecognitionPageObjects.loginPageObjects;
import resources.InitiateDriver;
import signInViaEmail.SlackSignInViaEmail;
import slackPageObjects.SlackIdentityObjects;

public class SlackAppValidationTest extends SlackSignInViaEmail {
	public WebDriver driver;
	public SlackIdentityObjects slackobject;
	public RecognitionPageObject recogobject;

	@BeforeClass
	public void init() throws FileNotFoundException, IOException {
		driver = initializeDriver();
		slackobject = new SlackIdentityObjects(driver);
		recogobject = new RecognitionPageObject(driver);
	}

	// validate Manage landing page when slack is not connected
	@Test(priority = 1)
	public void managePageSetup() throws InterruptedException {
		Thread.sleep(2000L);
		String giveRecogText = recogobject.giveRecognitionText().getText();
		System.out.println("The home page text is" + giveRecogText);
		Thread.sleep(1000L);
		Boolean value = recogobject.giveRecognitionText().isDisplayed();
		System.out.println("Boolean value is" + value);
		System.out.println("Is give recognition text displayed?" + giveRecogText);
		Thread.sleep(1000L);
		System.out.println("Is Avatar icon displayed?" + slackobject.avatarIcon().isDisplayed());
		Thread.sleep(1000L);
		selectManageSideNavbar();
		// validateManagePageAssertion();
		// System.out.println("Testcase-1 passed since application landed on Manage page
		// and
		// Assertion passed");
	}

	// validate Cancel button click on cancel
	@Test(priority = 2)
	public void validateCancelButtonOnClick() throws InterruptedException {
		slackIconPagevalidateOnClick();
		closeBotFunc();

		validateConnectPageAssertion();
		System.out.println("Is cancel button Enabled in Connect page? " + slackobject.CancelButton().isEnabled());
		System.out.println(
				"Is Connect Slack button Enabled in Connect page? " + slackobject.ConnectSlackButton().isEnabled());
		cancelButtonClickvalidate();
		validateManagePageAssertion();
		System.out.println(
				"Testcase-2 passed since application landed on Manage page and Assertion passed after clicked on Cancel button in Connect page");

	}

	// validate connecting to slack and disconnecting on click of cancel button and
	// click on sure button

	@Test(priority = 3)
	public void connectSlackOnCancel() throws InterruptedException {
		slackIconPagevalidateOnClick();
		slackobject.ConnectSlackButton().click();
		validateSignInSlackAppAssertion();
		slackWorkspaceFlow();
		nevermindButtonvalidate();
		System.out.println("User has clicked on Nevermind button");
		Thread.sleep(1000L); // validateSelectPeopleAssertion();
		sureButtonClickvalidate();
		System.out.println("User has clicked on Sure button");
		Thread.sleep(1000L);
		System.out.println("Testcase-3 passed since application connected to slack by entering details and"
				+ " disonnected on click of I'm sure button after cancel button clicked");
	}

	// validate Queued invites flow when selected I'll send them later

	@Test(priority = 4)
	public void validateQueuedInvitesFlow() throws InterruptedException {
		slackIconPagevalidateOnClick();
		slackobject.ConnectSlackButton().click();
		validateSlackAppActualHeaderAssertion();
		Thread.sleep(3000L);
		slackobject.AllowButton().click();
		Thread.sleep(4000L);
		validateSelectPeopleAssertion();
		System.out.println("Selected Everyone radio button option which is default when user lands");
		Thread.sleep(3000L);
		slackobject.ContinueWithEveryoneButton().click();
		validateConfigureInvitesAssertion();
		slackobject.SendThemLaterRadio().click();
		Thread.sleep(1000L);
		System.out.println("Selected I'll send them later and admin approval Radio button option");
		slackobject.CreateAssemblyAccountsButton().click();

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'View')]")));
		validateCreateAccountAssertion();
		System.out.println("Testcase-4 passed since application clicked on I'll send them later button");
	}

	// validate Queued invites flow on click of View Queued Invites Button

	@Test(priority = 5)
	public void validateQueuedInvitesFlowOnView() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Disconnect Slack')]")));
		Thread.sleep(9000L);
		disconnectIdentityManagementOnKeepIt();
		System.out.println("User has click on 'No, Keep it button in Create Accounts page");
		validateCreateAccountAssertion();
		System.out.println(
				"View Queued Invites button is displayed? " + slackobject.viewPeopleInviteButton().isEnabled());
		System.out.println(
				"Testcase-4 passed since Queued Invites flow is selected on choosing send them" + " later button");
		slackobject.viewPeopleInviteButton().click();
		System.out.println("Testcase-5 passed since application landed on Invites Page On Queued invite");

	}

	// Verify user lands on Invites page and does bulk delete operation

	@Test(priority = 6)
	public void DeleteUsersFromQueuedInvites() throws InterruptedException {
		Thread.sleep(2000L);
		slackobject.InviteText().click();
		String breadcrum = slackobject.InvitesBreadcrum().getText();
		Assert.assertEquals(breadcrum, "> Invites");
		slackobject.SelectAllCheckBox().click();
		slackobject.DeleteButton().click();
		deleteQueuedInvitesModalAssertion();
		Thread.sleep(1000L);
		slackobject.ImSureButton().click();
		System.out.println("The success toast message after deleting users from queued invites is:"
				+ slackobject.successToast().getText());
		Thread.sleep(1000L);
		slackobject.ManageText().click();
		String activeMembers = slackobject.ActiveMembersCount().getText();
		Assert.assertEquals(activeMembers, "1 members active");
		System.out.println("Testcase-6 passed since only owner is present in Assembly");

	}

	// Function to validate landing page of Manage
	public void selectManageSideNavbar() throws InterruptedException {
		System.out.println("Selecting manage side nav-bar");
		Thread.sleep(1000L);
		slackobject.avatarIcon().click();
		System.out.println("Selecting manage side nav-bar");
		System.out.println("Clicked on avatar icon");
		slackobject.AdminText().click();
		Thread.sleep(1000L);
		slackobject.UsersText().click();
		Thread.sleep(1000L);
		slackobject.ManageText().click();
		System.out.println("Clicked on manage text");
		Thread.sleep(1000L);
	}

	// Function to validate Cancel button on all pages
	public void cancelButtonClickvalidate() throws InterruptedException {
		slackobject.CancelButton().click();
		Thread.sleep(1000L);
		validateManagePageAssertion();
	}

	// Function to validate 'I'm sure' on click of cancel button
	public void sureButtonClickvalidate() throws InterruptedException {
		slackobject.CancelButton().click();
		Thread.sleep(1000L);
		validateCancelModalHeaderAssertion();
		slackobject.ImSureButton().click();
		Thread.sleep(1000L);
		validateManagePageAssertion();
	}

	// Function to validate 'Nevermind' on click of cancel button
	public void nevermindButtonvalidate() throws InterruptedException {
		Thread.sleep(5000L);
		slackobject.CancelButton().click();
		Thread.sleep(2000L);
		validateCancelModalHeaderAssertion();
		slackobject.NevermindButton().click();
		validateSelectPeopleAssertion();

	}

	// Function to validate Slack first page - Setup/Connect
	public void slackIconPagevalidateOnClick() throws InterruptedException {
		slackobject.SlackIdentityIcon().click();
		Thread.sleep(2000L);
		String actualFirstStepText = slackobject.SetupStepText().getText();
		System.out.println("Set up text is ===> " + actualFirstStepText);
		Assert.assertEquals(actualFirstStepText, "Set up Slack as your identity provider");
		validateConnectPageAssertion();
	}

	public void closeBotFunc() throws InterruptedException {
		Thread.sleep(1000L);
		this.driver.switchTo().frame(slackobject.LiveChatIframe());
		slackobject.LiveChatButton().click();
		Thread.sleep(1000L);
		slackobject.CloseIntercomLive().click();
		driver.switchTo().defaultContent();
	}

	// Function to validate Disconnect slack
	public void disconnectIdentityManagementOnKeepIt() throws InterruptedException {
		slackobject.DisconnectSlackButton().click();
		validateDisconnectSlackModalAssertion();
		slackobject.NokeepItIM().click();
	}

	// Function to validate Disconnect slack
	public void disconnectIdentityManagementOnYes() throws InterruptedException {
		slackobject.DisconnectSlackButton().click();
		validateDisconnectSlackModalAssertion();
		slackobject.YesDisconnectIM().click();
	}

	// Assertion Validation
	// validate Sign in to workspace landing page
	public void validateSignInSlackAppAssertion() {
		String SlackSignInWorkspaceText = slackobject.SlackSignInWorkspaceText().getText();
		System.out.println(SlackSignInWorkspaceText);
		Assert.assertEquals(SlackSignInWorkspaceText, "Sign in to your workspace");
	}

	// validate Slack App Actual header
	public void validateSlackAppActualHeaderAssertion() {
		String SlackActualHeader = slackobject.SlackSigninHeaderText().getText();
		Assert.assertEquals(SlackActualHeader,
				"Assembly v2 Dev is requesting permission to access the Joinassembly+21 Slack workspace");
	}

	// validate Manage landing page when slack is not connected
	public void validateManagePageAssertion() throws InterruptedException {
		Thread.sleep(2000L);
		String managePageLandingText = slackobject.ConnectIdentityText().getText();
		System.out.println("the text is " + managePageLandingText);
		Assert.assertEquals(managePageLandingText, "Connect your identity provider");
	}

	// validate Manage landing page when slack is connected
	public void validateManageSlackConnectedAssertion() throws InterruptedException {
		Thread.sleep(2000L);
		String managePageLandingText = slackobject.QuickSettingsText().getText();
		System.out.println("the text is " + managePageLandingText);
		Assert.assertEquals(managePageLandingText, "Quick Settings");
	}

	// validate Step1 content for Slack Connect
	public void validateConnectPageAssertion() {
		String stepCountText = slackobject.StepCount().getText();
		System.out.println("Step count is ===> " + stepCountText);
		Assert.assertEquals(stepCountText, "Step 1 of 4");
	}

	// validate Step2 content for Slack Select People
	public void validateSelectPeopleAssertion() {
		String stepCountText = slackobject.StepCount().getText();
		System.out.println("Step count is ===> " + stepCountText);
		Assert.assertEquals(stepCountText, "Step 2 of 4");
	}

	// validate Step3 content for Slack Configure Invites
	public void validateConfigureInvitesAssertion() {
		String stepCountText = slackobject.StepCount().getText();
		System.out.println("Step count is ===> " + stepCountText);
		Assert.assertEquals(stepCountText, "Step 3 of 4");
	}

	// validate Step2 content for Slack Assembly Accounts
	public void validateCreateAccountAssertion() {
		String stepCountText = slackobject.StepCount().getText();
		System.out.println("Step count is ===> " + stepCountText);
		Assert.assertEquals(stepCountText, "Step 4 of 4");
	}

	// validate Cancel modal header content
	public void validateCancelModalHeaderAssertion() {
		String actualCancelHeaderModalText = slackobject.CancelModalHeader().getText();
		System.out.println("The header of Cancel modal is  " + actualCancelHeaderModalText);
		Assert.assertEquals(actualCancelHeaderModalText, "Are you sure you want to cancel Slack setup?");
	}

	// validate Disconnect Slack modal header content
	public void validateDisconnectSlackModalAssertion() {
		String disconnectSlackModalHeader = slackobject.DisconnectSlackModalHeader().getText();
		System.out.println(disconnectSlackModalHeader);
		Assert.assertEquals(disconnectSlackModalHeader, "Disconnect Slack?");
	}

	// validate Sign in with slack flow
	public void signInWithSSOFunction() throws InterruptedException {
		slackobject.SignInWithSlackSSOClick().click();
		slackobject.SlackInputField().sendKeys("joinassembly21");
		slackobject.SlackContinueSubmitButton().click();
		slackobject.SlackEmailInputField().sendKeys("hema+21@joinassembly.com");
		slackobject.slackPwdInputField().sendKeys("Assembly2020!");
		slackobject.slackSignInButton().click();
		validateSlackAppActualHeaderAssertion();
		Thread.sleep(7000L);
		slackobject.AllowButton().click();
	}

	// Delete modal assertion validation
	public void deleteQueuedInvitesModalAssertion() throws InterruptedException {
		Thread.sleep(1000L);
		String deleteModalHeader = slackobject.DeleteModalHeader().getText();
		Assert.assertEquals(deleteModalHeader, "Are you sure you want to delete all queued members?");
	}

	// disconnect slack using Quick settings
	public void disconnectSlackThroughQuickSettings() throws InterruptedException {
		slackobject.QuickSettingsText().click();
		System.out
				.println("The state of Save settings before change is " + slackobject.SaveSettingsButton().isEnabled());
		slackobject.AdminApproveRadio().click();
		System.out
				.println("The state of Save settings after change is " + slackobject.SaveSettingsButton().isEnabled());
		slackobject.CloseButton().click();
		slackobject.QuickSettingsText().click();
		slackobject.SaveSettingsButton().click();
		disconnectIdentityManagementOnYes();
		System.out.println("Testcase-6 passed since slack is disconnected from settings");
	}

	// validate valid card details card
	public void validateCardValidDetails() throws InterruptedException {
		slackobject.CardNameInputField().sendKeys("abc");
		Thread.sleep(2000L);
		this.driver.switchTo().frame(slackobject.IframeCardNumber());
		slackobject.CardNumberInputField().sendKeys("4242424242424242");
		driver.switchTo().defaultContent();
		this.driver.switchTo().frame(slackobject.IframeExpiryDate());
		slackobject.CardExpiryDateField().sendKeys("1222");
		driver.switchTo().defaultContent();
		this.driver.switchTo().frame(slackobject.IframeCvcNumber());
		slackobject.CardCvcField().sendKeys("123");
		Thread.sleep(1000L);
		driver.switchTo().defaultContent();
		Thread.sleep(3000L);
		slackobject.ApplyButton().click();
		if (slackobject.SetUpAlertMessage().getText() == "Please enter Promo Code") {
			slackobject.PromCodeInputField().sendKeys("100OFF");
			slackobject.ApplyButton().click();
			Boolean successToast = slackobject.successToast().isDisplayed();
			System.out.println("Is promo applied successfully " + successToast);
		}
		slackobject.SetUpPaymentNextButton().click();
		slackobject.ReviewBillConfirm().click();
		slackobject.ContinueWithEveryoneButton().click();
		slackobject.SendInvitationsNowRadio().click();
		slackobject.CreateAssemblyAccountsButton().click();
		slackobject.viewPeopleInviteButton().click();

	}

	// validate quick settings flow
	public void validateQuickSettingsSlackFunction() {
		slackobject.QuickSettingsText().click();
		Boolean saveSettingsActive = slackobject.SaveSettingsButton().isEnabled();
		System.out.println(saveSettingsActive);
		if (saveSettingsActive == true) {
			System.out.println("The Save Settings button is disabled");
		} else {
			slackobject.AdminApproveRadio().click();
			slackobject.SaveSettingsButton().click();
			slackobject.CloseButton().click();

		}

	}

	// validate slackapp connection flow
	public void slackWorkspaceFlow() throws InterruptedException {
		slackobject.SlackInputField().sendKeys("joinassembly21");
		slackobject.SlackContinueSubmitButton().click();
		slackobject.SlackEmailInputField().sendKeys("hema+21@joinassembly.com");
		slackobject.slackPwdInputField().sendKeys("Assembly2020!");
		slackobject.slackSignInButton().click();
		validateSlackAppActualHeaderAssertion();
		Thread.sleep(4000L);
		slackobject.AllowButton().click();

	}

	@AfterClass
	public void finish() {
		driver.manage().deleteAllCookies();
		// driver.quit();
	}

}
