package dao;

import pojo.Order;

import java.util.List;

public interface OrderDao {
    int saveOrder(Order order);

    List<Order> searOrder_id(Integer id);

    Order searOrder_orderId(String id);

    List<Order> searOrders();
}
