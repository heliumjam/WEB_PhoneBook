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
    public void deleteLastContactPositive(){
       String lastPhone = app.getHelperContact().findAndSelectLastContactCreated();
        System.out.println("Last Contact created with phone number: "+lastPhone);
       app.getHelperContact().submitRemoveButton();
       app.getHelperContact().pause(1500);
        Assert.assertTrue(app.getHelperContact().isContactDeleted(lastPhone));
    }
@Test
    public void deleteLastContactPositiveLesson13(){
       int res = app.getHelperContact().removeOneContactLesson13();
        Assert.assertEquals(1,res);

    }

    @Test
    public void removeAllContactsPositive(){
        app.getHelperContact().removeAllContacts();
        Assert.assertTrue(app.getHelperContact().isNoContacts());
    }
}
