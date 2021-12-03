package com.bank.testsuits;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BankTest extends TestBase {
    HomePage homePage=new HomePage();
    AddCustomerPage addCustomerPage=new AddCustomerPage();
    BankManagerLogInPage bankManagerLogInPage=new BankManagerLogInPage();
    AccountPage accountPage=new AccountPage();
    CustomerLoginPage customerLoginPage=new CustomerLoginPage();
    CustomerPage customerPage=new CustomerPage();


    @Test
    public void bankMangerShouldAddCustomerSuccessfully(){
    homePage.clickOnBankManagerLogin();
    bankManagerLogInPage.clickOnAddCustomerTab();
    addCustomerPage.fillFirstName();
    addCustomerPage.fillLastName();
    addCustomerPage.fillPostCode();
    addCustomerPage.clickOnAddCustomerButton();
    String expected="Customer added successfully with customer id :6";
        System.out.println(expected);
    addCustomerPage.verifyMessageAndAcceptIt(expected);
    }

    @Test
    public void bankManagerShouldOpenAccountSuccessfully(){
        bankMangerShouldAddCustomerSuccessfully();
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLogin();
        accountPage.clickOnOpenAccount();
        accountPage.selectCustomerSearch();
        accountPage.selectCurrency();
        accountPage.clickOnProcessButton();
        String exp="Account created successfully with account Number :1016";
        System.out.println(exp);
        accountPage.verifyPopWindowTextAndAccept(exp);
    }
    @Test
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //bankMangerShouldAddCustomerSuccessfully();
        bankManagerShouldOpenAccountSuccessfully();
        homePage.clickOnHomeButton();
    homePage.clickOnCustomerLogin();
    customerLoginPage.searchCustomerFromDropDown();
    customerLoginPage.clickOnLoginButton();
    Thread.sleep(3000);
    customerLoginPage.verifyLogOutTabAndClickOnLogOutTab();
    }
    @Test
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        customerShouldLoginAndLogoutSuccessfully();
       Thread.sleep(2000);
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        customerLoginPage.searchCustomerFromDropDown();
        Thread.sleep(2000);
        customerLoginPage.clickOnLoginButton();
        customerPage.clickOnDeposit();
        customerPage.enterAmount100();
        customerPage.clickOnDepositButtonLast();
        String exp="Deposit Successful";
        customerPage.verifyDepositSuccessfully(exp);
    }
    @Test
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        customerShouldDepositMoneySuccessfully();
        Thread.sleep(2000);
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        customerLoginPage.searchCustomerFromDropDown();
        customerLoginPage.clickOnLoginButton();
        customerPage.clickOnWithDraw();
        customerPage.enterWithDrawlAmount();
        customerPage.clickOnWithDrawlButton();
        String exp="Transaction successful";
        customerPage.verifyTransactionSuccessful(exp);


    }
}
