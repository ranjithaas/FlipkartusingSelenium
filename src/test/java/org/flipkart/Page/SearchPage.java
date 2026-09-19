package org.flipkart.Page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    @FindBy(xpath ="(//input[@placeholder = \"Search for Products, Brands and More\"])[1]")
    private WebElement searchBox;
    @FindBy(xpath = "//span[text()=\"Price\"]")
    private WebElement priceFilter;
    @FindBy(xpath = "(//select[@class='hbnjE2'])[2]")
    private WebElement priceRange;
    @FindBy(xpath= "//div[text()=\"Core i5\"]/preceding-sibling::input")
    private WebElement processorFilter;
    @FindBy(xpath="//div[text()=\"Price -- Low to High\"]")
    private WebElement sortLowToHigh;
    @FindBy(xpath="(//div[text()=\"RAM Capacity\"])[1]")
    private WebElement ramCapacityAccordian;
    @FindBy(xpath="//div[text()=\"8 GB\"]")
    private WebElement selectRamSize;
    @FindBy(xpath = "//span[text()=\"Next\"]")
    private WebElement paginationNextButton;
    @FindBy(xpath="//div[@class=\"jIjQ8S\"]")
    private List<WebElement> productList; //using findelements concept
    @FindBy(xpath ="(//div[@class='_1psv1zeb9 _1psv1ze0 _7dzyg20 _1psv1ze9l _1psv1ze7o _1psv1ze2u _1psv1ze53']//child::div[@class='css-g5y9jx'])[1]")
    private WebElement addToCartIcon;
    @FindBy(xpath="//span[text()=\"Cart\"]")
    private WebElement clickOnCartIcon;
    @FindBy(xpath = "(//div[@class='jIjQ8S']/descendant::input)[1]")
    private WebElement addToCompareCheckBox1;
    @FindBy(xpath = "(//div[@class='jIjQ8S']/descendant::input)[2]")
    private WebElement addToCompareCheckBox2;
    @FindBy(xpath = "//span[text()='COMPARE']")
    private WebElement clickOnCompareButton;
    @FindBy(xpath = "//button[text()=\'Enter Delivery Pincode\']")
    private WebElement clickOnEnterPinCode;
    @FindBy(xpath="//input[@placeholder=\"Enter pincode\"]")
    private WebElement enterPinCode;
    @FindBy(xpath = "//div[text()='Submit']")
    private WebElement clickOnSubmitButton;





    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterSearchText(String searchText){
        searchBox.click();
        searchBox.sendKeys(searchText);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void waitForPriceFilter(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(priceFilter));
    }

    public void selectPriceRange(){
        Select select=new Select(priceRange);
        select.selectByValue("50000");
    }

    public void selectProcessor() {
        if (!processorFilter.isSelected()) {
            processorFilter.click();
        }

    }

    public void clickOnSortLowToHigh(){
        sortLowToHigh.click();

    }

    public void clickOnRamCapacity(){
        ramCapacityAccordian.click();

    }
    public void selectRamSize(){
        WebDriverWait explicit = new WebDriverWait(driver,Duration.ofSeconds(5));
        //  explicit.until(ExpectedConditions.visibilityOf(selectRamSize));
        if(!selectRamSize.isSelected()){
            selectRamSize.click();

        }
    }

    public void scrollToNxtButton(){
        Actions action = new Actions(driver);
        action.scrollToElement(paginationNextButton).build().perform();

    }

    public void clickPaginationNextButton(){
        paginationNextButton.click();

    }


    public void clickOnThirdElement(){
        if(productList.size()>=3){
            productList.get(2).click();
        }
    }

    public void scrollToAddCart(){
        Actions action = new Actions(driver);
        action.scrollToElement(addToCartIcon).build().perform();
    }

    public void clickOnAddToCart(){
        addToCartIcon.click();


    }

    public void clickOnCartIcon(){
        clickOnCartIcon.click();
    }

    public void clickOnAddToCheckBoxes(){
        JavascriptExecutor js=(JavascriptExecutor)driver;

        if(!addToCompareCheckBox1.isSelected()){
           // addToCompareCheckBox1.click();    //cannot clcik as checkbox is ead only
            js.executeScript("arguments[0].click();",addToCompareCheckBox1);

        }

        if(!addToCompareCheckBox2.isSelected()){
           /// addToCompareCheckBox2.click();
            js.executeScript("arguments[0].click();",addToCompareCheckBox2);
        }

    }

    public void clickOnCompare(){
        clickOnCompareButton.click();
    }

    public void clickOnEnterPinCode(){
        clickOnEnterPinCode.click();
    }

    public void enterPincode(String pincode){
        enterPinCode.sendKeys(pincode);
        clickOnSubmitButton.click();
    }

}
