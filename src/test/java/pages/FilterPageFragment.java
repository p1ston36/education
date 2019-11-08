package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FilterPageFragment {
    private final String tytleLocator = "./mat-toolbar";
    private final String searchButtonLocator = ".//button[contains(@class, 'mat-raised-button')]";
    private final String filterLocator = ".//mat-form-field";
    private SelenideElement filterBoard;
    private final String filterBoardLocator = "//mat-card[contains(@class, 'filter-card')]";

    public FilterPageFragment() {
        this.filterBoard = $x(filterBoardLocator)
                            .shouldBe(visible);
    }
    public String getTytle() {
        return filterBoard
                .$x(tytleLocator)
                .getText();
    }
    public SelenideElement getFilterByName(String name) {
        return  filterBoard
                .$$x(filterLocator)
                .findBy(text(name));
    }
    public SelenideElement getSearchButton() {
        return filterBoard
                .$x(searchButtonLocator);
    }
    public void search(){
        getSearchButton().click();
    }
}
