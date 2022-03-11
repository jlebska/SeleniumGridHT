package org.epam.poland.aqa.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BestsellersPage extends BasePage {

    @FindBy(xpath = "//ul[@class=\"products-listing small\"]/li[1]/article[1]/div[1]/a")
    private WebElement pickedItem;

    @FindBy(xpath = "//h1[@class=\"heading \"]")
    private WebElement pickedcategory;

    protected BestsellersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getCategory() {
        return pickedcategory.getText();
    }

    public ItemPage pickItem() {
        pickedItem.click();
        return new ItemPage(webDriver);
    }
}
