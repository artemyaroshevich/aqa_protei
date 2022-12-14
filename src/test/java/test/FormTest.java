package test;

import org.testng.annotations.Test;

public class FormTest extends BaseTest {


    @Test
    public void fillFieldMenFormTest() {
        loginPage.login("test@protei.ru","test");
        formPage.allFillFieldMen();
    }

    @Test
    public void fillFieldWomenFormTest() {
        loginPage.login("test@protei.ru","test");
        formPage.allFillFieldWomen();
    }

}
