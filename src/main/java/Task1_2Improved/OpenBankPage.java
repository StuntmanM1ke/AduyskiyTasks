package Task1_2Improved;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenBankPage {
    private String selectorExRates = "//*[@class='main-page-exchange main-page-info__card']";
    private String selectorHeaders = ".//tbody/tr[contains(@class,'header')]/td";
    private String selectorRows = ".//tbody/tr[contains(@class,'row')]";

    public WebDriver getWebDriver() {
        return webDriver;
    }


    private WebDriver webDriver;

    public WebElement getExChangeRates() {
        return exChangeRates;
    }

    private WebElement exChangeRates;
    List<Map<String, String>> collectERates = new ArrayList<>();
    private String mainURL = "https://www.open.ru/";

    public OpenBankPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        if (!webDriver.getTitle().contains("открытие")) {
            webDriver.get(mainURL);
            exChangeRates = webDriver.findElement(By.xpath(selectorExRates));
        }
    }

    public String getSelectorExRates() {
        return selectorExRates;
    }
    public List<Map<String, String>> getCollectERates() {
        List<WebElement> headers = exChangeRates.findElements(By.xpath(selectorHeaders));
        List<WebElement> rows = exChangeRates.findElements(By.xpath(selectorRows));
        for (int i = 0; i < rows.size(); i++) {
        Map <String, String> collectRow = new HashMap<>();
            for (int j = 0; j < headers.size(); j++) {
            collectRow.put(
                   headers.get(j).getText(),
                    rows.get(i).findElement(By.xpath(".//td["+(j+1)+"]")).getText()
                    );
            }
            collectERates.add(collectRow);
        }
        return collectERates;
    }
}
