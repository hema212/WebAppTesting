package signInViaSSO;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import adpPageObjects.ADPIdentityObjects;
import giveRecognitionPageObjects.RecognitionPageObject;
import giveRecognitionPageObjects.loginPageObjects;
import resources.InitiateDriver;

public class ADPSsoSignIn extends InitiateDriver {
	public static Logger log = LogManager.getLogger(ADPSsoSignIn.class.getName());

	public void validateADPLogin() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(baseurl);
		System.out.println(baseurl);
		log.info("Navigated to the provided URL");
		loginPageObjects loginobject = new loginPageObjects(driver);
		ADPIdentityObjects adppageobject = new ADPIdentityObjects(driver);
		String actualheader = loginobject.getHeader().getText();
		String expectedheader = "Welcome back!";
		// Check for Assertion
		Assert.assertEquals(actualheader, expectedheader);
		log.info("Assertion passed for login page");
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div/div/div/div[3]")));
		Thread.sleep(1000L);
		adppageobject.SignInWithADPSSOClick().click();

		System.out.println("is displayed" + adppageobject.ADPInputUserNameField().isDisplayed());
		Thread.sleep(5000L);
		System.out.println("is displayed" + adppageobject.ADPInputUserNameField().isDisplayed());
		adppageobject.ADPInputUserNameField().sendKeys("joanderson@testess2");
		Thread.sleep(1000L);
		adppageobject.ADPPasswordField().sendKeys("adpadp10");
		Thread.sleep(3000L);
		adppageobject.ADPSignin().click();
		Thread.sleep(3000L);
		RecognitionPageObject recogobject = new RecognitionPageObject(driver);
		String mainContent = recogobject.giveRecognitionText().getText();
		if (mainContent == null) {
			log.info("failed to login!");
		} else {
			log.info("Successfully logged into Assembly homepage!");
			Assert.assertEquals(mainContent, "Give Recognition");
			log.info("Assertion Passed for homepage landing");
		}

	}

	@Test
	public void validateSlackLoginWhenConnected() throws FileNotFoundException, IOException, InterruptedException {
		System.out.println("Logging in...");
		validateADPLogin();

	}

}
