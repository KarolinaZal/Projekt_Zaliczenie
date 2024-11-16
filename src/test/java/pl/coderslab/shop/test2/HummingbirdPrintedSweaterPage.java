package pl.coderslab.shop.test2;

import org.junit.platform.suite.api.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HummingbirdPrintedSweaterPage {
    WebDriver driver;

    public HummingbirdPrintedSweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"group_1\"]")
    private WebElement sizeList; // lista rozwijana do zmiany rozmiaru

    @FindBy(id="quantity_wanted")
    private WebElement quantityInput;

    @FindBy(xpath="//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement addToCartBtm;

    // szukam M, czyli najpierw rozwijam liste potem wskauzje sciezke do M i w nia klikam.
    public void chooseSize() {
        sizeList.click();
        WebElement sizeMOption = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
        sizeMOption.click();
    }

    //czyszczenie pola i wpisanie ilosci jaka chce
    public void chooseQuantity(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(quantityInput));
        if (quantityInput.isDisplayed() && quantityInput.isEnabled()) {
            Actions actions = new Actions(driver);
            actions.moveToElement(quantityInput)
                    .click() // Kliknij, aby uzyskać fokus na polu
                    .sendKeys(Keys.CONTROL + "a") // Zaznacz cały tekst
                    .sendKeys(Keys.BACK_SPACE) // Usuń zaznaczony tekst
                    .sendKeys("5") // Wprowadź nową wartość
                    .perform();

//            quantityInput.clear();
//            quantityInput.sendKeys("5");
        } else {
            System.out.println("Pole ilości jest niewidoczne lub zablokowane.");
        }

//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        quantityInput.clear();
//        quantityInput.sendKeys("5");

        addToCartBtm.click();

    }
}
