package slackTestSuite;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import accountSignInWhenIMConnected.SlackSignInWhenConnected;
import slackPageObjects.SlackIdentityObjects;

//Execute this Third(3rd) when Slack is not connected and account has free plan
public class SlackIdentityUpgradeViewFlowTest extends SlackSignInWhenConnected {
	public static Logger log = LogManager.getLogger(SlackIdentityUpgradeViewFlowTest.class.getName());
	public SlackIdentityObjects slackobject;

	@BeforeClass
	public void init() throws FileNotFoundException, IOException {

		driver = initializeDriver();
		slackobject = new SlackIdentityObjects(driver);
	}

	// Select Identity Management and Upgrade flow covered
	@Test(priority = 1)
	public void selectSlackIMProvider() throws InterruptedException {
		Thread.sleep(2000L);
		SignInWithSSOFunction();
		Thread.sleep(1000L);
		selectManagePage();
		Thread.sleep(1000L);
		slackobject.QuickSettingsText().click();
		disconnectIdentityManagementOnYes();
		System.out.println("Testcase-1 passed since application landed on Manage page and Assertion passed");
	}

	// validate connecting to slack and disconnecting on click of cancel button and
	// click on sure button
	@Test(priority = 2)
	public void connectSlackOnCancel() throws InterruptedException {
		Thread.sleep(1000L);
		slackIconSetUpPageValidate();
		closeBotFunc();

		slackobject.ConnectSlackButton().click();
		Thread.sleep(1000L);
		slackobject.AllowButton().click();
		Thread.sleep(4000L);
		nevermindButtonValidate();
		System.out.println("User has clicked on Nevermind button");
		Thread.sleep(1000L);
		validateSelectPeopleAssertion();
		System.out
				.println("Testcase-2 Passes since application is connected to Slack and landed on select people page");

	}

	// Validate Upgrade now flow

	@Test(priority = 3)
	public void SlackFlowValidateUpgradeNowEmptyFields() throws InterruptedException {
		Thread.sleep(2000L);
		slackobject.UpgradeNowFeature().click();
		String actualUpgradeFromText = slackobject.UpgradePlanText().getText();
		System.out.println(actualUpgradeFromText);
		Assert.assertEquals(actualUpgradeFromText, "Upgrade from the Free plan to Team or Business plan");
		Thread.sleep(1000L);
		slackobject.UpgradePlanNextButton().click();
		String actualSetupPaymentText = slackobject.UpgradePlanText().getText();
		System.out.println(actualSetupPaymentText);
		Assert.assertEquals(actualSetupPaymentText, "Setup your payment method");
		slackobject.SetUpPaymentNextButton().click();
		System.out.println(slackobject.SetUpAlertMessage().getText());
		if (slackobject.SetUpAlertMessage().getText() != null) {
			System.out.println("entering into billing details");
			validateCardValidDetails();
			System.out.println("Testcase-3 passed since billing details are provided and approved");
		}
	}

	// View Invite Flow

	@Test(priority = 4)
	public void ViewInvitesFlow() throws InterruptedException {
		validateSelectPeopleViewFlow();
		System.out.println(
				"Testcase-4 passed since channel is selected and page landed on Manage after view people button click");
	}

	// Edit Connection flow // View people using Edit Connection Flow

	@Test(priority = 5)
	public void editConnectionFlow() throws InterruptedException {
		slackobject.EditConnectionButton().click();
		createAssemblyAccountFlow();
		System.out.println("Testcase-5 passed since Edit Connection flow is completed");
		Thread.sleep(1000L);
		// validateQuickSettingsSlackFunction();
		String errorMessageText = slackobject.SlackErrorMessage().getText();
		System.out.println("Error message is " + errorMessageText);

	}

	// Function to validate landing page of Manage
	public void selectManagePage() throws InterruptedException {
		slackobject.avatarIcon().click();
		slackobject.AdminText().click();
		Thread.sleep(1000L);
		slackobject.UsersText().click();
		slackobject.ManageText().click();
		Thread.sleep(5000L);

	}

	// Function to validate Cancel button on all pages
	public void cancelButtonClickValidate() throws InterruptedException {
		slackobject.CancelButton().click();
		Thread.sleep(5000L);
		validateManagePageAssertion();
	}

	// Function to validate 'I'm sure' on click of cancel button
	public void sureButtonClickValidate() throws InterruptedException {
		slackobject.CancelButton().click();
		Thread.sleep(2000L);
		ValidateCancelModalHeaderAssertion();
		slackobject.ImSureButton().click();
		Thread.sleep(2000L);
		validateManagePageAssertion();
	}

	// Function to validate 'Never mind' on click of cancel button
	public void nevermindButtonValidate() throws InterruptedException {
		Thread.sleep(5000L);
		slackobject.CancelButton().click();
		Thread.sleep(2000L);
		ValidateCancelModalHeaderAssertion();
		slackobject.NevermindButton().click();
		validateSelectPeopleAssertion();

	}

