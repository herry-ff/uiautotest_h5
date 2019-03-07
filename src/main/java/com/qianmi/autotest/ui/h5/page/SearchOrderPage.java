package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;


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
     * 订单列表取消订单
     * @return 订单列表
     */

    public OrderPage cancelOrder(){

        sleepInMillTime(1000);
        clickByNativeWebViewPosition(cancelOrderBtn);

        return gotoPage(OrderPage.class);
    }


    /**
     * 订单搜索结果页取消订单
     * @return 订单列表
     */

    public OrderPage cancelSearchOrderResult(){

        sleepInMillTime(2000);

//        driver.findElement(By.id("qm-operations:cancel-btn")).click();
       WebElement cancelBtn = driver.findElement(By.id("qm-operations:cancel-btn"));
//        new TouchActions(driver).singleTap(cancelBtn).perform();
        clickByNativeWebViewPosition(cancelBtn);


        return gotoPage(OrderPage.class);
    }
    /**
     *订单号输入框输入获取到的订单号
     *按下搜索
     * @return
     */
    public SearchOrderPage searchOrder(String orderId){
        sleepInMillTime(2000);
        System.out.print("搜索输入的订单号:"+orderId);

        Actions actions = new Actions(driver);
        actions.moveToElement(orderNO);
        actions.click();
        actions.sendKeys(orderId);
        actions.build().perform();

        String cmdstr="adb shell input keyevent 66";
        try {
            Runtime.getRuntime().exec(cmdstr).waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gotoPage(SearchOrderPage.class);
    }

    /**
     *搜索框输入订单号
     */
    public SearchOrderPage searchOrderNO(){
        sleepInMillTime(2000);

        wait(orderNO).sendKeys("TP1902281533560399");

        String cmdstr="adb shell input keyevent 66";
        try {
            Runtime.getRuntime().exec(cmdstr).waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gotoPage(SearchOrderPage.class);
    }

}
