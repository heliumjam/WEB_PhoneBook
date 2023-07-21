package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
//    WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser helperUser;
    HelperContact helperContact;
    String browser;
    WebDriverWait wait;
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperContact getHelperContact() {
        return helperContact;
    }

    public WebDriverWait getWait() {return wait;}

    public String getEmail(){
        return properties.getProperty("web.email");
    }

    public String getPassword(){
        return properties.getProperty("web.password");
    }

////////////////////////////////////////////////////////////////
    @BeforeSuite
    public void init() throws IOException {
        String target = System.getProperty("target", "prod");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        //   wd = new ChromeDriver();
        if (browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests Using Chrome");
        } else if (browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests Using Firefox");
        } else if (browser.equals(BrowserType.EDGE)){
            wd = new EventFiringWebDriver(new EdgeDriver());
            logger.info("Tests Using Edge");
        }

        wd.register(new WebDriverListener()); // connection LISTENER
        helperUser = new HelperUser(wd);
        helperContact = new HelperContact(wd);
      //  wd.navigate().to("https://telranedu.web.app/home");
        wd.navigate().to(properties.getProperty("web.baseURL"));
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 60);
    }

    @AfterSuite
    public void tearDown(){
        wd.quit();
    }
}
