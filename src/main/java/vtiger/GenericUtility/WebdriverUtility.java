package vtiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void windowMaximize(WebDriver driver) {
		driver.manage().window().maximize();

	}
	/**
	 * This method will wait for 20 secs for the entire DOM to be loaded
	 * @param driver
	 */
	public void waitForElementstoLoadInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * This method will wait for particular element for visible
	 * @param driver
	 * @param element
	 */

	public void waitForElementsToLoad(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for particular element to e clickable
	 * @param driver
	 * @param element
	 */
	public void waitElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait for the particular element to perform click operation
	 * @param driver
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitAndClickOnElement(WebDriver driver, WebElement element) throws InterruptedException {
		int count=0;
		while(count<10) {
			try {
				element.click();
				break;
			}
			catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This will select the dropdown option by using index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will select dropdown option by using value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will select dropdown option by using visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will move the cursor to the particular element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOn(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform mouse hover by offset
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void mouseHoverOn(WebDriver driver, int x, int y) {
		Actions act=new Actions(driver);
		act.moveByOffset(x,y).perform();
	}
	/**
	 * This method will perform right click operation
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will perform rightclick on particular element
	 * @param driver
	 * @param element
	 */
	public void rightClickOn(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss the alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will get the text from alert
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	/**
	 * This method will switch the window with respect to window titele
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindows(WebDriver driver,String partialTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		while(iterator.hasNext()) {
			String winID = iterator.next();
			String title = driver.switchTo().window(winID).getTitle();
			if(title.contains(partialTitle)) {
				break;
			}
		}
	}
	/**
	 * Switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * switch to frame using name or id
	 * @param driver
	 * @param idOrName
	 */
	public void switchToFrame(WebDriver driver,String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	/**
	 * Switch to frame using element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String path="./ScreenShots/"+screenshotName+".png";
		File dest = new File(path);
		FileUtils.copyFile(source, dest);
		return dest.getAbsolutePath();//for listeners

	}
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * This method will scroll to the particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView()", element);

	}

}
