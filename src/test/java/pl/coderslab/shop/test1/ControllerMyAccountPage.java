package pl.coderslab.shop.test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// strona po zalogowaniu z your account i tam mam kliknac przyciks addresses

public class ControllerMyAccountPage {
    private final WebDriver driver;

    @FindBy(id="addresses-link")
    private WebElement addressesLinkBtm;

    public ControllerMyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void addressesLink() {
        addressesLinkBtm.click();
    }

}

