package com.google;

import Helpers.Constants;
import Steps.Steps;
import driver.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

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
        chromeDriver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        steps = new Steps(chromeDriver);
    }

    @AfterEach
    public void afterEach() {
      //  WebDriverManager.quitCurrentDriver();
    }
}
