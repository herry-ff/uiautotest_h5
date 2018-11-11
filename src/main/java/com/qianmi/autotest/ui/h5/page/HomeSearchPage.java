package com.qianmi.autotest.ui.h5.page;

import com.qianmi.autotest.h5.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * Created by shifangfang on 18/11/9.
 */
@Component
public class HomeSearchPage extends BasePage{

    //【搜索栏】
    @FindBy(id = "goods-search:query-text")
    private WebElement searchField;


    /**
     * 输入商品名称搜索
     *
     * @param queryString 搜索关键词
     * @return 搜索结果页面
     */


    public SearchResultPage search(String queryString) {
        sleepInMillTime(1000);
        wait(searchField).sendKeys(queryString);
        pressEnterKey(searchField);
        return gotoPage(SearchResultPage.class);
    }

}
