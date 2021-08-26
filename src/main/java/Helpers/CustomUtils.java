package Helpers;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomUtils {


    public static byte[] getScreen (WebDriver driver){
File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try {
    FileUtils.copyFile(screenshot, new File("C:/tmp/screens/screen.png"));

    return Files.readAllBytes((Paths.get("C:/tmp/screens", "screen.png")));
}
catch (IOException e) {
    e.printStackTrace();
}
    return new byte[0];
}
@Attachment
    public static byte[] getScreen(WebDriver driver, WebElement webElement){
    Actions actions = new Actions(driver);
    actions.moveToElement(webElement).build().perform();
    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(screenshot, new File("C:/tmp/screens/screen.png"));
        return Files.readAllBytes((Paths.get("C:/tmp/screens", "screen.png")));
    }
catch (IOException e) {
        e.printStackTrace();
    }
    return new byte[0];
}
}