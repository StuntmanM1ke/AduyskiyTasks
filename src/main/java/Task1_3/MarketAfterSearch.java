package Task1_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MarketAfterSearch {
    protected WebDriver driver;

    public MarketAfterSearch(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getResultsAfterSearch() {
        return resultsAfterSearch = driver.findElements(By.xpath("//h3"));
    }

    private List<WebElement> resultsAfterSearch= new ArrayList<>();
}
