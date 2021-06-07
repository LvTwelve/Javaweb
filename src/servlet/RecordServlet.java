package servlet;

import pojo.Record;
import pojo.RecordOper;
import pojo.User;
import service.RecordOperService;
import service.RecordService;
import service.impl.RecordOPerServiceImpl;
import service.impl.RecordServiceImpl;
import utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RecordServlet")
public class RecordServlet extends BaseServlet {

    private final RecordService recordService = new RecordServiceImpl();
    private final RecordOperService recordOperService =new RecordOPerServiceImpl();

    protected void addRec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //判断是否已登录
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("CommodityServlet?action=searCom_id_det").forward(request, response);
        } else {
            int comId = CommonUtils.phaseInt(request.getParameter("comId"));
            String comName = request.getParameter("comName");
            Record record = new Record(null, null, comId, comName, user.getId());

            recordService.addRec(record);

            request.getRequestDispatcher("CommodityServlet?action=searCom_id_det").forward(request, response);
        }
    }

    protected void searRec_id(HttpServletRequest request, HttpServletResponse response) {
        int searRec_user_id = CommonUtils.phaseInt(request.getParameter("searRec_user_id"));
        List<Record> records_id = recordService.searRec_id(searRec_user_id);
        request.setAttribute("records_id", records_id);
    }

    protected void searRec_all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Record> records_all = recordService.searRec_all();
        request.setAttribute("records_all", records_all);
        User user = (User) request.getSession().getAttribute("user");
        //操作日志记录
        //获取ip地址
        String ip;
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        } else {
            ip = request.getHeader("x-forwarded-for");
        }
        //获取user属性
        recordOperService.addRecOper(new RecordOper(null,null,user.getId(),ip,"searRec_all",user.getLevel()));
        //管理员跳转
        if (user.getLevel() == 1) {
            request.getRequestDispatcher("pages/admin/rec_view.jsp").forward(request, response);
        }
        //销售人员跳转
        if (user.getLevel() == 2) {
            request.getRequestDispatcher("pages/sales/rec_view.jsp").forward(request, response);
        }
    }
}
