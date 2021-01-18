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
import gsuitePageObjects.GooglePageObjects;
import resources.InitiateDriver;

public class GoogleSsoSignIn extends InitiateDriver {
	public static Logger log = LogManager.getLogger(GoogleSsoSignIn.class.getName());

	public void validateGSuiteLogin() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(baseurl);
		log.info("executing on the browser " + baseurl);
		log.info("Navigated to the provided URL");
		Thread.sleep(2000L);
		loginPageObjects loginobject = new loginPageObjects(driver);
		GooglePageObjects GSuiteobject = new GooglePageObjects(driver);
		String actualheader = loginobject.getHeader().getText();
		String expectedheader = "Welcome back!";
		// Check for Assertion
		Assert.assertEquals(actualheader, expectedheader);
		log.info("Assertion passed for login page");

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5/../div[1]/div/div/div[4]")));

		Thread.sleep(2000L);
		GSuiteobject.SignInWithGSuiteSSOClick().click();
		Thread.sleep(1000L);
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String signInHeader = GSuiteobject.GsuiteSignInHeader().getText();
		Assert.assertEquals(signInHeader, "Sign in");
		Thread.sleep(2000L);
		GSuiteobject.GsuiteEmail().sendKeys("hemaramakrishna@my.joinassembly.com");
		Thread.sleep(1000L);
		GSuiteobject.GsuiteNextButton().click();
		Thread.sleep(1000L);
		GSuiteobject.GsuitePwd().sendKeys("smileAfter1%");
		Thread.sleep(1000L);
		GSuiteobject.GsuiteNextButton().click();
		Thread.sleep(2000L);
		GSuiteobject.otpField().sendKeys(TOTPGenerator.getTwoFactorCode());
		Thread.sleep(1000L);
		GSuiteobject.GsuiteNextButton().click();
		Thread.sleep(3000L);
		GSuiteobject.GsuiteAllow().click();
		Thread.sleep(3000L);
		driver.switchTo().window(winHandleBefore);

	}

	@Test
	public void validateGsuiteLoginSSO() throws FileNotFoundException, IOException, InterruptedException {
		System.out.println("Logging in...");
		validateGSuiteLogin();

	}

}
