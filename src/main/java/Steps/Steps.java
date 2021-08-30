package Steps;

import Helpers.Constants;
import Task1_3.MarketAfterSearch;
import Task1_3.MarketBeforeSearch;
import Task1_3.YandexBeforeMarket;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Steps {
    private WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    // Задача 1.3
    @Step("Шаг 1. Переход на яндекс")
    public void openYandex() {
        driver.get("https://yandex.ru/");
    }

    @Step("Шаг 2. Переход в маркет")
    public void goMarket(YandexBeforeMarket yandexBeforeMarket) {
        yandexBeforeMarket.clickMarket();
    }

    @Step("Шаг 3. Смена вкладки")
    public void switchTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    @Step("Шаг 4. Переход в раздел ноутбуков")
    public void goToLaptops(MarketBeforeSearch marketBeforeSearch) {
        marketBeforeSearch.goToLaptop();
    }

    @Step("Шаг 5. Задание фильтров")
    public void filtersLaptops(MarketBeforeSearch marketBeforeSearch) {
        marketBeforeSearch.setAllFiltersLaptops();
    }

    @Step("Шаг 6. Установка количества показываемых элементов на страницу")
    public void setRange(MarketBeforeSearch marketBeforeSearch) {
        marketBeforeSearch.setRangeToTwelve();
    }

    @Step("Шаг 7. Проверка количества отображаемых элементов")
    public void checkResults(MarketBeforeSearch marketBeforeSearch) {
        Assertions.assertEquals(12, marketBeforeSearch.getResults().size());
    }

    @Step("Шаг 8. Поиск по первому элементу")
    public void findFirstOne(MarketBeforeSearch marketBeforeSearch) {
        marketBeforeSearch.searchFirstOne();
    }

    @Step("Шаг 9. Сравнение результатов с запросом")
    public void compareResults(MarketAfterSearch marketAfterSearch, MarketBeforeSearch marketBeforeSearch) {
        Assertions.assertTrue(marketBeforeSearch.getResults().get(0).getText().equals(marketAfterSearch.getResultsAfterSearch().get(0).getText()), "Результат не соответствует запросу");
    }

    // Задача 1.4
    @Step("Шаг 4. Переход в раздел смартфонов")
    public void goToSmarts(MarketBeforeSearch marketBeforeSearch) {
        marketBeforeSearch.goToSmartphones();
    }

    @Step("Шаг 5. Выбор бренда")
    public void brandFilters(MarketBeforeSearch marketBeforeSearch) throws InterruptedException {
        marketBeforeSearch.setBrandFilter(Constants.brandName);
    }

    @Step("Шаг 7. Проверка списка")
    public void checkBrandList(MarketBeforeSearch marketBeforeSearch) throws InterruptedException {
        List<WebElement> results = marketBeforeSearch.getBrandList();
        for (WebElement result : results) {
            Assertions.assertTrue(result.getText().contains(Constants.brandName), "В выборку попали не только " + Constants.brandName);
        }
    }
//    @Step("Шаг 1. Проверить ниличие имени; {name} ")
//    public void checkContainsName(List<Map<String, Object>> ResultSearch, String name, WebDriver webDriver) {
//        CustomUtils.getScreen(webDriver);
//        Assertions.assertTrue(ResultSearch.stream().anyMatch(x -> x.get("NAME_PAGE").toString().contains(name)), "Ссылка на сайт банка \"открытие\" отсутствует");
//    }
//
//    @Step("Шаг 2. Перейдём по ссылке с текстом; {title}")
//    public void goPageText(GooglePageWithSearch googlePageWithSearch, String title) {
//        Assertions.assertTrue(googlePageWithSearch.goPage(title), "Страница \"" + title + "\" не найдена");
//    }
//
//    @Step("Шаг 3. Проверка курса; {moneyType}")
//    public void checkERateDif(String moneyType, OpenBankPage openBankPage) {
//        CustomUtils.getScreen(openBankPage.getWebDriver(), openBankPage.getExChangeRates());
//        Assertions.assertTrue(
//                Double.parseDouble(
//                        openBankPage.getCollectERates().stream()
//                                .filter(x -> x.get("Валюта обмена").contains(moneyType))
//                                .findFirst()
//                                .get().get("Банк покупает").replaceAll(",", "."))
//                        < Double.parseDouble(
//                        openBankPage.getCollectERates().stream()
//                                .filter(x -> x.get("Валюта обмена").contains(moneyType))
//                                .findFirst()
//                                .get().get("Банк продает").replaceAll(",", "."))
//        );
//    }
//
//    @Step("Переход на страницу; {URL}")
//    public void goPage (String url){
//        driver.get(url);
//    }
//
//    @Step("Поиск по запросу; {request}")
//    public void find (String request, Page page){
//        page.getElement("Поле поиска").sendKeys(request);
//        page.getElement("Кнопка поиска").click();
//    }
//
//    @Step("Проверка курса; {moneyType}")
//    public void checkExRate(String moneyType, OpenBankPagePF openBankPagePF) {
//        Assertions.assertTrue(
//                Double.parseDouble(
//                        openBankPagePF.getCollectERates().stream()
//                                .filter(x -> x.get("Валюта обмена").contains(moneyType))
//                                .findFirst()
//                                .get().get("Банк покупает").replaceAll(",", "."))
//                        < Double.parseDouble(
//                        openBankPagePF.getCollectERates().stream()
//                                .filter(x -> x.get("Валюта обмена").contains(moneyType))
//                                .findFirst()
//                                .get().get("Банк продает").replaceAll(",", "."))
//        );
//    }
//
//    @Step("Поиск в гугл по запросу; {request}")
//    public void googleFind(String request) {
//        driver.get("https://www.google.com/search?q=" + request);
//    }
}
