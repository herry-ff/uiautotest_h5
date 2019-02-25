package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.html5.page.Html5Page;
import org.aspectj.weaver.ast.Or;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by shifangfang on 18/12/5.
 */
@Component
public class OrderPage extends Html5Page {
 /**
 * 搜索框
 */
    @FindBy(id = "goods-search:query-text")
    private WebElement searchOrder;

    /**
     * 取消订单按钮
     *
     */
//    @FindBy(id = "qm-operations:cancel-btn")
//    private WebElement cancelBtn;

    public SearchOrderPage clickSearch(){
        clickNativeElement(searchOrder);
        return gotoPage(SearchOrderPage.class);
    }

    /**
     * 订单列表再次购买
     */

    public CartPage orderBuyAgain(){

        sleepInMillTime(2000);
        List<WebElement> buyAgainButtons = driver.findElements(By.id("qm-operations:buy-again-btn"));
        WebElement el = buyAgainButtons.get(0);
        el.click();
        return gotoPage(CartPage.class);
    }


    /**
     *点击商品图片进入订单详情
     */

    public OrderDetailPage orderDetail(){

        sleepInMillTime(2000);
        List<WebElement> orders = driver.findElements(By.className("order-list-content"));
        WebElement el = orders.get(0);
        WebElement el2 = el.findElement(By.className("goods-img-item"));
        clickByNativeWebViewPosition(el2);
       return gotoPage(OrderDetailPage.class);
    }

    /**
     *
     */
    /**
     * 订单列表取消第一笔订单
     * 待优化
     */

    public OrderPage cancelOrder(){

        sleepInMillTime(2000);
        List<WebElement> orders = driver.findElements(By.id("qm-operations:cancel-btn"));
        WebElement el = orders.get(0);
        el.click();
        return this;
    }

}
