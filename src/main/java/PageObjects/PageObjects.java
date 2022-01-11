package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjects
{
    @FindBy(id = "twotabsearchtextbox")//search_query_top
    public static WebElement searchBox;
    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")//span[@class='lighter']
    public static WebElement searchResult;
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']/child::span[1]")//span[@class='heading-counter']
    public static WebElement noOfSearchResult;
    @FindBy(id = "s-result-sort-select")// selectProductSort
    public static WebElement dropdown;
    @FindBy(xpath = "//ul[@class='product_list grid row']/li[1]/div/div[2]/h5")
    public static WebElement productName;
    @FindBy(xpath = "//ul[@class='product_list grid row']/li[1]/div/div[2]/div[1]/span")
    public static WebElement productPrice;
    @FindBy(xpath = "//ul[@class='product_list grid row']/li[1]/div/div[2]/span/span")
    public static WebElement instock;


}
