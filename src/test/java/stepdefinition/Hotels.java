package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelsHome;
import org.testng.Assert;

public class Hotels {
    private HotelsHome homePage = new HotelsHome();

    @Given("^I am on default locations search result screen$")
    public void iAmOnAHotelsPage() {
        homePage.ignorAlert();
        homePage.whereTo();
        //Assert.assertTrue(homePage.isLogoDisplayed());

    }

    @When("^I select property class (.+)$")
    public void selectProperty(String stars) {
        switch (stars) {
            case "5 stars":
                homePage.fiveStarsLocate();
                break;
            case "4 stars":
                homePage.fourStarsLocate();
                break;
            case "3 stars":
                homePage.threeStarsLocate();
                break;

        }
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void allStarsDisplayed(String stars) throws InterruptedException {
        switch (stars) {
            case "5 stars":
                Assert.assertTrue(homePage.isFiveStarsDispalyed());
                break;
            case "4 stars":
                Assert.assertTrue(homePage.isFourStarsDispalyed());
                break;
            case "3 stars":
                Assert.assertTrue(homePage.isThreeStarsDisplayed());
                break;
        }
    }


    @Then("^I verify system displays all hotels within 10 miles radius of airport$")
    public void verifyRadius() throws InterruptedException {
        homePage.hoverOverDistanceLink();
        homePage.clickOnCityCenter();
        Assert.assertTrue(homePage.isRadiusDisplayed());
    }

    @And("^I verify Hilton Hotel is within radius$")
    public void verifyHiltonRadius() {
        homePage.setHiltonInputField("Hilton");
        homePage.clickOnHiltonSearch();
        Assert.assertTrue(homePage.isHotelDisplayed());

    }

}