package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHome extends PageObject {
	
	public GoogleHome(WebDriver driver, HashMap<String, String> data) {
		super(driver, data);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="q")
	private WebElement searchField;
	
	@FindBy(name="btnG")
	private WebElement searchButton;
	
	public void performSearch() {
		typeText(searchField, data.get("searchTerm"));
		clickButton(searchButton);
	}
}
