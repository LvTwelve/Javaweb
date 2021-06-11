package servlet;

import pojo.Cart;
import pojo.CartItem;
import pojo.Commodity;
import pojo.User;
import service.CommodityService;
import service.impl.CommodityServiceImpl;
import utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet{

    private final CommodityService commodityService = new CommodityServiceImpl();

    /**
     * 新增购物车Item
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //判断是否已登录
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }

        //获取商品信息并创建 CartItem对象
        int id = CommonUtils.phaseInt(request.getParameter("id"));
        Commodity commodity = commodityService.searCom_id(id);
        CartItem cartItem = new CartItem(commodity.getId(),commodity.getName(),1,commodity.getPrice(),commodity.getPrice());

        //Session域中设置
        Cart cart =(Cart)request.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        //重定向原页面
        //request.getRequestDispatcher("CommodityServlet?action=searComs_mall").forward(request,response);
        response.sendRedirect("CommodityServlet?action=searComs_mall");
    }

    /**
     * 删除购物车Item
     */
    protected void delItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取id及Cart值
        int id = CommonUtils.phaseInt(request.getParameter("id"));
        Cart cart =(Cart)request.getSession().getAttribute("cart");

        //购物车是否为空
        if(cart != null){
            cart.delItem(id);
            response.sendRedirect(request.getContextPath()+"/pages/user/cart.jsp");
        }
    }

    /**
     * 改变购物车Item
     */
    protected void updItem_count(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取id及Cart值
        int id = CommonUtils.phaseInt(request.getParameter("id"));
        int count = CommonUtils.phaseInt(request.getParameter("count"));
        Cart cart =(Cart)request.getSession().getAttribute("cart");

        //购物车是否为空
        if(cart != null){
            cart.updItem_count(id,count);
            response.sendRedirect(request.getContextPath()+"/pages/user/cart.jsp");
        }
    }

    /**
     * 清空购物车
     */
    protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取id及Cart值
        Cart cart =(Cart)request.getSession().getAttribute("cart");

        //购物车是否为空
        if(cart != null){
            cart.clearCart();
            response.sendRedirect(request.getContextPath()+"/pages/user/cart.jsp");
        }
    }
}
