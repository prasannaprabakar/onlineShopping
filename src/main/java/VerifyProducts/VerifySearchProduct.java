package VerifyProducts;
import CommonFunction.CommonFunctions;
import PageObjects.PageObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifySearchProduct extends CommonFunctions
{
    static Logger logger=Logger.getLogger(VerifySearchProduct.class);
    @Test
    public static void searchAndVerify(){
        PageFactory.initElements(driver, PageObjects.class);
        System.out.println();
        if(properties.getProperty("pageTitle").equalsIgnoreCase(driver.getTitle()))
        {
            logger.info("Launching browser");
            logger.info("Landing page verified with page title "+driver.getTitle());
            String expectedSearchInput = properties.getProperty("searchInput");
            if (PageObjects.searchBox.isDisplayed())
            {
                PageObjects.searchBox.sendKeys(expectedSearchInput + Keys.ENTER);
            }
            String actualSearchInput=PageObjects.searchResult.getText();
            String noOfSearchResult=PageObjects.noOfSearchResult.getText();
            actualSearchInput=actualSearchInput.replaceAll("\"", "");
            noOfSearchResult= String.valueOf(noOfSearchResult.charAt(0));
            System.out.println(noOfSearchResult);
            if (expectedSearchInput.equalsIgnoreCase(actualSearchInput)&&noOfSearchResult!="0")
            {
                logger.info("Search result found for " + expectedSearchInput);
                logger.info(PageObjects.noOfSearchResult.getText());
            } else
            {
                logger.info("No search result found for " + expectedSearchInput);
                logger.info(PageObjects.noOfSearchResult.getText());
            }
        }
        else {
            logger.info("expected page title is not found");
        }




    }

}
