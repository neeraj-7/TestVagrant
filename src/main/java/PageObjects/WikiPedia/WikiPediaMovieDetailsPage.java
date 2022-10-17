package PageObjects.WikiPedia;

import PageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WikiPediaMovieDetailsPage extends BasePage {

    public WikiPediaMovieDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//th[contains(text(),'Country')]/parent::tr/child::td")
    private WebElement countryName;

    @FindBy(xpath = "//div[contains(text(),'Release date')]/parent::th/following-sibling::td/div/ul/li")
    private WebElement releaseDate;

    @FindBy(id = "siteSub")
    private WebElement siteSub;


    public String getOriginCountryOfMovie(){
        releaseDate.isDisplayed();
        return countryName.getText();
    }

    public String getReleaseDateOfMovie(){
        releaseDate.isDisplayed();
        return releaseDate.getText();
    }

    public void waitForMovieDetailsPageToLoad(){

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(siteSub));
    }
}
