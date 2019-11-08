package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$x;

public class ResultRow {

    private final static String rowContentLocator = "./mat-cell";
    private final String viewButtonLocator = ".//button[contains(@class, 'primary')]";
    private final String deleteButtonLocator = ".//button[contains(@class, 'warn')]";

    public static List<String> from(SelenideElement row){
        List<String> content =  row.$$x(rowContentLocator)
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
        return content.subList(0, content.size()-2);
    }
    public void clickViewButton(ResultRow row){
        row.getViewButton().click();
    }
    public void clickRemoveButton(ResultRow row){
        row.getRemoveButton().click();
    }

    private SelenideElement getRemoveButton() {
        return $x(deleteButtonLocator);
    }

    private SelenideElement getViewButton() {
        return $x(viewButtonLocator);
    }


}
