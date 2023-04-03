package test;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class t9 {
    public static void main(String[] args) {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);
        try{
            //B1: Lấy web
            driver.get("http://chibooks.vn/");

            //B2: Vào combo sách  add sản phẩm vào
            WebElement combo = driver.findElement(By.xpath("//span[normalize-space()='Combo Sách']"));
            combo.click();

            WebElement choose = driver.findElement(By.xpath("//a[contains(text(),'Combo 6 cuốn Trò lừa xảo quyệt')]"));
            choose.click();

            WebElement addsp = driver.findElement(By.xpath("//form[@name='quantity']//input[@type='image']"));
            addsp.click();

            WebElement gh = driver.findElement(By.xpath("//img[@src='http://chibooks.vn/templates/images/cart_view.gif']"));
            gh.click();

            //B3: Nhập mã thẻ để giảm giá
            WebElement km = driver.findElement(By.xpath("//input[@name='couponcode']"));
            km.sendKeys("123456");

            WebElement clickkm = driver.findElement(By.xpath("//input[@name='updatecoupon']"));
            clickkm.click();

            //Làm giảm tg để xem quá trình
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }



        driver.quit();

    }
}
