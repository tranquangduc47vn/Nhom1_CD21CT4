package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class t1 {
    public static void main(String[] args) {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);
        try{
            //B1: Lấy web
            driver.get("http://chibooks.vn/");

            //B2: Web -> Tiêu đề
            WebElement gt = driver.findElement(By.xpath("//img[@title='NHÀ SÁCH TRỰC TUYẾN CHIBOOKS']"));
            gt.click();

            //B3: Web -> Click -> Combo Sách
            WebElement sm =  driver.findElement(By.xpath("//span[normalize-space()='Combo Sách']"));
            sm.click();

            //B4: Web -> Click -> Combo Sách -> Sách mới phát hành(sắp xếp)
            WebElement smph =  driver.findElement(By.xpath("//a[contains(text(),'Sách mới phát hành')]"));
            smph.click();

            //B5: Web -> Click -> Combo Sách -> Sách mới phát hành(sắp xếp) -> xem thêm các sp còn lại 26-50
            WebElement smphcl =  driver.findElement(By.xpath("//div[@class='blockcontent']//div[1]//div[2]//ul[1]//li[3]//a[1]"));
            smphcl.click();

            //Làm giảm tg để xem quá trình
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }



        driver.quit();

    }
}
