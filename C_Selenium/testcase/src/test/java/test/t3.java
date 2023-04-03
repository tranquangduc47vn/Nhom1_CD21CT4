package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class t3 {
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

            //B3: Web -> Click -> Combo Sách -> Mua sản phẩm(trò lừa xảo quyệt)
            WebElement buy =  driver.findElement(By.xpath("//div[@class='productname']//a[@title='Combo 6 cuốn Trò lừa xảo quyệt'][contains(text(),'Combo 6 cuốn Trò lừa xảo quyệt')]"));
            buy.click();

            //B4: Web -> Click -> Combo Sách -> Mua sản phẩm(trò lừa xảo quyệt) -> Xem giỏ hàng -> update sản phẩm lên 100 -> Cập nhập
            WebElement add = driver.findElement(By.xpath("//form[@name='quantity']//input[@type='image']"));
            add.click();
            WebElement skadd = driver.findElement(By.xpath("//a[contains(text(),'Giỏ hàng (1)')]"));
            skadd.click();
            WebElement upadd = driver.findElement(By.xpath("//input[@id='prd37670']"));
            upadd.clear();
            upadd.sendKeys("100");
            WebElement clup = driver.findElement(By.xpath("//input[@src='http://chibooks.vn/templates/images/cart_update.gif']"));
            clup.click();

            //B5:Web -> Click -> Combo Sách -> Mua sản phẩm(trò lừa xảo quyệt) -> Xem giỏ hàng -> update sản phẩm lên 100 -> Cập nhập -> Xóa hết
            WebElement dlsp = driver.findElement(By.xpath("//img[@src='http://chibooks.vn/templates/images/cart_delete.gif']"));
            dlsp.click();

            //Làm giảm tg để xem quá trình
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }



        driver.quit();

    }
}
