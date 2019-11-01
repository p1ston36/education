package pages;

import java.util.ArrayList;

public class OrderFilterPage extends FilterPage {

    public DropBoxFilter status = new DropBoxFilter(getFilterByName("Статус заявки"));
    private ArrayList<String> statusList = new ArrayList<>();
    public OrderFilterPage() {
        setStatusList();
    }

    public ArrayList<String> getStatusList() {
        return statusList;
    }

    private void setStatusList() {
        statusList.add("Не обрано");
        statusList.add("Виконано");
        statusList.add("Відмова");
        statusList.add("У роботі");
    }

}
