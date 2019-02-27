package org.fasttrackit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    protected WebDriver driver;

    @Before
    public void setup(){

        driver = DriverManager.initDriver("chrome");
        driver.get(AppConfig.getSiteUrl());
        System.out.println("Opened homepage.");
    }

    @After
    public void tearDown(){
        driver.quit();
        System.out.println("Browser closed after testing.");
    }
}
