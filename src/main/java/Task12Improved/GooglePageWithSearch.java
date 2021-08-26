package Task12Improved;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GooglePageWithSearch {
    private String selectorSearchItem = "//div[@class='g' and not(@data-hveid)]";
    private String selectorURL = ".//a[@href]";
    private String selectorNamePage = ".//h3";
    private String selectorDiscription = ".//div[@class='IsZvec']";

    private WebDriver webDriver;

    private List<WebElement> resultSearch = new ArrayList<>();

    private List<Map<String, Object>> separatedRes = new ArrayList<>();

    public GooglePageWithSearch(WebDriver webDriver) {
        this.webDriver = webDriver;
        resultSearch = webDriver.findElements(By.xpath(selectorSearchItem));
    }


    public List<Map<String, Object>> getSeparatedRes() {
        for (WebElement r : resultSearch) {
            separatedRes.add(Map.of(
                    "WEB_ELEMENT", r,
                    "URL", r.findElement(By.xpath(selectorURL)).getAttribute("href"),
                    "NAME_PAGE", r.findElement(By.xpath(selectorNamePage)).getText(),
                    "DISCRIPTION", r.findElement(By.xpath(selectorDiscription)).getText()
            ));

        }
        return separatedRes;
    }

    public boolean goPage(String namePage) {
        WebElement pageLink = (WebElement) separatedRes.stream()
                .filter(x->x.get("NAME_PAGE").toString().contains(namePage))
                .findFirst()
                .get().get("WEB_ELEMENT");
        pageLink.findElement(By.xpath(selectorURL)).click();
        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        for (String tab : tabs){
            webDriver.switchTo().window(tab);
            if(webDriver.getTitle().contains(namePage))
                return true;
        }
        return false;
    }
}
