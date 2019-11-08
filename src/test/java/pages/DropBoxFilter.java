package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DropBoxFilter extends Filter {
    private static String listLocator = "//div[contains(@class, 'mat-select-content')]//mat-option";
    private static String dropListLocator = ".//div[contains(@class, 'mat-select-arrow-wrapper')]";
    private static String selectLocator = ".//span[contains(@class, 'inserted')]/span";

    public DropBoxFilter(SelenideElement filter) {
        super(filter);
    }

    public boolean setValue(String value){
        if($x(listLocator).isDisplayed())
            $$x(listLocator)
                    .findBy(text(value))
                    .click();
        else {
            filter.$x(dropListLocator).click();
            $$x(listLocator)
                    .shouldHave(sizeGreaterThan(0))
                    .findBy(text(value)).click();
        }
        return filter
                .$x(selectLocator)
                .exists();
    }

    public List<String> open(){
        if(!$x(listLocator).isDisplayed())
            filter.$x(dropListLocator).click();
        return $$x(listLocator)
                .shouldBe(sizeGreaterThan(0))
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }


}
