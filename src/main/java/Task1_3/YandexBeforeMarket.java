package Task1_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YandexBeforeMarket {
    protected WebDriver driver;
    private WebElement marketButton;

    public YandexBeforeMarket(ChromeDriver driver) {
        this.driver = driver;
        this.marketButton = driver.findElement(By.xpath("//*[@data-id='market']"));
    }

    public void clickMarket() {
        marketButton.click();
    }
}
