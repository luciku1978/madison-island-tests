package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest extends TestBase{
    @Test
    public  void searchByOneKeywordTest(){
//

        Header header = PageFactory.initElements(driver,Header.class);

        String keyword = "vase";
//        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);
        header.search(keyword);
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
