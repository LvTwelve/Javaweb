package dao;

import pojo.Order;
import pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);

    List<OrderItem> searOrderItem(String id);
}
