package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.OrderPage;

import java.util.List;

public class OrderPageTest {

    private LoginPage loginPage = new LoginPage();
    private OrderPage orderPage = new OrderPage();

    @BeforeEach
    public void before(){
        loginPage.logIn();
    }

    @Test
    public void testStatusFilter(){
        List<?> orders = orderPage.setStatus("У роботі")
                .search()
                .getOrders();

    }

}
