package org.epam.poland.aqa.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@lang=\"pl-PL\"]")
    private List<WebElement> lang;

    @FindBy(xpath = "//*[contains(@href,\"store-locator\")][1]")
    private WebElement findStoreButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkLang() {
        return lang.size() != 0;
    }

    public FindStorePage goToFindStore() {
        findStoreButton.click();

        return new FindStorePage(webDriver);
    }

}
