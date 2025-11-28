package base;

import com.microsoft.playwright.*;
import observer.LoginSubject;
import kafka.KafkaObserver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected LoginSubject loginSubject;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();

        // Setup Subject + Kafka Observer
        loginSubject = new LoginSubject();
        loginSubject.addObserver(new KafkaObserver());
    }

    @AfterClass
    public void teardown() {
        browser.close();
        playwright.close();
    }
}