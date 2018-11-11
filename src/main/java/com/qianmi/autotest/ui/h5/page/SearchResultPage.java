package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.base.common.AutotestException;
import com.qianmi.autotest.h5.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * Created by shifangfang on 18/10/12.
 */
@Component
public class SearchResultPage extends BasePage{
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
     校验商品名称包含大熊
    */
   public SearchResultPage check_result(String goods_name){
     String actual_goods_name= result_goods_name.getText();
       if(isExist(result_goods_name)&&actual_goods_name.contains(goods_name)){
           return this;
       }
       throw new AutotestException("搜索结果为:"+actual_goods_name+"\n");
   }

    /*
    返回首页
     */
    public HomePage return_homePage(){
        return gotoPage(HomePage.class);
    }
   /*
      点击结果页第一行商品的购物车图标加入购物车
      已登录停留当前页面
    */
    public SearchResultPage add_goods_cart(){
        click(result_goods_cart);
        return gotoPage(SearchResultPage.class);

    }
    /*
     点击结果页第一行商品的购物车图标加入购物车
     未登录跳转登录页
   */
    public LoginPage add_goods_cart_login(){
        click(result_goods_cart);
        return gotoPage(LoginPage.class);

    }

}
