package unit;

import static org.example.configurations.Driver.quitDriver;
import static org.example.configurations.Properties.FRAMES_URL;
import static org.example.flows.InteractWithElementsInsideFrameFlow.boldButtonXpath;
import static org.example.flows.InteractWithElementsInsideFrameFlow.editButtonXpath;
import static org.example.flows.InteractWithElementsInsideFrameFlow.iFrameName;
import static org.example.flows.InteractWithElementsInsideFrameFlow.iFrameRefXpath;
import static org.example.flows.InteractWithElementsInsideFrameFlow.selectAllButtonXpath;
import static org.example.flows.InteractWithElementsInsideFrameFlow.textFieldId;

import io.qameta.allure.Description;
import org.example.steps.selenide_steps.SelenideMethods;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InteractWithElementsInsideFrame {

    private final SelenideMethods selenideMethods = new SelenideMethods();

    @BeforeEach
    void setUp() {
        selenideMethods.openPage(FRAMES_URL);
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
    @DisplayName("Changing the font of pasted text")
    @Description("Should paste the text and change the font to Bold")
    public void interactWithElementsInsideFrame() {
        selenideMethods.clickElement(iFrameRefXpath);

        selenideMethods.clickElement(editButtonXpath);

        selenideMethods.clickElement(selectAllButtonXpath);

        selenideMethods.switchFrame(iFrameName);

        selenideMethods.clearTextField(textFieldId);

        selenideMethods.insertIntoTextField(textFieldId, "Hello World");

        selenideMethods.switchDefaultFrame();

        selenideMethods.clickElement(editButtonXpath);

        selenideMethods.clickElement(selectAllButtonXpath);

        selenideMethods.clickElement(boldButtonXpath);
    }
}
