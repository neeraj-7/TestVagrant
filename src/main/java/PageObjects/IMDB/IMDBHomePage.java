package PageObjects.IMDB;

import PageObjects.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDBHomePage extends BasePage {

    public IMDBHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='suggestion-search']")
    private WebElement searchBox;

    @FindBy(xpath = "//h3[contains(text(),'Titles')]")
    private WebElement title;


    public void searchMovie(String movieName) {
        searchBox.isDisplayed();
        searchBox.sendKeys(movieName);
        searchBox.sendKeys(Keys.ENTER);
    }

    public boolean isTitleDisplayed() {
        return title.isDisplayed();
    }

}
