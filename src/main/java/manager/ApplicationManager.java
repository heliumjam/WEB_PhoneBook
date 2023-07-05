package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
//    WebDriver wd;
        EventFiringWebDriver wd;

    HelperUser helperUser;
    HelperContact helperContact;
    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperContact getHelperContact() {
        return helperContact;
    }

    @BeforeSuite
    public void init(){
        //   wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new WebDriverListener()); // connection LISTENER
        helperUser = new HelperUser(wd);
        helperContact = new HelperContact(wd);
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterSuite
    public void tearDown(){
      //  wd.quit();
    }
}
