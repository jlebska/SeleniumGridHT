package org.epam.poland.aqa.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HerPage extends BasePage {

    //    @FindBy (xpath = "//a[contains(@href,\"bestsellery\")]")
    private WebElement bestsellersCategory;

    protected HerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BestsellersPage clickBestsellers() {
        bestsellersCategory = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,\"bestsellery\") and @role]")));
        bestsellersCategory.click();
        return new BestsellersPage(webDriver);
    }
}
