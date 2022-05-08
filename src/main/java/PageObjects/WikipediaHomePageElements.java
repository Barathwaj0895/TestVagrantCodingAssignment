package main.java.PageObjects;

public interface WikipediaHomePageElements {
    String getWikipediaLogo = "//a[@class='mw-wiki-logo']";
    String getWikipediaSearchBar = "//input[@class='vector-search-box-input']";
    String getWikipediaSearchButton = "//input[@id='searchButton']";
    String getWikiPediaPageTitle = "//h1[@class='firstHeading mw-first-heading']";
    String getWikipediaTable = "//table[@class='infobox vevent']";
    String getWikipediaRow = "tr";
    String getWikipediaRowData = "td";
    String getWikipediaUrl = "https://en.wikipedia.org/wiki/Main_Page";
}
