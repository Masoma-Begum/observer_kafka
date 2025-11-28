package pages;

import com.microsoft.playwright.Page;

public class PetStoreLoginPage {
    private final Page page;


    public PetStoreLoginPage(Page page) {
        this.page = page;
    }


    // locators
    private String usernameSel = "input[name='username']";
    private String passwordSel = "input[name='password']";
    private String loginBtnSel = "input[value='Login']";


    public void navigate(String url) {
        page.navigate(url);
    }


    public void login(String username, String password) {
        page.fill(usernameSel, username);
        page.fill(passwordSel, password);
        page.click(loginBtnSel);
    }
}
