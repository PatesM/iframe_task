package org.example.steps.asserts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertSwitchBetweenWindows {

    public void assertionNewTabOpen(String originalHandle, String newHandle) {
        assertNotEquals(originalHandle, newHandle);
    }

    public void assertionPageTextCorrect(String expectedHandle, String newHandle) {
        assertEquals(newHandle, expectedHandle);
    }

    public void assertionAlertTextCorrect(String expectedAlertText, String jsAlertText) {
        assertEquals(expectedAlertText, jsAlertText);
    }

    public void assertionResultTextCorrect(String expectedAlertResultText, String alertResultText) {
        assertEquals(expectedAlertResultText, alertResultText);
    }
}
