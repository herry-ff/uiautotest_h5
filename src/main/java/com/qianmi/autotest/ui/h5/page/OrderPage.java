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

    public SearchOrderPage clickSearch(){
        clickNativeElement(searchOrder);
        return gotoPage(SearchOrderPage.class);
    }

    /**
     * 订单列表再次购买
     */

    public CartPage orderBuyAgain(){

        sleepInMillTime(2000);
        List<WebElement> orders = driver.findElements(By.className("order-list-content"));
        WebElement el = orders.get(0);
        WebElement el2 = el.findElement(By.id("qm-operations:buy-again-btn"));
        System.out.print("开始打印"+el2);
        //元素通过坐标定位不到
        //clickByNativeWebViewPosition(el2);
        return gotoPage(CartPage.class);
    }


    /**
     *订单详情再次购买
     */

    public OrderDetailPage orderDetailBuyAgain(){

        sleepInMillTime(2000);
        List<WebElement> orders = driver.findElements(By.className("order-list-content"));
        WebElement el = orders.get(0);
        WebElement el2 = el.findElement(By.className("goods-img-item"));
        clickByNativeWebViewPosition(el2);
       return gotoPage(OrderDetailPage.class);
    }
}
