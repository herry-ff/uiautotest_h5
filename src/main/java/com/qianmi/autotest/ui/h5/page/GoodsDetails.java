package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by shifangfang on 19/1/6.
 */
@Component
public class GoodsDetails extends Html5Page {
    /**
     * 悬浮小购物车图标
     */


   @FindBy(id = "back-home-back-cart")
    private WebElement cart_button;

    /*
      未登录,登录查看会员价图标id
     */
    @FindBy(id = "goods-detail:loginviewprice-btn")
    private WebElement goods_detail_login;

    /*
      已登录,商品详情加入采购车图标
     */
    @FindBy(id = "goods-detail:add-shopping-cart-btn")
    private WebElement add_cart_btm;

    /**
     * 点击小购物车图标进入购物车页面
     */
    public CartPage goto_CartPage() {
        sleepInMillTime(1000);
        driver.context("CHROMIUM");
        swipeDown(500);
        sleepInMillTime(1000);
        clickByNativeWebViewPosition(cart_button);
        return gotoPage(CartPage.class);
    }

    /*
    点击登录查看会员价按钮
    跳转登录页面
     */
    public LoginPage goto_Login(){
        clickByNativeWebViewPosition(wait(goods_detail_login));
        return gotoPage(LoginPage.class);
    }

    /*
    点击加入购物车弹框
    跳转弹层页
     */
    public GoodsDetailLayer goto_layer()
    {
        clickByNativeWebViewPosition(wait(add_cart_btm));
        return gotoPage(GoodsDetailLayer.class);
    }
}
