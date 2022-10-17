package PageObjects.WikiPedia;

import PageObjects.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPediaHomePage extends BasePage {

    public WikiPediaHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBox;

    @FindBy(xpath = "//h3[contains(text(),'Titles')]")
    private WebElement title;


    public void searchMovie(String movie){
        searchBox.isDisplayed();
        searchBox.clear();
        searchBox.sendKeys(movie);
        searchBox.sendKeys(Keys.ENTER);
    }
}
