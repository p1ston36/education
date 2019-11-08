package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.UserData;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final String URL = "http://vrs2019.cloud.internal.egp.com.ua/login";
    private static String  successSignInLocator = "//a[text() = 'Вийти з Системи']";
    private By logInButton = By.xpath("//span[text() = 'Увійти']");
    private By authSocialLink = By.xpath("//a[@class='auth__social-link']/i");

    public void logIn() {
        logIn(new UserData());
    }

    public void logIn(UserData user) {
        Selenide.open(URL);
        $(logInButton).click();
        $(authSocialLink).click();
        logInByEDS(user.getUserAcsk(), user.getPathKey(), user.getPass());
        Selenide.Wait()
                .withTimeout(Duration.ofSeconds(15))
                .until(w -> $x(successSignInLocator).exists());
    }

    private void logInByEDS(String acsk, String pathToKey, String password) {
        $(By.xpath("//select")).click();
        $$(By.xpath("//select/option")).findBy(Condition.text(acsk)).click();
        $(By.xpath("//file-upload//input[@type='file']")).uploadFile(new File(pathToKey));
        $(By.xpath("//input[@type='password']")).setValue(password);
        $(By.xpath("//button[text()=' Перевірити ']")).click();
    }

}
