package servlet;

import pojo.Order;
import pojo.OrderItem;
import service.OrderItemService;
import service.impl.OrderItemServiceImpl;
import utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OrderItemServlet")
public class OrderItemServlet extends BaseServlet{
    private OrderItemService orderItemService = new OrderItemServiceImpl();

    protected void searOrderItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数 -- id
        String id = request.getParameter("id");
        //查找对象
        List<OrderItem> orderItems = orderItemService.searOrderItem(id);
        //保存数据到页面中
        request.setAttribute("orderItems",orderItems);
        //回转页面
        request.getRequestDispatcher("pages/user/order_det.jsp").forward(request,response);
    }
}
