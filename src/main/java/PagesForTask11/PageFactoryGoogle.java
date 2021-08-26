package PagesForTask11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PageFactoryGoogle {
    protected WebDriver chromeDriver;
    @FindBy(how = How.XPATH, using = "//*[@class='gLFyf gsfi']")
    WebElement searchField;
    @FindBy(how = How.XPATH, using = "//*[@class='gNO89b']")
    WebElement searchButton;
    @FindBy(how = How.XPATH, using = "//*[@id='center_col']")
    List<WebElement> allElements;

    public PageFactoryGoogle(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public void find(String keysFind) {
        searchField.click();
        searchField.sendKeys(keysFind);
        searchButton.click();
    }

    public List<WebElement> getAllElements() {
        return allElements;
    }
}
