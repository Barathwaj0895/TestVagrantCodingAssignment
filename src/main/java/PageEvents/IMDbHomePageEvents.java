package main.java.PageEvents;

import main.java.PageObjects.IMDbHomePageElements;
import main.java.Utils.ElementFetch;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.Set;

import static test.java.BaseTest.driver;

public class IMDbHomePageEvents {
    ElementFetch elementFetch = new ElementFetch();

    public void getIMBdHomePage() {
        driver.get(IMDbHomePageElements.getIMDbUrl);
    }

    public void searchForMovie() {
        elementFetch.getWebElement("XPATH", IMDbHomePageElements.getIMDbSearchTextBox).isDisplayed();
        elementFetch.getWebElement("XPATH", IMDbHomePageElements.getIMDbSearchTextBox).click();
        elementFetch.getWebElement("XPATH", IMDbHomePageElements.getIMDbSearchTextBox).sendKeys(IMDbHomePageElements.movieToSearch);
        elementFetch.getWebElement("XPATH", IMDbHomePageElements.movieSuggestionList).getText().equalsIgnoreCase(IMDbHomePageElements.movieToSearch);
        elementFetch.getWebElement("XPATH", IMDbHomePageElements.movieSuggestionList).click();

    }

    public boolean validateMovieTitleInIMDbPage() {
        String movieName = elementFetch.getWebElement("XPATH", IMDbHomePageElements.getMovieTitle).getText();
        System.out.println(movieName);
        return movieName.equalsIgnoreCase(IMDbHomePageElements.movieToSearch);
    }

    public String  getMovieOriginCountry() throws InterruptedException {
        String selectOpenInNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        elementFetch.getWebElement("XPATH", IMDbHomePageElements.getIDMbLinkUrlFromWikiPage).sendKeys(selectOpenInNewTab);
        Thread.sleep(5000);
        for (String winHandle : driver.getWindowHandles()) { //Gets the new window handle
            driver.switchTo().window(winHandle);  // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertTrue(validateMovieTitleInIMDbPage(), "Movie Name is Incorrect");
//        validateMovieTitleInIMDbPage();
        String movieOrigin = elementFetch.getWebElement("XPATH", IMDbHomePageElements.getMovieOrigin).getText();
        String movieOriginSplit[] = movieOrigin.split(" ");
        String str = movieOriginSplit[2].substring(6,12).trim();
        return str;
    }

    public String getMovieReleaseDate() throws InterruptedException {
        String selectOpenInNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        elementFetch.getWebElement("XPATH", IMDbHomePageElements.getIDMbLinkUrlFromWikiPage).sendKeys(selectOpenInNewTab);
        Thread.sleep(5000);
        for (String winHandle : driver.getWindowHandles()) { //Gets the new window handle
            driver.switchTo().window(winHandle);  // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        String movieReleaseDate = elementFetch.getWebElement("XPATH", IMDbHomePageElements.getMovieReleaseDate).getText();
        String movieReleaseDateSplit[] = movieReleaseDate.split(" ");
        String str1 = movieReleaseDateSplit[1] + movieReleaseDateSplit[2] + movieReleaseDateSplit[3];
        String str2 = str1.replace(",", " ");
        String movieReleaseDateFinal = str2.replace("date", "").trim().replaceAll(".......", "$0 ");
        System.out.println(movieReleaseDateFinal);
        return movieReleaseDateFinal;
    }

}
