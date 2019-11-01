package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public abstract class Filter {
    private final String nameLocator = ".//label";
    protected SelenideElement filter;

    public Filter(SelenideElement filter) {
        this.filter = filter;
    }

    public String getName(SelenideElement filter) {
        return filter
                .$x(nameLocator)
                .shouldBe(visible)
                .getText();
    }

}
