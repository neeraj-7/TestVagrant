package PageObjects.IMDB;

import PageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IMDBMovieDetailsPage extends BasePage {

    public IMDBMovieDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Country of origin')]/parent::li/child::div/ul/li/a")
    private WebElement countryName;

    @FindBy(xpath = "//a[contains(text(),'Release date')]/parent::li/div/ul/li/a")
    private WebElement releaseDate;

    @FindBy(xpath = "//div[@data-testid='hero-subnav-bar-left-block']")
    private WebElement rating;
    public String getOriginCountryOfMovie(){
        countryName.isDisplayed();
        return countryName.getText();
    }

    public String getReleaseDateOfMovie(){
        releaseDate.isDisplayed();
        return releaseDate.getText();
    }

    public void waitForMovieDetailsPageToLoad(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(rating));
    }
}
