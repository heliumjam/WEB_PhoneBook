package tests;

import manager.HelperUser;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        String email = "domes7@mail.com";
        String password = "123456Aa$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @Test
    public void loginNegativeTestWrongEmail() {
        String email = "domes7mail.com";
        String password = "123456Aa$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        app.getUser().asseptAlertOk();
    }

    @Test
    public void loginNegativeTestWrongPas() {
        String email = "domes7@mail.com";
        String password = "123Aa$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        app.getUser().asseptAlertOk();
    }
    @Test
    public void loginPositiveTestChekSignOut() {
        String email = "domes287@mail.com";
        String password = "123456Aa$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
    }

    @AfterMethod
    public void postcondition() {
        app.getUser().pause(1000);
    }

}