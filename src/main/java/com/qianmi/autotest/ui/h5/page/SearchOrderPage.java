package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;


/**
 * Created by shifangfang on 19/2/15.
 */
@Component
public class SearchOrderPage extends OrderSuccessPage {

    /**
     * 搜索订单输入框
     */
    @FindBy(id = "goods-search:query-text")
    private WebElement orderNO;
    /**
     *取消按钮
     */
    @FindBy(id = "qm-operations:cancel-btn")
    private WebElement cancelOrderBtn;

    /**
     * 取消订单
     * @return 订单列表
     */

    public OrderPage cancelOrder(){

        sleepInMillTime(1000);
        clickByNativeWebViewPosition(cancelOrderBtn);

        return gotoPage(OrderPage.class);
    }

    /**
     *订单号输入框输入获取到的订单号
     *按下搜索
     * @return
     */
    public SearchOrderPage searchOrder(){
        sleepInMillTime(2000);
        wait(orderNO).sendKeys("TP1902211730324067");
        pressEnterKey(orderNO);
        return gotoPage(SearchOrderPage.class);
    }
}
