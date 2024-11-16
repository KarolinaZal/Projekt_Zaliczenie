package pl.coderslab.shop.test2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "js-address-form")
    private WebElement chooseAddress; // pole adresu wybieranego

    @FindBy(name = "confirm-addresses")
    private WebElement addressContinueBtm; // przycisk continue po adresie

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/div/div[1]/div[1]/label/div/div[1]/div/div")
    private WebElement selfPickUpBtm; // pole jaka dostawa

    @FindBy(name = "confirmDeliveryOption")
    private WebElement picUpContinueBtm; // przycik continue po pick up

    @FindBy(xpath = "//*[@id=\"payment-option-1-container\"]/label/span")
    private WebElement payByCheckOption; // opcja pay by check

    @FindBy(name = "conditions_to_approve[terms-and-conditions]")
    private WebElement confirmBtm; // checkbox do zaznaczenia

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement placeOrderBtm; // przycisk place order

    public void setChooseAddress(){
        chooseAddress.click();
        addressContinueBtm.click();
    }

    public void setSelfPickUpBtm(){
        selfPickUpBtm.click();
        picUpContinueBtm.click();
    }

    public void paymentMethod(){
        payByCheckOption.click();
        confirmBtm.click();
        placeOrderBtm.click();
    }
}
