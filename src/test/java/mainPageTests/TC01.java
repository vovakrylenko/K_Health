package mainPageTests;

import core.BaseTest;
import org.testng.annotations.Test;
import uiLayer.SearchResultPage;

public class TC01 extends BaseTest {

    SearchResultPage searchResultPage;

    @Test()

    public void searchingResults() {
        searchResultPage = new SearchResultPage();
        searchResultPage.openPageAndCheckURL();
        searchResultPage.setSearchValue();
        searchResultPage.checkSearchingResults();
    }
}