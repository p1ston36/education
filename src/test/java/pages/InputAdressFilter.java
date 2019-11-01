package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;

public class InputAdressFilter extends Filter {
    private String inputLocator = ".//input[contains(@aria-autocomplete, 'list')]";
    private String listLocator = "//div[contains(@class,'mat-autocomplete-panel')]//span";

    public InputAdressFilter(SelenideElement filter) {
        super(filter);
    }

    public ElementsCollection getSerchResalt(String searchRequest) {
        filter.$x(inputLocator).setValue(searchRequest);
        return filter.$$x(listLocator).shouldBe(sizeGreaterThan(0));
    }

    public void setFilterValue(SelenideElement searchResult) {
        searchResult.click();
    }

}