	// Function to validate Slack first page - Setup/Connect
	public void slackIconSetUpPageValidate() throws InterruptedException {
		slackobject.SlackIdentityIcon().click();
		Thread.sleep(2000L);
		String actualFirstStepText = slackobject.SetupStepText().getText();
		System.out.println("Set up text is ===> " + actualFirstStepText);
		Assert.assertEquals(actualFirstStepText, "Set up Slack as your identity provider");
		validateConnectPageAssertion();
	}

	// Function to validate Disconnect slack
	public void disconnectIdentityManagementOnKeepIt() throws InterruptedException {
		Thread.sleep(1000L);
		slackobject.DisconnectSlackButton().click();
		ValidateDisconnectSlackModalAssertion();
		slackobject.NokeepItIM().click();
	}

	// Function to validate Disconnect slack
	public void disconnectIdentityManagementOnYes() throws InterruptedException {
		slackobject.DisconnectSlackButton().click();
		ValidateDisconnectSlackModalAssertion();
		slackobject.YesDisconnectIM().click();
		validateManagePageAssertion();
	}

	// Assertion Validation
	// Validate Sign in to workspace landing page
	public void validateSignInSlackAppAssertion() {
		String SlackSignInWorkspaceText = slackobject.SlackSignInWorkspaceText().getText();
		System.out.println(SlackSignInWorkspaceText);
		Assert.assertEquals(SlackSignInWorkspaceText, "Sign in to your workspace");
	}

	// Validate Slack App Actual header
	public void validateSlackAppActualHeaderAssertion() {
		String SlackActualHeader = slackobject.SlackSigninHeaderText().getText();
		Assert.assertEquals(SlackActualHeader,
				"Assembly v2 Dev is requesting permission to access the Joinassembly+21 Slack workspace");
	}

	// Validate Manage landing page when slack is not connected
	public void validateManagePageAssertion() throws InterruptedException {
		Thread.sleep(2000L);
		String managePageLandingText = slackobject.ConnectIdentityText().getText();
		System.out.println("the text is " + managePageLandingText);
		// Assert.assertEquals(managePageLandingText, "Connect your identity provider");
	}

	// Validate Manage landing page when slack is connected
	public void validateManageSlackConnectedAssertion() throws InterruptedException {
		Thread.sleep(2000L);
		String managePageLandingText = slackobject.QuickSettingsText().getText();
		System.out.println("the text is " + managePageLandingText);
		Assert.assertEquals(managePageLandingText, "Quick Settings");
	}

	// Validate Step1 content for Slack Connect
	public void validateConnectPageAssertion() {
		String stepCountText = slackobject.StepCount().getText();
		System.out.println("Step count is ===> " + stepCountText);
		Assert.assertEquals(stepCountText, "Step 1 of 4");
	}

	// Validate Step2 content for Slack Select People
	public void validateSelectPeopleAssertion() {
		String stepCountText = slackobject.StepCount().getText();
		System.out.println("Step count is ===> " + stepCountText);
		Assert.assertEquals(stepCountText, "Step 2 of 4");
	}

	// Validate Step3 content for Slack Configure Invites
	public void validateConfigureInvitesAssertion() {
		String stepCountText = slackobject.StepCount().getText();
		System.out.println("Step count is ===> " + stepCountText);
		Assert.assertEquals(stepCountText, "Step 3 of 4");
	}

	// Validate Step2 content for Slack Assembly Accounts
	public void validateCreateAccountAssertion() {
		String stepCountText = slackobject.StepCount().getText();
		System.out.println("Step count is ===> " + stepCountText);
		Assert.assertEquals(stepCountText, "Step 4 of 4");
	}

	// Validate Cancel modal header content
	public void ValidateCancelModalHeaderAssertion() {
		String actualCancelHeaderModalText = slackobject.CancelModalHeader().getText();
		System.out.println("The header of Cancel modal is  " + actualCancelHeaderModalText);
		Assert.assertEquals(actualCancelHeaderModalText, "Are you sure you want to cancel Slack setup?");
	}

	// Validate Disconnect Slack modal header content
	public void ValidateDisconnectSlackModalAssertion() throws InterruptedException {
		Thread.sleep(3000L);
		String disconnectSlackModalHeader = slackobject.DisconnectSlackModalHeader().getText();
		System.out.println(disconnectSlackModalHeader);
		Assert.assertEquals(disconnectSlackModalHeader, "Disconnect Slack?");
	}

	// Validate Sign in with slack flow
	public void SignInWithSSOFunction() throws InterruptedException {
		// slackobject.SignInWithSlackSSOClick().click();
		slackobject.SlackInputField().sendKeys("joinassembly21");
		slackobject.SlackContinueSubmitButton().click();
		slackobject.SlackEmailInputField().sendKeys("hema+21@joinassembly.com");
		slackobject.slackPwdInputField().sendKeys("Assembly2020!");
		slackobject.slackSignInButton().click();
		validateSlackAppActualHeaderAssertion();
		Thread.sleep(7000L);
		slackobject.AllowButton().click();
	}

