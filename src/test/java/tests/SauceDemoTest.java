package tests;

import base.BaseTest;
import builders.LoginDataBuilder;
import org.testng.annotations.Test;
import pages.SauceDemoLoginPage;

public class SauceDemoTest extends BaseTest {

    @Test
    public void loginSauceDemo() {

        // Load username/password from users.json → "saucedemo" section
        LoginDataBuilder.LoginData loginData =
                new LoginDataBuilder()
                        .fromJsonResource("/testdata/ users.json", "saucedemo")
                        .build();
        System.out.println( loginData.username);


        // Create the Page Object
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage(page);

        // Navigate to site
        sauceDemoLoginPage.navigate("https://www.saucedemo.com/");

        // Login using JSON data
        sauceDemoLoginPage.login(loginData.username, loginData.password);

        // Notify observers (Kafka, logger, etc.)
        loginSubject.notifyObservers("SauceDemo login successful");
    }
//    @Test
//    public void loginSauceDemo() {
//        page.navigate("https://www.saucedemo.com/");
//        page.fill("#user-name", "standard_user");
//        page.fill("#password", "secret_sauce");
//        page.click("#login-button");
//
//        page.waitForURL("**/inventory.html");
//
//        // Notify observers (Kafka)
//        loginSubject.notifyObservers("SauceDemo login successful");
//    }
}