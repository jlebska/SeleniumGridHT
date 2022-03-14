package org.epam.poland.aqa.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartingPage extends BasePage {

    @FindBy(xpath = "//a[@data-name=\"Poland\"]")
    private WebElement polandButton;

    public StartingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public StartingPage open() {
        webDriver.get("https://www.hm.com/");
        return this;
    }

    public MainPage pickCountry() {
        polandButton.click();
        return new MainPage(webDriver);
    }

    public String getCountry() {
        return polandButton.getText();
    }


}
