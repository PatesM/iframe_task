package unit;

import static org.example.configurations.Driver.quitDriver;
import static org.example.configurations.Properties.JS_ALERTS_URL;
import static org.example.flows.WorkWithPopupNotificationFlow.alertText;
import static org.example.flows.WorkWithPopupNotificationFlow.clickJsAlertXpath;
import static org.example.flows.WorkWithPopupNotificationFlow.clickJsConfirmXpath;
import static org.example.flows.WorkWithPopupNotificationFlow.clickJsPromptXpath;
import static org.example.flows.WorkWithPopupNotificationFlow.expectedAlertResultText;
import static org.example.flows.WorkWithPopupNotificationFlow.expectedAlertText;
import static org.example.flows.WorkWithPopupNotificationFlow.expectedConfirmResultText;
import static org.example.flows.WorkWithPopupNotificationFlow.expectedPromptResultText;
import static org.example.flows.WorkWithPopupNotificationFlow.jsAlertResultXpath;

import io.qameta.allure.Description;
import org.example.steps.asserts.AssertSwitchBetweenWindows;
import org.example.steps.selenide_steps.SelenideMethods;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WorkWithPopupNotification {

    private final SelenideMethods selenideMethods = new SelenideMethods();
    private final AssertSwitchBetweenWindows assertion = new AssertSwitchBetweenWindows();

    @BeforeEach
    void setUp() {
        selenideMethods.openPage(JS_ALERTS_URL);
    }

    @AfterEach
    void tearDown() {
        selenideMethods.closeBrowser();
    }

    @AfterAll
    static void afterAll() {
        quitDriver();
    }

    @Test
    @DisplayName("Interaction with popup window")
    @Description("Should close the window and display an information message")
    void workWithPopupNotification() {
        //Click for JS Alert
        selenideMethods.clickElement(clickJsAlertXpath);

        String jsAlertText = selenideMethods.acceptAlert();

        assertion.assertionAlertTextCorrect(expectedAlertText, jsAlertText);

        String jsAlertResultText = selenideMethods.getElementText(jsAlertResultXpath);

        assertion.assertionResultTextCorrect(expectedAlertResultText, jsAlertResultText);

        // Click for JS Confirm
        selenideMethods.clickElement(clickJsConfirmXpath);

        selenideMethods.dismissAlert();

        String jsConfirmResultText = selenideMethods.getElementText(jsAlertResultXpath);

        assertion.assertionResultTextCorrect(expectedConfirmResultText, jsConfirmResultText);

        // Click for JS Prompt
        selenideMethods.clickElement(clickJsPromptXpath);

        selenideMethods.insertTextIntoAlert(alertText);

        String jsPromptResultText = selenideMethods.getElementText(jsAlertResultXpath);

        assertion.assertionResultTextCorrect(expectedPromptResultText, jsPromptResultText);
    }
}
