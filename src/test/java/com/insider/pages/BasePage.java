package com.insider.pages;

import com.insider.utilities.BrowserUtils;
import com.insider.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[text()='ACCEPT']")
    public WebElement cookieACCEPTbutton;

    public void navToModule(String navBar, String module) {

        String navBarLocator = "//span[text()='" + navBar + "']";
        String moduleLocator = "//h5[text()='" + module + "']";

        try {
            BrowserUtils.waitForClickablility(By.xpath(navBarLocator), 3);
            WebElement tabElement = Driver.get().findElement(By.xpath(navBarLocator));
            Driver.get().findElement(By.xpath(navBarLocator)).click();

        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(navBarLocator), 3);
        }

        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 3);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 3);
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);
        }
    }
}
