package com.insider.pages;

import com.insider.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePage {

    public WebElement getJobLocation(String jobLocation){

        return Driver.get().findElement(By.xpath("//p[text()='" + jobLocation + "']"));

    }

    public WebElement getTeamName(String teamName){

        return Driver.get().findElement(By.xpath("//h3[text()=\"" + teamName + "\"]"));

    }

    @FindBy(xpath = "//h3[normalize-space(text())='Our Locations']")
    public WebElement ourLocationsText;

    /*
    @FindBy(css = "#icon-close-button-1623157115126")
    public WebElement peakReportWindowCloseButton;
    */

    @FindBy(xpath = "//i[@class='icon-arrow-right location-slider-next ml-4 text-xsmall text-dark']/..")
    public WebElement rightArrowButton;

    @FindBy(xpath = "//a[text()='See all teams']")
    public WebElement seeAllTeamsButton;

    @FindBy(xpath = "//a[text()='Find your dream job'][contains(@class, 'py-3')]")
    public WebElement findYourDreamJobButtonAtTop;

    @FindBy(xpath = "//h2[text()='Life at Insider']")
    public WebElement lifeAtInsiderText;

}
