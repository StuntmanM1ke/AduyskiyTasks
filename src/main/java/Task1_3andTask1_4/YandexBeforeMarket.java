package Task1_3andTask1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexBeforeMarket {
    protected WebDriver driver;
    private WebElement marketButton;

    public YandexBeforeMarket(WebDriver driver) {
        this.driver = driver;
        this.marketButton = driver.findElement(By.xpath("//*[@data-id='market']"));
    }

    public void clickMarket() {
        marketButton.click();
    }
}
