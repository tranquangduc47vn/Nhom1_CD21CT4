package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class t4 {
    public static void main(String[] args) {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);
        try{
            //B1: Lấy web
            driver.get("http://chibooks.vn/");

            //B2: Web -> Click -> Combo Sách
            WebElement sm =  driver.findElement(By.xpath("//span[normalize-space()='Combo Sách']"));
            sm.click();

            //B3: Web -> Click -> Combo Sách -> Mua 2 sản phẩm (trò lừa xảo quyệt) và một sản phẩm khác
            WebElement buy1 =  driver.findElement(By.xpath("//div[@class='productname']//a[@title='Combo 6 cuốn Trò lừa xảo quyệt'][contains(text(),'Combo 6 cuốn Trò lừa xảo quyệt')]"));
            buy1.click();
            WebElement addbuy1 =  driver.findElement(By.xpath("//form[@name='quantity']//input[@type='image']"));
            addbuy1.click();
            WebElement buy2 =  driver.findElement(By.xpath("//a[contains(text(),'Combo 2 cuốn Đức vua hắc ám')]"));
            buy2.click();
            WebElement addbuy2 =  driver.findElement(By.xpath("//form[@name='quantity']//input[@type='image']"));
            addbuy2.click();

            //B4: Sau khi add 2 sản phẩm vào xem giỏ hàng kiểm tra
            WebElement ktsp =  driver.findElement(By.xpath("//img[@src='http://chibooks.vn/templates/images/cart_view.gif']"));
            ktsp.click();

            //B5: Bấm vào thanh toán giỏ hàng
            WebElement tt = driver.findElement(By.xpath("//input[@name='checkout']"));
            tt.click();

            //Làm giảm tg để xem quá trình
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }



        driver.quit();

    }
}
