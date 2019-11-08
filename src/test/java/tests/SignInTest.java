package tests;
import com.codeborne.selenide.Condition;
import pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class SignInTest {
    private LoginPage loginPage = new LoginPage();

    @BeforeEach
    public void beforeEach() {
        loginPage.logIn();
    }

    @Test
    public void testLogin() {
        assertTrue($(By.xpath("//a[text() = 'Вийти з Системи']")).shouldBe(Condition.visible).exists(), "не зашел");
    }

}
