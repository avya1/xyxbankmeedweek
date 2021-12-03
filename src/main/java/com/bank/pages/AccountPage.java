package com.bank.pages;

import com.bank.utility.Utilities;
import org.openqa.selenium.By;

public class AccountPage extends Utilities {
    By openAccount=By.xpath("//button[@ng-click='openAccount()']");
    By customerSearch= By.xpath("//select[@id='userSelect']");//6
    By currency=By.xpath("//select[@id='currency']");//Pound
    By process=By.xpath("//button[@type='submit']");

    public void clickOnOpenAccount(){
        clickOnElement(openAccount);
    }
    public void selectCustomerSearch()  {

        selectFromDropDown(customerSearch,"6");

    }
    public void selectCurrency(){
        selectFromDropDown(currency,"Pound");
    }
    public void clickOnProcessButton(){
        clickOnElement(process);
    }
    public void verifyPopWindowTextAndAccept(String exp){
        alertPopUpWindowAndVerifyText(exp);
    }


}
