package core;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.*;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Common {

    public static AppiumDriver mDriver = null;
    public static WebDriver pcDriver = null;
    private static Map<String, Object> GlobalStack = new HashMap<String, Object>();

    public static void LaunchEmulator(String OS, String DeviceName, String DeviceID) throws IOException, InterruptedException {

        boolean exitCode = false;
        ProcessBuilder builder;
        Process proccess;

            switch (OS.toLowerCase()) {

                case "android":

                    if (!DeviceName.startsWith("@")) {
                        DeviceName = "@" + DeviceName;
                    }
                    String emulatorLocation = getAppLocation("emulator");
                    builder = new ProcessBuilder(emulatorLocation, DeviceName, "-no-snapshot-load");
                    proccess = builder.start();
                    exitCode = proccess.waitFor(20, TimeUnit.SECONDS);
                    Thread.sleep(10000);
                    break;

                case "ios":

                    builder = new ProcessBuilder("/bin/sh", "-c", "xcrun instruments -w " + DeviceID);
                    proccess = builder.start();
                    exitCode = proccess.waitFor(20, TimeUnit.SECONDS);
                    Thread.sleep(10000);
                    break;
        }
    }

    private static String getAppLocation(String AppName)
    {
        String tmp = "";

            switch(AppName) {
                case "appium":
                    tmp = "/usr/local/bin/appium";
                    break;
                case "emulator":
                    tmp = System.getProperty("user.home") + "/Library/Android/sdk/tools/emulator";
                    break;
                case "adb":
                    tmp = System.getProperty("user.home") + "/Library/Android/sdk/platform-tools/adb";
                    break;
                default:
                    tmp = "";
        }
        return tmp;
    }

    public static void CloseEmulator(String EmulatorType, String DeviceName, String DeviceID) throws IOException, InterruptedException {

        switch (EmulatorType.toLowerCase()) {

            case "android":

                String ADBLocation = getAppLocation("adb");
                Runtime.getRuntime().exec(ADBLocation + " -s " + DeviceID + " emu kill");
                Thread.sleep(2000);

//                    if(VerifyProcessExists("adb")){
//                        Runtime.getRuntime().exec(ADBLocation + " -s "+DeviceID+" emu kill");
//                        Thread.sleep(2000);
//                    }
                break;

            case "ios":

                Runtime.getRuntime().exec("xcrun simctl shutdown " + DeviceID);
                Thread.sleep(5000);
                break;
        }
    }

}