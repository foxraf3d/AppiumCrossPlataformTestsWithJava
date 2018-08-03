package tests;

import static org.junit.Assert.assertTrue;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import screen.CalculatorScreen;

public class TestWebCalculator {
	
	private static CalculatorScreen calculatorScreen;
	private static RemoteWebDriver remoteDriver;
	
	@BeforeClass
	public static void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("plataformName", "MAC");
		capabilities.setCapability("plataform", "MAC");
	    	remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabilities);
	    calculatorScreen = new CalculatorScreen(remoteDriver);
	}
	
	@Test
	public void shouldSum() {
		remoteDriver.get("http://qaunderground.com.br/calculator/");
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
		assertTrue(calculatorScreen.operationResult().equals("Cannot divide by zero!!"));
	}
	
	@AfterClass
	public static void teardown() {
		remoteDriver.quit();
	}
}
