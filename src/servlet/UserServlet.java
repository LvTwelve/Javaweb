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
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        //创建Bean对象
        User user = CommonUtils.MaptoBean(req.getParameterMap(), new User());

        //判断用户名是否可用
        if(userService.existsUsername(user.getUsername())){
            //用户名存在
            //回显错误信息
            req.setAttribute("msg", "用户名已存在！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            //返回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
        else {
            //用户存在
            //保存数据
            userService.regist(user);
            //读取数据
            User user1 =userService.searUserName(username);
            //设置Session域值
            req.getSession().setAttribute("user",user1);
            //跳转到个人页面
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }


    }

    /**
     * 用户登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //处理业务
        User login_user = userService.login(new User(null,username,password,null));

        //判断
        if(login_user == null){
            //用户不存在
            //回显错误信息
            req.setAttribute("msg", "账号或密码错误！");
            req.setAttribute("username", username);
            //返回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
        else {
            //用户存在
            //设置Session域值
            req.getSession().setAttribute("user",login_user);

            //判断是否为管理员
            //TODO 后续创建相应数据库及登录页面
            if(login_user.getId()==1){
                //跳转到管理员主页
                req.getRequestDispatcher("/pages/admin/admin.jsp").forward(req,resp);
            }
            else {
                //跳转到商城页面
                req.getRequestDispatcher("CommodityServlet?action=searComs_mall").forward(req,resp);
            }

        }
    }

    /**
     * 用户注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //消除Session域中user值
        req.getSession().removeAttribute("user");
        //跳转回主页
        resp.sendRedirect(req.getContextPath());
        //req.getRequestDispatcher("/pages/mall/mall.jsp").forward(req,resp);
    }

}
