package education.itworx.pages;

import education.itworx.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        checkCorrectPage("btnLogin", "This is Not the Correct LogIn Page!");
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "Email")
    WebElement emailInput;

    @FindBy(id = "inputPassword")
    WebElement passwordInput;

    @FindBy(id = "btnLogin")
    WebElement signInButton;

    // Methods
    public void setSignInEmail(String value)
    {
        Utilities.waitClearAndSetInputField(emailInput, value, wait);
    }

    public void setSignInPassword(String value)
    {
        Utilities.waitClearAndSetInputField(passwordInput, value, wait);
    }

    public void clickOnSubmitBtn()
    {
        Utilities.waitAndClickOnWebElement(signInButton, wait);
    }

    public boolean isSubmitBtnDisplayed()
    {
        return Utilities.isFieldDisplayed(signInButton, wait);
    }

    public void login(String userEmail, String userPassword)
    {
        setSignInEmail(userEmail);
        setSignInPassword(userPassword);
        clickOnSubmitBtn();
    }
}
