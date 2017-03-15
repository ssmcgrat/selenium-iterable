package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleResultsPage extends PageObject {
	
	@FindBy(xpath="//*[@id=\"rso\"]/div/div/div[1]/div/h3/a")
	WebElement firstResult;
	
	public GoogleResultsPage(WebDriver driver, HashMap<String, String> data) {
		super(driver, data);
		// TODO Auto-generated constructor stub
	}
	
	public void selectFirstResult() {
		clickButton(firstResult);
	}
	
}
