package pages;

import org.openqa.selenium.By;


import java.util.Collections;
import java.util.List;

public class OrderPage {
    private OrderFilterPageFragment orderFilterPageFragment = new OrderFilterPageFragment();
    private List<String> statusFilterDropList;
    private By searchButton;
    private By orderList;

    public List<String> getAvailableStatuses() {
        return Collections.emptyList();
    }

    public OrderPage openStatusFilter(){
        this.statusFilterDropList =  orderFilterPageFragment.status.open();
        return this;
    }
    public OrderPage setStatus(String status) {
        orderFilterPageFragment.status.setValue(status);
        return this;
    }

    public OrderPage search() {
        orderFilterPageFragment.search();
        return this;
    }

    public List<?> getOrders() {

        return Collections.emptyList();
    }

    public List<String> getStatusFilterDroplist() {
        return statusFilterDropList;
    }
}
