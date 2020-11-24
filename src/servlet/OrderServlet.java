package servlet;

import pojo.Cart;
import pojo.Order;
import pojo.User;
import service.CommodityService;
import service.EmailService;
import service.OrderService;
import service.impl.CommodityServiceImpl;
import service.impl.EmailServiceImpl;
import service.impl.OrderServiceImpl;
import utils.CommonUtils;

import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();
    private EmailService emailService = new EmailServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AddressException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");

        //生成订单 判断库存是否充足
        Map<Integer,String> map = orderService.createOrder(cart,user.getId());
        Set<Integer> set = map.keySet();
        if(map.get(-1)!=null){
            request.setAttribute("itemName",map.get(-1));
            request.getRequestDispatcher("pages/user/settlement.jsp").forward(request,response);
        }
        else {
            request.setAttribute("orderId",map.get(0));
            emailService.SendEmail(user.getEmail(),map.get(0),map.get(1));
            request.getRequestDispatcher("pages/user/settlement.jsp").forward(request,response);
        }
    }

    protected void searOrder_id(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取参数 -- id
        User user = (User) req.getSession().getAttribute("user");
        //System.out.println(user.getId());
        List<Order> orders = orderService.searOrder_id(user.getId());
        //保存数据到页面中
        req.setAttribute("order_id",orders);
        //回转页面
        req.getRequestDispatcher("pages/user/order.jsp").forward(req,resp);
    }

    protected void searOrders(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //查找所有对象
        List<Order> orders = orderService.searOrders();
        //保存数据到页面中
        req.setAttribute("order_all",orders);
        //回转页面
        req.getRequestDispatcher("pages/admin/order_all.jsp").forward(req,resp);
    }
}
