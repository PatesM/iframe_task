package org.example.flows;

import org.openqa.selenium.By;

public class WorkWithPopupNotificationFlow {

    public static By clickJsAlertXpath = By.xpath("//button[@onclick='jsAlert()']");
    public static String expectedAlertText = "I am a JS Alert";
    public static By jsAlertResultXpath = By.xpath("//div/p[@id='result']");
    public static String expectedAlertResultText = "You successfully clicked an alert";
    public static String expectedConfirmResultText = "You clicked: Cancel";
    public static By clickJsConfirmXpath = By.xpath("//button[@onclick='jsConfirm()']");
    public static By clickJsPromptXpath = By.xpath("//button[@onclick='jsPrompt()']");
    public static String alertText = "Hello World";
    public static String expectedPromptResultText = "You entered: Hello World";
}
