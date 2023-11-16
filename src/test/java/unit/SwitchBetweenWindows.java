package unit;

import static org.example.configurations.Properties.CHROME_WEB_DRIVER_KEY;
import static org.example.configurations.Properties.CHROME_WEB_DRIVER_VALUE;
import static org.example.configurations.Properties.WINDOWS_URL;
import static org.example.flows.SwitchBetweenWindowsFlow.clickHereRefXpath;
import static org.example.flows.SwitchBetweenWindowsFlow.expectedPageText;
import static org.example.flows.SwitchBetweenWindowsFlow.newPageTextXpath;

import io.qameta.allure.Description;
import org.example.steps.asserts.AssertSwitchBetweenWindows;
import org.example.steps.selenium_steps.SeleniumMethods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class SwitchBetweenWindows {

    private final SeleniumMethods seleniumMethods = new SeleniumMethods(CHROME_WEB_DRIVER_KEY,
        CHROME_WEB_DRIVER_VALUE, WINDOWS_URL);
    private final AssertSwitchBetweenWindows assertion = new AssertSwitchBetweenWindows();

    @Test
    @DisplayName("Switching between pages ")
    @Description("Should open the new page and close tab")
    public void switchBetweenWindows() throws InterruptedException {

        String originalHandle = seleniumMethods.getWindowHandle();

        WebElement clickHereRef = seleniumMethods.searchElementByXpath(clickHereRefXpath);
        seleniumMethods.clickElement(clickHereRef);

        String newHandle = seleniumMethods.getNewWindowHandle(originalHandle);

        seleniumMethods.switchTab(newHandle);

        WebElement newPageTextElement = seleniumMethods.searchElementByXpath(newPageTextXpath);
        String actualPageText = seleniumMethods.getElementText(newPageTextElement);

        assertion.assertionNewTabOpen(originalHandle, newHandle);
        assertion.assertionPageTextCorrect(expectedPageText, actualPageText);

        seleniumMethods.closeTab();

        seleniumMethods.switchTab(originalHandle);

        String currentHandle = seleniumMethods.getWindowHandle();

        assertion.assertionNewTabOpen(newHandle, currentHandle);

        seleniumMethods.quitDriver();
    }
}
