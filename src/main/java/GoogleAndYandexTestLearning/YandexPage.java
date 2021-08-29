package GoogleAndYandexTestLearning;

import ForPageFactory.FieldName;
import ForPageFactory.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class YandexPage implements Page {

    @FieldName("Поле поиска")
    @FindBy(xpath = "//div[@class = 'search2__input']//input[contains(@class, 'input__control')]")
    public WebElement searchField;

    @FieldName("Кнопка поиска")
    @FindBy(xpath = "//div[@class = 'search2__button']//button[contains(@class, 'button')]")
    public WebElement searchButton;

    public YandexPage() {
        initPage();
    }

    @Override
    public boolean isPageLoaded() {
        return true;
    }


}
