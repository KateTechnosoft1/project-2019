package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.JavascriptExecutor;

import stepdefinition.SharedSD;

import java.time.Duration;
import java.util.List;

import static stepdefinition.SharedSD.getDriver;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {
	JavascriptExecutor jse = (JavascriptExecutor) SharedSD.getDriver();
	Actions actions = new Actions(SharedSD.getDriver());

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void hoverOver(By locator) {
		actions.moveToElement(webAction(locator)).build().perform();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	public boolean isElementEnabled(By locator) {
		return webAction(locator).isEnabled();
	}

	public List<WebElement> allElements(By locator){
		List<WebElement> elements= getDriver().findElements(locator);
		return elements;
	}

	public void scroll(int x, int y){
		String xStr = String.valueOf(x);
		String yStr = String.valueOf(y);
		jse.executeScript("javascript:window.scrollBy("+xStr+","+yStr+")");
	}
}
