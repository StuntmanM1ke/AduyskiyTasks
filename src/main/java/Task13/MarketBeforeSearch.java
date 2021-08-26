package Task13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class MarketBeforeSearch {
    protected WebDriver driver;

    public MarketBeforeSearch(WebDriver driver) {
        this.driver = driver;
        computerFilter = driver.findElement(By.xpath("//span[contains(text(),'Компьютеры')]"));
    }

    private WebElement computerFilter;
    ;
    private WebElement priceFieldFrom;
    private WebElement priceFieldTo;
    private WebElement LaptopFilter;
    private WebElement hpPoint;
    private WebElement lenovoPoint;
    private WebElement showSmthg = driver.findElement(By.xpath("//*[@class='vLDMf']"));
    private WebElement showTwelve = driver.findElement(By.xpath("//*[@class='_1KpjX _35Paz _3a1jD']"));


    public void setAllFilters() {
        computerFilter.click();
//        showSmthg.click();
//        showTwelve.click();
    }
    public boolean isItMarket () {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String tab : tabs){
           driver.switchTo().window(tab);
            if(driver.getTitle().contains("Яндекс.Маркет"))
                return true;
        }
        return false;
    }
}
