package searchingPageTests;

import DataDrivenPack.DataDrivenClass;
import core.BaseTest;
import org.testng.annotations.Test;
import uiLayer.MainPage;
import uiLayer.SearchResultPage;

public class TC01_SearchingBook extends BaseTest {

    SearchResultPage searchResultPage;
    MainPage mainPage;

    @Test(dataProvider = "TC01_SearchingBook", dataProviderClass = DataDrivenClass.class)

    public void searchingResults(String searchingValue, String regEx, String numberToCompare) {
        searchResultPage = new SearchResultPage();
        mainPage = new MainPage();
        mainPage.openPageAndCheckURL();
        mainPage.setSearchValue(searchingValue);
        searchResultPage.checkSearchingResults(regEx, numberToCompare);
    }
}