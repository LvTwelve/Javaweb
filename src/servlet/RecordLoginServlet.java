package servlet;

import pojo.Record;
import pojo.RecordLogin;
import pojo.RecordOper;
import pojo.User;
import service.RecordLoginService;
import service.RecordOperService;
import service.RecordService;
import service.impl.RecordLoginServiceImpl;
import service.impl.RecordOPerServiceImpl;
import service.impl.RecordServiceImpl;
import utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RecordLoginServlet")
public class RecordLoginServlet extends BaseServlet {

    private final RecordLoginService recordLoginService = new RecordLoginServiceImpl();
    private final RecordOperService recordOperService = new RecordOPerServiceImpl();

    protected void searRecLogin_all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RecordLogin> recordLogins_all = recordLoginService.searRecLogin_all();
        request.setAttribute("recordsLogin_all", recordLogins_all);
        //操作日志记录
        //获取ip地址
        String ip;
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        } else {
            ip = request.getHeader("x-forwarded-for");
        }
        //获取user属性
        User user = (User) request.getSession().getAttribute("user");
        recordOperService.addRecOper(new RecordOper(null,null,user.getId(),ip,"searRecLogin_all",user.getLevel()));
        //回转页面
        request.getRequestDispatcher("pages/admin/recLogin_view.jsp").forward(request, response);
    }
}
