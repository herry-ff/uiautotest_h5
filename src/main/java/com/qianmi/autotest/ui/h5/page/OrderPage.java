package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * Created by shifangfang on 18/12/5.
 */
@Component
public class OrderPage extends OrderSuccessPage {
 /**
 * 搜索框
 */
    @FindBy(id = "goods-search:query-text")
    private WebElement searchOrder;

    /**
     *订单号输入框输入获取到的订单号
     *按下搜索
     * @return
     */
  public SearchOrderPage searchOrderResult(){
      wait(searchOrder).sendKeys(getOrderNo());
      pressEnterKey(searchOrder);
      return gotoPage(SearchOrderPage.class);
  }

}
