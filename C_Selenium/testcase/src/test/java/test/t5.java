package test;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class t5 {
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

            //B3: Web -> Đăng nhập -> (chưa có tk) Đăng Ký
            WebElement rg =  driver.findElement(By.xpath("//a[contains(text(),'Chưa có tài khoản, đăng ký')]"));
            rg.click();

            //B4: Đăng Ký Tài khoản
            //---Email
            WebElement email =  driver.findElement(By.xpath("//input[@id='email']"));
            email.sendKeys("theviet2011@gmail.com");

            //---Mật khẩu & nhập lại mật khẩu
            WebElement password =  driver.findElement(By.xpath("//input[@id='userpass']"));
            password.sendKeys("28122001pp");

            WebElement cfpassword =  driver.findElement(By.xpath("//input[@id='userpass1']"));
            cfpassword.sendKeys("28122001pp");
            //Thông tin cá nhân
            WebElement dx =  driver.findElement(By.xpath("//input[@id='gender1']"));
            dx.click();

            WebElement name =  driver.findElement(By.xpath("//input[@id='fullname']"));
            name.sendKeys("Nhom1");

            WebElement day =  driver.findElement(By.xpath("//select[@id='bd_day']"));
            day.sendKeys("28");

            WebElement month =  driver.findElement(By.xpath("//select[@id='bd_month']"));
            month.sendKeys("12");

            WebElement year =  driver.findElement(By.xpath("//input[@id='bd_year']"));
            year.sendKeys("2001");

            WebElement phone =  driver.findElement(By.xpath("//input[@id='telephone']"));
            phone.sendKeys("0978068367");

            WebElement dd =  driver.findElement(By.xpath("//input[@id='mobilephone']"));
            dd.sendKeys("0978057956");

            WebElement address =  driver.findElement(By.xpath("//input[@id='street']"));
            address.sendKeys("12 Trịnh Đình Thảo");

            WebElement city =  driver.findElement(By.xpath("//select[@id='stateid']"));
            city.sendKeys("Hồ Chí Minh");

            WebElement districtid =  driver.findElement(By.xpath("//select[@id='districtid']"));
            districtid.sendKeys("Tân Phú");
            //B5: Đăng ký thành công
            WebElement tk =  driver.findElement(By.xpath("//input[@value='Tạo mới tài khoản']"));
            tk.click();
            System.out.println("Đăng ký tài khoản thành công" +tk);


            //Sau khi hoàn thành bước đăng ký thì em đăng nhập vào
            //B6: Login vào
            WebElement email1 =  driver.findElement(By.xpath("//input[@id='username']"));
            email1.sendKeys("theviet2812@gmail.com");

            WebElement pw =  driver.findElement(By.xpath("//input[@id='password']"));
            pw.sendKeys("28122001pp");

            WebElement login =  driver.findElement(By.xpath("//input[@value='Đăng nhập']"));
            login.click();

            //B7: Thêm sản phảm vào danh sách yêu thích
            WebElement choose = driver.findElement(By.xpath("//div[@class='productname']//a[@title='Phố Hàng Bột, chuyện tầm phào mà nhớ'][contains(text(),'Phố Hàng Bột, chuyện tầm phào mà nhớ')]"));
            choose.click();

            WebElement love = driver.findElement(By.xpath("//img[@src='http://chibooks.vn/templates/images/add_wishlist.gif']"));
            love.click();

            //B8: Chụp màn hình
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            System.out.println("Đã chụp màn hình !");
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            String fileWithPath = "Theviet.png";
            File DestFile = new File(fileWithPath);
            FileHandler.copy(SrcFile,DestFile);
            //B9: Xóa sản phẩm
            WebElement dlsp = driver.findElement(By.xpath("//a[contains(text(),'[Xóa sản phẩm]')]"));
            dlsp.click();


            //Làm giảm tg để xem quá trình
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }



        driver.quit();

    }
}
