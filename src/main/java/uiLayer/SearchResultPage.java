package uiLayer;

import core.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "(//span[@class='a-offscreen'])[2]")
    private WebElement priceElement;

    public void checkSearchingResults(String regEx, String numberToCompare) {
        String priceValue = priceElement.getAttribute("innerText").replaceAll(regEx, "");
        Assert.assertTrue(Float.parseFloat(priceValue) < Float.parseFloat(numberToCompare));
    }

}