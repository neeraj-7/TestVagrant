package TestClasses;

import BaseTest.BaseTest;
import Constants.Constant;
import Listener.TestAllureListeners;
import PageObjects.BasePage;
import PageObjects.IMDB.IMDBHomePage;
import PageObjects.IMDB.IMDBMovieDetailsPage;
import PageObjects.WikiPedia.WikiPediaHomePage;
import PageObjects.WikiPedia.WikiPediaMovieDetailsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.Map;

import static TestUtility.TestUtilityFunctions.fetchDataIMDB;
import static TestUtility.TestUtilityFunctions.fetchDataWikiPedia;

@Listeners({TestAllureListeners.class})
public class CompareMovieDetails extends BaseTest {

    IMDBHomePage imdbHomePage;
    IMDBMovieDetailsPage imdbMovieDetailsPage;
    WikiPediaHomePage wikiPediaHomePage;
    WikiPediaMovieDetailsPage wikiPediaMovieDetailsPage;
    Map<String,String> movieDetailsIMDB;
    Map<String,String> movieDetailsWikipedia;
    BasePage basePage;

    @BeforeClass
    public void setUp(){
        initialize();
        basePage = new BasePage(driver);
        movieDetailsIMDB = new HashMap<>();
        movieDetailsWikipedia = new HashMap<>();
        imdbHomePage = new IMDBHomePage(driver);
        imdbMovieDetailsPage = new IMDBMovieDetailsPage(driver);
        wikiPediaHomePage = new WikiPediaHomePage(driver);
        wikiPediaMovieDetailsPage = new WikiPediaMovieDetailsPage(driver);
    }


    @Test(dataProvider="SearchProvider",dataProviderClass = MovieDataProvider.TestDataProvider.class)
    public void compareMovieDetails(String movieName){
        //open home page of IMDB and verify the home page title
        basePage.openUrl(configFileReader.getUrl(Constant.IMDB_URL));
        Assert.assertEquals(basePage.getTitle(),Constant.IMDB_TITLE,"this is not IMDB home page");


        //Search for any movie on home page
        imdbHomePage.searchMovie(movieName);

        //Click on movie name by link text
        basePage.clickOnMovie(movieName);


        //Fetch origin country and release date of movie and store in some variable to parse the date,month and year
        String countryOfOriginIMDB =  imdbMovieDetailsPage.getOriginCountryOfMovie();
        String releaseDateIMDB = imdbMovieDetailsPage.getReleaseDateOfMovie();

        //parse date, month, year of the month and store in hashmap for later comparison
        movieDetailsIMDB = fetchDataIMDB(releaseDateIMDB);

        //Open wikipedia home page in same tab and verify title of the page
        basePage.openUrl(configFileReader.getUrl(Constant.WIKI_URL));
        Assert.assertEquals(basePage.getTitle(),Constant.WIKI_TITLE,"this is not wiki pedia home page");

        //Search for any movie on home page
        wikiPediaHomePage.searchMovie(movieName);

        //Click on movie name by link text
        basePage.clickOnMovie(movieName);
        wikiPediaMovieDetailsPage.waitForMovieDetailsPageToLoad();

        //Fetch origin country and release date of movie and store in some variable to parse the date,month and year
        String countryOfOriginWiki =  wikiPediaMovieDetailsPage.getOriginCountryOfMovie();
        String releaseDateWiki =  wikiPediaMovieDetailsPage.getReleaseDateOfMovie();

        //parse date, month, year of the month and store in hashmap for later comparison
        movieDetailsWikipedia = fetchDataWikiPedia(releaseDateWiki);

        //Compare day, month, year of release and origin of country from IMDB and Wikipedia sources
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(countryOfOriginIMDB,countryOfOriginWiki,"Country is not same");
        softAssert.assertEquals(movieDetailsIMDB.get("day"),movieDetailsWikipedia.get("day"),"Day is not same");
        softAssert.assertEquals(movieDetailsIMDB.get("month"),movieDetailsWikipedia.get("month"),"Month is not same");
        softAssert.assertEquals(movieDetailsIMDB.get("year"),movieDetailsWikipedia.get("year"),"Year is not same");
        softAssert.assertAll();


    }


@AfterClass
    public void tearDown(){
        driver.quit();
}





}
