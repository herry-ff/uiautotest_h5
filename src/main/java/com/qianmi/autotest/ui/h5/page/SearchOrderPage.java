package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;


/**
 * Created by shifangfang on 19/2/15.
 */
@Component
public class SearchOrderPage extends Html5Page {
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
}
