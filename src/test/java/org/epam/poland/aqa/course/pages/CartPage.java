package org.epam.poland.aqa.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {
    //    @FindBy(xpath = "(//*[text()=\"Rozmiar:\"]/parent::*/parent::*/span[2]")
    private WebElement size;

    protected CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getSize() {
        size = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Rozmiar:\"]/parent::*/parent::*/span[2]")));
        return size.getText();
    }
}
