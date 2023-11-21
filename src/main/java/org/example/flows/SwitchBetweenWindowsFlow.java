package org.example.flows;

import org.openqa.selenium.By;

public class SwitchBetweenWindowsFlow {

    public static By originalPageTitleXpath = By.xpath("//head/title");
    public static By clickHereRefXpath = By.xpath("//a[text()='Click Here']");
    public static By newPageTitleXpath = By.xpath("//head/title");
    public static By newPageTextXpath = By.xpath("//h3");
}
