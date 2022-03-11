package org.epam.poland.aqa.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HerPage extends BasePage{

    @FindBy (xpath = "//a[contains(@href,\"bestsellery\")]")
    private WebElement bestsellersCategory;

    protected HerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HerPage clickBestsellers(){
        bestsellersCategory.click();
        return new HerPage(webDriver);
    }
}
