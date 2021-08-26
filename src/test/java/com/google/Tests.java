package com.google;

import Helpers.Constants;
import PagesForTask11.GoogleAfterSearch;
import PagesForTask11.GoogleBeforeSearch;
import PagesForTask11.PageFactoryGoogle;
import PagesForTask12.OpenExchangeRates;
import Steps.Steps;
import Task12Improved.GooglePageWithSearch;
import Task12Improved.OpenBankPage;
import Task13.YandexBeforeMarket;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Tests extends BaseTest {

    @Test
    public void wikiCheckTestPO() {
        chromeDriver.get("https://www.google.com/");
        GoogleBeforeSearch googleBeforeSearch = new GoogleBeforeSearch(chromeDriver);
        googleBeforeSearch.find("Гладиолус");
        GoogleAfterSearch googleAfterSearch = new GoogleAfterSearch(chromeDriver);
        Assertions.assertTrue(googleAfterSearch.getResults().stream().anyMatch(x -> x.getText().contains("https://ru.wikipedia.org")), "Ссылка на википедию отсутствует");
    }

    @Test
    public void wikiCheckTestPF() {
        chromeDriver.get("https://www.google.com/");
        PageFactoryGoogle pageFactoryGoogle = PageFactory.initElements(chromeDriver, PageFactoryGoogle.class);
        pageFactoryGoogle.find("Гладиолус");
        System.out.println(pageFactoryGoogle.getAllElements().size());
        Assertions.assertTrue(pageFactoryGoogle.getAllElements().stream().anyMatch(x -> x.getText().contains("https://ru.wikipedia.org")), "Ссылка на википедию отсутствует");
    }

    @Test
    public void openERTestPO() {
        chromeDriver.get("https://www.google.com/");
        GoogleBeforeSearch googleBeforeSearch = new GoogleBeforeSearch(chromeDriver);
        googleBeforeSearch.find("Открытие");
        GoogleAfterSearch googleAfterSearch = new GoogleAfterSearch(chromeDriver);
        Assertions.assertTrue(googleAfterSearch.getResults().stream().anyMatch(x -> x.getText().contains("https://www.open.ru")), "Ссылка на сайт банка \"открытие\" отсутствует");
        chromeDriver.get("https://www.open.ru");
        OpenExchangeRates openExchangeRates = new OpenExchangeRates(chromeDriver);
        Assertions.assertTrue(openExchangeRates.getBuyUsdRate() < openExchangeRates.getSellUsdRate(), "Курс продажи доллара меньше курса покупки");
        Assertions.assertTrue(openExchangeRates.getBuyEurRate() < openExchangeRates.getSellEurRate(), "Курс продажи евро меньше курса покупки");
    }

    @Test
    public void openERTestImprovedPo() {
        GooglePageWithSearch googlePageWithSearch = new GooglePageWithSearch(chromeDriver);
        List<Map<String, Object>> sepResultSearch = googlePageWithSearch.getSeparatedRes();
        Assertions.assertTrue(sepResultSearch.stream().anyMatch(x -> x.get("NAME_PAGE").toString().equals("Банк Открытие: Частным клиентам")), "Ссылка на сайт банка \"открытие\" отсутствует");
        googlePageWithSearch.goPage("Банк Открытие: Частным клиентам");
        OpenBankPage openBankPage = new OpenBankPage(chromeDriver);
        List<Map<String, String>> collectERates = openBankPage.getCollectERates();
        Assertions.assertTrue(
                Double.parseDouble(collectERates.stream()
                        .filter(x -> x.get("Валюта обмена").contains("USD"))
                        .findFirst()
                        .get().get("Банк покупает").replaceAll(",", "."))
                        < Double.parseDouble(collectERates.stream()
                        .filter(x -> x.get("Валюта обмена").contains("USD"))
                        .findFirst()
                        .get().get("Банк продает").replaceAll(",", "."))


        );
        Assertions.assertTrue(
                Double.parseDouble(collectERates.stream()
                        .filter(x -> x.get("Валюта обмена").contains("EUR"))
                        .findFirst()
                        .get().get("Банк покупает").replaceAll(",", "."))
                        < Double.parseDouble(collectERates.stream()
                        .filter(x -> x.get("Валюта обмена").contains("EUR"))
                        .findFirst()
                        .get().get("Банк продает").replaceAll(",", "."))

        );
    }

    @Feature("Проверка курса валют")
    @DisplayName("Проверка курса валют со степами")
    @ParameterizedTest(name = "{displayName}) {arguments}")
    @Tag("openBank")
    @CsvSource("USD")
    public void openERTestWithSteps(String value) {
        steps.googleFind("открытие");
        GooglePageWithSearch googlePageWithSearch = new GooglePageWithSearch(chromeDriver);
        List<Map<String, Object>> sepResultSearch = googlePageWithSearch.getSeparatedRes();
        steps.checkContainsName(sepResultSearch, "Банк Открытие: Частным клиентам", chromeDriver);
        steps.goPageText(googlePageWithSearch, "Банк Открытие");
        OpenBankPage openBankPage = new OpenBankPage(chromeDriver);
        steps.checkERateDif(value, openBankPage);
    }


    @Test
    public void yandexMarketForTask13() {
//    steps.openYandex();
//    steps.goMarket();
//    chromeDriver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        operaDriver.get("https://market.yandex.ru/?clid=505&utm_source=main_stripe_big&src_pof=505&utm_source_service=morda");
        steps.filters();
    }
}