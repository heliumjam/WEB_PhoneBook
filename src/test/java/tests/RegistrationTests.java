package tests;

import manager.TestNgListener;
import model.User;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;


@Listeners(TestNgListener.class)

public class RegistrationTests extends TestBase {

    @BeforeMethod (alwaysRun = true)
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            app.getHelperUser().pause(2000);
        }
    }

//    @Test
//    public void registrationPositive() {
//        int i = (int)((System.currentTimeMillis()/1000)%3600);
//        String email = "domes"+ i +"@mail.com", password = "123456Aa$";
//
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm(email, password);
//        app.getUser().submitRegistration();
//        app.getUser().pause(2000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

//    }
    @Test (groups = {"smoke","positive", "regress"})
    public void registrationPositive() {
    int i = (int)((System.currentTimeMillis()/1000)%3600);
    User user = new User()
            .withEmail("domes"+ i +"@mail.com")
            .withPassword("123456Aa$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//button")));

        logger.info("User registration Positive successfully with Email: : "
                      + user.getEmail() +" & Password: " + user.getPassword());

    }

    @Test (groups = {"regress","negative"})
    public void registrationNegativeWrongEmail(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user = new User()
                .withEmail("domes"+ i +"mail.com")
                .withPassword("123456Aa$");
//        String email = "domes"+ i +"mail.com", password = "123456Aa$";
        app.getHelperUser().openLoginForm();
      //  app.getUser().fillLoginForm(email, password);
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(2000);
        app.getHelperUser().asseptAlertOk();
    }
@Test (groups = {"regress","negative"})
    public void registrationNegativeWrongPassword(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
 //       String email = "domes"+ i +"@mail.com", password = "123Aa$";
    User user = new User()
            .withEmail("domes"+ i +"@mail.com")
            .withPassword("123Aa$");
        app.getHelperUser().openLoginForm();
 //       app.getUser().fillLoginForm(email, password);
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(2000);
        app.getHelperUser().asseptAlertOk();

    }
    @Test (groups = {"regress","negative"})
    public void registrationNegativeUserExits() {
//        String email = "domes7@mail.com", password = "123456Aa$";
        User user = new User()
                .withEmail("domes7@mail.com")
                .withPassword("123456Aa$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(2000);
        app.getHelperUser().asseptAlertOk();
    }

    @AfterMethod (alwaysRun = true)
        public void postcondition() {
        app.getHelperUser().pause(2000);
    }

}
