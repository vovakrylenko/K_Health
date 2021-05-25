package DataDrivenPack;

import core.Config;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataDrivenClass {

    @DataProvider(name = "TC01_SearchingBook")
    public static Iterator<Object[]> TC01_SearchingBook() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{Config.getProperty("test.value"), "[!@#$%^&*]", Config.getProperty("test.number")});
        return data.iterator();
    }
}


