package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class ProductChangingColorTest {

    @Test
    public void changeTheColorForItemFromSearchResultsTest() {

        WebDriver driver = new ChromeDriver();
        driver.get(AppConfig.getSiteUrl());
        System.out.println("Opened homepage.");

        String keyword = "vase";
        Header header = PageFactory.initElements(driver,Header.class);

        driver.findElement(By.className("input-text")).sendKeys("vase" + Keys.ENTER);

        //se poate face si cu link = http...link-ul imaginii, dar testul nu e stabil

        driver.findElement(By.className("option-black")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String productName = "Modern Murray Ceramic Vase";
        driver.findElement(By.xpath("//div[@class='product-info' and  .//a[text() ='" + productName + "'] and .//span[@class ='swatch-label']]//img[@alt = 'black']")).click();

        String initialProductImage = driver.findElement(By.xpath("//div[@class='category-products']//a[@title ='Modern Murray Ceramic Vase']//img[@class!='hidden']")).getAttribute("src");
//        assertThat()

    }
}