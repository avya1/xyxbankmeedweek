package com.bank.testbase;

import com.bank.propertyreader.PropertyReader;
import com.bank.utility.Utilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utilities {
    String browser= PropertyReader.getInstance().getProperty("browser");
    @BeforeMethod
    public void setUp()
    {
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown()
    {
        closeBrowser();
    }
}
