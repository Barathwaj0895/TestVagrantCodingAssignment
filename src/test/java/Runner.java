package test.java;

import main.java.PageEvents.WikipediaHomePageEvents;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Runner extends BaseTest{
    @Test
    public void tc1Validation () {
        WikipediaHomePageEvents wikipediaHomePageEvents = new WikipediaHomePageEvents();
        wikipediaHomePageEvents.getWikipediaHomePage();
        wikipediaHomePageEvents.getSearchBarAndInputSearchText();
        Assert.assertTrue(wikipediaHomePageEvents.getPageTitle(), "Incorrect Page");
        wikipediaHomePageEvents.getMovieReleaseDateAndCountry();
    }
}
