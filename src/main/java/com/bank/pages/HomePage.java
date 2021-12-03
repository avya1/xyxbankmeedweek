package com.bank.pages;

import com.bank.utility.Utilities;
import org.openqa.selenium.By;

public class HomePage extends Utilities {
By bankMangerLogin=By.xpath("//button[contains(text(),'Bank Manager Login')]");
By customerLogin=By.xpath("//button[@ng-click=\"customer()\"]");
By homeButton=By.xpath("//button[@class=\"btn home\"]");
public  void  clickOnHomeButton(){
    clickOnElement(homeButton);
}

public void clickOnBankManagerLogin(){
    clickOnElement(bankMangerLogin);

}
public void clickOnCustomerLogin(){
    clickOnElement(customerLogin);
}


}
