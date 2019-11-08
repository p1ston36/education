package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class PaginationPage {
    private final String sizeFilterLocator = "//mat-paginator//mat-form-field";
    private final String resultLocator = "//div[contains(@class,'range-label')]";
    private final String nextPageLocator = "//mat-paginator//button[contains(@class,'next')]";
    private final String previousPageLocator = "//mat-paginator//button[contains(@class,'previous')]";
    private int[] pageSize = {10, 25, 50};
    DropBoxFilter size;
    public PaginationPage(SelenideElement pagination){
        size = new DropBoxFilter($x(sizeFilterLocator));
    }

    PaginationValue values = PaginationValue.parse($x(resultLocator).getText());

    public int[] getPageSize() {
        return pageSize;
    }

    public boolean nextPage(){
        if($x(nextPageLocator).isEnabled()) {
            $x(nextPageLocator).click();
        return true;}
        else return false;
    }
    public boolean previousPage(){
        if($x(previousPageLocator).isEnabled()) {
            $x(previousPageLocator).click();
        return true;}
        else return false;
    }

}
