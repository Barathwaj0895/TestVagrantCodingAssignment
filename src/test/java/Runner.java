package test.java;

import main.java.PageEvents.IMDbHomePageEvents;
import main.java.PageEvents.WikipediaHomePageEvents;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Runner extends BaseTest{
    @Test
    public void tc1Validation () throws InterruptedException {
        WikipediaHomePageEvents wikipediaHomePageEvents = new WikipediaHomePageEvents();
        IMDbHomePageEvents imDbHomePageEvents = new IMDbHomePageEvents();
        wikipediaHomePageEvents.getWikipediaHomePage();
        wikipediaHomePageEvents.getSearchBarAndInputSearchText();
        Assert.assertTrue(wikipediaHomePageEvents.getPageTitle(), "Incorrect Page");
        Assert.assertEquals(wikipediaHomePageEvents.getMovieCountry(), imDbHomePageEvents.getMovieOriginCountry());
//        Assert.assertEquals(wikipediaHomePageEvents.getMovieReleaseDate(),"17 December 2021 (India)");
        Assert.assertEquals(wikipediaHomePageEvents.getMovieReleaseDate(), imDbHomePageEvents.getMovieReleaseDate());
//        imDbHomePageEvents.getMovieReleaseDate();

    }
}
