package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.*;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class E2ETest {

    public static WebDriver driver;
    public static MainPage mainPage;
    public static LaptopsPage laptopsPage;
    public static ProductPage productPage;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;
    public static ShopChoicePage shopChoicePage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        mainPage = new MainPage(driver);
        laptopsPage = new LaptopsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        shopChoicePage = new ShopChoicePage(driver);

        driver.manage().window().maximize();
        driver.get("https://www.citilink.ru/");
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    @Owner("Ilya Butkovskiy")
    @Description("Product purchase")
    @Severity(SeverityLevel.CRITICAL)
    void test_buy_product() {
        mainPage.chooseLaptopsSection();

        laptopsPage.setFilters();
        laptopsPage.chooseLaptop();

        productPage.saveLaptopName();
        productPage.saveLaptopPrice();
        System.out.print("\nlaptopNameProductPage: " + productPage.laptopNameProductPage + "\n");
        System.out.print("laptopPriceProductPage: " + productPage.laptopPriceProductPage + "\n\n");
        productPage.addAndGoToCart();

        cartPage.saveLaptopName();
        cartPage.saveLaptopPrice();
        System.out.print("laptopNameCart: " + cartPage.laptopNameCart + "\n");
        System.out.print("laptopPriceCart: " + cartPage.laptopPriceCart + "\n\n");

        step("Check that info on Cart Page matches info on Product Page");
        assertThat(cartPage.laptopNameCart)
                .describedAs("Laptop's name on Cart Page doesn't match name on Product Page")
                .isEqualTo(productPage.laptopNameProductPage);
        assertThat(cartPage.laptopPriceCart)
                .describedAs("Laptop's price on Cart Page doesn't match price on Product Page")
                .isEqualTo(productPage.laptopPriceProductPage);

        cartPage.goToCheckout();

        try {
            checkoutPage.saveLaptopName();
            checkoutPage.saveLaptopPrice();
            checkoutPage.saveSumPrice();
        } catch (Exception timeoutException) {
            checkoutPage.saveLaptopName2();
            checkoutPage.saveLaptopPrice2();
            checkoutPage.saveSumPrice2();
        }

        System.out.print("laptopNameCheckout: " + checkoutPage.laptopNameCheckout + "\n");
        System.out.print("laptopPriceCheckout: " + checkoutPage.laptopPriceCheckout + "\n\n");

        String laptopNameProductPage = productPage.laptopNameProductPage.replaceAll(" \\d*.\\d*ГГц", "");
        laptopNameProductPage = laptopNameProductPage.replaceAll(" \\[.*\\]", "");
        List<String> laptopNameProductPageList = List.of(laptopNameProductPage.split(" "));
        List <String> laptopNameCheckoutList = List.of(checkoutPage.laptopNameCheckout.split(" "));

        step("Check that info on Checkout Page matches info on Product Page");
        assertThat(laptopNameCheckoutList)
                .describedAs("Laptop's name on Checkout Page doesn't match name on Product Page")
                .isSubsetOf(laptopNameProductPageList);
        assertThat(checkoutPage.laptopPriceCheckout)
                .describedAs("Laptop's price on Checkout Page doesn't match price on Product Page")
                .isEqualTo(productPage.laptopPriceProductPage);

        checkoutPage.inputPersonalInfo();

        shopChoicePage.choosePickupPoint();

        step("Check that final price on Checkout Page matches price on Product Page");
        assertThat(checkoutPage.laptopPriceCheckout)
                .describedAs("Laptop's final price on Checkout Page doesn't match price on Product Page")
                .isEqualTo(productPage.laptopPriceProductPage);
    }
}
