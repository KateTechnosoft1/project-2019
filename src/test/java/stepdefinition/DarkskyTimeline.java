package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHome;
import org.testng.Assert;

public class DarkskyTimeline {
    private DarkSkyHome homePagehome = new DarkSkyHome();

    @Given("^I am on a DarkSky homepage with timeline$")
    public void iAmOnDarkSkyHome(){
        Assert.assertTrue(homePagehome.isLogoDisplayed());
    }

    @When("^I expand todays timeline$")
    public void expendTimeline() throws InterruptedException {
        homePagehome.scrollToElement();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void correctTemperature(){
        homePagehome.isTemperatureCorrect();

    }
}
