package pages;

import helper.LoginHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderPage {

    private LoginHelper loginHelper = new LoginHelper();

    @BeforeEach
    public void before(){
        loginHelper.logIn();
    }

    @Test
    public void testStatusFilter(){
        OrderFilterPage filters = new OrderFilterPage();
        int i = new Random().nextInt(3);
        filters.status.setValue(filters.getStatusList().get(i));

    }

}
