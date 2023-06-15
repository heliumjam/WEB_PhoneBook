import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests extends TestBase {
//    WebDriver wd;
//
//    @BeforeTest
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    @Test
    public void loginPositiveTest(){
        //open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        //fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("domes7@mail.com");

    // Alt+shift parts words
        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("123456Aa$");

        //click on button login
        wd.findElement(By.xpath("//button[1]")).click();

        //Assert
      //  Assert.assertTrue(isElementPresent(By.xpath("//button")));

     //   Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size()>0);
        pause(1000);
        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
        tearDown();

    }

     @Test
     public void loginNegativeTestWrongEmail(){
         //open login form

         wd.findElement(By.xpath("//*[.='LOGIN']")).click();
         //fill login form
         WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
         emailInput.click();
         emailInput.clear();
         emailInput.sendKeys("domes7mail.com");

         // Alt+shift parts words
         WebElement passInput = wd.findElement(By.xpath("//input[2]"));
         passInput.click();
         passInput.clear();
         passInput.sendKeys("123456Aa$");

         //click on button login
         wd.findElement(By.xpath("//button[1]")).click();

         //Assert
         pause(2000);
      //   Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);

        wd.switchTo().alert().accept();
        tearDown();
     }
    @Test
     public void loginNegativeTestWrongPass(){
        String email = "domes7@mail.com";
        String password = "1236Aa$";
        openLoginForm();
        fillLoginForm(email, password);
        submitLogin();

        pause(2000);
        wd.switchTo().alert().accept();
        tearDown();



     }

//    @AfterTest
//    public void tearDown(){
//        {
//
//        }
//    }
}
