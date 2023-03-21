package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.qameta.allure.Allure.step;

public class ShopChoicePage {


    public WebDriver driver;

    public ShopChoicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Locators

    @FindBy(xpath = "//div[@class=\"OrderDeliveryCard__change\"][1]")
    private WebElement shop;

    @FindBy(xpath = "//button[@class=\"e1tiqnd20 css-1oq0lvh e4mggex0\"]")
    private WebElement shop2;

    // Actions

    public void choosePickupPoint() {
        step("Choose shop");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.visibilityOf(shop));
            shop.click();
        } catch (Exception timeoutException) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(shop2));
            shop2.click();
        }
    }

}


