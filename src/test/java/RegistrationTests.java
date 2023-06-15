import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class RegistrationTests extends TestBase {

//    WebDriver wd; // in class inheritance cannot be the same variable
//
//    @BeforeTest
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

 //   @Test

//    public void registrationPositive(){
//        //open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//
//        //fill login form
//        int i = (int)((System.currentTimeMillis()/1000)%3600);
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("domes"+ i +"@mail.com");
//
//        // Alt+shift parts words
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("123456Aa$");
//
//        //click on button Registration
//        wd.findElement(By.xpath("//button[2]")).click();
//
//        // Assert
////        Assert.assertTrue(wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
//        // Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//        pause(5000);
//        Assert.assertTrue(isElementPresent(By.xpath("//button")));
//    }
    @Test
    public void registrationPositive() {
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        String email = "domes"+ i +"@mail.com", password = "123456Aa$";
        openLoginForm();
        fillLoginForm(email, password);
        submitRegistration();
        pause(1000);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));
        tearDown();


    }

    @Test
    public void registrationNegativeWrongEmail(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        String email = "domes"+ i +"mail.com", password = "123456Aa$";
        //open login form
        openLoginForm();

        //fill login form
        fillLoginForm(email, password);

        //click on button Registration
        submitRegistration();
        tearDown();
            pause(1000);

        // Assert
    }
@Test
    public void registrationNegativeWrongPassword(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        String email = "domes"+ i +"@mail.com", password = "123Aa$";
        //open login form
        openLoginForm();

        //fill login form
        fillLoginForm(email, password);

        //click on button Registration
        submitRegistration();

        tearDown();

    }





}
