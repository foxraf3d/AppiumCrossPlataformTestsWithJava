package screen;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CalculatorScreen {
	
	private RemoteWebDriver appiumDriver; 

	public CalculatorScreen(RemoteWebDriver appiumDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		this.appiumDriver = appiumDriver;
	}

	@AndroidFindBy(id = "android_button_sum")
	@iOSFindBy(accessibility = "apple-sum-button")
	@FindBy(id = "Web-Button-Sum")
	public RemoteWebElement buttonSum;
	
	@AndroidFindBy(id = "android_button_sub")	
	@iOSFindBy(accessibility = "apple-subtract-button")
	@FindBy(id = "Web-Button-Subtract")
	public RemoteWebElement buttonSubtract;
	
	@AndroidFindBy(id = "android_button_div")
	@iOSFindBy(accessibility = "apple-divide-button")
	@FindBy(id = "Web-Button-Divide")
	public RemoteWebElement buttonDivide;
	
	@AndroidFindBy(id = "android_button_mult")
	@iOSFindBy(accessibility = "apple-multiply-button")
	@FindBy(id = "Web-Button-Multiply")
	public RemoteWebElement buttonMultiply;
	
	@AndroidFindBy(id = "android_result_text")
	@iOSFindBy(accessibility = "apple_result_text")
	@FindBy(id = "resultWeb")
	private RemoteWebElement resultText;
	
	@AndroidFindBy(id = "android_field_first_number")
	@iOSFindBy(accessibility = "apple_first_input")
	@FindBy(id = "firstNumber")
	private RemoteWebElement inputFirstNumber;
	
	@AndroidFindBy(id = "android_field_second_number")
	@iOSFindBy(accessibility = "apple_second_input")
	@FindBy(id = "secondNumber")
	private RemoteWebElement inputSecondNumber;
	
	public CalculatorScreen fillFirstNumber(String number) {
		inputFirstNumber.click();
		inputFirstNumber.clear();
		appiumDriver.getKeyboard().sendKeys(number);
		return this;
	}
	
	public CalculatorScreen fillSecondNumber(String number) {
		inputSecondNumber.click();
		inputSecondNumber.clear();
		appiumDriver.getKeyboard().sendKeys(number);
		return this;
	}
	
	public CalculatorScreen closeKeyboard() {
		appiumDriver.getKeyboard().pressKey(Keys.RETURN);
		return this;
	}
	
	public String operationResult() {
		return resultText.getText().toString().trim();
	}
	
	public void quitDriver() {
		appiumDriver.quit();
	}
}
	
