package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by shifangfang on 18/11/9.
 */
@Component
public class CartPage extends Html5Page {

    /**
     * 去结算按钮
     */
    @FindBy(id = "shopping-cart:settle-up-btn")
    private WebElement btn_cart;

    /*
    数量输入框
     */
    @FindBy()
    private WebElement inputNumber;

    /*
      classname返回多个元素
      校验价格
      校验数量
     */


    public CartPage verify_Goods(String name,String num){

        List<WebElement> els= driver.findElements(By.className("cart-main"));
        sleepInMillTime(1000);
        for (WebElement i:els) {
            if(i.getText().equals(name)){
              if(i.findElements(By.className("amount carAmount")).get(0).equals(num))
                System.out.print("购买数量校验通过");

            }
            break;
        }
        return this;
    }

    /*
      classname返回多个元素
      校验大小单位
     */

    public CartPage verify_Goods_unit(String name,String unit){

        List<WebElement> els= driver.findElements(By.className("cart-main"));

        sleepInMillTime(1000);
        for (WebElement i:els) {
            if(i.getText().equals(name)){

                if(i.findElements(By.className("text-tip text-gray")).get(1).equals(unit))
                    System.out.print("购买数量校验通过");
            }
            break;
        }
        return this;
    }

    /**
     * 正常下单
     * 点击去结算按钮
     * 跳转确认订单页
     */
    public ConfirmOrderPage click_cart(){
        sleepInMillTime(2000);
        clickByNativeWebViewPosition(wait(btn_cart));
        return gotoPage(ConfirmOrderPage.class);
    }

    /**
     * 再次购买进入购物车页面
     * 点击去结算按钮
     * @return
     */
    public ConfirmOrderPage gotoConfirmOrderPage() {
        Set<String> contextNames = driver.getContextHandles();
        sleepInMillTime(2000);
        for (String context : contextNames) {
            System.out.println(context);
            if (context.contains("NATIVE_APP")) {
                driver.context(context);
                btn_cart.click();
                break;
            }
        }
        return gotoPage(ConfirmOrderPage.class);
    }

    /**
     * 修改商品数量
     * @param name
     * @param num
     * @return
     */

    public CartPage modifyNumber(String name,String num){

        List<WebElement> els= driver.findElements(By.className("cart-main"));

        sleepInMillTime(1000);
        for (WebElement i:els) {
            if(i.getText().equals(name)){
                WebElement el=i.findElement(By.tagName("input"));
                wait(el).sendKeys(num);
            }
            break;
        }

    return this;
    }

}

