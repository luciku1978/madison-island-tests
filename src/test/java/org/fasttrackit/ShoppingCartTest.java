package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest extends TestBase{

    @Test
    public void addToCartFromSearchResultsTest(){
        WebDriver driver = new ChromeDriver();
        driver.get(AppConfig.getSiteUrl());
        System.out.println("Opened homepage.");

        String keyword = "vase";
        Header header = PageFactory.initElements(driver,Header.class);
        header.search(keyword);

        driver.findElement(By.className("input-text")).sendKeys("vase" + Keys.ENTER);
        System.out.println("Pressed enter in search fiels.");

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

        String productName = "Herald Glass Vase";
//        driver.findElement(By.xpath
//                ("//div[@class='product-info' and .//a[text()='"+productName+"']]//button[@title='Add to Cart']"))
//                .click();
        productsGrid.addProductToCart(productName,driver);
        String successMessage = driver.findElement(By.className("success-msg")).getText();
        assertThat("Unexpected success message",successMessage,is(productName+" was added to your shopping cart."));


        WebElement productNameInCart = driver.findElement((By.xpath("//table[@id='shopping-cart-table']//a[text()='"+productName+"']")));
        assertThat("Product not displayed in cart!",productNameInCart.isDisplayed());
    }
}
