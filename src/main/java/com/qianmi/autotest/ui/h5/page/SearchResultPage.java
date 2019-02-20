package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.base.common.AutotestException;
import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by shifangfang on 18/10/12.
 */
@Component
public class SearchResultPage extends Html5Page {

    /*
     搜索结果页第一行元素区域
     */
//    @FindBy(id = "goods-undefined")
//    private WebElement result_goods_area;
    /*
     搜索结果页第一行元素名称
     */
    @FindBy(id = "goods-list:goods-name-0-btn")
    private WebElement result_goods_name;
    /*
     搜索结果页第一行元素下方的购物车图标
     */
    @FindBy(id = "goods-list:cart-0-btn")
    private WebElement result_goods_cart;
    /*
    点击商品图片进入商品详情页

    */
    @FindBy(id = "goods-list:goods-img-0-btn")
    private WebElement result_goods_pic;
    /**
     * 悬浮小购物车图标
     */
//    @FindBy(className = "qIcon qIcon-cart1")
    @FindBy(xpath = "//div[@class=\"goods-search\"]//a[@class=\"back-top listview-cart\"]//i[@class=\"qIcon qIcon-cart1\"]")
    private WebElement cart_button;


    /**
     * /*
     * 校验商品名称包含大熊
     */
    public SearchResultPage check_result(String goods_name) {
        String actual_goods_name = result_goods_name.getText();
        if (isExist(result_goods_name) && actual_goods_name.contains(goods_name)) {
            return this;
        }
        throw new AutotestException("搜索结果为:" + actual_goods_name + "\n");
    }

    /*
    返回首页
     */
    public HomePage return_homePage() {
        return gotoPage(HomePage.class);
    }

    /*
       点击结果页第一行商品的购物车图标加入购物车
       已登录停留当前页面
     */
    public SearchResultPage add_goods_cart() {
        sleepInMillTime(1000);
        clickByNativeWebViewPosition(wait(result_goods_cart));
        sleepInMillTime(2000);
        return gotoPage(SearchResultPage.class);

    }

    /*
     点击结果页第一行商品的购物车图标加入购物车
     未登录跳转登录页
   */
    public LoginPage add_goods_cart_login() {
        clickByNativeWebViewPosition(wait(result_goods_cart));
        return gotoPage(LoginPage.class);

    }

    /**
     * 点击商品图片进入商品详情页面
     */
    public GoodsDetails goto_GoodsDetails() {
        sleepInMillTime(1000);
        swipeUp(2000);
        clickByNativeWebViewPosition(wait(result_goods_pic));
        return gotoPage(GoodsDetails.class);
    }

    /**
     * 点击小购物车图标进入购物车页面
     */
    public CartPage goto_CartPage() {

        sleepInMillTime(2000);
        wait(cart_button).click();
        return gotoPage(CartPage.class);
    }

    /*
      id返回多个元素
      校验价格
     */
    public SearchResultPage vertify_GoodsPrice(String prices) {
        List<WebElement> els = driver.findElements(By.id("goods-undefined"));
        sleepInMillTime(1000);
        for (WebElement i : els
                ) {
            if (i.getText().equals(prices))
                System.out.print("校验通过");
            break;
        }
        return this;
    }


}
