package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.qameta.allure.Allure.step;

public class CheckoutPage {

    public String laptopNameCheckout;
    public int laptopPriceCheckout;
    public int sumPrice;

    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Locators
    @FindBy(xpath = "//input[@name=\"firstName\"]")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name=\"contact-form_firstName\"]")
    private WebElement firstName2;

    @FindBy(xpath = "//input[@name=\"lastName\"]")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name=\"contact-form_lastName\"]")
    private WebElement lastName2;

    @FindBy(xpath = "//input[@name=\"phone\"]")
    private WebElement phone;

    @FindBy(xpath = "//input[@name=\"contact-form_phone\"]")
    private WebElement phone2;

    @FindBy(xpath = "//input[@name=\"additionalPhone\"]")
    private WebElement additionalPhone;

    @FindBy(xpath = "//input[@name=\"contact-form_additionalPhone\"]")
    private WebElement additionalPhone2;

    @FindBy(xpath = "//div[@class=\"TooltipCheckout\"]")
    private WebElement pickupPoint;

    @FindBy(xpath = "//button[@class=\"e4uhfkv0 css-1n36vh3 e4mggex0\"]")
    private WebElement pickupPoint2;

    @FindBy(xpath = "//span[@class=\"e1j9birj0 e106ikdt0 css-1nj39i9 e1gjr6xo0\"]")
    private WebElement sumPriceLocator;

    @FindBy(xpath = "//span[@class=\"e1j9birj0 e106ikdt0 css-1f8xctp e1gjr6xo0\"]")
    private WebElement sumPriceLocator2;

    @FindBy(xpath = "//div[@class=\"CheckoutLayout__aside\"]//span[@class=\"e1wd4glt0 e106ikdt0 css-otysme-StyledProductItemTitle e1gjr6xo0\"]")
    private WebElement laptopName;

    @FindBy(xpath = "//div[@class=\"e1352qzt0 css-1523u2l e1loosed0\"]//span[@class=\"ecy4qjt0 e106ikdt0 css-1qo2d1j e1gjr6xo0\"]")
    private WebElement laptopName2;

    @FindBy(xpath = "//div[@class=\"CheckoutLayout__aside\"]//span[@class=\"e1j9birj0 e106ikdt0 css-1b0ueat e1gjr6xo0\"]")
    private WebElement laptopPrice;

    @FindBy(xpath = "//div[@class=\"e1352qzt0 css-1523u2l e1loosed0\"]//span[@class=\"e1j9birj0 e106ikdt0 css-175fskm e1gjr6xo0\"]")
    private WebElement laptopPrice2;


    // Actions
    public void inputFirstName() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys("Илья");
    }

    public void inputFirstName2() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(firstName2));
        firstName2.sendKeys("Илья");
    }

    public void inputLastName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys("Бутковский");
    }

    public void inputLastName2() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(lastName2));
        lastName2.sendKeys("Бутковский");
    }

    public void inputPhone() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(phone));
        phone.sendKeys("9161494793");
    }

    public void inputPhone2() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(phone2));
        phone2.sendKeys("9161494793");
    }

    public void inputAdditionalPhone() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(additionalPhone));
        additionalPhone.sendKeys("88005553535");
    }

    public void inputAdditionalPhone2() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(additionalPhone2));
        additionalPhone2.sendKeys("88005553535");
    }

    public void clickPickupPoint() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(pickupPoint));
        pickupPoint.click();
    }

    public void clickPickupPoint2() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(pickupPoint2));
        pickupPoint2.click();
    }

    public String saveLaptopName() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(laptopName));
        laptopNameCheckout = laptopName.getText();
        return laptopNameCheckout;
    }

    public String saveLaptopName2() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(laptopName2));
        laptopNameCheckout = laptopName2.getText();
        return laptopNameCheckout;
    }

    public int saveLaptopPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(laptopPrice));
        String laptopPriceCheckout = laptopPrice.getText();
        laptopPriceCheckout = laptopPriceCheckout.replace(" ", "");
        this.laptopPriceCheckout = Integer.parseInt(laptopPriceCheckout);
        return this.laptopPriceCheckout;
    }

    public int saveLaptopPrice2() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(laptopPrice2));
        String laptopPriceCheckout = laptopPrice2.getText();
        laptopPriceCheckout = laptopPriceCheckout.replace(" ", "");
        this.laptopPriceCheckout = Integer.parseInt(laptopPriceCheckout);
        return this.laptopPriceCheckout;
    }

    public int saveSumPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(sumPriceLocator));
        String sumPrice = sumPriceLocator.getText();
        sumPrice = sumPrice.replace(" ", "");
        this.sumPrice = Integer.parseInt(sumPrice);
        return this.laptopPriceCheckout;
    }

    public int saveSumPrice2() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(sumPriceLocator2));
        String sumPrice = sumPriceLocator2.getText();
        sumPrice = sumPrice.replace(" ", "");
        this.sumPrice = Integer.parseInt(sumPrice);
        return this.laptopPriceCheckout;
    }

    //Methods
    public void inputPersonalInfo() {
        step("Input personal info");
        try {
            inputFirstName();
            inputLastName();
            inputPhone();
            inputAdditionalPhone();
            clickPickupPoint();
        } catch (Exception timeoutException) {
            inputFirstName2();
            inputLastName2();
            inputPhone2();
            inputAdditionalPhone2();
            clickPickupPoint2();
        }
    }

}


