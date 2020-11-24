package service.impl;

import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import pojo.OrderItem;
import service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public List<OrderItem> searOrderItem(String id) {

        return orderItemDao.searOrderItem(id);
    }
}
