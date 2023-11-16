package org.example.steps.selenium_steps;

import static org.example.configurations.Driver.configureWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumMethods {

    private final WebDriver driver;

    public SeleniumMethods(String CHROME_WEB_DRIVER_KEY, String CHROME_WEB_DRIVER_VALUE,
        String URL) {
        driver = configureWebDriver(CHROME_WEB_DRIVER_KEY, CHROME_WEB_DRIVER_VALUE, URL);
    }

    public WebElement searchElementById(String elementId) {
        return driver.findElement(By.id(elementId));
    }

    public WebElement searchElementByXpath(String elementId) {
        return driver.findElement(By.xpath(elementId));
    }

    public void insertIntoTextField(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    public String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    public void clearTextField(WebElement webElement) {
        webElement.clear();
    }

    public void clickElement(WebElement webElement) throws InterruptedException {
        webElement.click();
    }

    public void switchFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    public void switchDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public String getNewWindowHandle(String originalWindow) {
        String newHandle = null;
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                newHandle = windowHandle;
            }
        }
        return newHandle;
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void insertTextIntoAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void switchTab(String tabHandle) {
        driver.switchTo().window(tabHandle);
    }

    public void closeTab() {
        driver.close();
    }

    public void quitDriver() {
        driver.quit();
    }
}
