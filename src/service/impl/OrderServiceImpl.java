package service.impl;

import dao.CommodityDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.CommodityDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import pojo.*;
import service.OrderService;
import utils.CommonUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private CommodityDao commodityDao = new CommodityDaoImpl();

    @Override
    public Map<Integer,String> createOrder(Cart cart, Integer userId) {
        Map <Integer,String> map=new HashMap<>();

        //判断库存是否充足
        for (Map.Entry<Integer, CartItem>entry : cart.getItemMap().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();

            //获取对象
            Commodity commodity = commodityDao.searCom_id(cartItem.getId());
            if(commodity.getStock()<cartItem.getCount()){
                String tip = cartItem.getName();
                map.put(-1,tip);
                return map;
            }
        }

        //利用时间+id生成唯一订单号
        String orderId = System.currentTimeMillis()+""+userId;

        Order order = new Order(orderId,cart.getTotalPrice(),0,userId);

        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem>entry : cart.getItemMap().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();

            //获取对象
            Commodity commodity = commodityDao.searCom_id(cartItem.getId());

            //保存订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);

            //更新商品数据

            commodity.setSales(commodity.getSales()+cartItem.getCount());
            commodity.setStock(commodity.getStock()-cartItem.getCount());
            commodityDao.updCom(commodity);
        }

        Order order1 = orderDao.searOrder_orderId(orderId);
        cart.clearCart();
        map.put(0,orderId);
        map.put(1, CommonUtils.timestampToString(order1.getCreateTime()));
        return map;
    }

    @Override
    public List<Order> searOrder_id(Integer id) {
        return orderDao.searOrder_id(id);
    }

    @Override
    public List<Order> searOrders() {
        return orderDao.searOrders();
    }
}
