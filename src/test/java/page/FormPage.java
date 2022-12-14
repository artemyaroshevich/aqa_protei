package page;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class FormPage {

    public void allFillFieldMen() {
        Faker faker = new Faker();
        fillEmail();
        fillName(faker);
        selectGenderMen();
        selectOptionOne();
        selectRadioButtonOptionTwo();
        submitButton();
        submitModalWindow();
        List<SelenideElement> idRows = $$x(("//*[contains(@class,'uk-table')]//*[contains(@td,'')][2]//tr"));
        for (int i = 1; i < idRows.size(); i++) {
            if (idRows.size() - 1 == i) {
                break;
            }
            assertTrue(Integer.parseInt(idRows.get(i).getText().replaceAll("[^\\d.]", "")) < Integer.parseInt(idRows.get(i + 1).getText().replaceAll("[^\\d.]", ""))
                    , "Did not add new string values");
        }
    }

    public void allFillFieldWomen() {
        Faker faker = new Faker();
        fillEmail();
        fillName(faker);
        selectGenderWomen();
        selectOptionOne();
        selectRadioButtonOptionTwo();
        submitButton();
        submitModalWindow();
        List<SelenideElement> idRows = $$x(("//*[contains(@class,'uk-table')]//*[contains(@td,'')][2]//tr"));
        for (int i = 1; i < idRows.size(); i++) {
            if (idRows.size() - 1 == i) {
                break;
            }
            assertTrue(Integer.parseInt(idRows.get(i).getText().replaceAll("[^\\d.]", "")) < Integer.parseInt(idRows.get(i + 1).getText().replaceAll("[^\\d.]", ""))
                    , "Did not add new string values");
        }
    }

    private static void submitModalWindow() {
        $(".uk-modal-close").click();
    }

    private static void submitButton() {
        $("[id=\"dataSend\"]").click();
    }

    private static void selectRadioButtonOptionTwo() {
        $("[id=\"dataSelect21\"]").click();
    }

    private static void selectOptionOne() {
        $("[id=\"dataCheck11\"]").click();
    }

    private static void selectGenderMen() {
        Select select = new Select($("[id=\"dataGender\"]"));
        select.selectByIndex(1);
    }

    private static void selectGenderWomen() {
        Select select = new Select($("[id=\"dataGender\"]"));
        select.selectByIndex(1);
    }

    private static void fillName(Faker faker) {
        $("[id=\"dataName\"]").sendKeys(faker.name().firstName());
    }

    private static void fillEmail() {
        $("[id=\"dataEmail\"]").sendKeys("test@protei.ru");
    }
}
