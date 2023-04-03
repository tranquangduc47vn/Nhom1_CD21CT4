package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class t2 {
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

            //B3: Web -> Click -> Combo Sách -> Sreach(Trò lừa xảo quyệt)
            WebElement sre =  driver.findElement(By.xpath("//input[@id='input']"));
            sre.sendKeys("trò lừa xảo quyệt");

            //B4: Web -> Click -> Combo Sách -> Sreach(Trò lừa xảo quyệt) -> Tìm kiếm
            WebElement clsre = driver.findElement(By.xpath("//input[@alt='Go']"));
            clsre.click();

            //B5: Web -> Click -> Combo Sách -> Sreach(Trò lừa xảo quyệt) -> Tìm kiếm -> Xem chi tiết sản phẩm
            WebElement ctsp = driver.findElement(By.xpath("//a[contains(text(),'Combo 6 cuốn Trò lừa xảo quyệt')]"));
            ctsp.click();

            //Làm giảm tg để xem quá trình
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }



        driver.quit();

    }
}
