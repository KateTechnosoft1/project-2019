package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHome;
import org.testng.Assert;

public class DarkskyRegister {
     private DarkSkyHome homePagehome = new DarkSkyHome();

     @Given("^I am on a homepage$")
        public void iAmOnDarkSkyHome(){
         Assert.assertTrue(homePagehome.isLogoDisplayed());
     }

     @When("^I click on darkSkyApi button on homepage$")
        public void clickOnApiButton(){
         homePagehome.clickOnDarkskyAPI();
     }

     @And("^I click on signup button on register page$")
        public void clickOnSignUpButton(){
         homePagehome.clickOnSignUp();
     }

     @And("^I click on register button on register page$")
        public void clickOnRegisterButton(){
         homePagehome.clickOnRegister();
     }

     @Then("^I have to stay on register page$")
        public void verrifyPage(){
         homePagehome.isButtonDisplayed();


     }
}
