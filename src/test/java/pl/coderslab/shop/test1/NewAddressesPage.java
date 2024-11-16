package pl.coderslab.shop.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// strona z formularzem gdzie wpisuje dane do dodania nowego adresu i klikam przycisk create

public class NewAddressesPage {
private final WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasField;

    @FindBy(name = "address1")
    private WebElement addressField;

    @FindBy(id = "field-city")
    private WebElement cityField;

    @FindBy(name = "postcode")
    private WebElement postalCodeField;

    @FindBy(id = "field-id_country")
    private WebElement countrySelect;

    @FindBy(id = "field-phone")
    private WebElement phoneField;

    @FindBy(css = "button[name='submitAddress']")
    private WebElement saveAddressButton;

    public NewAddressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterAndCreateNewAddress(String alias, String address, String city, String postal, String country, String phone) {
        aliasField.clear();
        aliasField.sendKeys(alias);

        addressField.clear();
        addressField.sendKeys(address);

        cityField.clear();
        cityField.sendKeys(city);

        postalCodeField.clear();
        postalCodeField.sendKeys(postal);

        // Kliknij, aby otworzyć dropdown
       countrySelect.click();

        // Zlokalizuj opcję kraju
        WebElement countryOption = driver.findElement(By.xpath("//*[@id=\"field-id_country\"]"));
        countryOption.click(); // Kliknij na odpowiedni kraj

        phoneField.clear();
        phoneField.sendKeys(phone);

        saveAddressButton.click();
    }
}
