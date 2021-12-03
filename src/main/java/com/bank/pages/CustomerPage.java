package com.bank.pages;

import com.bank.utility.Utilities;
import org.openqa.selenium.By;

public class CustomerPage extends Utilities {
By deposit=By.xpath("//button[@ng-class=\"btnClass2\"]");
By amount=By.xpath("//input[@placeholder=\"amount\"]");
By depositButton=By.xpath("//button[@class=\"btn btn-default\"]");
By depositSuccessfully=By.xpath("//span[@class=\"error ng-binding\"]");
By withDrawl=By.xpath("//button[@class=\"btn btn-lg tab btn-primary\"]");
By withDrawlAmount=By.xpath("//input[@class=\"form-control ng-pristine ng-invalid ng-invalid-required ng-touched\"]");
By withDrawlButton=By.xpath("//button[@type='submit']");
By transactionSuccessful=By.xpath("//span[@class='error ng-binding']");

public void clickOnDeposit(){
    clickOnElement(deposit);
}
public void enterAmount100(){

   sendTextElement(amount,"100");

}
public void clickOnDepositButtonLast(){
    clickOnElement(depositButton);
}
public void verifyDepositSuccessfully(String exp){
    verifyPage(exp,depositSuccessfully);

    }
    public void clickOnWithDraw(){
    clickOnElement(withDrawl);
    }
    public void enterWithDrawlAmount(){
    sendTextElement(withDrawlAmount,"50");
    }
    public void clickOnWithDrawlButton(){
    clickOnElement(withDrawlButton);
    }
    public void verifyTransactionSuccessful(String exp){
    verifyPage(exp,transactionSuccessful);
    }
}
