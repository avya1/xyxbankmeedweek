package com.bank.pages;

import com.bank.utility.Utilities;
import org.openqa.selenium.By;

public class AddCustomerPage extends Utilities {
    By firstName=By.xpath("//input[@placeholder='First Name']");
    By lastName=By.xpath("//input[@placeholder='Last Name']");
    By postCode=By.xpath("//input[@placeholder='Post Code']");
    By addCustomerButton=By.xpath("//button[@class='btn btn-default']");

    public void fillFirstName(){
        sendTextElement(firstName,"james");
    }
    public void fillLastName(){
        sendTextElement(lastName,"ore");
    }
    public void fillPostCode(){
        sendTextElement(postCode,"40001");
    }
    public void clickOnAddCustomerButton(){
        clickOnElement(addCustomerButton);
    }
    public void verifyMessageAndAcceptIt(String exp){

        alertPopUpWindowAndVerifyText(exp);
    }

}
