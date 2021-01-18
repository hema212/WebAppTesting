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

import giveRecognitionPageObjects.loginPageObjects;
import officePageObjects.O365PageObjects;
import resources.InitiateDriver;

public class O365SsoSignIn extends InitiateDriver {
	public static Logger log = LogManager.getLogger(O365SsoSignIn.class.getName());

	public void validateO365Login() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(baseurl);
		log.info("Navigated to the provided URL");
		loginPageObjects loginobject = new loginPageObjects(driver);
		O365PageObjects O365object = new O365PageObjects(driver);
		String actualheader = loginobject.getHeader().getText();
		String expectedheader = "Welcome back!";
		// Check for Assertion
		Assert.assertEquals(actualheader, expectedheader);
		log.info("Assertion passed for login page");
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5/../div[1]/div/div/div[2]/button")));
		Thread.sleep(1000L);
		O365object.O365SsoSignIn().click();
		O365object.O365Email().sendKeys("hema2508@joinassembly123.onmicrosoft.com");
		Thread.sleep(1000L);
		O365object.SubmitEmail().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
		O365object.O365Pwd().sendKeys("Elizebeth@1234");
		O365object.SubmitEmail().click();
		Thread.sleep(2000L);
		O365object.YesText().click();
		/*
		 * O365object.O365Consent().click(); O365object.AcceptO365Consent().click();
		 */

	}

	@Test
	public void validateSlackLoginWhenConnected() throws FileNotFoundException, IOException, InterruptedException {
		System.out.println("Logging in...");
		validateO365Login();

	}

}