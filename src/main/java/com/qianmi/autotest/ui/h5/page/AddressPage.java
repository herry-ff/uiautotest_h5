package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.StringCoercer;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressPage extends Html5Page {


    /**
     * 新增收货地址按钮
     */
    @FindBy(id = "add-address-btn")
    private WebElement addAddressBtn;

    /**
     * 删除按钮
     */
    @FindBy(className = "qIcon,qIcon-delete")
    private WebElement delAddressBtn;


    /**
     * 点击新增收货地址按钮
     * 跳转填写收货地址页面
     */
    public AddressInfoPage click_add_Address() {
        sleepInMillTime(1000);
        wait(addAddressBtn).click();
        return gotoPage(AddressInfoPage.class);
    }

    /**
     * 校验收货地址list中存在新增的收货地址
     *
     * @return
     */
    public AddressPage verifyAddressExist(String tel) {
        sleepInMillTime(1000);
        driver.context("CHROMIUM");
        List<WebElement> addressList = driver.findElements(By.className("addr-list-item"));
        for (WebElement i : addressList) {
            WebElement els = i.findElement(By.className("addr-info-main"));
            if (els.getText().contains(tel)) {
                System.out.print("添加收货地址成功："+els.getText());
                break;
            }
            System.out.print("添加收货地址失败："+i.getText());
        }
        return this;
    }

    /**
     * 找到现在的手机号的收货地址
     * 然后执行删除操作
     *
     * @param name
     * @return
     */

    public AddressPage delAddress(String name) {
        sleepInMillTime(1000);
        driver.context("CHROMIUM");
        List<WebElement> addressList = driver.findElements(By.className("addr-list-item"));
        for (WebElement i : addressList) {
            WebElement els = i.findElement(By.className("addr-info-main"));
            List<WebElement> buttons = i.findElement(By.className("addr-info-operate")).findElements(By.tagName("div"));
            if (els.getText().contains(name)) {
                sleepInMillTime(1000);
                buttons.get(1).click();
                List<WebElement> a = driver.findElements(By.className("am-modal-button"));
                a.get(1).click();
                break;
            }

        }
        return this;
    }


}