package com.itacademy;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.itacademy.listeners.LocalListener;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class SelenideCompareProductsTest {

    @BeforeMethod
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
        SelenideLogger.addListener("localListener", new LocalListener());
    }
    @Test
    public void test1() throws InterruptedException {

        open("https://react-shopping-cart-67954.firebaseapp.com/"); //поднимает драйвер и создает сессию
        String itemInCatalogText = $(By.xpath("//p[@class = 'sc-124al1g-4 eeXMBo']")).getText();

        $(By.xpath("//*[@class = 'sc-124al1g-0 jCsgpZ']")).click();
        String itemInBasketText = $(By.xpath("//p[@class = 'sc-11uohgb-2 elbkhN']")).getText();
        Thread.sleep(4000);

        Assert.assertEquals(itemInBasketText,itemInCatalogText);
    }
    @Test
    public void test2() throws InterruptedException {
        open("https://react-shopping-cart-67954.firebaseapp.com/");

        // получаем тексты всех элементов
        List<String> namesOfElements = $$(By.xpath("//p[@class = 'sc-124al1g-4 eeXMBo']")).texts();
        for (String text : namesOfElements) {
        }
        Thread.sleep(5000);
        List<String> itemsInCart = $$(By.xpath("//*[@class = 'sc-11uohgb-2 elbkhN']")).texts();
        for (String text : itemsInCart) {
        }

        Assert.assertEquals(namesOfElements,itemsInCart);
    }

    @Test
    public void test3() throws InterruptedException {
        open("https://react-shopping-cart-67954.firebaseapp.com/");
        Thread.sleep(4000);
        List<String> allProductsList = $$(By.xpath("//*[@class = 'sc-124al1g-4 eeXMBo']")).texts();
        $(By.xpath("//span[@class = 'checkmark']")).click();
        Thread.sleep(4000);

        List<String> xsProducts = $$(By.xpath("//*[@class = 'sc-124al1g-4 eeXMBo']")).texts();
        for (String text : xsProducts){
        }
        if (xsProducts.size() < allProductsList.size()) {
            System.out.println("Размер списка текущих продуктов меньше размера списка всех продуктов");
        } else {
            System.out.println("Размер списка текущих продуктов больше или равен размеру списка всех продуктов");
        }
    }

    @Test
    public void test4() throws InterruptedException {
        open("https://react-shopping-cart-67954.firebaseapp.com/");
        List <String> listOfProductsNaming = $$(By.xpath("//*[@class = 'sc-ebmerl-4 iliWeY']/p")).texts();
        $(By.xpath("//span[@class = 'checkmark']")).click();
        Thread.sleep(3000);
        List<String> sizeListOfProductsNaming = $$(By.xpath("//*[@class = 'sc-ebmerl-4 iliWeY']/p")).texts();
        if (listOfProductsNaming.equals(sizeListOfProductsNaming)) {
            System.out.println("Списки продуктов совпадают");
        } else {
            System.out.println("Списки продуктов не совпадают");
        }
    }




}
