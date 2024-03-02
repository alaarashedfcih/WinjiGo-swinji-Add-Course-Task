package education.itworx.pages;

import education.itworx.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursesPage extends BasePage {

    public CoursesPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("btnListAddCourse", "This is Not the Correct Courses Page!");
        PageFactory.initElements(driver, this);
    }
    // Locators
    @FindBy(xpath = "//h1[contains(text(),'All Courses')]")
    WebElement myCoursesHeader;

    @FindBy(id = "btnListAddCourse")
    WebElement createCourseBtn;

    @FindBy(id = "txtCourseSearch")
    WebElement courseSearchInput;

    @FindBy(id = "lnkListCourseSelcted")
    WebElement createdCourseLink;


    // Methods

    public boolean isCoursesPageDisplayed()
    {
        return Utilities.isFieldDisplayed(myCoursesHeader, wait);
    }

    public void navigateToCreateCoursePage()
    {
        Utilities.waitAndClickOnWebElement(createCourseBtn, wait);
    }

    public void searchForCreatedCourse(String value)
    {
        Utilities.waitAndSearchForItem(courseSearchInput, value,wait,driver);
    }

    public boolean isCreatedCourseDisplayed()
    {
        return Utilities.isFieldDisplayed(createdCourseLink, wait);
    }
    public void navigateToCreatedCoursePage()
    {
        Utilities.waitAndClickOnWebElement(createdCourseLink, wait);
    }


}
