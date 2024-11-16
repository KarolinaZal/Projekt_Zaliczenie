package pl.coderslab.shop.test2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.coderslab.shop.test1.LoginPage;
import pl.coderslab.shop.test1.MainPage;
import pl.coderslab.shop.test1.YourAddressesPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class OrderTest {
    WebDriver driver;

    @Given("I'm on the shop main page")
    public void iOnShopMainPage() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");

        MainPage mainPage = new MainPage(driver);
        mainPage.enterSingIn();
    }

    @When("I'm sign in")
    public void iSignIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("wdedeamkeyjmpkmqxf@ytnhy.com", "1234qazWSX1234Zosia.");
    }


    @And("I choose and enter Hummingbird Printed Sweater")
    public void iChooseAndEnterHummingbirdPrintedSweater() {
        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.myStore();

        MainPage mainPage = new MainPage(driver);
        mainPage.enterSweater();
    }

    @And("I choose size")
    public void iChooseSize() {
        HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);
        hummingbirdPrintedSweaterPage.chooseSize();
    }

    @And("I choose quantity")
    public void iChooseQuantity() {
        HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);
        hummingbirdPrintedSweaterPage.chooseQuantity();
    }

    @And("I'm go to the checkout option")
    public void iMGoToTheCheckoutOption() {
        //driver.findElement(By.xpath("//*[@id="blockcart-modal"]/div/div/div[2]/div/div[2]/div/div/a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")));

        // Teraz możesz kliknąć lub interagować z tym elementem
        cartModal.click();
    }

    @And("I choose address")
    public void iChooseAddress() {
        // w koszyku klikam na guzik zeby zatwierdzic i isc dalej
        driver.findElement(By.xpath("//a[@href='https://mystore-testlab.coderslab.pl/index.php?controller=order']")).click();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setChooseAddress();
    }

    @And("I'm choose pickup method")
    public void iMChoosePickupMethod() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setSelfPickUpBtm();
    }

    @And("I'm choose payment method")
    public void iMChoosePaymentMethod() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.paymentMethod();
    }


    @Then("I'm take a screenshot of the order confirmation and the amount")
    public void iMTakeAScreenshotOfTheOrderConfirmationAndTheAmount() throws IOException {

        //Znalezc elementy na stronie : potwierdzenienie"your order is conformed" i kwota
        WebElement orderConfirmationElement = driver.findElement(By.xpath("//*[@id=\"content-hook_order_confirmation\"]/div/div/div"));
        WebElement amountElement = driver.findElement(By.xpath("//*[@id=\"order-items\"]/div[2]/table/tbody/tr[4]/td[1]"));
//zrzut ekranu
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//dodanie daty do nazwy pliku zeby nie nadpisywaly sie
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File destination = new File("screenshot_" + timestamp + ".png");
        //zapisanie w lokalizacji
        FileHandler.copy(screenshot, destination);

//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
//        DocFile FileUtils;
//        FileUtils.copyFile(screenshotFile, new File("order_confirmation.png"));
    }
// SPRAWDZIC TE SCREENSHOOTY!

//    @Then("I'm take a screenshot of the order confirmation and the amount")
//    public void iMTakeAScreenshotOfTheOrderConfirmationAndTheAmount() throws IOException {
//        // Czekaj, aż elementy będą widoczne
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Poczekaj na elementy "Potwierdzenie zamówienia" i "Kwota"
//        WebElement orderConfirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content-hook_order_confirmation\"]/div/div/div")));
//        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"order-items\"]/div[2]/table/tbody/tr[4]/td[1]")));
//
//        // Sprawdzenie, czy elementy są widoczne
//        if (orderConfirmationElement.isDisplayed() && amountElement.isDisplayed()) {
//            // Wykonaj zrzut ekranu
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//            // Dodaj datę do nazwy pliku, aby uniknąć nadpisania
//            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//            File screenshotFolder = new File("screenshots");  // Folder na screenshoty
//
//            // Jeśli folder nie istnieje, utwórz go
//            if (!screenshotFolder.exists()) {
//                screenshotFolder.mkdirs();
//            }
//
//            // Ścieżka do pliku zrzutu ekranu
//            File destination = new File(screenshotFolder, "screenshot_" + timestamp + ".png");
//
//            // Zapisz zrzut ekranu
//            FileHandler.copy(screenshot, destination);
//
//            // Opcjonalnie: Zaloguj pełną ścieżkę do pliku zrzutu ekranu
//            System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
//        } else {
//            System.out.println("Order confirmation or amount element not visible, screenshot not taken.");
//        }
//    }


    @And("I'm close browser")
    public void iMCloseBrowser() {
        driver.quit();
    }
}
