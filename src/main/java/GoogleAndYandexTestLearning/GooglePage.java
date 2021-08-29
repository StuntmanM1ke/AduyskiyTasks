package GoogleAndYandexTestLearning;

import ForPageFactory.FieldName;
import ForPageFactory.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;

public class GooglePage implements Page {
    @FieldName("Поле поиска")
    @FindBy(name = "q")
    public WebElement searchField;

    @FieldName("Кнопка поиска")
    @FindBy(name = "btnK")
    public WebElement searchButton;

    public GooglePage() {
        initPage();
    }

    @Override
    public boolean isPageLoaded() {
        return true;
    }
}
