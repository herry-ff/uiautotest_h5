package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * Created by shifangfang on 19/1/8.
 */
@Component
public class GoodsDetailLayer extends Html5Page {
    /*
       数量输入框
     */
    @FindBy(id = "goods-num")
    private WebElement goodsNumber;

    /*
      确认采购按钮
     */
    @FindBy(className = "btn btn-primary btn-cart")
    private WebElement confirmAddCart;

    /*
    输入数量
    点击确认采购
    返回商品详情页面
     */
    public GoodsDetails inputDecimalAddCart(String decimal) {
        wait(goodsNumber).sendKeys(decimal);
        clickByNativeWebViewPosition(wait(confirmAddCart));
        return gotoPage(GoodsDetails.class);
    }
}
