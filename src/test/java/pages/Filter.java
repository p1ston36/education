package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public abstract class Filter {
    private final String nameLocator = ".//label";
    private String columnName;
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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
