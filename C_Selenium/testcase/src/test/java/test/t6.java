package test;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class t6 {
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

            //B4: Thêm sản phảm vào danh sách yêu thích
            WebElement choose = driver.findElement(By.xpath("//div[@class='productname']//a[@title='Phố Hàng Bột, chuyện tầm phào mà nhớ'][contains(text(),'Phố Hàng Bột, chuyện tầm phào mà nhớ')]"));
            choose.click();

            WebElement love = driver.findElement(By.xpath("//img[@src='http://chibooks.vn/templates/images/add_wishlist.gif']"));
            love.click();

            //B5: Sau khi thêm danh sách yêu thích thì thêm sản phẩm đó vào giỏ hàng
            WebElement ctsp = driver.findElement(By.xpath("//div[@class='productname']//a[@title='Phố Hàng Bột, chuyện tầm phào mà nhớ'][contains(text(),'Phố Hàng Bột, chuyện tầm phào mà nhớ')]"));
            ctsp.click();

            WebElement addsp = driver.findElement(By.xpath("//form[@name='quantity']//input[@type='image']"));
            addsp.click();

            //B6: Tiến vào phần thanh toán mặt hàng sau khi thêm
            WebElement ttsp = driver.findElement(By.xpath("//tbody/tr/td[@class='mycart']/div[@class='block']/div[1]/a[1]"));
            ttsp.click();

            WebElement ttsp2 = driver.findElement(By.xpath("//input[@name='checkout']"));
            ttsp2.click();

            //B7: Địa chỉ thanh toán và địa chỉ giao hàng
            WebElement ttcu = driver.findElement(By.xpath("//input[@id='copyuser']"));
            ttcu.click();
            WebElement quan = driver.findElement(By.xpath("//select[@id='billsuburbid']"));
            quan.sendKeys("Tân Phú");
            WebElement ttcu2 = driver.findElement(By.xpath("//input[@id='copybill']"));
            ttcu2.click();

            //B8: Chụp màn hình sau khi vào thanh toán
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            System.out.println("Đã chụp màn hình !");
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            String fileWithPath = "Thanhtoan.png";
            File DestFile = new File(fileWithPath);
            FileHandler.copy(SrcFile,DestFile);

            //B9: Tiếp tục thanh toán
//            WebElement pay = driver.findElement(By.xpath("//input[@src='http://chibooks.vn/templates/images/bill_continute.gif']"));
//            pay.click();


            //Làm giảm tg để xem quá trình
            Thread.sleep(20000);
        }catch (Exception e){
            e.printStackTrace();
        }



        driver.quit();

    }
}
