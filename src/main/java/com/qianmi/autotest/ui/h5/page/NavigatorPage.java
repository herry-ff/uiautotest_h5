package com.qianmi.autotest.ui.h5.page;



import com.qianmi.autotest.html5.page.Html5Page;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.time.Duration;

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
     * 前往登录页面
     *
     * @return 登录页
     */


    public LoginPage gotoLoginPage() {
        sleepInMillTime(1000);
        wait(userbutton).click();
        return gotoPage(LoginPage.class);
    }

    /**已登录
     * 点击更多跳转登录页
     */
    public MorePage click_more(){
        sleepInMillTime(1000);
        clickByNativeWebViewPosition(wait(userbutton));
        return gotoPage(MorePage.class);
    }
}
