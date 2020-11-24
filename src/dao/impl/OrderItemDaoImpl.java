package dao.impl;

import dao.BaseDao;
import dao.OrderItemDao;
import pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into orderitem(`name`,`count`,`price`,`totalPrice`,`orderId`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> searOrderItem(String id) {
        String sql = "select `itemId`,`name`,`count`,`price`,`totalPrice`,`orderId` from `orderitem` where orderId = ?";
        return queryForBeans(OrderItem.class,sql,id);
    }
}
