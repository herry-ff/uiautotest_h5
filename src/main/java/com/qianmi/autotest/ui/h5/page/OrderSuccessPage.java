package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.html5.page.Html5Page;
import com.sun.tools.javac.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;


/**
 * Created by shifangfang on 18/12/5.
 */
@Component
public class OrderSuccessPage extends Html5Page {
    private String orderNo;



    /**
     * 订单列表返回按钮
     */
    @FindBy(id = "order-confirm-success:order-list-btn")
    private WebElement orderListButton;


    /**
     * 点击订单列表按钮返回订单列表
     */
     public OrderPage backOrderList() {
         sleepInMillTime(2000);
         clickNativeElement(wait(orderListButton));
         return gotoPage(OrderPage.class);
     }

    /**
     * 获取提交订单成功页的订单号
     * @param
     * @return
     */
    public OrderSuccessPage getOrder(){
        sleepInMillTime(2000);
        WebElement el=driver.findElement(By.className("order-success-content")).findElements(By.tagName("li")).get(1);
        String orderNo =el.findElement(By.tagName("span")).getText();
        setOrderNo(orderNo);
        return this;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
