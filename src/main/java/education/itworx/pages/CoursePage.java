package education.itworx.pages;

import education.itworx.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursePage extends BasePage {

    public CoursePage(WebDriver driver) {
        super(driver);
        checkCorrectPage("courseNameView", "This is Not the Correct Created Course Page!");
        PageFactory.initElements(driver, this);
    }
    // Locators
    @FindBy(id = "courseNameView")
    WebElement courseTitleHeading;

    @FindBy(id = "btnViewManageCourse")
    WebElement viewManageCourseBtn;

    @FindBy(id = "lnkDeleteCourse")
    WebElement deleteCourseBtn;
    @FindBy(id = "btnDialogOk")
    WebElement confirmDeletionPopUpBtn;


    // Methods

    public boolean isCreatedCoursePageDisplayed()
    {
        return Utilities.isFieldDisplayed(courseTitleHeading, wait);
    }

    public void navigateToManageCourseList()
    {
        Utilities.waitAndClickOnWebElement(viewManageCourseBtn, wait);
    }


    // Method to delete the course
    public void deleteCreatedCourse() {
        Utilities.waitAndClickOnWebElement(deleteCourseBtn, wait);
    }
    public void confirmDeletion() {
        Utilities.waitAndClickOnPopUpElement(confirmDeletionPopUpBtn, wait,driver);
    }
}