	// Validate signout flow
	public void signOutFunction() {
		slackobject.avatarIcon().click();
		slackobject.SignoutText().click();
	}

	public void validateCardValidDetails() throws InterruptedException {
		slackobject.CardNameInputField().sendKeys("abc");
		Thread.sleep(1000L);
		this.driver.switchTo().frame(slackobject.IframeCardNumber());
		slackobject.CardNumberInputField().sendKeys("4242424242424242");
		driver.switchTo().defaultContent();
		this.driver.switchTo().frame(slackobject.IframeExpiryDate());
		slackobject.CardExpiryDateField().sendKeys("1222");
		driver.switchTo().defaultContent();
		this.driver.switchTo().frame(slackobject.IframeCvcNumber());
		slackobject.CardCvcField().sendKeys("123");
		driver.switchTo().defaultContent();
		Thread.sleep(1000L);
		slackobject.ApplyButton().click();
		if (slackobject.SetUpAlertMessage().getText() != null) {
			Thread.sleep(1000L);
			slackobject.PromCodeInputField().sendKeys("100OFF");
			slackobject.ApplyButton().click();
			Boolean successToast = slackobject.successToast().isDisplayed();
			System.out.println("Is promo applied successfully " + successToast);
		}
		slackobject.SetUpPaymentNextButton().click();
		Thread.sleep(1000L);
		String billingContent = slackobject.ReviewBillingContent().getText();
		System.out.println("The reviewed billing content is: " + billingContent);
		slackobject.ReviewBillConfirm().click();
		Thread.sleep(3000L);

	}

	// change the logic here
	public void validateQuickSettingsSlackFunction() {
		slackobject.QuickSettingsText().click();
		Boolean saveSettingsActive = slackobject.SaveSettingsButton().isEnabled();
		System.out.println(saveSettingsActive);
		if (saveSettingsActive == true) {
			// slackobject.AutoApproveRadio().click();
			Boolean isAutoapprovalSelected = slackobject.AutoApproveRadio().isSelected();
			if (isAutoapprovalSelected == true) {
				System.out.println("Auto approve is selected by default");
			}
			slackobject.SaveSettingsButton().click();
			slackobject.CloseButton().click();
			System.out.println("Now newly added users to slack will be auto approved");
		} else {
			System.out.println("The Save Changes button is Disabled");
		}

	}

	public void slackWorkspaceFlow() throws InterruptedException {
		slackobject.SlackInputField().sendKeys("joinassembly21");
		slackobject.SlackContinueSubmitButton().click();
		slackobject.SlackEmailInputField().sendKeys("hema+21@joinassembly.com");
		slackobject.slackPwdInputField().sendKeys("Assembly2020!");
		slackobject.slackSignInButton().click();
		validateSlackAppActualHeaderAssertion();
		Thread.sleep(10000L);
		slackobject.AllowButton().click();
	}

	public void validateSelectPeopleViewFlow() throws InterruptedException {
		createAssemblyAccountFlow();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", slackobject.DisconnectSlackButton());
		Thread.sleep(10000L);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Disconnect Slack')]")));
		Thread.sleep(4000L);
		disconnectIdentityManagementOnKeepIt();
		validateCreateAccountAssertion();
		System.out.println("User has click on 'No, Keep it button in Create Accounts page");
		validateCreateAccountAssertion();
		System.out.println("View people button is displayed? " + slackobject.viewPeopleInviteButton().isEnabled());
		Thread.sleep(2000);
		slackobject.viewPeopleInviteButton().click();
		validateManageSlackConnectedAssertion();

	}

	public void createAssemblyAccountFlow() throws InterruptedException {
		Thread.sleep(1000L);
		validateSelectPeopleAssertion();
		System.out.println("selecting channels");
		Thread.sleep(4000L);
		slackobject.SelectChannels().click();
		Thread.sleep(2000L);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", slackobject.SelectAllCheckBox());
		Thread.sleep(1000L);
		slackobject.SelectAllCheckBox().click();
		Thread.sleep(1000L);
		slackobject.ContinueNext().click();
		Thread.sleep(1000L);
		slackobject.SendInvitationsNowRadio().click();
		validateConfigureInvitesAssertion();
		slackobject.CreateAssemblyAccountsButton().click();
	}

	public void closeBotFunc() throws InterruptedException {
		Thread.sleep(1000L);
		this.driver.switchTo().frame(slackobject.LiveChatIframe());
		slackobject.LiveChatButton().click();
		Thread.sleep(1000L);
		slackobject.CloseIntercomLive().click();
		driver.switchTo().defaultContent();
	}

	@AfterClass
	public void finish() {
		driver.manage().deleteAllCookies();
		// driver.quit();
	}

}
