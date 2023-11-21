package unit;

import static org.example.configurations.Driver.quitDriver;
import static org.example.configurations.Properties.WINDOWS_URL;
import static org.example.flows.SwitchBetweenWindowsFlow.clickHereRefXpath;
import static org.example.flows.SwitchBetweenWindowsFlow.newPageTextXpath;

import io.qameta.allure.Description;
import org.example.steps.asserts.AssertSwitchBetweenWindows;
import org.example.steps.selenide_steps.SelenideMethods;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SwitchBetweenWindows {

    private final SelenideMethods selenideMethods = new SelenideMethods();
    private final AssertSwitchBetweenWindows assertion = new AssertSwitchBetweenWindows();

    @BeforeEach
    void setUp() {
        selenideMethods.openPage(WINDOWS_URL);
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
    @DisplayName("Switching between pages ")
    @Description("Should open the new page and close tab")
    public void switchBetweenWindows() {
        String originalPageTitle = selenideMethods.getWindowTitle();

        selenideMethods.clickElement(clickHereRefXpath);

        selenideMethods.switchTab(1);

        String newPageTitle = selenideMethods.getWindowTitle();
        String newPageText = selenideMethods.getElementText(newPageTextXpath);

        assertion.assertionNewTabOpen(originalPageTitle, newPageTitle);
        assertion.assertionPageTextCorrect("New Window", newPageText);

        selenideMethods.closeTab();

        selenideMethods.switchTab(0);

        String currentPageTitle = selenideMethods.getWindowTitle();

        assertion.assertionNewTabOpen(newPageTitle, currentPageTitle);
    }
}
