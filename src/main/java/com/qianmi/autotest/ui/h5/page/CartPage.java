package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by shifangfang on 18/11/9.
 */
@Component
public class CartPage extends Html5Page {

    /**
     * 去结算按钮
     */
    @FindBy(id = "shopping-cart:settle-up-btn")
//      @FindBy(xpath = "//div[@class=\"footer footer-white\"]//a[@class=\"btn btn-primary btn-cart\"]")
    private WebElement btn_cart;

    /*
      classname返回多个元素
      校验价格
      校验数量
     */


    public CartPage verify_Goods(String name,String num,String price){

        List<WebElement> els= driver.findElements(By.className("cart-main"));
        sleepInMillTime(1000);
        for (WebElement i:els) {
            if(i.getText().equals(name)){
               if(i.findElements(By.className("good-price")).get(0).equals(price))
                   System.out.print("会员价校验通过");
//               if(Float(i.findElements(By.tagName("input")).get(0).getAttribute("value"))==(num))
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
     * 点击去结算按钮跳转确认订单页
     */
    public ConfirmOrderPage click_cart(){
        sleepInMillTime(2000);
        clickByNativeWebViewPosition(wait(btn_cart));
        return gotoPage(ConfirmOrderPage.class);
    }

    public CartPage modifyGoodsNum(String name,String num){

        List<WebElement> els= driver.findElements(By.className("cart-main"));

        sleepInMillTime(1000);
        for (WebElement i:els) {
            if(i.getText().equals(name)){
                WebElement el=i.findElement(By.className("amount carAmount"));
                wait(el).sendKeys(num);
            }
            break;
        }
        return this;
    }

}

