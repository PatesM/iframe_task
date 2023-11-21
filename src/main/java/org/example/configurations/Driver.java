package org.example.configurations;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class Driver {

    public static Wait<WebDriver> wait;

    public static void configureWebDriver() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 8000;
    }

    public static void quitDriver() {
        Selenide.closeWebDriver();
    }
}
