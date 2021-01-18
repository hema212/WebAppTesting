package resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseDriver {
	public static Logger log = LogManager.getLogger(BaseDriver.class.getName());

	public static WebDriver driver;
	public String baseurl;
	public String homepageurl;

	@BeforeTest
	public WebDriver initializeDriver() throws IOException, FileNotFoundException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Work\\chromedriver.exe");
		try {
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			options.addArguments("--test-type");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-first-run");
			options.addArguments("--no-default-browser-check");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--start-maximized");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("--window-size=1280,800");

			//specifically this line here :)
			options.setCapability("acceptInsecureCerts", true);
			options.setCapability(ChromeOptions.CAPABILITY, options);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(options);
			//System.out.println("options are : " + options);
		}
		
		catch (Exception e) {

			throw new Error(e);

		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void getDriver() {
		driver.manage().window().maximize();
	}
}