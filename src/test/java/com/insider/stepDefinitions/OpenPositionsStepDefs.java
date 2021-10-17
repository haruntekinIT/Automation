package com.insider.stepDefinitions;

import com.insider.pages.OpenPositionsPage;
import com.insider.utilities.BrowserUtils;
import com.insider.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertTrue;

public class OpenPositionsStepDefs {

    OpenPositionsPage openPositionsPage = new OpenPositionsPage();
    Select dropDownMenuLoc;

    @When("the user clicks on drop-down menu under {string} label")
    public void the_user_clicks_on_drop_down_menu_under_label(String string) {

        BrowserUtils.waitForPageToLoad(10);
        ((JavascriptExecutor)Driver.get()).executeScript("window.scrollBy(0,250);");
        BrowserUtils.waitFor(2);
        dropDownMenuLoc = new Select(openPositionsPage.filterByLocationDropdownMenu);


    }

    @When("the user selects Istanbul, Turkey from the menu")
    public void the_user_selects_Istanbul_Turkey_from_the_menu() {

        dropDownMenuLoc.selectByIndex(1);

    }

    @When("the user selects Quality Assurance from the menu")
    public void the_user_selects_Quality_Assurance_from_the_menu() {

        Select dropDownMenuDept = new Select(openPositionsPage.filterByDepartmentDropdDownMenu);
        dropDownMenuDept.selectByVisibleText("Quality Assurance");
        BrowserUtils.waitFor(4);

    }

    @Then("the user should be able to display the number of listed jobs at the right of Open Positions header as equal or greater than one")
    public void the_user_should_be_able_to_display_the_number_of_listed_jobs_at_the_right_of_Open_Positions_header_as_equal_or_greater_than_one() {
        String totalNumOfListedJobs = openPositionsPage.totalNumberOfListedJobs.getText();
        System.out.println("Total number of listed jobs: " + totalNumOfListedJobs);

        assertTrue("Total number of listed job is equal or greater than 1",Integer.parseInt(totalNumOfListedJobs) >= 1);
    }

    @Then("the all jobs' position contains {string}")
    public void the_all_jobs_position_contains(String expectedPosition) {

        for (WebElement job : openPositionsPage.jobNameList) {

            assertTrue("Job position DOES NOT contain " + expectedPosition, job.getAttribute("innerHTML").contains(expectedPosition));

        }

    }

    @Then("the all jobs' department contains {string}")
    public void the_all_jobs_department_contains(String expectedDepartment) {

        for (WebElement department : openPositionsPage.departmantNameList ) {
                assertTrue("All jobs' department name DOES NOT contain " + expectedDepartment, department.getText().contains(expectedDepartment));
            }

    }

    @Then("the all jobs' location contains {string}")
    public void the_all_jobs_location_contains_Istanbul_Turkey(String expectedlocation) {

        for (WebElement location : openPositionsPage.locationNameList ) {
            assertTrue("All jobs' location name DOES NOT contain " + expectedlocation, location.getText().contains(expectedlocation));
        }

    }

    @When("the user clicks on the Apply Now button of the Software Quality Assurance Engineer position")
    public void the_user_clicks_on_the_Apply_Now_button_of_the_Software_Quality_Assurance_Engineer_position() {

        String currentWindowHandle = Driver.get().getWindowHandle();

        openPositionsPage.applyNowButton.click();

        BrowserUtils.waitForPageToLoad(10);

        for (String windowHandle : Driver.get().getWindowHandles()){

            if(!windowHandle.equals(currentWindowHandle)){
                Driver.get().switchTo().window(windowHandle);
                break;
            }
        }

        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("the title of the newly opened page is {string}")
    public void the_title_of_the_newly_opened_page_is(String expectedWindowTitle) {

        Assert.assertEquals(expectedWindowTitle, Driver.get().getTitle());

    }

}
