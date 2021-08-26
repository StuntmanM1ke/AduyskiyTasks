package com.google;

import Steps.Steps;
import driver.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver chromeDriver;
    protected WebDriver ffoxDriver;
    protected WebDriver operaDriver;
    protected Steps steps;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.initChrome();
        chromeDriver = WebDriverManager.getCurrentDriver();
        chromeDriver.manage().window().maximize();
        steps = new Steps(chromeDriver);
    }

    @AfterEach
    public void afterEach() {
      //  WebDriverManager.quitCurrentDriver();
    }
}
