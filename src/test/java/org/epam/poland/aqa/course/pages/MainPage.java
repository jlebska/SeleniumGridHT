package org.epam.poland.aqa.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "onetrust-reject-all-handler")
    private WebElement cookiesButton;

    @FindBy(xpath = "//a[contains(@href,\"ona.html\")]")
    private WebElement categoryHer;

    @FindBy(xpath = "//*[@id=\"menu-links\"]/li[2]/ul/li[1]/a")
    private WebElement categoryBestsellers;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage closeCookiesAlert() {
        cookiesButton.click();
        return this;
    }

    public BestsellersPage openCategory() {
        categoryHer.click();
        categoryBestsellers.click();
        return new BestsellersPage(webDriver);
    }
}
