package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.h5.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by shifangfang on 18/10/12.
 */

public abstract class NavigatorPage extends BasePage{
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
        sleepInMillTime(3000);
        wait(userbutton).click();
        return gotoPage(LoginPage.class);
    }
    /*
    点击采购车图标进入采购车页面
     */
    public CartPage click_cart_button(){
        click(cartButton);
        return gotoPage(CartPage.class);
    }
}
