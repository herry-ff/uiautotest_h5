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
        sleepInMillTime(3000);
        swipeUp(500);
        wait(searchInput).click();
        return gotoPage(HomeSearchPage.class);
    }


}
