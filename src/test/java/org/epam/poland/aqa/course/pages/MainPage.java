package org.epam.poland.aqa.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {

    @FindBy(id = "onetrust-reject-all-handler")
    private List<WebElement> cookiesButton;

    //    @FindBy(xpath = "//a[contains(@href,\"ona.html\")]")
    private WebElement categoryHer;

    //    @FindBy(xpath = "//*[@id=\"menu-links\"]/li[2]/ul/li[1]/a")
    private WebElement categoryBestsellers;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage closeCookiesAlert() {
        if (cookiesButton.size() != 0) {
            cookiesButton.get(0).click();
        }
        return this;
    }

    public HerPage openHerCategory() {
        categoryHer = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,\"ona.html\")]")));
        categoryHer.click();
        return new HerPage(webDriver);
    }
}
