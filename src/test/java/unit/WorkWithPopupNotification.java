package unit;

import static org.example.configurations.Properties.CHROME_WEB_DRIVER_KEY;
import static org.example.configurations.Properties.CHROME_WEB_DRIVER_VALUE;
import static org.example.configurations.Properties.JS_ALERTS_URL;
import static org.example.flows.WorkWithPopupNotificationFlow.alertText;
import static org.example.flows.WorkWithPopupNotificationFlow.clickJsAlertXpath;
import static org.example.flows.WorkWithPopupNotificationFlow.clickJsConfirmXpath;
import static org.example.flows.WorkWithPopupNotificationFlow.clickJsPromptXpath;
import static org.example.flows.WorkWithPopupNotificationFlow.expectedAlertResultText;
import static org.example.flows.WorkWithPopupNotificationFlow.expectedAlertText;
import static org.example.flows.WorkWithPopupNotificationFlow.expectedConfirmResultText;
import static org.example.flows.WorkWithPopupNotificationFlow.expectedPromptResultText;
import static org.example.flows.WorkWithPopupNotificationFlow.jsAlertResultId;

import io.qameta.allure.Description;
import org.example.steps.asserts.AssertSwitchBetweenWindows;
import org.example.steps.selenium_steps.SeleniumMethods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class WorkWithPopupNotification {

    private final SeleniumMethods seleniumMethods = new SeleniumMethods(CHROME_WEB_DRIVER_KEY,
        CHROME_WEB_DRIVER_VALUE, JS_ALERTS_URL);
    private final AssertSwitchBetweenWindows assertion = new AssertSwitchBetweenWindows();

    @Test
    @DisplayName("Changing the font of pasted text")
    @Description("Should ")
    void workWithPopupNotification() throws InterruptedException {
        //Click for JS Alert
        WebElement jsAlert = seleniumMethods.searchElementByXpath(clickJsAlertXpath);
        seleniumMethods.clickElement(jsAlert);

        String jsAlertText = seleniumMethods.getAlertText();

        assertion.assertionAlertTextCorrect(expectedAlertText, jsAlertText);

        seleniumMethods.acceptAlert();

        WebElement jsAlertResult = seleniumMethods.searchElementById(jsAlertResultId);
        String jsAlertResultText = seleniumMethods.getElementText(jsAlertResult);

        assertion.assertionResultTextCorrect(expectedAlertResultText, jsAlertResultText);

        // Click for JS Confirm
        WebElement jsConfirm = seleniumMethods.searchElementByXpath(clickJsConfirmXpath);
        seleniumMethods.clickElement(jsConfirm);

        seleniumMethods.dismissAlert();

        WebElement jsConfirmResult = seleniumMethods.searchElementById(jsAlertResultId);
        String jsConfirmResultText = seleniumMethods.getElementText(jsConfirmResult);

        assertion.assertionResultTextCorrect(expectedConfirmResultText, jsConfirmResultText);

        // Click for JS Prompt
        WebElement jsPrompt = seleniumMethods.searchElementByXpath(clickJsPromptXpath);
        seleniumMethods.clickElement(jsPrompt);

        seleniumMethods.insertTextIntoAlert(alertText);
        seleniumMethods.acceptAlert();

        WebElement jsPromptResult = seleniumMethods.searchElementById(jsAlertResultId);
        String jsPromptResultText = seleniumMethods.getElementText(jsPromptResult);

        assertion.assertionResultTextCorrect(expectedPromptResultText, jsPromptResultText);

        seleniumMethods.quitDriver();
    }
}
