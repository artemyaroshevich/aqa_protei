package page;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final String emailLocator = "[id=\"loginEmail\"]";
    private final String passwordLocator = "[id=\"loginPassword\"]";

    private final String submitButtonLocator = "[type=submit]";

    public void login(String email,String password) {
        $(emailLocator).sendKeys(email);
        $(passwordLocator).sendKeys(password);
        $(submitButtonLocator).click();
        $(submitButtonLocator).shouldNot(Condition.disabled);
        $x("(//*[contains(@class,'uk-form ')])[2]").shouldBe(Condition.visible);
    }

    public void invalidEmail(String email) {
        $(emailLocator).sendKeys(email);
        $(submitButtonLocator).click();
        $("[id=\"emailFormatError\"]").shouldHave(Condition.text("Неверный формат E-Mail"));
    }

    public void invalidPasswordWithEmail(String email, String password) {
        $(emailLocator).sendKeys(email);
        $(passwordLocator).sendKeys(password);
        $(submitButtonLocator).click();
        $("[id=\"emailFormatError\"]").shouldHave(Condition.text("Неверный E-Mail или пароль"));
    }

    public void invalidPassword(String email, String password) {
        $(emailLocator).sendKeys(email);
        $(passwordLocator).sendKeys(password);
        $(submitButtonLocator).click();
        $("[id=\"emailFormatError\"]").shouldHave(Condition.text("Неверный формат E-Mail"));
    }
}
