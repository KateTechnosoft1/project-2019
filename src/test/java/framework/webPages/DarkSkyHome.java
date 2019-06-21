package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.NoSuchElementException;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DarkSkyHome extends BasePage{

    private By darkSkyAPI = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private By signUp = By.xpath("//a[@class='button filled']");
    private By registerButton = By.xpath("//button[contains(text(),'Register')]");
    private By logo = By.xpath("//a[@class='logo']//img");
    private By currentTemperature = By.xpath("//span[@class='summary swap']");
    private By summaryTemperature = By.xpath("//span[@class='summary-high-low']");
    private By temperatureRange = By.xpath("//a[@class='day revealed']//span[@class='date__icon__details']");
    private By lowestTemperature = By.xpath("//a[@class='day revealed']//span[@class='minTemp']");
    private By highestTemperature = By.xpath("//a[@class='day revealed']//span[@class='maxTemp']");
    private By lowestCorrect = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']/[@class='temp']");
    private By highestCorrect = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap'/[@class='temp']");
    private By hourSpans = By.className("hour");
    private ByChained test = new ByChained(By.className("hour"), By.tagName("span"));



    public void clickOnDarkskyAPI(){
        clickOn(darkSkyAPI);
    }

    public void clickOnSignUp(){
        clickOn(signUp);
    }

    public void clickOnRegister(){
        clickOn(registerButton);
    }

    public boolean isLogoDisplayed(){
        return webAction(logo).isDisplayed();
    }

    public boolean isButtonDisplayed(){
        return webAction(registerButton).isDisplayed();
    }



    public String currentTemperature(){
        return  webAction(currentTemperature).getText();

    }

    public boolean summaryTemperature(){
        boolean currentResult = true;
        String newSummary = currentTemperature().toString();
        String numbersLine = newSummary.replaceAll("[^-?0-9]+", " ");
        String[] digitsFromSummary = numbersLine.split("\\s");
        List<Integer> intArrayList = new ArrayList<>();
        int current = 0;
        for(String string : digitsFromSummary){
            if(!string.equals("")){
                System.out.println(string);
                intArrayList.add(Integer.parseInt(string));
                current = Integer.parseInt(string);
            }
        }


        ArrayList<String> summary = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        for(WebElement temp : SharedSD.getDriver().findElements(summaryTemperature)){
            summary.add(temp.getText());
            for(String s : summary){
                string.append(s);
                string.append("\t");
            }
            String newString = string.toString();
            String numbersFromString = newString.replaceAll("[^0-9]+", " ");
            String[] digitsFromString = numbersFromString.split(" ");

            List<Integer> intArray = new ArrayList<>();
            for(String str : digitsFromString){
                if(!str.equals("")){
                    intArray.add(Integer.parseInt(str));
                    Collections.sort(intArray);
                }
            }
            System.out.println(intArray);
            if(current>= intArray.get(0) && current <= intArray.get(intArray.size()-1)){
                currentResult = false;
            }
        }
        return currentResult;
    }

    public void scrollToElement()throws InterruptedException {
        scroll(temperatureRange);
        Thread.sleep(2000);
        clickOn(temperatureRange);
    }

    public boolean isTemperatureCorrect(){
        boolean isCorrectTemperature = false;
        String todaysTempLowest = getTextFromElement(lowestTemperature);
        String todaysTempHighest = getTextFromElement(highestTemperature);
        String dayLowest = getTextFromElement(lowestCorrect);
        String dayHighest = getTextFromElement(highestCorrect);

        if(todaysTempLowest.equals(dayLowest) && todaysTempHighest.equals(dayHighest)){
            isCorrectTemperature = true;
        }


        return isCorrectTemperature;
    }



    public ArrayList<String> getTimeSlots(){
        ArrayList<String> timeSlots = new ArrayList<>();
        for(WebElement item : SharedSD.getDriver().findElements(By.xpath("//span[@class='hour']/span/"))){
                timeSlots.add(item.getText());
            }

        return timeSlots;
        }
    }



