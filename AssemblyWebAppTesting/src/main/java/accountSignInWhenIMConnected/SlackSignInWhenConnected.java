package accountSignInWhenIMConnected;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import giveRecognitionPageObjects.loginPageObjects;
import resources.InitiateDriver;
import slackPageObjects.SlackIdentityObjects;

public class SlackSignInWhenConnected extends InitiateDriver {
	public static Logger log = LogManager.getLogger(SlackSignInWhenConnected.class.getName());

	public void validateSlackLogin() throws InterruptedException {
		System.out.println("Navigated to the provided URL");
		// Create an object for loginObjects class of pageObjects
		loginPageObjects loginobject = new loginPageObjects(driver);
		SlackIdentityObjects slackobject = new SlackIdentityObjects(driver);
		String actualheader = loginobject.getHeader().getText();
		String expectedheader = "Welcome back!";
		// Check for Assertion
		Assert.assertEquals(actualheader, expectedheader);
		System.out.println("Assertion passed for login page");
		loginobject.getUsernameObject().sendKeys("hema+21@joinassembly.com");
		loginobject.getPasswordObject().sendKeys("jonSnow09!");
		Thread.sleep(1000L);
		loginobject.signinObject().click();
		Thread.sleep(4000L);
		String getLoginMessage = loginobject.SlackSSOHeader().getText();
		System.out.println("The Message is " + getLoginMessage);
		if (getLoginMessage.equalsIgnoreCase("Please use your SSO")) {
			System.out.println("SSO sign in button is displayed");
			slackobject.SignInWithSlackButton().click();

		} else if (getLoginMessage.equalsIgnoreCase("invalid email/password")) {
			System.out.println("Invalid mail/password");
		}
	}

	@Test
	public void validateSlackLoginWhenConnected() throws FileNotFoundException, IOException, InterruptedException {
		validateSlackLogin();
	}

}
