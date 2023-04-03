package test;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class t8 {
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

            //B4: Do là kh đặt hàng nên kh thể đặt hàng lại

            //B5: Tự add sản phẩm vào lại
            WebElement choose = driver.findElement(By.xpath("//div[@class='productname']//a[@title='Phố Hàng Bột, chuyện tầm phào mà nhớ'][contains(text(),'Phố Hàng Bột, chuyện tầm phào mà nhớ')]"));
            choose.click();

            //B6: Thêm vào giỏ hàng
            WebElement addsp = driver.findElement(By.xpath("//form[@name='quantity']//input[@type='image']"));
            addsp.click();

            //B5: Xem giỏ hàng
            WebElement checkgh =  driver.findElement(By.xpath("//a[contains(text(),'Giỏ hàng (1)')]"));
            checkgh.click();

            //B6: Thay đổi số lượng 1 -> 10
            WebElement upsl =  driver.findElement(By.xpath("//input[@id='prd37900']"));
            upsl.clear();
            upsl.sendKeys("10");

            //B7: Cập nhập thành tiền và số lượng thay đổi
            WebElement updatesl =  driver.findElement(By.xpath("//input[@src='http://chibooks.vn/templates/images/cart_update.gif']"));
            updatesl.click();

            //B8: Thanh toán sau khi cập nhập
            WebElement ttsp = driver.findElement(By.xpath("//input[@name='checkout']"));
            ttsp.click();

            //B9: Địa chỉ thanh toán và địa chỉ giao hàng
            WebElement dctt = driver.findElement(By.xpath("//input[@id='copyuser']"));
            dctt.click();
            WebElement quan = driver.findElement(By.xpath("//select[@id='billsuburbid']"));
            quan.sendKeys("Tân Phú");
            WebElement dcgh = driver.findElement(By.xpath("//input[@id='copybill']"));
            dcgh.click();

            //B10: Chụp màn hình sau khi thay đổi số lượng
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            System.out.println("Đã chụp màn hình !");
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            String fileWithPath = "Giaohang.png";
            File DestFile = new File(fileWithPath);
            FileHandler.copy(SrcFile,DestFile);



            //Làm giảm tg để xem quá trình
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }



        driver.quit();

    }
}
