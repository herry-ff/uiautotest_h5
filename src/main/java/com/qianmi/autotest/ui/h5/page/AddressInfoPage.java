package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.html5.page.Html5Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class AddressInfoPage extends Html5Page {
/**
 * 智能地址输入框
 */
  @FindBy(id="words-input")
  private WebElement address_textarea;

/**
 * 智能解析按钮
 */
  @FindBy(id = "analysis-address")
  private WebElement address_analysis;

  /**
   * 保存收货地址
   * @return
     */
  @FindBy(id = "save-address-btn")
  private WebElement save_address;

  /**
   * 导入店铺地址
   * @return
     */
  @FindBy(id = "import-address-btn")
  private WebElement export_address;

  /**
   * 点击智能解析按钮
   * @return 当前页面
     */

  public AddressInfoPage clickAnalysis(){

    driver.context("CHROMIUM");
    WebElement el = driver.findElementByClassName("address-title");
    Actions actions = new Actions(driver);
    actions.moveToElement(el).click().perform();

    clickNativeElement(address_analysis);

    return gotoPage(AddressInfoPage.class);
  }

  public AddressInfoPage inputAnalysisAddress(String text){
    swipeUp(500);
    driver.context("CHROMIUM");
    wait(address_textarea).sendKeys(text);
    return gotoPage(AddressInfoPage.class);
  }

  /**
   *点击保存收货地址按钮
   * 返回收货地址页面
   */
  public AddressPage clickSaveAddress(){
    sleepInMillTime(1000);
    clickNativeElement(save_address);
    return gotoPage(AddressPage.class);
  }

  /**
   * 点击导入店铺地址
   * @return 当前页面
     */
  public AddressInfoPage clickExportAddress(){
    swipeUp(500);
    clickNativeElement(wait(export_address));
    return gotoPage(AddressInfoPage.class);
  }
}
