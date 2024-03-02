package education.itworx;

import education.itworx.pages.LoginPage;
import education.itworx.utilities.ConfigReader;
import education.itworx.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;


public class BaseTest {
    protected WebDriver driver;
    LoginPage loginPage;
    SoftAssert softAssert;

    @BeforeSuite(alwaysRun = true)
    public void setUpLogin() {

        // Set up WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open the Winjigo website
        driver.get(Constants.APPLICATION_HOST);
        // Login
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        softAssert.assertTrue(loginPage.isSubmitBtnDisplayed(), "Log in Page is not displayed");
        softAssert.assertAll();
        loginPage.login(ConfigReader.getUsername(),ConfigReader.getPassword());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
