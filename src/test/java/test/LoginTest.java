package test;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        loginPage.login("test@protei.ru","test");
    }

    @Test
    public void invalidEmailTest() {
        loginPage.invalidEmail("tet@protei.ru");
    }

    @Test
    public void invalidPasswordWithEmailTest() {
        loginPage.invalidPasswordWithEmail("tet@protei.ru","tes");
    }

    @Test
    public void invalidPasswordTest() {
        loginPage.invalidPassword("test@protei.ru", "tes");
    }
}
