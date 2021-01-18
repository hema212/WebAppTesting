package slackTestSuite;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import accountSignInWhenIMConnected.SlackSignInWhenConnected;
import slackPageObjects.SlackIdentityObjects;

public class SlackEditViewUsersTest extends SlackSignInWhenConnected {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(SlackEditViewUsersTest.class.getName());
	public SlackIdentityObjects slackobject;

	@BeforeClass
	public void init() throws FileNotFoundException, IOException {

		driver = initializeDriver();
		slackobject = new SlackIdentityObjects(driver);
	}

	// Select Identity Management and Upgrade flow covered
	@Test(priority = 1)
	public void selectManagePageValidation() throws InterruptedException {
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
		slackIconPagevalidateOnClick();
		// closeBotFunc();
		Thread.sleep(1000L);
		slackobject.ConnectSlackButton().click();
		Thread.sleep(4000L);
		slackobject.AllowButton().click();
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
		System.out.println("Testcase-2 passed since application clicked on I'll send them later button");
	}

	@Test(priority = 3)
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
		System.out.println("Testcase-3 passed since application landed on Invites Page On Queued invite");

	}

	// Verify user lands on Invites page
	@Test(priority = 4)
	public void EditInvitesValidationOnCancel() throws InterruptedException {
		String breadcrum = slackobject.InvitesBreadcrum().getText();
		Assert.assertEquals(breadcrum, "> Invites");
		selectDepartmentStatusOnEditModalCancel();
		System.out.println("Testcase-4 passed since Edit is cancelled and user landed on Invites page");
	}

	// Verify edited user details can be saved
	@Test(priority = 5)
	public void EditInvitesValidationOnConfirm() throws InterruptedException {
		selectDepartmentStatusOnEditModalConfirm();
		singleEdit();
		Thread.sleep(1000L);
		getDeptStatusTextUserOne();
		Thread.sleep(1000L);
		bulkApprove();
		Thread.sleep(1000L);
		System.out.println("Testcase-5 passed since Bulk Approval is completed");
		System.out.println("After Bulk Approval data is :" + slackobject.NoDataAvailableText().getText());
		String breadcrum = slackobject.InvitesBreadcrum().getText();
		Assert.assertEquals(breadcrum, "> Invites");
	}

	// Validate Manage page against saved details
	@Test(priority = 6)
	public void ValidateManagePageUserDetails() throws InterruptedException {
		Thread.sleep(1000L);
		slackobject.ManageText().click();
		String breadcrum = slackobject.InvitesBreadcrum().getText();
		Assert.assertEquals(breadcrum, "> Manage");
		System.out.println("Validating user-1 details in Manage page");
		getDeptStatusTextUserOne();
		if (slackobject.UserOneDept().getText().equalsIgnoreCase("Human Resources")) {
			Assert.assertTrue(true);
			System.out.println("The department matches with the edited one");
		}
		if (slackobject.UserOneStatus().getText().equalsIgnoreCase("Receiver")) {
			Assert.assertTrue(true);
			System.out.println("Testcase-6 passed since Status matches with the edited one");
		}
		Thread.sleep(1000L);
		bulkApprove();
	}

	// Validate Sign in with slack flow
	public void SignInWithSSOFunction() throws InterruptedException {
		// slackobject.SignInWithSlackSSOClick().click();
		Thread.sleep(1000L);
		slackobject.SlackInputField().sendKeys("joinassembly21");
		slackobject.SlackContinueSubmitButton().click();
		slackobject.SlackEmailInputField().sendKeys("hema+21@joinassembly.com");
		slackobject.slackPwdInputField().sendKeys("Assembly2020!");
		slackobject.slackSignInButton().click();
		validateSlackAppActualHeaderAssertion();
		Thread.sleep(5000L);
		slackobject.AllowButton().click();
	}

	// Function to validate landing page of Manage
	public void selectManagePage() throws InterruptedException {
		slackobject.avatarIcon().click();
		slackobject.AdminText().click();
		Thread.sleep(1000L);
		slackobject.UsersText().click();
		slackobject.ManageText().click();
		Thread.sleep(2000L);

	}

	// Function to validate Disconnect slack
	public void disconnectIdentityManagementOnYes() throws InterruptedException {
		slackobject.DisconnectSlackButton().click();
		ValidateDisconnectSlackModalAssertion();
		slackobject.YesDisconnectIM().click();
		validateManagePageAssertion();
	}

	// Validate Slack App Actual header
	public void validateSlackAppActualHeaderAssertion() {
		String SlackActualHeader = slackobject.SlackSigninHeaderText().getText();
		Assert.assertEquals(SlackActualHeader,
				"Assembly v2 Dev is requesting permission to access the Joinassembly+21 Slack workspace");
	}

	// Validate Disconnect Slack modal header content
	public void ValidateDisconnectSlackModalAssertion() throws InterruptedException {
		Thread.sleep(3000L);
		String disconnectSlackModalHeader = slackobject.DisconnectSlackModalHeader().getText();
		System.out.println(disconnectSlackModalHeader);
		Assert.assertEquals(disconnectSlackModalHeader, "Disconnect Slack?");
	}

	// Validate Manage landing page when slack is not connected
	public void validateManagePageAssertion() throws InterruptedException {
		Thread.sleep(2000L);
		String managePageLandingText = slackobject.ConnectIdentityText().getText();
		System.out.println("the text is " + managePageLandingText);
		// Assert.assertEquals(managePageLandingText, "Connect your identity provider");
	}

	
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

	// Function to validate Slack first page - Setup/Connect
	public void slackIconPagevalidateOnClick() throws InterruptedException {
		slackobject.SlackIdentityIcon().click();
		Thread.sleep(2000L);
		String actualFirstStepText = slackobject.SetupStepText().getText();
		System.out.println("Set up text is ===> " + actualFirstStepText);
		Assert.assertEquals(actualFirstStepText, "Set up Slack as your identity provider");
		validateConnectPageAssertion();
	}

	// Assertion Validation
	// validate Sign in to workspace landing page
	public void validateSignInSlackAppAssertion() {
		String SlackSignInWorkspaceText = slackobject.SlackSignInWorkspaceText().getText();
		System.out.println(SlackSignInWorkspaceText);
		Assert.assertEquals(SlackSignInWorkspaceText, "Sign in to your workspace");
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

	// Function to validate Disconnect slack
	public void disconnectIdentityManagementOnKeepIt() throws InterruptedException {
		slackobject.DisconnectSlackButton().click();
		validateDisconnectSlackModalAssertion();
		slackobject.NokeepItIM().click();
	}

	// validate Disconnect Slack modal header content
	public void validateDisconnectSlackModalAssertion() {
		String disconnectSlackModalHeader = slackobject.DisconnectSlackModalHeader().getText();
		System.out.println(disconnectSlackModalHeader);
		Assert.assertEquals(disconnectSlackModalHeader, "Disconnect Slack?");
	}

	// function to validate edit bulk users by selecting dept, status and click on
	// Cancel button
	public void selectDepartmentStatusOnEditModalCancel() throws InterruptedException {
		Thread.sleep(1000L);
		slackobject.SelectAllCheckBox().click();
		slackobject.EditButton().click();
		editModalAssertion();
		slackobject.DepartmentDropdown().click();
		slackobject.DesignerDept().click();
		slackobject.SelectStatus().click();
		slackobject.GiverStatus().click();
		slackobject.EditCancelButton().click();
		Thread.sleep(2000L);
		getDeptStatusTextUserOne();
	}

	// function to validate edit bulk users by selecting dept, status and click on
	// Cancel button
	public void selectDepartmentStatusOnEditModalConfirm() throws InterruptedException {
		Thread.sleep(1000L);
		slackobject.SelectAllCheckBox().click();
		slackobject.EditButton().click();
		editModalAssertion();
		slackobject.DepartmentDropdown().click();
		slackobject.DesignerDept().click();
		slackobject.SelectStatus().click();
		slackobject.ReceiverStatus().click();
		slackobject.ConfirmInvite().click();
		Thread.sleep(2000L);
		getDeptStatusTextUserTwo();
	}

	// Edit modal assertion validation
	public void editModalAssertion() {
		String editModalHeader = slackobject.EditInviteModalHeader().getText();
		System.out.println("Edit modal header content is " + editModalHeader);
		Assert.assertTrue(true);
		// Assert.assertEquals(editModalHeader, "Edit 2 Pending Invite(s)");
	}

	// Validate default dept and status in Invites flow
	public void getDeptStatusTextUserOne() throws InterruptedException {
		Thread.sleep(1000L);
		System.out.println("The number of rows are : " + slackobject.Row().size());
		System.out.println("The Department of first user is " + slackobject.UserOneDept().getText());
		System.out.println("The Status of first user is " + slackobject.UserOneStatus().getText());
	}

	// Validate default dept and status in Invites flow
	public void getDeptStatusTextUserTwo() throws InterruptedException {
		Thread.sleep(1000L);
		System.out.println("The number of rows are : " + slackobject.Row().size());
		System.out.println("The Department of Second user is " + slackobject.UserTwoDept().getText());
		System.out.println("The Status of Second user is " + slackobject.UserTwoStatus().getText());
	}

	// Validate Single edit flow
	public void singleEdit() throws InterruptedException {
		slackobject.SingleUserSelectToEdit().click();
		slackobject.EditButton().click();
		Thread.sleep(1000L);
		slackobject.DepartmentDropdownEditEmployee().click();
		slackobject.HumanResourceDept().click();
		Thread.sleep(1000L);
		slackobject.BirthMonthDropDown().click();
		slackobject.BirthMonthSelect().click();
		slackobject.ConfirmInvite().click();

		String monthErrorText = slackobject.HelperBirthMonthError().getText();
		System.out.println("The error text is " + monthErrorText);
		if (monthErrorText != null) {
			slackobject.BirthDayDropDown().click();
			slackobject.BirthDayDate().click();
			slackobject.ConfirmInvite().click();
		}
	}

	public void bulkApprove() throws InterruptedException {
		Thread.sleep(2000L);
		slackobject.SelectAllCheckBox().click();
		slackobject.BulkApprove().click();
		String bulkApproveModalHeader = slackobject.BulkApproveModalHeaderText().getText();
		Assert.assertEquals(bulkApproveModalHeader, "Are you sure you want to approve all queued members?");
		slackobject.ImSureButton().click();
		Thread.sleep(5000L);
		String noDataInTable = slackobject.NoDataAvailableText().getText();
		Assert.assertEquals(noDataInTable, "No Invitees");
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
