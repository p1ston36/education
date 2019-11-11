package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ResultPage{
    private final String headerLocator = ".//mat-header-row/mat-header-cell";
    private final String resultPageLocator = "//mat-table/";
    private final String paginationLocator = "//mat-paginator";
    private SelenideElement resultPage;
    public ResultPage(){

    }

    PaginationPage pagination = new PaginationPage($x(paginationLocator));

    public List<String> getHeaders(){
        return $$x(headerLocator)
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
    }

}
