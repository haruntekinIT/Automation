package com.insider.stepDefinitions;

import com.insider.pages.CareersPage;
import com.insider.pages.HomePage;
import com.insider.utilities.BrowserUtils;
import com.insider.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import static org.junit.Assert.*;

public class CareersStepDefs {

    CareersPage careersPage = new CareersPage();

    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String navBar, String module) {
        new HomePage().navToModule(navBar, module);
        BrowserUtils.waitForPageToLoad(8);
    }

    @When("the user scrolls down to display Our Locations block")
    public void the_user_scrolls_down_to_display_Our_Locations_block() {
        BrowserUtils.scrollToElement(careersPage.rightArrowButton);
    }

    @Then("the user should be able to display the Locations listed below under Our Locations block")
    public void the_user_should_be_able_to_display_the_Locations_listed_below_under_Our_Locations_block(List<String> jobLocations) throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
        //WebDriverWait wait = new WebDriverWait(Driver.get(),1);

        for (String jobLocation : jobLocations) {

            assertTrue(careersPage.getJobLocation(jobLocation).isDisplayed());
            js.executeScript("document.querySelector('.icon-arrow-right.location-slider-next.ml-4.text-xsmall.text-dark').click()");
            Thread.sleep(500);

            System.out.println(jobLocation + " is displayed");

        }

    }

    @When("the user clicks on See all teams")
    public void the_user_clicks_on_See_all_teams() {

        BrowserUtils.scrollToElement(careersPage.ourLocationsText);
        BrowserUtils.clickWithJS(careersPage.seeAllTeamsButton);
        BrowserUtils.waitForPageToLoad(1);

    }

    @Then("the user should be able to display team names listed below under Find your calling block")
    public void the_user_should_be_able_to_display_team_names_listed_below_under_Find_your_calling_block(List<String> expectedTeamNamesList) {

        for (int i = 0; i < expectedTeamNamesList.size(); i++) {

            BrowserUtils.scrollToElement(Driver.get().findElements(By.cssSelector(".col-12.d-flex.flex-wrap.p-0.career-load-more>div")).get(i));

            assertTrue(careersPage.getTeamName(expectedTeamNamesList.get(i)).isDisplayed());

            System.out.println((expectedTeamNamesList.get(i)) + " is displayed");

        }
    }

    @When("the user clicks on Find your dream job button under Ready to disrupt header")
    public void the_user_clicks_on_Find_your_dream_job_button_under_Ready_to_disrupt_header() {

                careersPage.findYourDreamJobButtonAtTop.click();
                BrowserUtils.waitForPageToLoad(5);

    }

    @When("the user scrolls down on the Careers page")
    public void the_user_scrolls_down_on_the_Careers_page() {

        BrowserUtils.scrollToElement(careersPage.lifeAtInsiderText);

    }

    @Then("the user should be able to display Life at Insider header")
    public void the_user_should_be_able_to_display_Life_at_Insider_header() {

        assertEquals("Life at Insider", careersPage.lifeAtInsiderText.getText());

    }
}
