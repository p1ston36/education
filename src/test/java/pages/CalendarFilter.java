package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

public class CalendarFilter extends Filter {
    private String inputLocator = ".//mat-form-field//button";
    private String dateListLocator = ".//tbody//div";
    private String clearLocator = ".//button[contains(@aria-label, 'Clear')]";

    public CalendarFilter(SelenideElement filter) {
        super(filter);
    }

    public ElementsCollection getDayList() {
        filter.$x(inputLocator).click();
        return $$x(dateListLocator).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    public void selectDate(SelenideElement date) {
        date.click();
    }

    public boolean isDateSelect() {
        return filter.$x(clearLocator).isDisplayed();
    }

    public boolean clearDate() {
        if (isDateSelect()) {
            filter.$x(clearLocator).click();
            return true;
        } else return false;
    }
}
