package pl.coderslab.shop.test1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShopNewAddressesCreate {
    WebDriver driver;

    @Given("I'm on shop main page")
    public void iOnShopMainPage() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");

        MainPage mainPage = new MainPage(driver);
        mainPage.enterSingIn();
    }

    @When("I sign in")
    public void iSignIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("wdedeamkeyjmpkmqxf@ytnhy.com", "1234qazWSX1234Zosia.");
    }

    @And("I enter a bottom Addresses")
    public void iEnterABottomAddresses() {
        ControllerMyAccountPage controllerMyAccountPage = new ControllerMyAccountPage(driver);
        controllerMyAccountPage.addressesLink();

    }

    @And("I enter create a new address")
    public void iEnterCreateANewAddress() {
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.addNewAddress();

    }

    @And("I enter {string} {string} {string} {string} {string} {string}")
    public void iEnterNewAddress(String alias, String address, String city, String postal, String country, String phone) {
        driver.findElement(By.id("field-alias")).sendKeys(alias);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.id("field-city")).sendKeys(city);
        driver.findElement(By.name("postcode")).sendKeys(postal);
        driver.findElement(By.id("field-id_country")).sendKeys(country);
        driver.findElement(By.id("field-phone")).sendKeys(phone);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();

    }

    @Then("I can see success message with text {string}")
    public void iCanSeeSuccessMessageWithText(String text) {
        WebElement alert = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
        String alertText = alert.getText();
        Assertions.assertEquals(text, alertText);

    }

    @And("I verify created address {string} {string} {string} {string} {string} {string}")
    public void iVerifyCreatedAddress(String alias, String address, String city, String postal, String country, String phone) {
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        String addressText = yourAddressesPage.getFirstAddressAsText();
        // Spodziewany adres - połączony w taki sposób, jak jest wprowadzany do formularza
        String expectedAddress = alias + "\n" + address + "\n" + city + "\n" + postal + "\n" + country + "\n" + phone;

        // Usunięcie tagów <br> i zamiana na "\n" (nowa linia)
        String cleanedAddressText = addressText.replaceAll("<br>", "\n").trim();

        // Asercja porównująca oczekiwany adres z oczyszczonym tekstem
        Assertions.assertEquals(expectedAddress, cleanedAddressText, "Adres nie został dodany poprawnie!");

    }
    @And("I'm delete created address")
    public void iMDeleteCreatedAddress() {
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.deleteAddress();
    }

    // zamykanie WebDrivera po każdym teście
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
