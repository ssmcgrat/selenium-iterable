package drivers;

import org.testng.annotations.Test;

import pages.GoogleHome;
import pages.GoogleResultsPage;

public class PerformGoogleSearch extends TestDriver {

	GoogleHome googleHome;
	GoogleResultsPage googleResultsPage;
	
	@Test(priority=0)
	public void launchURL() {
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("title: " + title);
	}
	
	@Test(priority=1)
	public void performGoogleSearch() {
		googleHome = new GoogleHome(driver, data);
		googleHome.performSearch();
	}
	
	@Test(priority=2)
	public void selectFirstSearchResult() {
		googleResultsPage = new GoogleResultsPage(driver, data);
		googleResultsPage.selectFirstResult();
	}
}
