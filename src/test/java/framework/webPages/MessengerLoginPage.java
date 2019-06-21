package framework.webPages;

import org.openqa.selenium.By;

public class MessengerLoginPage extends BasePage{

    private By errorMessage = By.linkText("Sign up for an account.");

    public String getErrorMessage() {

        return getTextFromElement(errorMessage);
    }
}
