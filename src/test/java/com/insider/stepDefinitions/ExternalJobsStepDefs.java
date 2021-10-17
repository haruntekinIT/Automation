package com.insider.stepDefinitions;

import com.insider.pages.ExternalJobsPage;
import com.insider.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ExternalJobsStepDefs {

    ExternalJobsPage externalJobsPage = new ExternalJobsPage();

    @Then("the job description section is displayed")
    public void the_job_description_section_is_displayed() {

        Assert.assertTrue(externalJobsPage.firstLineOfJobDescription.isDisplayed());

    }

    @Then("the job requirements section is displayed")
    public void the_job_requirements_section_is_displayed() {

        Assert.assertTrue(externalJobsPage.firstLineOfRequirements.isDisplayed());

    }

    @Then("APPLY FOR THIS JOB button is displayed")
    public void apply_FOR_THIS_JOB_button_is_displayed() {

        Assert.assertTrue(externalJobsPage.firstLineOfRequirements.isDisplayed());

    }

    @When("the user clicks on the APPLY FOR THS JOB button")
    public void the_user_clicks_on_the_APPLY_FOR_THS_JOB_button() {

        externalJobsPage.listOfApplyForThisJobButtons.get(0).click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Then("the user should be able to display SUBMIT YOUR APPLICATION header")
    public void the_user_should_be_able_to_display_SUBMIT_YOUR_APPLICATION_header() {

        Assert.assertTrue(externalJobsPage.submitYourAppHeader.isDisplayed());

    }

}
