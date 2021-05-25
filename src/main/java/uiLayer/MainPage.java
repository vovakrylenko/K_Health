package uiLayer;

import core.BasePage;
import core.Config;
import core.Driver;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static core.Config.getBaseURL;

public class MainPage extends BasePage {
    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchField;
    @FindBy(css = "#nav-search-submit-button")
    private WebElement searchBtn;

    public void openPageAndCheckURL(){
        Assert.assertEquals(Driver.get().getCurrentUrl(), getBaseURL());
    }

    public void setSearchValue(String searchingValue){
        searchField.sendKeys(searchingValue);
        searchBtn.click();
    }
}