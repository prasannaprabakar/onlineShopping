package VerifyProducts;

import CommonFunction.CommonFunctions;
import PageObjects.PageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FindLowestPriceItem extends CommonFunctions
{
    static Logger logger=Logger.getLogger(FindLowestPriceItem.class);
@Test
    public void find() throws InterruptedException
{
    PageFactory.initElements(driver, PageObjects.class);
    String dropdownText=properties.getProperty("dropdownText");
    Select select=new Select(PageObjects.dropdown);
    select.selectByVisibleText(dropdownText);
    logger.info("Details for Lowest price item");
    logger.info("Product name  "+PageObjects.productName.getText());
    logger.info("Product price "+PageObjects.productPrice.getText());
    logger.info("Availability  "+PageObjects.instock.getText());
    //Thread.sleep(10000);

}
}
