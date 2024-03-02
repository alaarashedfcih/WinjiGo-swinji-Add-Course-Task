package education.itworx;

import education.itworx.BaseTest;
import education.itworx.dataproviderobjects.CourseData;
import education.itworx.pages.CoursePage;
import education.itworx.pages.CoursesPage;
import education.itworx.pages.CreateCoursePage;
import education.itworx.pages.HomePage;
import education.itworx.utilities.DataProviderSource;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;


public class CourseCreationTest extends BaseTest {
    SoftAssert softAssert;
    HomePage homePage;
    CoursesPage coursesPage;
    CreateCoursePage createCoursePage;
    CoursePage coursePage;

    @BeforeMethod(alwaysRun = true)
    public synchronized void setUp() throws MalformedURLException {
        super.setUpLogin();
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isCoursesBtnDisplayed(), "My Courses Button is not displayed");
        homePage.clickOnCoursesBtn();
        coursesPage = new CoursesPage(driver);
        softAssert.assertTrue( coursesPage.isCoursesPageDisplayed(), "My Courses Page is not displayed");

    }
    @Test(alwaysRun = true, dataProvider = "CreateCourseDataFeed", dataProviderClass = DataProviderSource.class)
    public void validateCourseCreationTest(CourseData data) {

        // Navigate to Create Course page
        coursesPage.navigateToCreateCoursePage();
        createCoursePage = new CreateCoursePage(driver);
        softAssert.assertTrue( createCoursePage.isCreateCoursePageDisplayed(), "Create Course Page is not displayed");
        // Fill course basic info and save
        createCoursePage.setCourseName(data.getCourseName());
        createCoursePage.setSubjectByVisibleText(data.getSubject());
        createCoursePage.selectSingleGradeOption();
        createCoursePage.setGradeByVisibleText(data.getGrade());
        createCoursePage.scroll();
        createCoursePage.openTeachersList();
        createCoursePage.selectTeacher();
        createCoursePage.selectCourseCompletion();
        createCoursePage.createCourse();

        coursePage = new CoursePage(driver);
        softAssert.assertTrue( coursePage.isCreatedCoursePageDisplayed(), "Created Course Page is not displayed");
        // Assert course title is displayed
        homePage.clickOnCoursesBtn();
        coursesPage.searchForCreatedCourse(data.getCourseName());
        softAssert.assertTrue(coursesPage.isCreatedCourseDisplayed(), "Created Course Link is not Displayed");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        coursesPage.navigateToCreatedCoursePage();
        coursePage.navigateToManageCourseList();
        coursePage.deleteCreatedCourse();
        coursePage.confirmDeletion();

    }
}
