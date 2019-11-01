package helper;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.UserData;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class LoginHelper {

    private static final String URL = "http://vrs2019.cloud.internal.egp.com.ua/login";
    private static String  successSignInLocator = "//a[text() = 'Вийти з Системи']";

    public static boolean logIn() {
        UserData user = new UserData();
        Selenide.open(URL);
        $(By.xpath("//span[text() = 'Увійти']")).click();
        $(By.xpath("//a[@class='auth__social-link']/i")).click();
        logInByEDS(user.getUserAcsk(), user.getPathKey(), user.getPass());
        return $x(successSignInLocator).exists();
    }

    public static boolean logIn(UserData user) {
        Selenide.open(URL);
        $(By.xpath("//span[text() = 'Увійти']")).click();
        $(By.xpath("//a[@class='auth__social-link']/i")).click();
        logInByEDS(user.getUserAcsk(), user.getPathKey(), user.getPass());
        return $x(successSignInLocator).exists();
    }

    private static void logInByEDS(String acsk, String pathToKey, String password) {
        $(By.xpath("//select")).click();
        $$(By.xpath("//select/option")).findBy(Condition.text(acsk)).click();
        $(By.xpath("//file-upload//input[@type='file']")).uploadFile(new File(pathToKey));
        $(By.xpath("//input[@type='password']")).setValue(password);
        $(By.xpath("//button[text()=' Перевірити ']")).click();
    }

}
