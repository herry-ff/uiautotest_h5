package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * Created by shifangfang on 18/11/9.
 */
@Component
public class ConfirmOrderPage extends Html5Page {

/**
 * 货到付款按钮
 */
    @FindBy(id = "order-confirm:pay-type-1-radio")
    private WebElement payOnDelivery;
    /**
     * 提交订单按钮
     */
    @FindBy(id = "order-confirm:confirm-btn")
    private WebElement confirmButton;
    /**
     * 选择支付方式为货到付款
     *
     * @return 订单确认页面
     */
    public ConfirmOrderPage select_PayOnDelivery() {
        sleepInMillTime(2000);
        wait(payOnDelivery).click();
        return this;
    }

    /**
     * 货到付款方式提交订单
     *
     * @return 跳转到订单成功页面
     */
    public OrderSuccessPage submitOrderByOnDeliveryPay() {
        swipeUp(1000);
        sleepInMillTime(2000);
        clickNativeElement(wait(confirmButton));
        return gotoPage(OrderSuccessPage.class);
    }


}

