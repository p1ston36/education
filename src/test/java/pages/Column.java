package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

public class Column {
    private final String rowLocator = "./mat-row";
    private final String rowContentLocator = "./mat-cell";
    private final String headerLocator = ".//mat-header-row/mat-header-cell";
    private String title;
    private SelenideElement table;
    private int titleNumber = getColumnNumber();

    public Column from(SelenideElement table, String title){
        this.title = title;
        this.table = table;
        return this;
    }

    private Column(){
    }

    public List<SelenideElement> getColumn() {
        List<SelenideElement> rows = table
                .$$(rowLocator)
                .stream()
                .collect(Collectors.toList());
        List<SelenideElement> column = rows.stream()
                .map(el -> el.$$x(rowContentLocator).get(titleNumber))
                .collect(Collectors.toList());

        return column;
    }

private int getColumnNumber(){
        return table.$$x(headerLocator)
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList())
                .indexOf(title);
}


}
