package com.bank.pages;

import com.bank.utility.Utilities;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CustomerLoginPage extends Utilities {
By searchCustomer=By.xpath("//select[@id='userSelect']");
By loginButton=By.xpath("//button[@class='btn btn-default']");

By logOut=By.xpath("//span[text()='james ore']");



public void searchCustomerFromDropDown() throws InterruptedException {
    selectFromDropDown(searchCustomer,"6");
    Thread.sleep(3000);

}
public void clickOnLoginButton(){
    clickOnElement(loginButton);
}
public void verifyLogOutTabAndClickOnLogOutTab(){
    Boolean isDisplay=driver.findElement(By.xpath("//button[@class='btn logout']")).isDisplayed();
    if(isDisplay){
        String exp="james ore";
        verifyPage(exp,logOut);
    }
    else{
        System.out.println("logOut tab is not display");
    }



}
}
