package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static io.qameta.allure.Allure.step;
public class CartPage {


    public WebDriver driver;
    public String laptopNameCart;
    public int laptopPriceCart;
    public int additionalPrice;
    public int sumPrice;
    public int amountOfProduct;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Locators

    @FindBy(xpath = "//button[@title=\"Перейти к оформлению\"]")
    private WebElement goToCheckoutBtn;

    @FindBy(xpath = "//span[@class=\"e1ys5m360 e106ikdt0 css-175fskm e1gjr6xo0\"]")
    private WebElement laptopName;

    @FindBy(xpath = "//span[@class=\"css-0 eb8dq160\"]")
    private WebElement laptopPrice;

    @FindBy(xpath = "//span[@class=\"e1j9birj0 e106ikdt0 css-zmmgir e1gjr6xo0\"]")
    private WebElement sumPriceLocator;

    @FindBy(xpath = "//span[@class=\"e11v1gn60 css-389ojc elcxude0\"][1]")
    private WebElement additionalService;

    @FindBy(xpath = "//span[@class=\"e1j9birj0 e106ikdt0 css-xbfpj5 e1gjr6xo0\"][1]")
    private WebElement additionalServicePrice;

    @FindBy(xpath = "//input[@type=\"number\"]")
    private WebElement amountOfProductLocator;


    // Actions

    public void chooseAdditionalPrice(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(additionalService));
        additionalService.click();
    }

    public void setAmountOfProduct(String amount){
        amountOfProductLocator.clear();
        amountOfProductLocator.sendKeys(amount);
        laptopPrice.click();
    }

    public String saveLaptopName(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(laptopName));
        laptopNameCart = laptopName.getText();
        return laptopNameCart;
    }

    public int saveLaptopPrice(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(laptopPrice));
        String laptopPriceCart = laptopPrice.getText();
        laptopPriceCart = laptopPriceCart.replace("₽", "");
        laptopPriceCart = laptopPriceCart.replace(" ", "");
        this.laptopPriceCart = Integer.parseInt(laptopPriceCart);
        return this.laptopPriceCart;
    }

    public int saveAdditionalPrice(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(additionalServicePrice));
        String additionalPrice = additionalServicePrice.getText();
        additionalPrice = additionalPrice.replace(" ", "");
        additionalPrice = additionalPrice.replace("от", "");
        this.additionalPrice = Integer.parseInt(additionalPrice);
        return this.additionalPrice;
    }

    public int saveSumPrice(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(sumPriceLocator));
        String sumPrice = sumPriceLocator.getText();
        sumPrice = sumPrice.replace("₽", "");
        sumPrice = sumPrice.replace(" ", "");
        this.sumPrice = Integer.parseInt(sumPrice);
        return this.sumPrice;
    }

    public int saveAmountOfProduct(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(amountOfProductLocator));
        String amountOfProduct = amountOfProductLocator.getAttribute("value");
        this.amountOfProduct = Integer.parseInt(amountOfProduct);
        return this.amountOfProduct;
    }

    // Methods

    public void goToCheckout() {
        step("Go to checkout");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(goToCheckoutBtn));
        goToCheckoutBtn.click();
    }
}


