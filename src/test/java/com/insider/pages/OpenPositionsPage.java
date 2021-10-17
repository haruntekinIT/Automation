package com.insider.pages;

import com.insider.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OpenPositionsPage extends BasePage{

    @FindBy(css = "select#filter-by-location")
    public WebElement filterByLocationDropdownMenu;

    @FindBy(css = "select#filter-by-department")
    public WebElement filterByDepartmentDropdDownMenu;

    @FindBy(css = ".totalResult")
    public WebElement totalNumberOfListedJobs;

    @FindBy(css = "#jobs-list>div p")
    public List<WebElement> jobNameList;

    @FindBy(css = "#jobs-list>div span")
    public List<WebElement> departmantNameList;

    @FindBy(css = "#jobs-list>div div")
    public List<WebElement> locationNameList;

    @FindBy(xpath = "//p[text() ='Software Quality Assurance Engineer']/following-sibling::a")
    public WebElement applyNowButton;

}
