package pages;

import helper.LoginHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderPage {
    OrderFilterPage filters = new OrderFilterPage();
    private LoginHelper loginHelper = new LoginHelper();

    @BeforeEach
    public void before(){
        loginHelper.logIn();
    }

    @Test
    public void testFilter(){
        int i = 0;
        assertTrue(filters.status.setValue(filters.getStatusList().get(i)), filters.getStatusList().get(i));

    }

}
