package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DropBoxFilter extends Filter {
    private static String listLocator = "//div[contains(@class, 'mat-select-content')]//mat-option";
    private static String inputLocator = ".//div[contains(@class, 'mat-select-arrow-wrapper')]";
    private static String selectLocator = ".//span[contains(@class, 'inserted')]/span";

    public DropBoxFilter(SelenideElement filter) {
        super(filter);
    }


//    private List<String> getValueList() {
//        filter.$x(clickLocator).click();
//        return $$x(listLocator).shouldBe(CollectionCondition.sizeGreaterThan(0))
//                .stream()
//                .map(SelenideElement::getText)
//                .collect(Collectors.toList());
//    }

    public boolean setValue(String value){
        filter.$x(inputLocator).click();
        $$x(listLocator).shouldBe(CollectionCondition.sizeGreaterThan(0))
                .find(text(value)).click();
        return filter
                .$x(selectLocator)
                .exists();
    }

}
