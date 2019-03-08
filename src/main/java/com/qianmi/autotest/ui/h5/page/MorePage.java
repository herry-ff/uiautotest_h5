package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class MorePage extends Html5Page {


    /**
     * 收货地址按钮
     */
    @FindBy(id="user:address-btn")
    private WebElement addressBtn;

    /*
       退出按钮
     */
    @FindBy(id = "btn:log-out")
    private WebElement logoutBtn;

    /**
     * 退出登录
     *
     * @return 退出登录
     */
    public HomePage logout() {
        sleepInMillTime(2000);
        swipeUp(500);
        wait(logoutBtn).click();
        return gotoPage(HomePage.class);
    }

   public AddressPage clickAddressBtn(){

       swipeUp(1000);
       sleepInMillTime(1000);
       wait(addressBtn).click();
       return gotoPage(AddressPage.class);
   }
}
