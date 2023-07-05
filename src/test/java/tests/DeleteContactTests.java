package tests;

import model.Contact;
import model.User;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;

public class DeleteContactTests extends TestBase{
    Logger logger = LoggerFactory.getLogger(DeleteContactTests.class);


    @BeforeMethod
    public void precondition(){
        if (!app.getHelperUser().isLogged())
        {
            User user = new User()
                    .withEmail("domes7@mail.com")
                    .withPassword("123456Aa$");
            app.getHelperUser().openLoginForm();
            app.getHelperUser().fillLoginForm(user);
            app.getHelperUser().submitLogin();
        }

    }
    @Test
    public void DeleteLastContactPositive(){


       String lastPhone = app.getHelperContact().findAndSelectLastContactCreated();
        System.out.println("Last Contact created with phone number: "+lastPhone);
       app.getHelperContact().submitRemoveButton();
       app.getHelperContact().pause(1500);
        Assert.assertTrue(app.getHelperContact().isContactDeleted(lastPhone));
     //   app.getHelperContact().asseptAlertbuttonOk();
    }

}
