package com.google;

import Helpers.Constants;
import Task1_3.MarketAfterSearch;
import Task1_3.MarketBeforeSearch;
import Task1_3.YandexBeforeMarket;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Tests extends BaseTest {

//    @Test
//    public void wikiCheckTestPO() {
//        chromeDriver.get("https://www.google.com/");
//        GoogleBeforeSearch googleBeforeSearch = new GoogleBeforeSearch(chromeDriver);
//        googleBeforeSearch.find("Гладиолус");
//        GoogleAfterSearch googleAfterSearch = new GoogleAfterSearch(chromeDriver);
//        Assertions.assertTrue(googleAfterSearch.getResults().stream().anyMatch(x -> x.getText().contains("https://ru.wikipedia.org")), "Ссылка на википедию отсутствует");
//    }

//    @Test
//    public void wikiCheckTestPF() {
//        chromeDriver.get("https://www.google.com/");
//        PageFactoryGoogle pageFactoryGoogle = PageFactory.initElements(chromeDriver, PageFactoryGoogle.class);
//        pageFactoryGoogle.find("Гладиолус");
//        System.out.println(pageFactoryGoogle.getAllElements().size());
//        Assertions.assertTrue(pageFactoryGoogle.getAllElements().stream().anyMatch(x -> x.getText().contains("https://ru.wikipedia.org")), "Ссылка на википедию отсутствует");
//    }
//
//    @Test
//    public void openERTestPO() {
//        chromeDriver.get("https://www.google.com/");
//        GoogleBeforeSearch googleBeforeSearch = new GoogleBeforeSearch(chromeDriver);
//        googleBeforeSearch.find("Открытие");
//        GoogleAfterSearch googleAfterSearch = new GoogleAfterSearch(chromeDriver);
//        Assertions.assertTrue(googleAfterSearch.getResults().stream().anyMatch(x -> x.getText().contains("https://www.open.ru")), "Ссылка на сайт банка \"открытие\" отсутствует");
//        chromeDriver.get("https://www.open.ru");
//        OpenExchangeRates openExchangeRates = new OpenExchangeRates(chromeDriver);
//        Assertions.assertTrue(openExchangeRates.getBuyUsdRate() < openExchangeRates.getSellUsdRate(), "Курс продажи доллара меньше курса покупки");
//        Assertions.assertTrue(openExchangeRates.getBuyEurRate() < openExchangeRates.getSellEurRate(), "Курс продажи евро меньше курса покупки");
//    }

//    @Test
//    public void openERTestImprovedPo() {
//        GooglePageWithSearch googlePageWithSearch = new GooglePageWithSearch(chromeDriver);
//        List<Map<String, Object>> sepResultSearch = googlePageWithSearch.getSeparatedRes();
//        Assertions.assertTrue(sepResultSearch.stream().anyMatch(x -> x.get("NAME_PAGE").toString().equals("Банк Открытие: Частным клиентам")), "Ссылка на сайт банка \"открытие\" отсутствует");
//        googlePageWithSearch.goPage("Банк Открытие: Частным клиентам");
//        OpenBankPage openBankPage = new OpenBankPage(chromeDriver);
//        List<Map<String, String>> collectERates = openBankPage.getCollectERates();
//        Assertions.assertTrue(
//                Double.parseDouble(collectERates.stream()
//                        .filter(x -> x.get("Валюта обмена").contains("USD"))
//                        .findFirst()
//                        .get().get("Банк покупает").replaceAll(",", "."))
//                        < Double.parseDouble(collectERates.stream()
//                        .filter(x -> x.get("Валюта обмена").contains("USD"))
//                        .findFirst()
//                        .get().get("Банк продает").replaceAll(",", "."))
//
//
//        );
//        Assertions.assertTrue(
//                Double.parseDouble(collectERates.stream()
//                        .filter(x -> x.get("Валюта обмена").contains("EUR"))
//                        .findFirst()
//                        .get().get("Банк покупает").replaceAll(",", "."))
//                        < Double.parseDouble(collectERates.stream()
//                        .filter(x -> x.get("Валюта обмена").contains("EUR"))
//                        .findFirst()
//                        .get().get("Банк продает").replaceAll(",", "."))
//
//        );
//    }

//    @Feature("Проверка курса валют")
//    @DisplayName("Проверка курса валют со степами")
//    @ParameterizedTest(name = "{displayName}) {arguments}")
//    @Tag("openBank")
//    @CsvSource("USD")
//    public void openERTestWithSteps(String value) {
//        steps.googleFind("открытие");
//        GooglePageWithSearch googlePageWithSearch = new GooglePageWithSearch(chromeDriver);
//        List<Map<String, Object>> sepResultSearch = googlePageWithSearch.getSeparatedRes();
//        steps.checkContainsName(sepResultSearch, "Банк Открытие: Частным клиентам", chromeDriver);
//        steps.goPageText(googlePageWithSearch, "Банк Открытие");
//        OpenBankPage openBankPage = new OpenBankPage(chromeDriver);
//        steps.checkERateDif(value, openBankPage);
//    }

//    @Test
//    public void GoogleAndYandexTest() {
//        steps.goPage("https://yandex.ru/");
//        YandexPage yandexPage = new YandexPage();
//        steps.find("открытие", yandexPage);
////        steps.goPage("https://www.google.ru/");
////        GooglePage googlePage = new GooglePage();
////        steps.find("открытие", googlePage);
//        steps.goPage("https://www.open.ru/");
//        OpenBankPagePF openBankPagePF = new OpenBankPagePF(chromeDriver);
//        steps.checkExRate("USD", openBankPagePF);
//    }


    @Test
    public void yandexMarketForTask13() throws InterruptedException {
        steps.openYandex();
        YandexBeforeMarket yandexBeforeMarket = new YandexBeforeMarket(chromeDriver);
        steps.goMarket(yandexBeforeMarket);
        steps.switchTab();
        MarketBeforeSearch marketBeforeSearch = new MarketBeforeSearch(chromeDriver);
        steps.goToLaptops(marketBeforeSearch);
        steps.filtersLaptops(marketBeforeSearch);
        Thread.sleep(6000);
        steps.setRange(marketBeforeSearch);
        Thread.sleep(3000);
        steps.checkResults(marketBeforeSearch);
        steps.findFirstOne(marketBeforeSearch);
        MarketAfterSearch marketAfterSearch = new MarketAfterSearch(chromeDriver);
        steps.compareResults(marketAfterSearch, marketBeforeSearch);
    }

    @Test
    public void yandexMarketForTask14() throws InterruptedException {
        steps.openYandex();
        YandexBeforeMarket yandexBeforeMarket = new YandexBeforeMarket(chromeDriver);
        steps.goMarket(yandexBeforeMarket);
        steps.switchTab();
        MarketBeforeSearch marketBeforeSearch = new MarketBeforeSearch(chromeDriver);
        steps.goToSmarts(marketBeforeSearch);
        Thread.sleep(6000);
        steps.brandFilters(marketBeforeSearch);
        Thread.sleep(6000);
        steps.setRange(marketBeforeSearch);
        Thread.sleep(3000);
        steps.checkBrandList(marketBeforeSearch);
    }
}