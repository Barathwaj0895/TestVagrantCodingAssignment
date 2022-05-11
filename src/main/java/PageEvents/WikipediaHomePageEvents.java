package main.java.PageEvents;

import main.java.PageObjects.WikipediaHomePageElements;
import main.java.Utils.ElementFetch;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static test.java.BaseTest.driver;

public class WikipediaHomePageEvents {
    ElementFetch elementFetch = new ElementFetch();

    public void getWikipediaHomePage() {
        driver.get(WikipediaHomePageElements.getWikipediaUrl);
    }

    public void getSearchBarAndInputSearchText() {
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaSearchBar).isDisplayed();
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaSearchBar).click();
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaSearchBar).sendKeys("Pushpa: The Rise");
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaSearchButton).isDisplayed();
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaSearchButton).click();
    }

    public boolean getPageTitle() {
        System.out.println(elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikiPediaPageTitle).getText());
        return elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikiPediaPageTitle).getText().equalsIgnoreCase("Pushpa: The Rise");
    }

    public String getMovieReleaseDate() {
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        String oldTab = driver.getWindowHandle();
        driver.switchTo().window(oldTab);
        driver.switchTo().window(newTab.get(0));
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaTable);
        List<WebElement> listright = elementFetch.getListWebElements("XPATH", WikipediaHomePageElements.getWikipediaTableRHS);
        List<String> rhs = new ArrayList<String>();
        for (WebElement tr : listright) {
            rhs.add(tr.getText().toString());
        }
        List<WebElement> listleft = elementFetch.getListWebElements("XPATH", WikipediaHomePageElements.getWikipediaTableLHS);
        List<String> lhs = new ArrayList<String>();
        for (WebElement tr : listleft) {
            lhs.add(tr.getText().toString());
        }
        int li = lhs.indexOf("Country");
        int si = lhs.indexOf("Release date");
        System.out.println(rhs.get(si).replace(" (India)", ""));
        return rhs.get(si).replace(" (India)", "");
    }

    public String getMovieCountry(){
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaTable);
        List<WebElement> listright = elementFetch.getListWebElements("XPATH", WikipediaHomePageElements.getWikipediaTableRHS);
        List<String> rhs = new ArrayList<String>();
        for (WebElement tr : listright) {
            rhs.add(tr.getText().toString());
        }
        List<WebElement> listleft = elementFetch.getListWebElements("XPATH", WikipediaHomePageElements.getWikipediaTableLHS);
        List<String> lhs = new ArrayList<String>();
        for (WebElement tr : listleft) {
            lhs.add(tr.getText().toString());
        }
        int li = lhs.indexOf("Country");
        int si = lhs.indexOf("Release date");
        System.out.println("Country of Pushpa-The Rise is " + rhs.get(li));
        return rhs.get(li);
    }
}