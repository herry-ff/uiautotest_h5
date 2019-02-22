package com.qianmi.autotest.ui.h5.page;


import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

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


}
