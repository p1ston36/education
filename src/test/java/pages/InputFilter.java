package pages;

import com.codeborne.selenide.SelenideElement;

public class InputFilter extends Filter {
    private String inputLocator = ".//input[contains(@type, 'text')]";

    public InputFilter(SelenideElement filter) {
        super(filter);
    }


    public void setFilterValue(String value) {
        filter.$x(inputLocator).setValue(value);
    }
}
