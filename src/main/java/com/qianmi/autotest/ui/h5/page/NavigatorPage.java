package com.qianmi.autotest.ui.h5.page;



import com.qianmi.autotest.html5.page.Html5Page;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

/**
 * Created by shifangfang on 18/10/12.
 */
@Component
public abstract class NavigatorPage extends Html5Page {


    /**
     * 工具条首页按钮
     */
    @FindBy(id = "home:home-btn")
    protected WebElement homeButton;

    /**
     * 工具条分类按钮
     */
    @FindBy(id = "home:category-btn")
    protected WebElement categoryButton;

    /**
     * 工具条采购车按钮
     */
    @FindBy(id = "home:shopping-cart-btn")
    protected WebElement cartButton;

    /**
     * 工具条订单按钮
     */
    @FindBy(id = "home:order-btn")
    protected WebElement orderButton;

    /**
     * 工具条更多按钮
     */
    @FindBy(id = "home:user-btn")
    protected WebElement userbutton;


    /**
     * 未登录点击更多跳转登录页
     * @return
     */
    public LoginPage homePageLogin(){
        sleepInMillTime(2000);
        swipeUp(2000);
        driver.context("NATIVE_APP");
        userbutton.click();
        return gotoPage(LoginPage.class);
    }

    /**
     * 已登录
     * 点击订单
     * 跳转订单列表
     */
    public OrderPage gotoOrderPage(){
        Set<String> contextNames=driver.getContextHandles();
        sleepInMillTime(3000);
        for(String context : contextNames){
            System.out.println(context);
            if (context.contains("NATIVE_APP")) {
                driver.context(context);
                orderButton.click();
                break;
            }

        }
        return gotoPage(OrderPage.class);
    }

    /**
     * 已登录
     * 点击采购车
     * 跳转采购车
     */
    public CartPage gotoCartPage(){
        sleepInMillTime(2000);
        driver.context("NATIVE_APP");
        cartButton.click();

        return gotoPage(CartPage.class);
    }


    /**已登录
     * 点击更多跳转更多页面
     */
    public MorePage click_more() {

        sleepInMillTime(2000);

        driver.context("NATIVE_APP");
        userbutton.click();

        return gotoPage(MorePage.class);
    }
}
