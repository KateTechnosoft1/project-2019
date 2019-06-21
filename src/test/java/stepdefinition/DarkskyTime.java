package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHome;
import org.testng.Assert;

public class DarkskyTime {

    private DarkSkyHome homePagehome = new DarkSkyHome();

    @Given("^I am on Darksky homepage$")
    public void iAmOnDarkSkyHomeTime(){
        Assert.assertTrue(homePagehome.isLogoDisplayed());
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimeline(){
        System.out.println(homePagehome.getTimeSlots());
    }
}
