package org.epam.poland.aqa.course.tests;

import org.epam.poland.aqa.course.pages.StartingPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;


public class AppTest {

    public WebDriver driver;

    @Parameters("browser")

    @BeforeClass
    public void beforeTest(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("firefox")) {
            String url = "http://localhost:4444";
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("firefox");
            desiredCapabilities.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver((new URL(url)), desiredCapabilities);
        } else if (browser.equalsIgnoreCase("chrome")) {
            String url = "http://localhost:4444";
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("chrome");
            desiredCapabilities.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver((new URL(url)), desiredCapabilities);
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
    public void correctLangTest() {
        StartingPage startingPage = new StartingPage(driver);
        boolean correctLang = startingPage
                .open()
                .pickCountry()
                .checkLang();
        Assert.assertTrue(correctLang, "The language is not correct");
    }

    @Test
    public void findingStoreInCountryTest() {
        StartingPage startingPage = new StartingPage(driver);
        String correctCountry = startingPage
                .open()
                .pickCountry()
                .goToFindStore()
                .getCountry();
        Assert.assertEquals(correctCountry, "Poland", "The country is not correct");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
