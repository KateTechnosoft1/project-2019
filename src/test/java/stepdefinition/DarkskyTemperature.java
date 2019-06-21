package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHome;
import org.testng.Assert;

public class DarkskyTemperature {
    private DarkSkyHome homePagehome = new DarkSkyHome();

    @Given("^I am on a DarkSky homepage$")
    public void iAmOnDarkSkyHome(){
        Assert.assertTrue(homePagehome.isLogoDisplayed());
    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void currentTemperature(){
        Assert.assertFalse(homePagehome.summaryTemperature(), "Temperature not correct");


    }
}
