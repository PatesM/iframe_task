package org.example.steps.selenide_steps;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.example.configurations.Driver.configureWebDriver;
import static org.openqa.selenium.devtools.v118.page.Page.close;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class SelenideMethods {

    public void openPage(String url) {
        configureWebDriver();
        open(url);
        searchElement(By.xpath("//body")).shouldBe(visible);
    }

    public SelenideElement searchElement(By selenideElement) {
        return $(selenideElement);
    }

    public void clickElement(By selenideElement) {
        searchElement(selenideElement).shouldBe(visible, interactable).click();
    }

    public void insertIntoTextField(By selenideElement, String text) {
        searchElement(selenideElement).sendKeys(text);
    }

    public String getElementText(By selenideElement) {
        return searchElement(selenideElement).getText();
    }

    public void clearTextField(By selenideElement) {
        searchElement(selenideElement).shouldBe(visible).clear();
    }

    public void switchFrame(String frameName) {
        Selenide.switchTo().frame(frameName);
    }

    public void switchDefaultFrame() {
        Selenide.switchTo().defaultContent();
    }

    public String getWindowTitle() {
        return Selenide.title();
    }

    public String acceptAlert() {
        return Selenide.confirm();
    }

    public void dismissAlert() {
        Selenide.dismiss();
    }

    public void insertTextIntoAlert(String text) {
        Selenide.prompt(text);
    }

    public void switchTab(int tabIndex) {
        Selenide.switchTo().window(tabIndex);
    }

    public void closeTab() {
        close();
    }

    public void closeBrowser() {
        Selenide.closeWindow();
    }
}
