package com.qianmi.autotest.ui.h5.test;



import com.qianmi.autotest.html5.common.Html5PageTest;
import com.qianmi.autotest.ui.h5.page.GoodsDetails;
import com.qianmi.autotest.ui.h5.page.HomePage;

//import org.apache.xpath.operations.String;
import com.qianmi.autotest.ui.h5.page.OrderSuccessPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by shifangfang on 18/10/12.
 */
public class SkuTest extends Html5PageTest {
    /**
     * 场景0:未登录,首页输入商品名称:az,搜索出商品
     * 价格为570,校验价格3位数字是否正常显示
     */

    @Test(priority = 0)
    public void verifyGoodsPrices() {
        logger.info("*************************** verifyGoodsPrices start");
        String prices = inputData.getProperty("productName2Price");
        String goods_name = inputData.getProperty("productName2");
        pageFacade.gotoPage(HomePage.class)
                .home_search()
                .search(goods_name)
                .vertify_GoodsPrice(prices);

    }
    /**
     * 场景1:未登录,首页输入商品名称,搜索出商品
     * 返回首页,校验搜索结果正确
     */

    @Test(priority = 1)
    public void searchProductWhenLogout() {
        logger.info("*************************** searchProductWhenLogout start");
        String goods_name = inputData.getProperty("productName1");
        pageFacade.gotoPage(HomePage.class)
                .home_search()
                .search(goods_name)
                .check_result(goods_name);

    }


    /*
    场景2: 未登录
          输入商品名称:新商品小数测试
          进入商品详情
          点击登录
          点击加入购物车弹层
          输入数量确认采购
          点击商品详情小购物车图标进入购物车页面
          校验数量

     */
    @Test(priority = 2)
    public void addCartDecimalGoods(){
        String telephone = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String queryString = inputData.getProperty("productName3");
        String num = inputData.getProperty("productName3Num");
        String price = inputData.getProperty("productName3Price");
        pageFacade.gotoPage(HomePage.class)
                .home_search()
                .search(queryString)
                .check_result(queryString)
                .goto_GoodsDetails()
                .goto_Login()
                .loginGoToGoodsDetail(telephone,pwd)
                .goto_layer()
                .inputDecimalAddCart(num)
                .goto_CartPage()
                .verify_Goods(queryString,num)
                .deleteGoods()

        ;
    }

    /*
   场景3: 未登录
         输入商品名称:整数商品
         进入商品详情
         点击登录
         点击加入购物车弹层
         输入数量确认采购
         点击商品详情小购物车图标进入购物车页面
         校验数量

    */
    @Test(priority = 3)
    public void addCartIntegerGoods(){
        String telephone = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String queryString = inputData.getProperty("productName4");
        String num = inputData.getProperty("productName4Num");
        String price = inputData.getProperty("productName4Price");
        pageFacade.gotoPage(HomePage.class)
                .home_search()
                .search(queryString)
                .check_result(queryString)
                .goto_GoodsDetails()
                .goto_layer()
                .inputDecimalAddCart(num)
                .goto_CartPage()
                .verify_Goods(queryString,num)
                .deleteGoods()
        ;
    }
 /*
    场景4:搜索商品
         跳转登录,去登录
         输入手机号密码登录进入店铺列表跳转搜索结果列表页
         加入购物车
         进入商品详情页
         进入购物车页面
         修改数量从1改成4,满足大小单位换算为1组+1个
     */

    @Test(priority = 4)
    public void verifyUnit() {
        logger.info("*************************** order start");
        String telephone = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String name = inputData.getProperty("productName5");
        String unit = inputData.getProperty("productName5Unit");
        String num = inputData.getProperty("productName5Number");
        pageFacade.gotoPage(HomePage.class)
                .home_search()
                .search(name)
                .check_result(name)
                .add_goods_cart()
                .goto_GoodsDetails()
                .goto_CartPage()
                .modifyNumber(name,num)
                .verify_Goods_unit(name,unit)
                .deleteGoods()
        ;
    }

     /*
    场景5:搜索商品
         跳转登录,去登录
         输入手机号密码登录进入店铺列表跳转搜索结果列表页
         加入购物车
         进入商品详情页
         进入购物车页面
         修改数量从1改成1.55,修改数量成功
     */

    @Test(priority = 5)
    public void verifyNumDecimal() {
        logger.info("*************************** verifyNumDecimal start");
        String telephone = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String name = inputData.getProperty("productName3");
        String num = inputData.getProperty("productName3Num");
        pageFacade.gotoPage(HomePage.class)
                .home_search()
                .search(name)
                .check_result(name)
                .add_goods_cart()
                .goto_CartPage()
                .modifyNumber(name,num)
                .deleteGoods()
        ;
    }
    /*
    场景6:搜索商品
         跳转登录,去登录
         输入手机号密码登录进入店铺列表跳转搜索结果列表页
         加入购物车
         进入商品详情页
         进入购物车页面
         使用货到付款
         提交订单
     */
    @Test(priority = 6)
        public void order(){
            logger.info("*************************** order start");
            String tel = inputData.getProperty("telephone");
            String pwd = inputData.getProperty("pwd");
            String queryString = inputData.getProperty("productName1");
            pageFacade.gotoPage(HomePage.class)
                    .home_search()
                    .search(queryString)
                    .check_result(queryString)
                    .add_goods_cart()
                    .goto_GoodsDetails()
                    .goto_CartPage()
                    .click_cart()
                    .select_PayOnDelivery()
                    .submitOrderByOnDeliveryPay()
                    ;
        }

