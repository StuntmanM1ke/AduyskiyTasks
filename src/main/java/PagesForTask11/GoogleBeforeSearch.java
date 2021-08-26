package PagesForTask11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleBeforeSearch {
    protected WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;

    public GoogleBeforeSearch(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//*[@class='gLFyf gsfi']"));
        searchButton = chromeDriver.findElement(By.xpath("//*[@class='gNO89b']"));
    }

    public void find(String keysFind) {
        searchField.click();
        searchField.sendKeys(keysFind);
        searchButton.click();
    }
}
