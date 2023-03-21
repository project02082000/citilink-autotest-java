package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.qameta.allure.Allure.step;

public class ProductPage {


    public WebDriver driver;
    public String laptopNameProductPage;
    public int laptopPriceProductPage;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Locators

    @FindBy(xpath = "//button[@data-meta-name='BasketDesktopButton']")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//button[@class='e4uhfkv0 css-10je9jt e4mggex0']")
    private WebElement btnGoToCart;

    @FindBy(xpath = "//h1[@class='e1ubbx7u0 eml1k9j0 app-catalog-tn2wxd e1gjr6xo0']")
    private WebElement laptopName;

    @FindBy(xpath = "//span[@class=\"e1j9birj0 e106ikdt0 app-catalog-1f8xctp e1gjr6xo0\"]")
    private WebElement laptopPrice;

    // Actions

    public void clickBtnAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        btnAddToCart.click();
    }

    public void clickBtnGoToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnGoToCart));
        btnGoToCart.click();
    }

    public String saveLaptopName(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(laptopName));
        laptopNameProductPage = laptopName.getText();
        return laptopNameProductPage;
    }

    public int saveLaptopPrice(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(laptopPrice));
        String laptopPriceProductPage = laptopPrice.getText();
        laptopPriceProductPage = laptopPriceProductPage.replace(" ", "");
        this.laptopPriceProductPage = Integer.parseInt(laptopPriceProductPage);
        return this.laptopPriceProductPage;
    }

    // Methods

    public void addAndGoToCart(){
        step("Add product and go to cart");
        clickBtnAddToCart();
        clickBtnGoToCart();
    }

}


