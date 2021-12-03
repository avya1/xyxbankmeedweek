package com.bank.utility;

import com.bank.drivermanager.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Utilities  extends DriverManager {
    public void clickOnElement(By by){
        WebElement loginLink = driver.findElement(by);
        loginLink.click();

    }
    public void productsCompareAndSortList(String sortBy) {
        List<WebElement> products = driver.findElements(By.linkText(sortBy));
        List<String> names = new ArrayList<String>();
        for (WebElement e : products) {
            names.add(e.getText());
        }
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames.equals(names));
        Assert.assertEquals(names,sortedNames);

    }
    public void doubleClickOnElement(By by){
        Actions actions=new Actions(driver);
        actions.doubleClick(driver.findElement(by)).perform();
    }
    public void mouseHoverOnElement(WebElement menu){
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).build().perform();
    }

    public WebElement waitUntilVisibilityOfElementLocated(By by,int time){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));


    }
    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
               /* .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

       */


        WebElement element = wait.until(new Function<WebDriver,WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }



    /**
     * this method will get text from element
     * @param by
     * @return
     */
    public String getTextFromElement(By by){
        driver.findElement(by).getText();//one way
        //second way to write
        WebElement message = driver.findElement(by);
        String actualMessage = message.getText();
        return actualMessage;

    }
    public void selectFromDropDown(By by,String value){
        WebElement dropDown1=driver.findElement(by);
        dropDown1.click();
        Select select1=new Select(dropDown1);
        select1.selectByValue(value);
    }


    /**
     * this method will send text on element
     * @param by
     * @param text
     */
    public void sendTextElement(By by,String text){
        driver.findElement(by).sendKeys(text);

    }

    /**
     *
     * @param by
     * @param text
     */
    public  void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown=driver.findElement(by);
        Select select=new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void verifyPage(String expectedResult, By by){
        WebElement compare = driver.findElement(by);
        String actualResult = compare.getText();
        Assert.assertEquals( expectedResult, actualResult);


    }
    public void alertPopUPAccept(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public void alertPopUpWindowAndVerifyText(String expResult){
        Alert alert=driver.switchTo().alert();
        String actualResult=alert.getText();
        System.out.println(actualResult);
        Assert.assertEquals(expResult,actualResult);
        alert.accept();
    }
    public void mHoverAndClick(By mouseHover,By mouseClick){
        Actions actions=new Actions(driver);
        WebElement hover=driver.findElement(mouseHover);
        WebElement click1=driver.findElement(mouseClick);
        actions.moveToElement(hover).moveToElement(click1).click().perform();
    }

}
