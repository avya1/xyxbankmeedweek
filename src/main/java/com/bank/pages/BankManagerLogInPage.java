package com.bank.pages;

import com.bank.utility.Utilities;
import org.openqa.selenium.By;

public class BankManagerLogInPage extends Utilities {
    By addCustomer=By.xpath("//button[@ng-class='btnClass1']");
    public void clickOnAddCustomerTab(){
        clickOnElement(addCustomer);
    }

}
