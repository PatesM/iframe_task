package org.example.flows;

public class WorkWithPopupNotificationFlow {

    public static String clickJsAlertXpath = "//button[@onclick='jsAlert()']";
    public static String expectedAlertText = "I am a JS Alert";
    public static String jsAlertResultId = "result";
    public static String expectedAlertResultText = "You successfully clicked an alert";
    public static String expectedConfirmResultText = "You clicked: Cancel";
    public static String clickJsConfirmXpath = "//button[@onclick='jsConfirm()']";
    public static String clickJsPromptXpath = "//button[@onclick='jsPrompt()']";
    public static String alertText = "Hello World";
    public static String expectedPromptResultText = "You entered: Hello World";
}
