package main.java.PageEvents;

import main.java.PageObjects.WikipediaHomePageElements;
import main.java.Utils.ElementFetch;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WikipediaHomePageEvents implements WikipediaHomePageElements {
    ElementFetch elementFetch = new ElementFetch();

    public void getWikipediaHomePage() {
        elementFetch.getUrl("getWikipediaUrl");
    }

    public void getSearchBarAndInputSearchText() {
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaSearchBar).isDisplayed();
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaSearchBar).click();
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaSearchBar).sendKeys("Pushpa: The Rise");
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaSearchButton).isDisplayed();
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaSearchButton).click();
    }

    public boolean getPageTitle() {
        return elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikiPediaPageTitle).equals("Pushpa: The Rise");
    }

    public void getMovieReleaseDateAndCountry() {
        elementFetch.getWebElement("XPATH", WikipediaHomePageElements.getWikipediaTable);
        List<WebElement> tableRows = elementFetch.getListWebElements("TAGNAME",WikipediaHomePageElements.getWikipediaRow);
        String strRowData = "";

        for (WebElement tr: tableRows) {
            List<WebElement> lstColumnData = elementFetch.getListWebElements("TAGNAME", WikipediaHomePageElements.getWikipediaRowData);
            if (lstColumnData.size()>0) {
                for (WebElement tbleColmnData: lstColumnData) {
                    strRowData = strRowData + tbleColmnData.getText();
                    System.out.println(strRowData);
                }
            }
        }
    }
}
