package pl.coderslab.shop.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// strona gdzie wyswietlaja się dodane adresy i mam kliknac guzik create new address

public class YourAddressesPage {
    private final WebDriver driver;


    @FindBy(css = "[data-link-action='add-address']")
    private WebElement newAddressBtn;

    @FindBy(className = "address-body")
    private List<WebElement> addresses;

    @FindBy(xpath = "//*[@data-link-action='delete-address']")
    private WebElement deleteBtm; // przycisk do usunięcia adresu

    @FindBy(id = "_desktop_logo")
    private WebElement logo; // logo mystore do powrotu na głowna strone

    public YourAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress() {
        newAddressBtn.click();
    }

    public String getFirstAddressAsText() {
        if (addresses.isEmpty()) {
            return "No addresses available"; // W przypadku braku adresów
        }
        WebElement address = addresses.get(0);
        String addressText = address.findElement(By.xpath("//*[@id=\"address-16416\"]/div[1]/address")).getText();
        return addressText;
    }

    // usunięcie dodanego adresu
    public void deleteAddress() {
        deleteBtm.click();
    }

    //metoda do klikniecia logo zeby wrocic na strone głowna
    public void myStore(){
        logo.click();
    }
}

