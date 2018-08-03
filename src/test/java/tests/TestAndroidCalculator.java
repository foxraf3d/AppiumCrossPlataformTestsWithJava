package tests;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import screen.CalculatorScreen;

public class TestAndroidCalculator {
	
	private static CalculatorScreen calculatorScreen;
	private static AppiumDriver<MobileElement> appiumDriver;
	
	@BeforeClass
	public static void setup() throws MalformedURLException {
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    	capabilities.setCapability("app",new File("apps/app-android-calculator.apk"));
	    	capabilities.setCapability("platformName","Android" );
	    	capabilities.setCapability("deviceName","Android Emulator API 22");
	    	capabilities.setCapability("unicodeKeyboard", true);
	    	capabilities.setCapability("automationName", "uiautomator2");
	    	capabilities.setCapability("disableAndroidWatchers" , true);
	    	appiumDriver = new AndroidDriver<MobileElement>(new URL("http://localhost:4444/wd/hub") , capabilities);
	    	calculatorScreen = new CalculatorScreen(appiumDriver);
	}
	
	@Test
	public void shouldSum() {
		calculatorScreen.fillFirstNumber("10").fillSecondNumber("10").buttonSum.click();
		assertTrue(calculatorScreen.operationResult().equals("20"));
	}
	
	@Test
	public void shouldSubtract() {
		calculatorScreen.fillFirstNumber("10").fillSecondNumber("11").buttonSubtract.click();
		assertTrue(calculatorScreen.operationResult().equals("-1"));
	}
	
	@Test
	public void shouldDivide() {
		calculatorScreen.fillFirstNumber("10").fillSecondNumber("10").buttonDivide.click();
		assertTrue(calculatorScreen.operationResult().equals("1"));
	}
	
	@Test
	public void shouldMultiply() {
		calculatorScreen.fillFirstNumber("10").fillSecondNumber("10").buttonMultiply.click();
		assertTrue(calculatorScreen.operationResult().equals("100"));
	}
	
	@Test
	public void dontShouldDivideByZero() {
		calculatorScreen.fillFirstNumber("10").fillSecondNumber("0").buttonDivide.click();
		assertTrue(calculatorScreen.operationResult().equals("Cannot divide by zero!"));
	}
	
	@AfterClass
	public static void teardown() {
		calculatorScreen.quitDriver();
	}
}
