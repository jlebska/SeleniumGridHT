package org.epam.poland.aqa.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindStorePage extends BasePage {

    protected FindStorePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getCountry() {
        WebElement country = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),\"Poland\")]")));
        return country.getText();
    }

}
