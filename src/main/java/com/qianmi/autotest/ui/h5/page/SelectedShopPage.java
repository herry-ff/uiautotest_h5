package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by shifangfang on 18/11/10.
 */
@Component
public class SelectedShopPage extends Html5Page {
    /*
   找到class=title-text 名称为:苏果小店1号的店铺
    */
//    @FindBy(xpath = "//div[@class=\"content-text\"]//p[@class=\"title-text\"]//p[@text=\"苏果小店1号\"]")
//
//    private WebElement shop_name;
//



 /*
    多店铺选中店铺后进入首页
    名称为:苏果小店1号的店铺
     */
//    public HomePage selected_shop(String query_shop){
//        sleep(1000);
//        click(shop_name);
//        return gotoPage(HomePage.class);
//    }

    /*
    商品列表搜索结果页面,多店铺选中店铺后商品列表搜索结果页
    名称为:苏果小店1号的店铺
     */
    public SearchResultPage search_selected_shop(String shop_name){

        sleep(1000);

        List<WebElement> list= driver.findElementsByClassName("title-text");
        for(int i=0;i<list.size();i++)
        {
            if (list.get(i).getText().equals(shop_name)) {
                list.get(i).click();
            }
        }


        return gotoPage(SearchResultPage.class);
    }
}
