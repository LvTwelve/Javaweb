package service;

import pojo.Cart;
import pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<Integer,String> createOrder(Cart cart, Integer userId);

    List<Order> searOrder_id(Integer id);

    List<Order> searOrders();
}
