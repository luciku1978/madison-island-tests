package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {
    @Test
    public  void searchByOneKeywordTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");

        String keyword = "vase";
//        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);
        driver.findElement(By.className("input-text")).sendKeys("vase" + Keys.ENTER);
//       driver.findElement(By.tagName("input")).click();
//    driver.findElement(By.name("q")).sendKeys("vase" + Keys.ENTER);
//        driver.findElement(By.linkText("WOMEN")).click();
//        driver.findElement(By.partialLinkText("SS")).click();

        List<WebElement> productNameContainers =
                driver.findElements(By.cssSelector(".product-name > a"));

        for(WebElement container : productNameContainers){
            String productName = container.getText();
//            System.out.println(productName);
            assertThat("Some of the product names do not contains the searched keyword",productName,
                    containsString(keyword.toUpperCase()));
        }
    }
}
