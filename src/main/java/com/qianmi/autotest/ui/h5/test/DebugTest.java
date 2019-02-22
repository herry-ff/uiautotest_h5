package com.qianmi.autotest.ui.h5.test;

import com.qianmi.autotest.html5.common.Html5PageTest;
import com.qianmi.autotest.ui.h5.page.HomePage;
import org.testng.annotations.Test;

public class DebugTest  extends Html5PageTest {


    /**
     * 无法点击首页导航栏按钮
     * 比如点击采购车没有反应
     * 搜索订单sendkeys不生效
     */

    @Test(priority = 12)
    public void getOrder(){
        String tel = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String queryString = inputData.getProperty("productName1");
        pageFacade.gotoPage(HomePage.class)
                .gotoLoginPage()
                .login_homePage(tel,pwd)
                .gotoOrderPage()
                .clickSearch()
                .searchOrder()
                .cancelOrder()
        ;

    }


    /*
场景11:订单列表取消订单
       取消按钮定位的坐标不对导致点击不了
*/
    @Test(priority = 10)
    public void test1(){
        logger.info("*************************** test1 start");
        String tel = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String queryString = inputData.getProperty("productName1");
        pageFacade.gotoPage(HomePage.class)
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
                .backOrderList()
                .clickSearch()
                .searchOrder()
                .cancelOrder()
        ;
    }



}
