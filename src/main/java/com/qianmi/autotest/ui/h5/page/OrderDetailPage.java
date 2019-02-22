package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailPage extends Html5Page {
    //再次购买按钮
    @FindBy(id = "qm-operations:buy-again-btn")
    private WebElement buyAgainBtn;

    public CartPage clickBuyAgain(){
        sleepInMillTime(2000);
        clickNativeElement(buyAgainBtn);
        return gotoPage(CartPage.class);
    }
}
