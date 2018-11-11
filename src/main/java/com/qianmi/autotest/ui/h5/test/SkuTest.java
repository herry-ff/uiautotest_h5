package com.qianmi.autotest.ui.h5.test;



import com.qianmi.autotest.ui.h5.page.HomePage;
import com.qianmi.autotest.h5.common.PageTest;
//import org.apache.xpath.operations.String;
import org.testng.annotations.Test;

/**
 * Created by shifangfang on 18/10/12.
 */
public class SkuTest extends PageTest {
    /**
     * 场景1:未登录,首页输入商品名称,搜索出商品
     * 返回首页
     */
    @Test
    public void searchProductWhenLogout() {
        logger.info("*************************** searchProductWhenLogout start");
        String goods_name = inputData.getProperty("productName1");
        pageFacade.gotoPage(HomePage.class)
                .home_search()
                .search(goods_name)
                .check_result(goods_name);

    }

    /*
    场景2:搜索商品
         跳转登录,去登录
         输入手机号密码登录进入店铺列表跳转搜索结果列表页
         加入购物车
     */
    @Test
    public void add_goods_cart() {
        logger.info("*************************** searchProductWhenLogout start");
        String telephone = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String queryString = inputData.getProperty("productName1");
        String shop_name = inputData.getProperty("shop_name");
        pageFacade.gotoPage(HomePage.class)
                .home_search()
                .search(queryString)
                .check_result(queryString)
                .add_goods_cart()
                .add_goods_cart_login()
                .login_shop_list(telephone,pwd)
                .search_selected_shop(shop_name)
                .return_homePage()
                .click_cart_button()
                ;
    }

}
