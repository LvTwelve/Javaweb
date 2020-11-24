package test;

import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import org.junit.Test;
import pojo.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class orderItemDaotest {
    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"java", 1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"C++", 2,new BigDecimal(100),new BigDecimal(200),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"python", 1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
    }

    @Test
    public void searOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        List<OrderItem> orderItems =orderItemDao.searOrderItem("1234567890");
        System.out.println(orderItems);

    }
}
