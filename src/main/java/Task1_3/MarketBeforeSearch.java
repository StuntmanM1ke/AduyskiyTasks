package Task1_3;

import ForPageFactory.FieldName;
import ForPageFactory.Page;
import Helpers.Constants;
import Helpers.PageUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MarketBeforeSearch implements Page {
    protected WebDriver driver;


    public MarketBeforeSearch(WebDriver driver) {
        this.driver = driver;
        if (driver.getTitle().contains("Яндекс.Маркет")) {
            computerFilter = driver.findElement(By.xpath("//span[contains(text(),'Компьютеры')]"));
//
//
        } else System.out.println("не перешел на вкладку");
    }

    @FieldName("Компьютеры")
    private WebElement computerFilter;

    private WebElement priceFieldFrom;
    private WebElement priceFieldTo;

    @FieldName("Ноутбуки")
    private WebElement laptopFilter;

    private WebElement hpPoint;
    private WebElement lenovoPoint;

    @FieldName("Кнопка рейнджа")
    private WebElement showSmthg;
    private WebElement showTwelve;
    private WebElement searchField;
    private WebElement searchButton;

    public List<WebElement> getResults() {
        results = driver.findElements(By.xpath("//h3"));
        return results;
    }


    private List<WebElement> results = new ArrayList<>();

    public void goToLaptop() {
        computerFilter.click();
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        laptopFilter = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[2]/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div[1]/div[2]/ul/li[1]/div"));
        if (PageUtils.isClickable(getElement("Ноутбуки")))
            laptopFilter.click();
    }

    public void setAllFilters() {
        setPrice("10000", "30000");
        hpPoint = driver.findElement(By.xpath("//span[@class = '_1o8_r' and contains(text(),'HP')]"));
        lenovoPoint = driver.findElement(By.xpath("//span[@class = '_1o8_r' and contains(text(),'Lenovo')]"));
        hpPoint.click();
        lenovoPoint.click();
    }

    public void setPrice(String from, String to) {
        priceFieldFrom = driver.findElement(By.xpath("//*[@id = 'glpricefrom']"));
        priceFieldTo = driver.findElement(By.xpath("//*[@id = 'glpriceto']"));
        priceFieldFrom.sendKeys(from);
        priceFieldTo.sendKeys(to);
    }

    public void setRangeToTwelve() {
        showSmthg = driver.findElement(By.xpath("//button[@class='vLDMf']"));
        showSmthg.click();
        showTwelve = driver.findElement(By.xpath("//button[@class='_1KpjX _35Paz']"));
        showTwelve.click();
    }

    public void searchFirstOne() {
       searchField = driver.findElement(By.xpath("//input[@id='header-search']"));
       searchButton = driver.findElement(By.xpath("//span[contains(text(),'Найти')]"));
       searchField.sendKeys(results.get(0).getText());
       searchButton.click();
    }

    @Override
    public boolean isPageLoaded() {
        return true;
    }
}
