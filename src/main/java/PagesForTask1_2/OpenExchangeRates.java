package PagesForTask1_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenExchangeRates {
    protected WebDriver chromeDriver;
    private List<WebElement> allElements;

    public OpenExchangeRates(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        allElements = chromeDriver.findElements(By.xpath("//*[@class='main-page-exchange__rate']"));
    }
// Понимаю что способ получения объектов никуда не годится, но другого варианта не придумал =( Поля на этом сайте не имеют оригинального идентификатора за который можно было бы зацепиться.
    public Double getBuyUsdRate() {
        return Double.parseDouble(allElements.get(0).getText().replaceAll(",","."));
    }

    public Double getSellUsdRate() {
        return Double.parseDouble(allElements.get(1).getText().replaceAll(",","."));
    }

    public Double getBuyEurRate() {
        return Double.parseDouble(allElements.get(2).getText().replaceAll(",","."));
    }

    public Double getSellEurRate() {
        return Double.parseDouble(allElements.get(3).getText().replaceAll(",","."));
    }
}
