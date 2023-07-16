package tests;

import model.Contact;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddNewContactTests extends TestBase {
//Spider - Men - 12345678956 - fsldfj@sdjfl.dl
Logger logger = LoggerFactory.getLogger(AddNewContactTests.class);
    @BeforeMethod(alwaysRun = true)
    public void preconditions(){
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

   @Test(invocationCount = 3, groups = {"smoke","positive"})

    public void addNewContactPositive(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Contact contact = Contact.builder()  // create a new contact by Lombok
                .name("Spider"+i)
                .lastName("Man")
                .phone("1234567689"+i)
                .email("spider"+i+"@mail.po")
                .address("Country"+i)
                .description("AutoAddContact")
                .build();
        logger.info("Phone number is " + contact.getPhone());
    app.getHelperContact().openContactForm();
    app.getHelperContact().fillContactForm(contact);
    app.getHelperContact().submitContactForm();
    app.getHelperContact().pause(1500);
       Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }
    @Test (groups = {"regress","negative"})
    public void addNewContactNegativeWrongEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Contact contact = Contact.builder()  // create a new contact by Lombok
                .name("Spider" + i)
                .lastName("Man")
                .phone("1234567689" + i)
                .email("spidermail.po")
                .address("Country" + i)
                .description("AutoAddContact")
                .build();
        logger.info("Phone number is " + contact.getPhone());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        app.getHelperContact().pause(1500);
        Assert.assertTrue(app.getHelperContact().asseptAlertWrongDataAddContact());
    }
}
