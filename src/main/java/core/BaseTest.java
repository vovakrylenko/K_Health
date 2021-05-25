package core;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void init() {

        Driver.init();

    }

    @BeforeClass
    public void openURL() {

        Driver.get().get(Config.getBaseURL());

    }


    @AfterSuite
    public void cleanup() {

        Driver.tearDown();

    }
}

