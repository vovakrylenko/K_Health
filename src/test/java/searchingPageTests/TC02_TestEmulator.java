package searchingPageTests;

import DataDrivenPack.DataDrivenClass;
import core.BaseTest;

import static core.Common.CloseEmulator;
import static core.Common.LaunchEmulator;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC02_TestEmulator extends BaseTest {


    @Test(dataProvider = "TC02_TestEmulator", dataProviderClass = DataDrivenClass.class)

    public void runEmulatorTest() throws IOException, InterruptedException {

        LaunchEmulator("android", "Pixel_3a_API_30", "emulator-5554");
        System.out.println("Executed successfully");
        CloseEmulator("android", "Pixel_3a_API_30", "emulator-5554");
    }
}