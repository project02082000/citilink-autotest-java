package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.qameta.allure.Allure.step;

public class LaptopsPage {

    public WebDriver driver;

    public LaptopsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Locators

    @FindBy(xpath = "//div[@data-meta-name=\"FilterListGroupsLayout\"]//input[@name=\"input-min\"]")
    private WebElement minPrice;

    @FindBy(xpath = "//div[@data-meta-name=\"FilterListGroupsLayout\"]//input[@name=\"input-max\"]")
    private WebElement maxPrice;

    @FindBy(xpath = "//button[@class=\"e4uhfkv0 css-1jfe691 e4mggex0\"]")
    private WebElement cookies;

    @FindBy(xpath = "//div[@data-meta-value=\"4,5 и выше\"]")
    private WebElement reviewsButton;

    @FindBy(xpath = "//div[@data-meta-value='Core i5']")
    private WebElement processor1;

    @FindBy(xpath = "//div[@data-meta-value='Core i7']")
    private WebElement processor2;

    @FindBy(xpath = "//div[@data-meta-value='15 \"']")
    private WebElement screenSize;

    @FindBy(xpath = "//div[@data-meta-value='16 ГБ']")
    private WebElement ramSize;

    @FindBy(xpath = "//div[@class=\"app-catalog-v4lp2l eetttp30\"]")
    private WebElement showProductsButton;

    @FindBy(xpath = "//button[@class=\"app-catalog-ud4v0n esgsbwb0\"][2]")
    private WebElement sortedByReviews;

    @FindBy(xpath = "//a[@class=\"app-catalog-fjtfe3 e1lhaibo0\"][1]")
    private WebElement laptop;

    // Actions

    public void chooseMinPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(minPrice));
        minPrice.clear();
        minPrice.sendKeys("100000");
    }

    public void chooseMaxPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(maxPrice));
        maxPrice.clear();
        maxPrice.sendKeys("200000");
    }

    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(cookies));
        cookies.click();
    }

    public void clickReviewsButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(reviewsButton));
        reviewsButton.click();
    }

    public void chooseProcessor1() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(processor1));
        processor1.click();
    }

    public void chooseProcessor2() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(processor2));
        processor2.click();
    }

    public void chooseScreenSize() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(screenSize));
        screenSize.click();
    }

    public void chooseRam() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ramSize));
        ramSize.click();
    }

    public void clickShowProductButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(showProductsButton));
        showProductsButton.click();
    }

    public void clickSortedByReviews() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(sortedByReviews));
        sortedByReviews.click();
    }

    public void chooseLaptop() {
        step("Choose first laptop");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(laptop));
        driver.get(laptop.getAttribute("href"));
    }

    // Methods

    public void setFilters(){
        step("Add laptop's filters");
        acceptCookies();
        chooseMinPrice();
        chooseMaxPrice();
        clickReviewsButton();
        chooseScreenSize();
        chooseRam();
        chooseProcessor1();
        chooseProcessor2();
        clickShowProductButton();
        clickSortedByReviews();
    }
}


