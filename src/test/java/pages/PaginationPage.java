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
    private final String selectResultLocator = "//div[contains(@class,'range-label')]";
    private final String nextPageLocator = "//mat-paginator//button[contains(@class,'next')]";
    private final String previousPageLocator = "//mat-paginator//button[contains(@class,'previous')]";
    private ArrayList<String> pageSize = new ArrayList<>();
    DropBoxFilter size;
    public PaginationPage(SelenideElement pagination){
        initPageSize();
        size = new DropBoxFilter($x(sizeFilterLocator));
    }

    public ArrayList<String> getPageSize() {
        return pageSize;
    }

    private void initPageSize() {
        pageSize.add("10");
        pageSize.add("25");
        pageSize.add("50");
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
