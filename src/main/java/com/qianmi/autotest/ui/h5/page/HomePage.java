package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.appium.page.AppiumBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * Created by shifangfang on 18/10/12.
 */
@Component
public class HomePage extends NavigatorPage{

    /**
     * 工具条采购车按钮
     */
    @FindBy(id = "home:shopping-cart-btn")
    protected WebElement cartButton;


    //[搜索框]
    @FindBy(id = "search-placeholder")
    private WebElement searchInput;

    /**
     * 点击搜索框进入搜索页面
     */
    public HomeSearchPage home_search() {
        sleepInMillTime(1000);
        swipeUp(2000);
        wait(searchInput).click();
        return gotoPage(HomeSearchPage.class);
    }


    /*
   已登录
   点击购物车图标
   进入购物车页面
    */
   public CartPage click_cartBtn(){
       sleepInMillTime(1000);

       clickByNativeWebViewPosition(wait(cartButton));
       return gotoPage(CartPage.class);
   }

}
