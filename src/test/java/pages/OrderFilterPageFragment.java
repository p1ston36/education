package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderFilterPageFragment extends FilterPageFragment {

    public DropBoxFilter status = new DropBoxFilter(getFilterByName("Статус заявки"));
//    private List<String> statusList = status.open();
    public OrderFilterPageFragment(){
    }

//    public List<String> getStatusList() {
//        return statusList;
//    }


}
