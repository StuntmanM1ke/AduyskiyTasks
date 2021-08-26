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
        WebDriverManager.initOperaDriver();
        operaDriver = WebDriverManager.getCurrentDriver();
        operaDriver.manage().window().maximize();
        steps = new Steps(operaDriver);
    }

    @AfterEach
    public void afterEach() {
      //  WebDriverManager.quitCurrentDriver();
    }
}
