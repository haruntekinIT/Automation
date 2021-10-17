package com.insider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ExternalJobsPage extends BasePage {

    @FindBy(xpath = "//h3[text()='A Software Quality Assurance Engineer in Insider day in and day out:']")
    public WebElement firstLineOfJobDescription;

    @FindBy(xpath = "//h3[text()='We want you to join us while we are taking a step into the future if you:']")
    public WebElement firstLineOfRequirements;

    @FindBy(xpath = "//a[text()='Apply for this job']")
    public List<WebElement> listOfApplyForThisJobButtons;

    @FindBy(xpath = "//h4[text()='Submit your application']")
    public WebElement submitYourAppHeader;


}
