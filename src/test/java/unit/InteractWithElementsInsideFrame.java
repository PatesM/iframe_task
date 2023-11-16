package unit;

import static org.example.configurations.Properties.CHROME_WEB_DRIVER_KEY;
import static org.example.configurations.Properties.CHROME_WEB_DRIVER_VALUE;
import static org.example.configurations.Properties.FRAMES_URL;
import static org.example.flows.InteractWithElementsInsideFrameFlow.boldButtonXpath;
import static org.example.flows.InteractWithElementsInsideFrameFlow.editButtonXpath;
import static org.example.flows.InteractWithElementsInsideFrameFlow.iFrameName;
import static org.example.flows.InteractWithElementsInsideFrameFlow.iFrameRefXpath;
import static org.example.flows.InteractWithElementsInsideFrameFlow.selectAllButtonXpath;
import static org.example.flows.InteractWithElementsInsideFrameFlow.textFieldId;

import io.qameta.allure.Description;
import org.example.steps.selenium_steps.SeleniumMethods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class InteractWithElementsInsideFrame {

    private final SeleniumMethods seleniumMethods = new SeleniumMethods(CHROME_WEB_DRIVER_KEY,
        CHROME_WEB_DRIVER_VALUE, FRAMES_URL);

    @Test
    @DisplayName("Changing the font of pasted text")
    @Description("Should paste the text and change the font to Bold")
    public void interactWithElementsInsideFrame() throws InterruptedException {

        WebElement iframeRef = seleniumMethods.searchElementByXpath(iFrameRefXpath);
        seleniumMethods.clickElement(iframeRef);

        WebElement editButton = seleniumMethods.searchElementByXpath(editButtonXpath);
        seleniumMethods.clickElement(editButton);

        WebElement selectAllButton = seleniumMethods.searchElementByXpath(selectAllButtonXpath);
        seleniumMethods.clickElement(selectAllButton);

        seleniumMethods.switchFrame(iFrameName);

        WebElement textField = seleniumMethods.searchElementById(textFieldId);
        seleniumMethods.clearTextField(textField);

        seleniumMethods.insertIntoTextField(textField, "Hello World");

        seleniumMethods.switchDefaultFrame();

        seleniumMethods.clickElement(editButton);

        WebElement selectAllButtonNew = seleniumMethods.searchElementByXpath(selectAllButtonXpath);
        seleniumMethods.clickElement(selectAllButtonNew);

        WebElement boldButton = seleniumMethods.searchElementByXpath(boldButtonXpath);
        seleniumMethods.clickElement(boldButton);

        seleniumMethods.quitDriver();
    }
}
