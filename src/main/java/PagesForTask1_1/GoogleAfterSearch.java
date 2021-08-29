package PagesForTask1_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleAfterSearch {
    List<WebElement> results;

    protected WebDriver chromeDriver;


    public GoogleAfterSearch(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }


    public List<WebElement> getResults() {
        results = chromeDriver.findElements(By.xpath("//*[@id='center_col']"));
        return results;
    }


}