    /**
     * 场景7:订单列表再次购买
     * 获取订单列表第一笔订单
     * 点击订单列表再次购买
     * 购物车去结算
     * 提交订单
     */
    @Test(priority = 7)
    public void buyAgain(){
        String tel = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String queryString = inputData.getProperty("productName1");
        pageFacade.gotoPage(HomePage.class)
                .gotoOrderPage()
                .orderBuyAgain()
                .gotoConfirmOrderPage()
                .selectCashOnDelivery()
                .submitOrderByOnDeliveryPay()
        ;

    }

    /**
     * 场景8:订单详情再次购买
     * 获取订单列表第一笔订单
     * 点击进入订单详情的再次购买
     * 购物车去结算
     * 提交订单
     */
    @Test(priority = 8)
    public void detailBuyAgain(){
        String tel = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String queryString = inputData.getProperty("productName1");
        pageFacade.gotoPage(HomePage.class)
                .gotoOrderPage()
                .orderDetail()
                .clickBuyAgain()
                .click_cart()
                .select_PayOnDelivery()
                .submitOrderByOnDeliveryPay()
        ;

    }


    /*
 场景9:订单详情取消订单
      搜索商品
      跳转登录,去登录
      输入手机号密码登录进入店铺列表跳转搜索结果列表页
      加入购物车
      进入商品详情页
      进入购物车页面
      使用货到付款
      提交订单
      进入订单详情页
      取消订单
  */
    @Test(priority = 9)
    public void detailCancelOrder(){
        logger.info("*************************** cancelOrder start");
        String tel = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String queryString = inputData.getProperty("productName1");
        pageFacade.gotoPage(HomePage.class)
                .gotoOrderPage()
                .orderDetail()
                .clickBuyAgain()
                .click_cart()
                .select_PayOnDelivery()
                .submitOrderByOnDeliveryPay()
                .backOrderList()
                .orderDetail()
                .cancelOrder()
        ;
    }


    /*
   场景10:订单列表取消订单
        搜索商品
        跳转登录,去登录
        输入手机号密码登录进入店铺列表跳转搜索结果列表页
        加入购物车
        进入商品详情页
        进入购物车页面
        使用货到付款
        提交订单
        获取成功页订单号
        根据订单号搜索订单
        取消订单
    */
    @Test(priority = 10)
    public void cancelOrderTest(){
        logger.info("*************************** cancelOrder start");
        String tel = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String queryString = inputData.getProperty("productName1");
        OrderSuccessPage page = pageFacade.gotoPage(HomePage.class)
                .home_search()
                .search(queryString)
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
                .cancelSearchOrderResult()
        ;
    }



    /*
     场景11:新增收货地址-智能解析
        登录
        点击更多
        点击收货地址
        点击新增收货地址
        智能解析输入:王想,15195862767,江苏省南京市雨花台区软件大道118号
        点击保存收货地址
        返回，校验收货地址列表存在新增的地址

      */
    @Test(priority = 11)
    public void createAddress(){
        logger.info("***************************createAddress");
        String tel = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String addText = inputData.getProperty("addressInfo");
        String addTel = inputData.getProperty("addressTel");
        String name = inputData.getProperty("addressName");
        String queryString = inputData.getProperty("productName3");
        pageFacade.gotoPage(HomePage.class)
                .swipeMore()
                .clickAddAddressBtn()
                .click_add_Address()
                .inputAddress(addText)
                .clickAnalysis()
                .clickSaveAddress()
                .verifyAddressExist(addTel)
                .delAddress(name)
        ;
    }

    /*
   场景12:新增收货地址-导入店铺地址
      登录
      点击更多
      点击收货地址
      点击新增收货地址
      点击保存收货地址
      返回，校验收货地址列表存在新增的地址

    */
    @Test(priority = 12)
    public void createAddressWithExport(){
        logger.info("***************************createAddressWithExport");
        String tel = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String addTel = inputData.getProperty("addressExportTel");
        String name = inputData.getProperty("addressExportName");
        pageFacade.gotoPage(HomePage.class)
                .swipeMore()
                .clickAddAddressBtn()
                .click_add_Address()
                .clickExportAddress()
                .clickSaveAddress()
                .verifyAddressExist(addTel)
        ;
    }


    /*
     场景13:退出
        首页点击购物车
        跳转登录
        点击首页更多
        退出

      */
    @Test(priority = 13)
    public void logout(){
        logger.info("***************************createAddress");
        String tel = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        pageFacade.gotoPage(HomePage.class)
                .homeToMorePage()
                .logout()
        ;

    }

}