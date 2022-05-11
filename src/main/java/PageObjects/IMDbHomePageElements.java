package main.java.PageObjects;

public interface IMDbHomePageElements {
    String  getIMDbUrl = "https://www.imdb.com/";
    String getIMDbSearchTextBox = "//input[@aria-label='Search IMDb']";
    String getIMDbSearchButton = "//button[@aria-label='Submit Search']";
    String movieToSearch = "Pushpa: The Rise - Part 1";
    String movieSuggestionList = "//div[@class='searchResult__constTitle searchResults__ResultTextItem-sc-1pmqwbq-2 hzkacB']";
    String getMovieTitle = "//h1[@data-testid='hero-title-block__title']";
    String getMovieReleaseDate = "//li[@data-testid='title-details-releasedate']";
    String getMovieOrigin = "//li[@data-testid='title-details-origin']";
    String getIDMbLinkUrlFromWikiPage = "//a[@href='https://www.imdb.com/title/tt9389998/']";
}
