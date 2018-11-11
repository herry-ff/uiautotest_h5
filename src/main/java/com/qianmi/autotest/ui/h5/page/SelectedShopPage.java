package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.h5.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * Created by shifangfang on 18/11/10.
 */
@Component
public class SelectedShopPage extends BasePage {
    /*
   找到class=title-text 名称为:苏果小店1号的店铺
    */
    @FindBy(xpath = "//div[@class=\"list-item-content\"]//p[@class=\"title-text\"]//p[@text=\"苏果小店1号\"]")
    private WebElement shop_name;
 /*
    多店铺选中店铺后进入首页
    名称为:苏果小店1号的店铺
     */
    public HomePage selected_shop(String query_shop){
        sleep(3000);
        click(shop_name);
        return gotoPage(HomePage.class);
    }

    /*
    商品列表搜索结果页面,多店铺选中店铺后商品列表搜索结果页
    名称为:苏果小店1号的店铺
     */
    public SearchResultPage search_selected_shop(String text){
        sleep(3000);
        click(shop_name);
        return gotoPage(SearchResultPage.class);
    }
}
