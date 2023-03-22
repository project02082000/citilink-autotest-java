package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.qameta.allure.Allure.step;

public class MainPage {


    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Locators

    @FindBy(xpath = "//button[@data-meta-name='DesktopHeaderFixed__catalog-menu']")
    private WebElement btnCatalog;

    @FindBy(xpath = "//div[@class=\"css-e9jgwe emy7mzo0\"]//a[@href=\"/catalog/noutbuki-i-kompyutery/?ref=mainmenu\"]")
    private WebElement btnLaptopsPc;

    @FindBy(xpath = "//span[@class='e1ys5m360 e106ikdt0 css-1bu1ack e1gjr6xo0'][1]")
    private WebElement btnLaptops;


    // Actions

    public void clickCatalog() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnCatalog));
        btnCatalog.click();
    }

    public void moveToLaptopsPc() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnLaptopsPc));
        Actions action = new Actions(driver);
        action.moveToElement(btnLaptopsPc).perform();
    }

    public void clickLaptops(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btnLaptops));
        btnLaptops.click();
    }

    // Methods

    public void chooseLaptopsSection(){
        step("Choose section with laptops");
        clickCatalog();
        moveToLaptopsPc();
        clickLaptops();
    }
}
