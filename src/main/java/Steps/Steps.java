package Steps;

import Helpers.CustomUtils;
import Task12Improved.GooglePageWithSearch;
import Task12Improved.OpenBankPage;
import Task13.MarketBeforeSearch;
import Task13.YandexBeforeMarket;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Utilities;
import java.util.List;
import java.util.Map;

public class Steps {
    private WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Шаг 1. Переход на яндекс")
    public void openYandex(){
        driver.get("https://yandex.ru/");
    }
    @Step("Шаг 2. Переход в маркет")
    public void goMarket() {
        YandexBeforeMarket yandexBeforeMarket = new YandexBeforeMarket((ChromeDriver) driver);
        yandexBeforeMarket.clickMarket();
    }
    @Step("Шаг 3. Установка фильтров")
    public void filters(){
        MarketBeforeSearch marketBeforeSearch = new MarketBeforeSearch(driver);
        if(marketBeforeSearch.isItMarket()) {
            marketBeforeSearch.setAllFilters();
        }
    }
    @Step("Шаг 1. Проверить ниличие имени; {name} ")
    public void checkContainsName(List<Map<String, Object>> ResultSearch, String name, WebDriver webDriver) {
        CustomUtils.getScreen(webDriver);
        Assertions.assertTrue(ResultSearch.stream().anyMatch(x -> x.get("NAME_PAGE").toString().contains(name)), "Ссылка на сайт банка \"открытие\" отсутствует");
    }

    @Step("Шаг 2. Перейдём по ссылке с текстом; {title}")
    public void goPageText(GooglePageWithSearch googlePageWithSearch, String title) {
        Assertions.assertTrue(googlePageWithSearch.goPage(title), "Страница \"" + title + "\" не найдена");
    }

    @Step("Шаг 3. Проверка курса; {moneyType}")
    public void checkERateDif(String moneyType, OpenBankPage openBankPage) {
        CustomUtils.getScreen(openBankPage.getWebDriver(), openBankPage.getExChangeRates());
        Assertions.assertTrue(
                Double.parseDouble(
                        openBankPage.getCollectERates().stream()
                                .filter(x -> x.get("Валюта обмена").contains(moneyType))
                                .findFirst()
                                .get().get("Банк покупает").replaceAll(",", "."))
                        < Double.parseDouble(
                        openBankPage.getCollectERates().stream()
                                .filter(x -> x.get("Валюта обмена").contains(moneyType))
                                .findFirst()
                                .get().get("Банк продает").replaceAll(",", "."))
        );
    }

    @Step("Поиск в гугл по запросу; {request}")
    public void googleFind(String request) {
        driver.get("https://www.google.com/search?q=" + request);
    }
}
