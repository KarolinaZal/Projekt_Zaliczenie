package pl.coderslab.shop.test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// strona główna do zalogowania

public class MainPage {
    private final WebDriver driver;

    @FindBy(className = "user-info")
    private WebElement signInButton; // guzik Sign In który trzeba kliknąć

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/div[2]/article/div/div[1]/a/img")
    private WebElement hummingbirdPrintedSweater; // zadanie 2 obrazek swetra do klikniecia

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSingIn() {
        signInButton.click();
    }

    public void enterSweater() {
        hummingbirdPrintedSweater.click();
    }
}
