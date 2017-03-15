package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	protected WebDriver driver;	
	protected WebDriverWait wait;	
	protected HashMap<String, String> data;
	protected Actions actions;
	
	public PageObject(WebDriver driver, HashMap<String, String> data) {
		this.driver = driver;
		this.data = data;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 30);
	}
	
	protected void typeText(WebElement element, String str) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(str);
		actions.build().perform();
	}
	
	protected void clickButton(WebElement button) {
		wait.until(ExpectedConditions.visibilityOf(button));
		button.click();
	}
}
