package org.epam.poland.aqa.course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.epam.poland.aqa.course.pages.StartingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AppTest {

    private WebDriver driver;

    //    @Parameters({"platform","browser","version","node"})
    @BeforeTest
    public void profileSetUp() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        if (platform.equalsIgnoreCase("Windows")){
//            caps.setPlatform(Platform.WINDOWS);
//        }
//        if (browser.equalsIgnoreCase("Internet Explorer")){
//            caps = DesiredCapabilities.chrome();
//        }
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
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
        String category = startingPage
                .open()
                .pickCountry()
                .closeCookiesAlert()
                .openCategory()
                .getCategory();
        Assert.assertEquals(category, "BESTSELLERY", "Picked category is not correct");
    }

    @Test
    public void addingToCartTest() {
        StartingPage startingPage = new StartingPage(driver);
        String size = startingPage
                .open()
                .pickCountry()
                .closeCookiesAlert()
                .openCategory()
                .pickItem()
                .pickSize()
                .addToCart()
                .goToCart()
                .getSize();
        Assert.assertEquals(size, "M", "Incorrect size of item in the cart");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
