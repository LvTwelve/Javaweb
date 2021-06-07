package servlet;

import pojo.RecordLogin;
import pojo.RecordOper;
import pojo.User;
import service.RecordLoginService;
import service.RecordOperService;
import service.impl.RecordLoginServiceImpl;
import service.impl.RecordOPerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RecordOperServlet")
public class RecordOperServlet extends BaseServlet {

    private final RecordOperService recordOperService = new RecordOPerServiceImpl();

    protected void searRecOper_all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        List<RecordOper> recordOpers_all = recordOperService.searRecOper_all();
        //设置对象
        request.setAttribute("recordsOper_all", recordOpers_all);
        //回转页面
        request.getRequestDispatcher("pages/admin/recOper_view.jsp").forward(request, response);
    }
}
