package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.base.page.AppLoginPage;
import com.qianmi.autotest.html5.page.Html5Page;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * Created by shifangfang on 18/10/12.
 */
@Component
/*
   登录页继承basePage实现接口login
 */
public class LoginPage extends Html5Page implements AppLoginPage {
    @FindBy(id = "login:user-name-text")
    private WebElement usernameField;

    @FindBy(id = "login:user-password-text")
    private WebElement passwordField;

    @FindBy(id = "login:login-btn")
    private WebElement submitButton;

    public void login(String telephone, String pwd){

    }

    /*
       输入手机号和密码登录
       跳转首页

     */

    public  HomePage  login_homePage(String telephone, String pwd){
        initPage(this);
        sleepInMillTime(2000);
        wait(usernameField).sendKeys(telephone);
        wait(passwordField).sendKeys(pwd);
//        driver.hideKeyboard();
//        refactClick(wait(submitButton));
        wait(submitButton).click();
        return gotoPage(HomePage.class);

     }
   /*
    登录点击后跳转选择店铺列表页
    */
    public SelectedShopPage login_shop_list(String telephone, String pwd){
        initPage(this);
        sleepInMillTime(2000);
        wait(usernameField).sendKeys(telephone);
        wait(passwordField).sendKeys(pwd);

//        driver.hideKeyboard();
//        refactClick(wait(submitButton));
        wait(submitButton).click();
        sleepInMillTime(2000);
        return gotoPage(SelectedShopPage.class);
    }

    /**
     * 登录后跳转搜索结果页
     */
    public SearchResultPage login_goto_searchResultPage(String telephone, String pwd){
        initPage(this);
        sleepInMillTime(2000);
        wait(usernameField).sendKeys(telephone);
        wait(passwordField).sendKeys(pwd);
//        driver.hideKeyboard();
//        refactClick(wait(submitButton));
        wait(submitButton).click();
        return gotoPage(SearchResultPage.class);
    }

    /**
     * 登录后跳转商品详情页
     */
    public GoodsDetails loginGoToGoodsDetail(String telephone, String pwd){
        initPage(this);
        sleepInMillTime(2000);
        wait(usernameField).sendKeys(telephone);
        wait(passwordField).sendKeys(pwd);
//        driver.hideKeyboard();
//        refactClick(wait(submitButton));
        wait(submitButton).click();
        return gotoPage(GoodsDetails.class);
    }

}
