package org.epam.poland.aqa.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'trigger small')]")
    private WebElement sizeOptions;

    //    @FindBy (xpath = "//button[contains(@class,\"buy\")]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[contains(@class,\"shoppingbag\")]")
    private WebElement numberOfItemsInCart;

    private WebElement pickedSize;

    //    @FindBy(xpath = "//*[contains(@class,\"goto\")]")
    private WebElement shoppingCartButton;

    protected ItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ItemPage pickSize() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,350)", "");
        sizeOptions.click();
        pickedSize = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class =\"option \"]/*[text()=\"M\"]")));
        pickedSize.click();

        return this;
    }

    public ItemPage addToCart() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,350)", "");
        addToCartButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,\"buy\")]")));
        addToCartButton.click();

        return this;
    }

    public CartPage goToCart() {
        webDriver.navigate().refresh();
        shoppingCartButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,\"goto\")]")));
        shoppingCartButton.click();
        return new CartPage(webDriver);
    }

}
