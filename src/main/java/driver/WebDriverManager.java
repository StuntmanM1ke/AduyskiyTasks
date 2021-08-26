package driver;

import Helpers.Constants;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static WebDriver currentDriver;

    public static WebDriver getCurrentDriver() {
        return currentDriver;
    }
    public static void initChrome (){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(List.of("start-maximized", "disable-infobars", "--no-sandbox"));
        try {
            currentDriver = new ChromeDriver(options);
        } catch (SessionNotCreatedException e) {
            System.out.println("Данный драйвер не совместим с текущим браузером. Используйте другой драйвер");
        }
    }
    public static void initFFox (){
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(List.of("--start-maximized", "disable-infobars", "--no-sandbox"));
        try {
            currentDriver = new FirefoxDriver(options);
        } catch (SessionNotCreatedException e) {
            System.out.println("Данный драйвер не совместим с текущим браузером. Используйте другой драйвер");
        }
    }

    public static void initOperaDriver (){
        System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
        try {
            currentDriver = new OperaDriver();
        } catch (SessionNotCreatedException e) {
            System.out.println("Данный драйвер не совместим с текущим браузером. Используйте другой драйвер");
        }
    }
    public static void setDriverDefaultSettings() {
        currentDriver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }
    public static void quitCurrentDriver () {
        if (currentDriver != null) {
            currentDriver.quit();
            currentDriver = null;
        }
    }
}
