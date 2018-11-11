package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.base.page.AppLoginPage;
import com.qianmi.autotest.h5.page.BasePage;
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
public class LoginPage extends BasePage implements AppLoginPage {
    @FindBy(id = "login:user-name-text")
    private WebElement usernameField;

    @FindBy(id = "login:user-password-text")
    private WebElement passwordField;

    @FindBy(id = "login:login-btn")
    private WebElement submitButton;

    /*
       输入手机号和密码登录
       点击登录
     */
    @Override
    public void  login(String telephone, String pwd){
        initPage(this);
        sleepInMillTime(2000);
        wait(usernameField).sendKeys(telephone);
        wait(passwordField).sendKeys(pwd);
        driver.hideKeyboard();
        refactClick(wait(submitButton));
     }
   /*
    登录点击后跳转选择店铺列表页
    */
    public SelectedShopPage login_shop_list(String telephone, String pwd){
        initPage(this);
        sleepInMillTime(2000);
        wait(usernameField).sendKeys(telephone);
        wait(passwordField).sendKeys(pwd);
        driver.hideKeyboard();
        refactClick(wait(submitButton));
        sleepInMillTime(2000);
        return gotoPage(SelectedShopPage.class);
    }

}