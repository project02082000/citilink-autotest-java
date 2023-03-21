package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.*;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModuleTest {

    public static WebDriver driver;
    public static LaptopsPage laptopsPage;
    public static ProductPage productPage;
    public static CartPage cartPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        laptopsPage = new LaptopsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        driver.manage().window().maximize();
        driver.get("https://www.citilink.ru/catalog/noutbuki/");
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    @Owner("Ilya Butkovskiy")
    @Description("Calculate total order cost when additional service is added")
    @Severity(SeverityLevel.NORMAL)
    void testPriceWhenAdditionalServiceAdded() throws InterruptedException {
        laptopsPage.acceptCookies();
        laptopsPage.chooseLaptop();

        productPage.addAndGoToCart();

        cartPage.saveLaptopPrice();
        System.out.print("\nproductPrice: " + cartPage.saveLaptopPrice() + "\n");
        cartPage.chooseAdditionalPrice();
        cartPage.saveAdditionalPrice();
        System.out.print("additionalServicePrice: " + cartPage.saveAdditionalPrice() + "\n");

        Thread.sleep(2000);

        cartPage.saveSumPrice();
        System.out.print("totalCost: " + cartPage.saveSumPrice() + "\n\n");

        step("Check that total order cost matches the expected one");
        assertThat(cartPage.laptopPriceCart + cartPage.additionalPrice)
                .describedAs("Total order cost doesn't match the expected one")
                .isEqualTo(cartPage.sumPrice);
    }

    @Test
    @Owner("Ilya Butkovskiy")
    @Description("Calculate total order cost when several copies of product are added")
    @Severity(SeverityLevel.NORMAL)
    void testPriceWhenMultipleCopiesOfProductAdded() throws InterruptedException {
        laptopsPage.acceptCookies();
        laptopsPage.chooseLaptop();

        productPage.addAndGoToCart();

        int productPrice = cartPage.saveLaptopPrice();
        System.out.print("\nproductPrice: " + productPrice + "\n");

        int amountInt = (int) (Math.random() * 9 + 1);
        String amount = Integer.toString(amountInt);
        cartPage.setAmountOfProduct(amount);

        Thread.sleep(3000);

        int amountOfProduct = cartPage.saveAmountOfProduct();
        System.out.print("amountOfProduct: " + amountOfProduct + "\n");

        int expectedResult = cartPage.saveLaptopPrice();
        System.out.print("totalCost: " + expectedResult + "\n\n");

        step("Check that total order cost matches the expected one");
        assertThat(productPrice * amountOfProduct)
            .describedAs("Total order cost doesn't match the expected one")
                .isEqualTo(expectedResult);
    }
}
