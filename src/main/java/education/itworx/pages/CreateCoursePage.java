package education.itworx.pages;

import education.itworx.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCoursePage extends BasePage {

    public CreateCoursePage(WebDriver driver) {
        super(driver);
        checkCorrectPage("btnSaveAsDraftCourse", "This is Not the Correct LogIn Page!");
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "txtCourseName")
    WebElement courseNameInput;

    @FindBy(id = "courseSubject")
    WebElement subjectDropdown;
    @FindBy(xpath = " //em[@class='lms-margin-end-5 lms-position-relative-imp']")
    WebElement selectGradeLocator;
    @FindBy(id = "courseGrade")
    WebElement singleGradeRadioBtn;
    @FindBy(id = "courseGrade")
    WebElement gradeDropdown;
    @FindBy(id = "teacherOnBehalf")
    WebElement teacherOnBehalfListDiv;

    @FindBy(id = "ui-select-choices-row-0-0")
    WebElement instructorNameInput;
    @FindBy(id = "rdFinalAssessment")
    WebElement finalAssessmentCriteria;

    @FindBy(xpath = "//i[@class='lms-position-relative-imp']")
    WebElement courseCompletionBtn;

    @FindBy(id = "btnSaveAsDraftCourse")
    WebElement createCourseBtn;

    // Methods

    public boolean isCreateCoursePageDisplayed()
    {
        return Utilities.isFieldDisplayed(createCourseBtn, wait);
    }

    public void setCourseName(String value)
    {
        Utilities.waitClearAndSetInputField(courseNameInput, value, wait);
    }

    public void setSubjectByVisibleText(String value)
    {
        Utilities.waitAndSelectByVisibleText(subjectDropdown, value, wait);
    }

    public void selectSingleGradeOption() {
        Utilities.waitAndClickOnWebElement(selectGradeLocator,wait);
    }
    public void setGradeByVisibleText(String value)
    {
        Utilities.waitAndSelectByVisibleText(gradeDropdown, value, wait);
    }
    public void openTeachersList()
    {
        Utilities.waitAndClickOnWebElement(teacherOnBehalfListDiv, wait);
    }
    public void scroll()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
    }
    public void selectTeacher()
    {
        Utilities.waitAndClickOnWebElement(instructorNameInput, wait);
    }
    public void selectCourseCriteria()
    {
        Utilities.waitAndClickOnWebElement(finalAssessmentCriteria, wait);
    }

    public void selectCourseCompletion()
    {
        Utilities.waitAndClickOnWebElement(courseCompletionBtn, wait);
    }


    public void createCourse() {
        Utilities.waitAndClickOnWebElement(createCourseBtn, wait);
    }

}
