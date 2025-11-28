package tests;

import base.BaseTest;
import builders.LoginDataBuilder;
import org.testng.annotations.Test;
import pages.PetStoreLoginPage;
import pages.SauceDemoLoginPage;

public class PetStoreTest extends BaseTest {
    @Test
    public void loginSauceDemo() {

        // Load username/password from users.json → "saucedemo" section
        LoginDataBuilder.LoginData loginData =
                new LoginDataBuilder()
                        .fromJsonResource("/testdata/ users.json", "petstore")
                        .build();
        System.out.println( loginData.username);


        // Create the Page Object
        PetStoreLoginPage petStoreLoginPage = new PetStoreLoginPage(page);

        // Navigate to site
        petStoreLoginPage.navigate("https://petstore.octoperf.com/actions/Account.action?signonForm=");

        // Login using JSON data
        petStoreLoginPage.login(loginData.username, loginData.password);

        // Notify observers (Kafka, logger, etc.)
        loginSubject.notifyObservers("PetStore login successful");
    }

//    @Test
//    public void loginPetStore() {
//        page.navigate("https://petstore.octoperf.com/actions/Account.action?signonForm=");
//
//        page.fill("input[name='username']", "j2ee");
//        page.fill("input[name='password']", "j2ee");
//        page.click("input[value='Login']");
//
//        // Simple verification — user ID is visible
//        page.waitForSelector("a[href='/actions/Account.action?editAccountForm=']");
//
//        // Notify observers (Kafka)
//        loginSubject.notifyObservers("PetStore login successful");
//    }
}
