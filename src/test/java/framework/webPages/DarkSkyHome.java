package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DarkSkyHome extends BasePage{

    private By darkSkyAPI = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private By signUp = By.xpath("//a[@class='button filled']");
    private By registerButton = By.xpath("//button[contains(text(),'Register')]");
    private By logo = By.xpath("//a[@class='logo']//img");
    private By currentTemperature = By.xpath("//span[@class='summary swap']");
    private By summaryTemperature = By.xpath("//span[@class='summary-high-low']");
    private By temperatureRange = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]");
    private By lowestTemperature = By.xpath("//div[@id='week']/a[1]/span[2]/span[1]");
    private By highestTemperature = By.xpath("//div[@id='week']/div[2]/div[1]//div[1]/span[1]/span[1]");
    private By lowestCorrect = By.xpath("//div[@id='week']/a[1]/span[2]/span[3]");
    private By highestCorrect = By.xpath("//div[@id='week']/div[2]//div[2]/div[1]/span[3]/span[1]");
    private By allTimes = By.xpath("//div[@id='timeline']//div[@class='hours']/*/span");
    private By now = By.xpath("//div[@id='timeline']//span[@class='hour first']");
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

    public void clickOnTodayTemp()throws InterruptedException {
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



    public void checkTwoHourIncrement(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        calendar.setTime(date);
        String now = simpleDateFormat.format(calendar.getTime());
        int nowInt = Integer.parseInt(now);
        System.out.println(nowInt);


        ArrayList<Integer> actualTimes = new ArrayList<>();
        List<WebElement> hours = SharedSD.getDriver().findElements(allTimes);
        for(WebElement hour : hours){
            if (hour.getText().equals("Now")) {
                continue;
            } else {
                actualTimes.add(deriveMilitaryTime(hour.getText()));
            }
        }
        Assert.assertEquals(actualTimes,getExpectedTimes());


    }

    public int deriveMilitaryTime(String timeString) {
        int positionOfTimePeriod = timeString.length() - 2;
        String period = timeString.substring(positionOfTimePeriod);
        int time = Integer.parseInt(timeString.substring(0, positionOfTimePeriod));
        if (period.equals("pm")) {
            time += 12;
        }
        return time;
    }

    public ArrayList<Integer> getExpectedTimes(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        calendar.setTime(date);
        String now = simpleDateFormat.format(calendar.getTime());
        int nowInt = Integer.parseInt(now);
        System.out.println(nowInt);

        ArrayList<Integer> expectedTimes = new ArrayList<>();
        int interval = 2;
        int maxTime = 24;
        for(int i = 0; i < 11 ; i++){
            if (nowInt + interval >= maxTime) {
                expectedTimes.add(nowInt+interval-maxTime);
            }
            else {
                expectedTimes.add(nowInt+interval);
            }
            interval+=2;
        }
        return expectedTimes;
    }



}



