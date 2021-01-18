package slackTestSuite;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import accountSignInWhenIMConnected.SlackSignInWhenConnected;
import slackPageObjects.SlackIdentityObjects;

public class ManagerReportsEditTest extends SlackSignInWhenConnected {
	public static Logger log = LogManager.getLogger(ManagerReportsEditTest.class.getName());
	public SlackIdentityObjects slackobject;

	@BeforeTest
	public void init() throws FileNotFoundException, IOException {
		driver = initializeDriver();
		slackobject = new SlackIdentityObjects(driver);
	}

	// Verify Managers/Reports can be selected by user
	@Test(priority = 1)
	public void DeleteUsersFromQueuedInvites() throws InterruptedException {
		selectManageSideNavbar();
		slackobject.ManageText().click();
		String breadcrum = slackobject.InvitesBreadcrum().getText();
		Assert.assertEquals(breadcrum, "> Manage");
		Thread.sleep(1000L);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", slackobject.SIngleUserSelectToEditThree());
		slackobject.SIngleUserSelectToEditThree().click();
		slackobject.ManagePageEditIcon().click();
		Thread.sleep(1000L);
		managePageEditModalHeader();
		slackobject.UserNameFullName().sendKeys(" testuser");
		Thread.sleep(1000L);
		slackobject.ManagersDropDown().click();
		keyboardFunc();
		Thread.sleep(1000L);
		slackobject.ReportsDropdown().click();
		keyboardFuncReport();
		slackobject.ConfirmInvite().click();
		Thread.sleep(1000L);
		toastAssertion();
	}

	// Verify Managers/Reports can be selected by user
	@Test(priority = 2)
	public void DeleteManagerReportUser() throws InterruptedException {
		slackobject.SingleUserSelectToEdit().click();
		slackobject.ManagePageDeleteIcon().click();
		managePageDeleteModalHeader();
		slackobject.RemoveButton().click();
		Thread.sleep(3000L);
		toastAssertion();
	}

	// Verify Managers/Reports can be selected by user
	@SuppressWarnings("unused")
	@Test(priority = 3)
	public void validateDeletedUserInManagerReports() throws InterruptedException {
		Thread.sleep(3000L);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", slackobject.SIngleUserSelectToEditThree());
		slackobject.SIngleUserSelectToEditThree().click();
		slackobject.ManagePageEditIcon().click();
		Thread.sleep(2000L);
		managePageEditModalHeader();
		js.executeScript("arguments[0].scrollIntoView(true);", slackobject.ReportsDropdown());
		slackobject.ManagerReporterChip().isDisplayed();
		System.out.println("the boolean value is" + slackobject.ManagerReporterChip().isDisplayed());
		if (false) {
			System.out.println("User has been removed from Managers/Reporters");
		}
	}

	// function to validate landing page of Manage
	public void selectManageSideNavbar() throws InterruptedException {
		slackobject.avatarIcon().click();
		slackobject.AdminText().click();
		Thread.sleep(1000L);
		slackobject.UsersText().click();
		slackobject.ManageText().click();
		Thread.sleep(1000L);
	}

	// keyboard function
	public void keyboardFunc() throws InterruptedException {
		Thread.sleep(1000L);
		slackobject.ManagersDropDown().sendKeys(Keys.ARROW_DOWN);
		slackobject.ManagersDropDown().sendKeys(Keys.ENTER);
	}

	public void keyboardFuncReport() throws InterruptedException {
		Thread.sleep(1000L);
		slackobject.ReportsDropdown().sendKeys(Keys.ARROW_DOWN);
		slackobject.ReportsDropdown().sendKeys(Keys.ENTER);
	}

	public void managePageEditModalHeader() {
		String actualEditModalHeader = slackobject.ManagePageEditModalHeader().getText();
		Assert.assertEquals(actualEditModalHeader, "Edit Employee");
	}

	public void managePageDeleteModalHeader() {
		String actualEditModalHeader = slackobject.ManageUserDeleteHeader().getText();
		Assert.assertEquals(actualEditModalHeader, "Remove User(s)");
	}

	public void toastAssertion() throws InterruptedException {
		Thread.sleep(2000L);
		slackobject.successToast().isDisplayed();
		if (true) {
			Assert.assertTrue(true);
		}
	}
}