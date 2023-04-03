package test;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class t7 {
    public static void main(String[] args) {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);
        try{
            //B1: Lấy web
            driver.get("http://chibooks.vn/");

            //B2: Web -> Đăng nhập
            WebElement lg =  driver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]"));
            lg.click();

            //B3: Login vào
            WebElement email1 =  driver.findElement(By.xpath("//input[@id='username']"));
            email1.sendKeys("theviet2812@gmail.com");

            WebElement pw =  driver.findElement(By.xpath("//input[@id='password']"));
            pw.sendKeys("28122001pp");

            WebElement login =  driver.findElement(By.xpath("//input[@value='Đăng nhập']"));
            login.click();

            //B4: Xem giỏ hàng
            WebElement checkgh =  driver.findElement(By.xpath("//a[contains(text(),'Giỏ hàng (0)')]"));
            checkgh.click();

            //B5: Xem đơn hàng đặt hàng đã tạo trước đó
            WebElement checkls =  driver.findElement(By.xpath("//a[contains(text(),'Xem lịch sử mua hàng')]"));
            checkls.click();

            //B6: Chụp màn hình
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            System.out.println("Đã chụp màn hình !");
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            String fileWithPath = "Donhang.png";
            File DestFile = new File(fileWithPath);
            FileHandler.copy(SrcFile,DestFile);



            //Làm giảm tg để xem quá trình
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }



        driver.quit();

    }
}
