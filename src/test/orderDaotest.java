package test;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import org.junit.Test;
import pojo.Order;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;

public class orderDaotest {
    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567890",new BigDecimal(200), 0, 1));
    }

    @Test
    public void seaOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(orderDao.searOrders());
    }

    @Test
    public void seaOrder_id() {
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(orderDao.searOrder_id(2));
    }

    @Test
    public void seaOrder_orderId() {
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println(orderDao.searOrder_orderId("16060469973807"));
    }
}
