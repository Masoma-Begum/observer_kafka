package pages;

import com.microsoft.playwright.Page;

public class SauceDemoLoginPage {
    private final Page page;


    public SauceDemoLoginPage(Page page) {
        this.page = page;
    }


    // locators
    private String usernameSel = "#user-name";
    private String passwordSel = "#password";
    private String loginBtnSel = "#login-button";


    public void navigate(String url) {
        page.navigate(url);
    }


    public void login(String username, String password) {
        page.fill(usernameSel, username);
        page.fill(passwordSel, password);
        page.click(loginBtnSel);
    }
}
