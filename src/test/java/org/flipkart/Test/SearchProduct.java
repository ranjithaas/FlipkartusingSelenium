package org.flipkart.Test;

import org.flipkart.Base.BaseClass;
import org.flipkart.Config.MyRetryAnalyzer;
import org.flipkart.Page.SearchPage;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SearchProduct extends BaseClass {
    @Test(retryAnalyzer = MyRetryAnalyzer.class)
    public void searchProduct() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchText("Laptop");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        searchPage.waitForPriceFilter();
        searchPage.selectPriceRange();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    //    searchPage.selectProcessor();
        searchPage.clickOnSortLowToHigh();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        searchPage.clickOnRamCapacity();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        searchPage.selectRamSize();
        searchPage.scrollToNxtButton();
        Thread.sleep(5000);
        searchPage.clickPaginationNextButton();
        Thread.sleep(5000);
        searchPage.clickOnAddToCheckBoxes();
        Thread.sleep(5000);
        searchPage.clickOnCompare();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        searchPage.clickOnThirdElement();
        Thread.sleep(5000);
        Set<String> openWindow=driver.getWindowHandles();
        String currentWindow=driver.getWindowHandle();
        for(String window: openWindow){
            if(currentWindow != window){
                driver.switchTo().window(window);
                Thread.sleep(5000);

            }

        }

        searchPage.scrollToAddCart();
        searchPage.clickOnAddToCart();
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(currentWindow);
        driver.navigate().refresh();
        Thread.sleep(5000);
        searchPage.clickOnCartIcon();
        Thread.sleep(5000);
        searchPage.clickOnEnterPinCode();
        Thread.sleep(5000);
        searchPage.enterPincode("560037");
        Thread.sleep(5000);

    }

}
