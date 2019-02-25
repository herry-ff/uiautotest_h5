package com.qianmi.autotest.ui.h5.test;

import com.qianmi.autotest.html5.common.Html5PageTest;
import com.qianmi.autotest.ui.h5.page.HomePage;
import com.qianmi.autotest.ui.h5.page.OrderSuccessPage;
import org.testng.annotations.Test;

public class DebugTest  extends Html5PageTest {

    /*
    场景11:订单列表取消订单
         搜索商品
         跳转登录,去登录
         输入手机号密码登录进入店铺列表跳转搜索结果列表页
         加入购物车
         进入商品详情页
         进入购物车页面
         使用货到付款
         提交订单
         取消订单
     */
    @Test(priority = 10)
    public void cancelOrder(){
        logger.info("*************************** cancelOrder start");
        String tel = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String queryString = inputData.getProperty("productName1");
        OrderSuccessPage page = pageFacade.gotoPage(HomePage.class)
                .home_search()
                .search(queryString)
                .check_result(queryString)
                .add_goods_cart_login()
                .login_goto_searchResultPage(tel,pwd)
                .add_goods_cart()
                .goto_GoodsDetails()
                .goto_CartPage()
                .click_cart()
                .select_PayOnDelivery()
                .submitOrderByOnDeliveryPay()
                .getOrder();

        String orderId= page.getOrderNo();

                page.backOrderList()
                .clickSearch()
                .searchOrder(orderId)
                .cancelOrder()
        ;
    }





}
