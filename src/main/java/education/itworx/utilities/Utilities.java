package education.itworx.utilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;

@Slf4j
public class Utilities
{

	public static void waitAndClickOnWebElement(WebElement webElement, WebDriverWait wait)
	{
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
	}
	public static void waitAndClickOnPopUpElement(WebElement webElement, WebDriverWait wait, WebDriver driver)
	{
		// Switch to the pop-up window or frame
		String mainWindowHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		// Now you can interact with elements inside the pop-up dialog
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();

		// Switch back to the main window
		driver.switchTo().window(mainWindowHandle);
	}

	public static void waitUntilSelectHasOptions(WebElement webElement, WebDriverWait wait)
	{
		final Select dropdown = new Select(webElement);
		wait.until(new ExpectedCondition<Boolean>()
		{
			@Nullable
			@Override //implementation of apply method??
			public Boolean apply(@Nullable WebDriver driver)
			{
				return (dropdown.getOptions().size() > 1);
			}
		});
	}

	public static void waitClearAndSetInputField(WebElement element, String value, WebDriverWait wait)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}

	public static void waitAndSelectByVisibleText(WebElement element, String value, WebDriverWait wait)
	{
		waitUntilSelectHasOptions(element, wait);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}

	public static void waitAndSearchForItem(WebElement element, String value, WebDriverWait wait, WebDriver driver)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions actions = new Actions(driver);
		actions.sendKeys(element,value).perform();
		actions.sendKeys(element,Keys.ENTER).perform();
	}

	public static boolean isFieldDisplayed(WebElement element, WebDriverWait wait)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		}
		catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e)
		{
			log.debug("A Handled Exception is Thrown\n" + e);
			return false;
		}
	}

}
