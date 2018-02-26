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
import io.appium.java_client.ios.IOSDriver;
import screen.CalculatorScreen;

public class TestIosCalculator {
	
	private static CalculatorScreen calculatorScreen;
	private static AppiumDriver<MobileElement> appiumDriver;
	
	@BeforeClass
	public static void setup() throws MalformedURLException {
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("app",new File("apps/SimpleCalculator.app"));
	    	capabilities.setCapability("plataform", "MAC" );
	    	capabilities.setCapability("plataformName", "ios" );
	    	capabilities.setCapability("deviceName", "iPhone SE");
	 	capabilities.setCapability("automationName" , "XCUITest");
		appiumDriver = new IOSDriver<MobileElement>(new URL("http://localhost:4444/wd/hub") , capabilities);
		calculatorScreen = new CalculatorScreen(appiumDriver);
	}
	
	@Test
	public void should_sum() {
		calculatorScreen.fillFirstNumber("10").fillSecondNumber("10").closeKeyboard().buttonSum.click();
		assertTrue(calculatorScreen.operationResult().equals("20"));
	}
	
	@Test
	public void should_subtract() {
		calculatorScreen.fillFirstNumber("10").fillSecondNumber("11").closeKeyboard().buttonSubtract.click();
		assertTrue(calculatorScreen.operationResult().equals("-1"));
	}
	
	@Test
	public void should_divide() {
		calculatorScreen.fillFirstNumber("10").fillSecondNumber("10").closeKeyboard().buttonDivide.click();
		assertTrue(calculatorScreen.operationResult().equals("1"));
	}
	
	@Test
	public void should_multiply() {
		calculatorScreen.fillFirstNumber("10").fillSecondNumber("10").closeKeyboard().buttonMultiply.click();
		assertTrue(calculatorScreen.operationResult().equals("100"));
	}
	
	@Test
	public void dont_should_divide_by_zero() {
		calculatorScreen.fillFirstNumber("10").fillSecondNumber("0").closeKeyboard().buttonDivide.click();
		assertTrue(calculatorScreen.operationResult().equals("Cannot divide by zero!"));
	}
	
	@AfterClass
	public static void teardown() {
		calculatorScreen.quitDriver();
	}
}
