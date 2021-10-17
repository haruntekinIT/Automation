package com.insider.stepDefinitions;

import com.insider.pages.HomePage;
import com.insider.utilities.ConfigurationReader;
import com.insider.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;

public class HomeStepDefs {

    @Given("the user is on the Insider home page")
    public void the_user_is_on_the_Insider_home_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        if(new HomePage().cookieACCEPTbutton.isDisplayed()){

            new HomePage().cookieACCEPTbutton.click();
        }

    }

    @Then("the title of the page is {string}")
    public void the_title_of_the_page_is(String expectedPageTitle) {

        System.out.println("Expected page title = " + expectedPageTitle);
        System.out.println("Actual page title = " + Driver.get().getTitle());
        assertEquals(Driver.get().getTitle(), expectedPageTitle);
        //assertion can be done by verifying the home page URL as well
    }

}
