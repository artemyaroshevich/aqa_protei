package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.UploadFile;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import page.FormPage;
import page.LoginPage;


public class BaseTest {

    LoginPage loginPage = new LoginPage();
    FormPage formPage = new FormPage();

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Selenide.open(  "file:///Users/artemarosevic/Downloads/qa-test.html");
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(false));
    }

    @AfterMethod
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }
}
