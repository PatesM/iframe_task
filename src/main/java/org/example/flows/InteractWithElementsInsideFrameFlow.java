package org.example.flows;

import org.openqa.selenium.By;

public class InteractWithElementsInsideFrameFlow {

    public static By iFrameRefXpath = By.xpath("//a[text()='iFrame']");
    public static String iFrameName = "mce_0_ifr";
    public static By boldButtonXpath = By.xpath("//button[@aria-label='Bold']");
    public static By textFieldId = By.xpath("//body");
    public static By editButtonXpath = By.xpath("//button/span[text()='Edit']");
    public static By selectAllButtonXpath = By.xpath("//div[@title='Select all']");
}
