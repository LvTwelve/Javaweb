package dao.impl;

import dao.BaseDao;
import dao.OrderDao;
import pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into `order`(`orderId`,`price`,`status`,`userId`) values(?,?,?,?)";
        return update(sql,order.getOrderId(),order.getPrice(),order.getStatus(),order.getUserId());

    }

    @Override
    public List<Order> searOrder_id(Integer id) {
        String sql = "select `orderId`,`createTime`,`price`,`status`,`userId` from `order` where userId = ?";
        return queryForBeans(Order.class,sql,id);
    }

    @Override
    public Order searOrder_orderId(String id) {
        String sql = "select `orderId`,`createTime`,`price`,`status`,`userId` from `order` where orderId = ?";
        return queryForBean(Order.class,sql,id);
    }

    @Override
    public List<Order> searOrders() {
        String sql = "select `orderId`,`createTime`,`price`,`status`,`userId` from `order`";
        return queryForBeans(Order.class,sql);
    }
}
