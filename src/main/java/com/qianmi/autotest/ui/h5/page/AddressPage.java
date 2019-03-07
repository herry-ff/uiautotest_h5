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
     * 点击新增收货地址按钮
     * 跳转填写收货地址页面
     */
    public AddressInfoPage click_add_Address(){
        sleepInMillTime(1000);
        wait(addAddressBtn).click();
        return gotoPage(AddressInfoPage.class);
    }

    /**
     * 校验收货地址list中存在新增的收货地址
     * @return
     */
    public AddressPage verifyAddressExist(String tel){
        List<WebElement> addressList = driver.findElements(By.className("addr-list-item"));
        for (WebElement i : addressList) {
            WebElement els=i.findElement(By.className("addr-info-main"));
            if (els.getTagName().equals(tel))
                System.out.print("校验通过");
            break;
        }
        return this;
    }

    /**
     * 找到现在的手机号的收货地址
     * 然后执行删除操作
     * @param name
     * @return
     */

   public AddressPage delAddress(String name){
       List<WebElement> addressList = driver.findElements(By.className("addr-list-item"));
       for (WebElement i : addressList) {
           WebElement els=i.findElement(By.className("addr-info-main"));
           WebElement elsOne=i.findElement(By.className("addr-info-operate"));
           WebElement elsTwo=elsOne.findElement(By.className("qIcon qIcon-delete"));
           if (els.getTagName().equals(name))
               clickByNativeWebViewPosition(wait(elsTwo));
           break;
       }
       return this;
   }


    /**
     * 点击删除确认弹窗中的确定按钮
     * @return
     */
    public AddressPage confirmDeleteAddress(){
        sleepInMillTime(1000);
        List<WebElement> els = driver.findElementsByClassName("am-modal-button");
        for(WebElement i : els){
            if(i.getText().equals("确定")){
                i.click();
                break;
            }
        }

        return gotoPage(AddressPage.class);
    }
}
