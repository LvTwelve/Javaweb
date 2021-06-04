package servlet;

import pojo.User;
import service.impl.UserServiceImpl;
import service.UserService;
import utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

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
        User login_user = userService.login(new User(null, username, password, null));

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

            //判断是否为管理员
            //TODO 后续创建相应数据库及登录页面
            if (login_user.getId() == 1) {
                //跳转到管理员主页
                request.getRequestDispatcher("/pages/admin/admin.jsp").forward(request, response);
            } else if(login_user.getId() == 2){
                //跳转到销售人员主页
                request.getRequestDispatcher("/pages/sales/sales.jsp").forward(request, response);
            }
            else {
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
        //消除Session域中user值
        request.getSession().removeAttribute("user");
        //跳转回主页
        response.sendRedirect(request.getContextPath());
    }

}
