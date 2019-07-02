package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HotelsHome extends BasePage {

    private By logo = By.xpath("//h1[@class='cont-hd-alt widget-query-heading']");
    private By starsFive = By.id("f-label-star-rating-5");
    private By starsFour = By.id("f-star-rating-4");
    private By starsThree = By.id("f-label-star-rating-3");
    private By location = By.id("qf-0q-destination");
    private By buttonSearch = By.xpath("//button[@class='cta cta-strong']");
    private By fiveStarsRaiting = By.xpath("//span[@class='star-rating-text star-rating-text-strong']");
    private By fourStarRaiting = By.xpath("//span[@class='star-rating-text star-rating-text-strong']");
    private By threeStarRaiting = By.id("f-label-star-rating-3");
    private By wantToSeeMore = By.id("result-info-container");
    private By distance = By.xpath("//a[contains(text(),'Distance')]");
    private By cityCenter = By.xpath("//a[contains(text(),'City center')]");
    private By cityCenterList = By.xpath("//li[contains(text(),'City center')]");
    private By hiltonInput = By.id("f-name");
    private By hiltonButton = By.id("f-name-cta");

    public void ignorAlert() {
        SharedSD.getDriver().navigate().refresh();
    }


    public boolean isLogoDisplayed() {
        return webAction(logo).isDisplayed();
    }

    public void whereTo() {
        setValue(location, "Boston");
        clickOn(logo);
        clickOn(buttonSearch);

    }

    public void fiveStarsLocate() {
        clickOn(starsFive);
    }

    public void fourStarsLocate() {
        clickOn(starsFour);
    }

    public void threeStarsLocate() {
        clickOn(starsThree);
    }

    public boolean isFiveStarsDispalyed() throws InterruptedException {
        List<WebElement> allWebElements = allElements(fiveStarsRaiting);
        for (int i = 0; i < allWebElements.size(); i++) {
            scroll(0, 600);
            allWebElements = allElements(fiveStarsRaiting);
            Thread.sleep(2000);
            if (allWebElements.size() > 50 || isElementDisplayed(wantToSeeMore)) {
                break;
            }
        }
        for (WebElement element : allWebElements) {
            if (!element.getText().equals("5-star")) {
                return false;
            }
        }

        return true;
    }

    public boolean isFourStarsDispalyed() throws InterruptedException {
        List<WebElement> allWebElements = allElements(fourStarRaiting);
        for (int i = 0; i < allWebElements.size(); i++) {
            scroll(0, 600);
            allWebElements = allElements(fourStarRaiting);
            Thread.sleep(2000);
            if (allWebElements.size() > 50 || isElementDisplayed(wantToSeeMore)) {
                break;
            }
        }
        List<Double> hotelDouble = new ArrayList<>();
        for (WebElement element : allWebElements) {

            if (hotelDouble.size() < 50) {
                Double stars = Double.parseDouble(element.getText().split("-")[0]);
                hotelDouble.add(stars);
            } else {
                break;
            }
        }
        for (double star : hotelDouble) {
            if (star < 4.0 || star >= 5.0) {
                //System.out.println("Test failed");
                return false;
            }
        }
        return true;
    }

    public boolean isThreeStarsDisplayed() throws InterruptedException {
        List<WebElement> allWebElements = allElements(threeStarRaiting);
        for (int i = 0; i < allWebElements.size(); i++) {
            scroll(0, 600);
            allWebElements = allElements(threeStarRaiting);
            Thread.sleep(2000);
            if (allWebElements.size() > 50 || isElementDisplayed(wantToSeeMore)) {
                break;
            }
        }
        List<Double> hotelDouble = new ArrayList<>();
        for (WebElement element : allWebElements) {

            if (hotelDouble.size() < 50) {
                Double stars = Double.parseDouble(element.getText().split("-")[0]);
                hotelDouble.add(stars);
            } else {
                break;
            }
        }
        for (double star : hotelDouble) {
            if (star < 3.0 || star >= 4.0) {
                //System.out.println("Test failed");
                return false;
            }
        }
        return true;
    }

    public void hoverOverDistanceLink() {
        hoverOver(distance);
    }

    public void clickOnCityCenter() {
        clickOn(cityCenter);
    }

    public boolean isRadiusDisplayed() throws InterruptedException {
        List<WebElement> allCityCenters = allElements(cityCenterList);
        List<Double> doubleMiles = new ArrayList<>();

        for (WebElement mile : allCityCenters) {
            String str = mile.getText().substring(0,3);
            doubleMiles.add(Double.valueOf(str));
        }

        for (double d : doubleMiles) {
            if (d > 10) {
                boolean isWithinRadius = false;
            }
        }
        return true;
    }


    public void setHiltonInputField(String hotel) {
        setValue(hiltonInput,hotel);
    }

    public void clickOnHiltonSearch() {
        clickOn(hiltonButton);
    }


    public boolean isHotelDisplayed(){

        List<WebElement> allCityCenters = allElements(cityCenterList);
        List<Double> doubleMiles = new ArrayList<>();
        for (WebElement e : allCityCenters) {
            String str = e.getText().substring(0,3);
            doubleMiles.add(Double.valueOf(str));
        }
        boolean isWithinRadius = false;
        for (double d : doubleMiles) {
            if (d > 10) {
                isWithinRadius = false;
            }
        }
        return true;
    }
}

