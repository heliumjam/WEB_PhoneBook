package tests;

import manager.TestNgListener;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNgListener.class)

public class LoginTests extends TestBase {
    @BeforeMethod (alwaysRun = true)
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            app.getHelperUser().pause(2000);
        }
    }

    @Test (groups = {"smoke","positive"})
    public void loginPositiveTestOptimased() {
//        String email = "domes7@mail.com";String password = "123456Aa$";
        User user = new User()
                .withEmail("domes7@mail.com")
                .withPassword("123456Aa$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//button")));

    }
    @Test (groups = {"regress","negative"})
    public void loginNegativeTestWrongEmail() {
        //String email = "domes7mail.com";String password = "123456Aa$";
        User user = new User()
                .withEmail("domes7mail.com")
                .withPassword("123456Aa$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);
        //app.getUser().asseptAlertOk();
        Assert.assertTrue(app.getHelperUser().isWrongFormatMassage());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test (groups = {"regress","negative"})
    public void loginNegativeTestWrongPas() {
    //    String email = "domes7@mail.com";String password = "123Aa$";
        User user = new User()
                .withEmail("domes7@mail.com")
                .withPassword("1Aa$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);
        app.getHelperUser().asseptAlertOk();
    }
    @Test
    public void loginTestCheckSignOut() {
       // String email = "domes287@mail.com";String password = "123456Aa$";
        User user = new User()
                .withEmail("domes287@mail.com")
                .withPassword("123456Aa$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//button")));
        app.getHelperUser().logout();
        Assert.assertFalse(app.getHelperUser().isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @AfterMethod (alwaysRun = true)
    public void postcondition() {
        app.getHelperUser().pause(1000);
    }

}