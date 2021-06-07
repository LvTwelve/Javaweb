package servlet;

import pojo.Commodity;
import pojo.RecordLogin;
import pojo.User;
import service.RecordLoginService;
import service.impl.RecordLoginServiceImpl;
import service.impl.UserServiceImpl;
import service.UserService;
import utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    private RecordLoginService recordLoginService = new RecordLoginServiceImpl();

    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        //创建Bean对象
        User user = CommonUtils.MaptoBean(request.getParameterMap(), new User());

        //判断用户名是否可用
        if (userService.existsUsername(user.getUsername())) {
            //用户名存在
            //回显错误信息
            request.setAttribute("msg", "用户名已存在！！");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            //返回注册页面
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        } else {
            //用户存在
            //保存数据
            userService.regist(user);
            //读取数据
            User user1 = userService.searUserName(username);
            //设置Session域值
            request.getSession().setAttribute("user", user1);
            //获取ip地址
            String ip;
            if (request.getHeader("x-forwarded-for") == null) {
                ip = request.getRemoteAddr();
            } else {
                ip = request.getHeader("x-forwarded-for");
            }
            recordLoginService.addRecLogin(new RecordLogin(null,null,null,user1.getId(),ip,user1.getLevel()));
            //跳转到个人页面
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }


    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //处理业务
        User login_user = userService.login(new User(null, username, password, null, 3));
        //判断
        if (login_user == null) {
            //用户不存在
            //回显错误信息
            request.setAttribute("msg", "账号或密码错误！");
            request.setAttribute("username", username);
            //返回登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            //用户存在
            //设置Session域值
            request.getSession().setAttribute("user", login_user);
            //获取ip地址
            String ip;
            if (request.getHeader("x-forwarded-for") == null) {
                ip = request.getRemoteAddr();
            } else {
                ip = request.getHeader("x-forwarded-for");
            }
            recordLoginService.addRecLogin(new RecordLogin(null,null,null,login_user.getId(),ip,login_user.getLevel()));
            //判断是否为管理员
            if (login_user.getLevel() == 1) {
                //跳转到管理员主页
                request.getRequestDispatcher("/pages/admin/admin.jsp").forward(request, response);
            } else if (login_user.getLevel() == 2) {
                //跳转到销售人员主页
                request.getRequestDispatcher("/pages/sales/sales.jsp").forward(request, response);
            } else {
                //跳转到商城页面
                request.getRequestDispatcher("CommodityServlet?action=searComs_mall").forward(request, response);
            }
        }
    }

    /**
     * 用户注销
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ip地址
        String ip;
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        } else {
            ip = request.getHeader("x-forwarded-for");
        }
        //获取user属性
        User user = (User) request.getSession().getAttribute("user");
        //获取登录id
        int rec_id = recordLoginService.getRecLogin_id(user.getId());
        //更新登录记录
        recordLoginService.updRecLogin(new RecordLogin(rec_id,null,null,user.getId(),ip,user.getLevel()));
        //消除Session域中user值
        request.getSession().removeAttribute("user");
        //跳转回主页
        response.sendRedirect(request.getContextPath());
    }

    protected void updUserPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        int password = CommonUtils.phaseInt(request.getParameter("password"));
        int id = CommonUtils.phaseInt(request.getParameter("id"));
        //更新对象
        userService.updUserPass(password, id);
        //回转页面
        response.sendRedirect("UserServlet?action=searSales");
    }

    protected void updUserLevel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        int level = CommonUtils.phaseInt(request.getParameter("level"));
        int id = CommonUtils.phaseInt(request.getParameter("id"));
        //更新对象
        userService.updUserLevel(level, id);
        //回转页面
        response.sendRedirect("UserServlet?action=searSales");
    }

    protected void searSale_id(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数 -- id
        int id = CommonUtils.phaseInt(request.getParameter("id"));
        //查找对象
        User sale = userService.searUserId(id);
        //保存数据到页面中
        request.setAttribute("sale", sale);
        //回转页面
        if (CommonUtils.phaseInt(request.getParameter("opt")) == 1) {
            request.getRequestDispatcher("pages/admin/sales_edit_pass.jsp").forward(request, response);
        }
        if (CommonUtils.phaseInt(request.getParameter("opt")) == 2) {
            request.getRequestDispatcher("pages/admin/sales_edit_level.jsp").forward(request, response);
        }
    }

    protected void searSales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查找所有对象
        List<User> sales = userService.searSales();
        //保存数据到页面中
        request.setAttribute("sales", sales);
        //回转页面
        request.getRequestDispatcher("pages/admin/sales_manage.jsp").forward(request, response);
    }
}
