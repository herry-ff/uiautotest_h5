package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


/**
 * Created by shifangfang on 18/11/9.
 */
@Component
public class CartPage extends Html5Page {
    /*
      编辑按钮
     */
    @FindBy(id = "qm-header:edit-btn")
    private WebElement editDeleteBtn;

    /**
     * 全选按钮
     */
    @FindBy(id = "shopping-cart:select-all-btn")
    private WebElement allSelectBtn;

    /**
     * 删除按钮
     */
    @FindBy(id = "shopping-cart:delete-btn")
    private WebElement deleteBtn;

    /**
     * 去结算按钮
     */
    @FindBy(id = "shopping-cart:settle-up-btn")
    private WebElement btn_cart;

    /*
    数量输入框
     */
    @FindBy(id = "goods-number-input")
    private WebElement inputNumber;

    public CartPage deleteGoods() {
        sleepInMillTime(1000);
        driver.context("CHROMIUM");
        clickByNativeWebViewPosition(editDeleteBtn);
        clickByNativeWebViewPosition(allSelectBtn);
        clickByNativeWebViewPosition(deleteBtn);
        List<WebElement> els = driver.findElementsByClassName("am-modal-button");
        els.get(1).click();
        return this;
    }



    /*
      classname返回多个元素
      校验价格
      校验数量
     */


    public CartPage verify_Goods(String name, String num) {

        driver.context("CHROMIUM");

        List<WebElement> els = driver.findElements(By.className("good"));

        for (WebElement i : els) {
            if (i.getText().contains(name)) {
                if (inputNumber.getAttribute("value").equals(num)) {
                    System.out.println("购物车商品数量正确，值为:" + inputNumber.getAttribute("value"));
                    break;
                }
                System.out.println("购物车数量不正确，值为" + inputNumber.getAttribute("value"));
            }
            System.out.println("购物车数量不正确，值为" + inputNumber.getAttribute("value"));
        }
        return this;
    }


    /**
     * 正常下单
     * 点击去结算按钮
     * 跳转确认订单页
     */
    public ConfirmOrderPage click_cart() {
        sleepInMillTime(2000);
        clickByNativeWebViewPosition(wait(btn_cart));
        return gotoPage(ConfirmOrderPage.class);
    }

    /**
     * 再次购买进入购物车页面
     * 点击去结算按钮
     *
     * @return
     */
    public ConfirmOrderPage gotoConfirmOrderPage() {
        sleepInMillTime(2000);
        driver.context("NATIVE_APP");
        btn_cart.click();
        return gotoPage(ConfirmOrderPage.class);
    }

    /**
     * 修改商品数量
     * 并校验输入的数量
     *
     * @param name
     * @param num
     * @return
     */

    public CartPage modifyNumber(String name, String num) {

        sleepInMillTime(1000);
        driver.context("CHROMIUM");

        List<WebElement> els = driver.findElementsByClassName("cart-main");
        for (WebElement i : els) {
            if (i.getText().contains(name)) {
                wait(inputNumber).clear();
                wait(inputNumber).sendKeys(num);
                Actions actions = new Actions(driver);
                actions.moveToElement(i.findElement(By.className("good-amount")).findElement(By.className("good-price"))).click().perform();
                if (inputNumber.getAttribute("value").equals(num)) {
                    System.out.println("修改数量成功，值为:" + inputNumber.getAttribute("value"));
                    break;
                }
                System.out.println("修改数量失败" + inputNumber.getText());
            }
        }

        return this;
    }

     /*
      classname返回多个元素
      校验大小单位
     */

    public CartPage verify_Goods_unit(String name, String unit) {
        sleepInMillTime(1000);
        driver.context("CHROMIUM");
        List<WebElement> els = driver.findElements(By.className("cart-main"));
        for (WebElement i : els) {
            if (i.getText().contains(name)) {

                if (i.findElements(By.className("text-right")).get(0).getText().contains(unit))
                    System.out.println("大小单位换算正确:" + i.findElements(By.className("text-right")).get(0).getText());
                break;
            }
            System.out.println("大小单位换算错误:" + i.findElements(By.className("text-right")).get(0).getText());

        }
        return this;
    }
}

