package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class MorePage extends Html5Page {
    /**
     * 退出登录按钮
     */
    @FindBy()
    private WebElement logoutBtn;

    /**
     * 收货地址按钮
     */
    @FindBy(id="user:address-btn")
    private WebElement addressBtn;
    /**
     * 退出登录
     *
     * @return 退出登录
     */
    public HomePage logout() {
        sleepInMillTime(2000);
        swipeUp(1000);
        sleepInMillTime(2000);
        clickByNativeWebViewPosition(wait(logoutBtn));
        return gotoPage(HomePage.class);
    }

   public AddressPage clickAddressBtn(){
       clickByNativeWebViewPosition(wait(addressBtn));
       return gotoPage(AddressPage.class);
   }
}
