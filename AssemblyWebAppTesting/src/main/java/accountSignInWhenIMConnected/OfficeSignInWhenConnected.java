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

public class OfficeSignInWhenConnected extends InitiateDriver {
	public static Logger log = LogManager.getLogger(SlackSignInWhenConnected.class.getName());

	public void validateO365Login() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(baseurl);
		log.info("Navigated to the provided URL");
		// Create an object for loginObjects class of pageObjects
		loginPageObjects loginobject = new loginPageObjects(driver);
		SlackIdentityObjects slackobject = new SlackIdentityObjects(driver);
		String actualheader = loginobject.getHeader().getText();
		String expectedheader = "Welcome back!";
		// Check for Assertion
		Assert.assertEquals(actualheader, expectedheader);
		log.info("Assertion passed for login page");
		loginobject.getUsernameObject().sendKeys("hema2508@joinassembly123.onmicrosoft.com");
		loginobject.getPasswordObject().sendKeys("Elizebeth@1234");
		Thread.sleep(1000L);
		loginobject.signinObject().click();
		Thread.sleep(4000L);
		String getLoginMessage = loginobject.SlackSSOHeader().getText();
		System.out.println("The Message is " + getLoginMessage);
		if (getLoginMessage.equalsIgnoreCase("Please use your SSO")) {
			slackobject.SignInWithSlackButton().click();

		} else if (getLoginMessage.equalsIgnoreCase("invalid email/password")) {
			System.out.println("Invalid mail/password");
		}
	}

	@Test
	public void validateO365LoginWhenConnected() throws FileNotFoundException, IOException, InterruptedException {
		validateO365Login();
	}

}
