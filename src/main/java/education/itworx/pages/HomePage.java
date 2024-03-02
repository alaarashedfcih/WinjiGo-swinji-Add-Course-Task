package education.itworx.pages;

import education.itworx.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
        checkCorrectPage("btnMyCoursesList", "This is Not the Correct LogIn Page!");
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "btnMyCoursesList")
    WebElement myCoursesBtn;

    public void clickOnCoursesBtn()
    {
        Utilities.waitAndClickOnWebElement(myCoursesBtn, wait);
    }

    public boolean isCoursesBtnDisplayed()
    {
        return Utilities.isFieldDisplayed(myCoursesBtn, wait);
    }
}
