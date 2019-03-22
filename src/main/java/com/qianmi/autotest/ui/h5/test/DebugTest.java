package com.qianmi.autotest.ui.h5.test;

import com.qianmi.autotest.html5.common.Html5PageTest;
import com.qianmi.autotest.ui.h5.page.HomePage;
import com.qianmi.autotest.ui.h5.page.OrderSuccessPage;
import org.testng.annotations.Test;

public class DebugTest  extends Html5PageTest {
    @Test()
    public void deleteAddress() {
        String telephone = inputData.getProperty("telephone");
        String pwd = inputData.getProperty("pwd");
        String name = inputData.getProperty("addressName");
        String addTel = inputData.getProperty("addressTel");
        pageFacade.gotoPage(HomePage.class)
                .homePageLogin()
                .login_homePage(telephone,pwd)
                .click_more()
                .clickAddressBtn()
                .verifyAddressExist(addTel)
        ;


    }

}
