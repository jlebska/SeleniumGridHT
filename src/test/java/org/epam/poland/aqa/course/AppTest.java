package org.epam.poland.aqa.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.epam.poland.aqa.course.pages.StartingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class AppTest {

    public WebDriver driver;

    @Parameters("browser")

    @BeforeClass
    public void beforeTest(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    @Test
    public void countryPresentTest() {
        StartingPage startingPage = new StartingPage(driver);
        String country = startingPage
                .open()
                .getCountry();
        Assert.assertEquals(country, "Poland | Polska", "Poland not present");
    }

    @Test
    public void correctCategoryTest() {
        StartingPage startingPage = new StartingPage(driver);
        String category = null;
        if (driver instanceof ChromeDriver) {
            category = startingPage
                    .open()
                    .pickCountry()
                    .closeCookiesAlert()
                    .openHerCategory()
                    .clickBestsellers()
                    .getCategory();
        } else if (driver instanceof FirefoxDriver) {
            category = startingPage
                    .open()
                    .pickCountry()
                    .openHerCategory()
                    .clickBestsellers()
                    .getCategory();
        }
        Assert.assertEquals(category, "BESTSELLERY", "Picked category is not correct");
    }

    @Test
    public void addingToCartTest() {
        StartingPage startingPage = new StartingPage(driver);
        String size = null;
        if (driver instanceof ChromeDriver) {
            size = startingPage
                    .open()
                    .pickCountry()
                    .closeCookiesAlert()
                    .openHerCategory()
                    .clickBestsellers()
                    .pickItem()
                    .pickSize()
                    .addToCart()
                    .goToCart()
                    .getSize();
        } else if (driver instanceof FirefoxDriver) {
            size = startingPage
                    .open()
                    .pickCountry()
                    .openHerCategory()
                    .clickBestsellers()
                    .pickItem()
                    .pickSize()
                    .addToCart()
                    .goToCart()
                    .getSize();
        }
        Assert.assertEquals(size, "M", "Incorrect size of item in the cart");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
