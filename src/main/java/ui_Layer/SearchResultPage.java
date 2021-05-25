package ui_Layer;

import core.BasePage;
import core.Driver;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static core.Config.getBaseURL;

public class SearchResultPage extends BasePage {
    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchField;
    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchBtn;
    @FindBy(xpath = "(//span[@class='a-offscreen'])[2]")
    private WebElement priceElement;

    String searchValue = "QA Test Automation Books";
    double priceToCompare = 30.0;

    public void openPageAndCheckURL(){
        Assert.assertEquals(Driver.get().getCurrentUrl(), getBaseURL());
    }

    public void setSearchValue(){
        searchField.sendKeys(searchValue);
        searchBtn.click();
    }

    public void checkSearchingResults() {
        String priceValue = priceElement.getAttribute("innerText").replaceAll("[!@#$%^&*]", "");
        Assert.assertTrue(Float.parseFloat(priceValue) < priceToCompare);
    }
}