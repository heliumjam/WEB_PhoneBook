package tests;

import manager.HelperUser;
import manager.TestNgListener;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.net.util.IPAddressUtil;

@Listeners(TestNgListener.class)
public class LoginTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
            app.getUser().pause(2000);
        }
    }

    @Test
    public void loginPositiveTestOptimased() {
//        String email = "domes7@mail.com";String password = "123456Aa$";
        User user = new User()
                .withEmail("domes7@mail.com")
                .withPassword("123456Aa$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void loginNegativeTestWrongEmail() {
        //String email = "domes7mail.com";String password = "123456Aa$";
        User user = new User()
                .withEmail("domes7mail.com")
                .withPassword("123456Aa$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        //app.getUser().asseptAlertOk();
        Assert.assertTrue(app.getUser().isWrongFormatMassage());
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

    @Test
    public void loginNegativeTestWrongPas() {
    //    String email = "domes7@mail.com";String password = "123Aa$";
        User user = new User()
                .withEmail("domes7@mail.com")
                .withPassword("1Aa$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        app.getUser().asseptAlertOk();
    }
    @Test
    public void loginPositiveTestCheckSignOut() {
       // String email = "domes287@mail.com";String password = "123456Aa$";
        User user = new User()
                .withEmail("domes287@mail.com")
                .withPassword("123456Aa$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
        app.getUser().logout();
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @AfterMethod
    public void postcondition() {
        app.getUser().pause(1000);
    }

}