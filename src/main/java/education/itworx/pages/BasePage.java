package education.itworx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public abstract class BasePage
{

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Wait<WebDriver> fluentWait;

	public BasePage(WebDriver driver)
	{
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.fluentWait = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class);
	}

	/***********Common Methods Used across Different Pages***********/

	public WebDriverWait getWait()
	{
		return wait;
	}

	public void checkCorrectPage(String pageIdentifier, String exceptionMsg)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pageIdentifier)));

		WebElement element = driver.findElement(By.tagName("html"));
		String elementSource;

		elementSource = element.getAttribute("innerHTML");
		if (!elementSource.contains("id=\"" + pageIdentifier + "\""))
		{
			throw new IllegalStateException(exceptionMsg);
		}
	}

	public void selectItemByValueFromDropdown(WebElement dropdownList, String value) {
		// Initialize the Select class with the dropdown element
		Select dropdown = new Select(dropdownList);
		// Select the item from the dropdown list by index
		dropdown.selectByValue(value);
	}

}
