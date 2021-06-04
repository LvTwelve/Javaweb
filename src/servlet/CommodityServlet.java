package servlet;

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
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/CommodityServlet")
public class CommodityServlet extends BaseServlet {

    private CommodityService commodityService = new CommodityServiceImpl();

    protected void addCom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数
        Commodity commodity = CommonUtils.MaptoBean(request.getParameterMap(), new Commodity());
        //保存对象
        commodityService.addCom(commodity);
        //回转页面
        response.sendRedirect("CommodityServlet?action=searComs_manage");
    }

    protected void delCom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数 -- id
        int id = CommonUtils.phaseInt(request.getParameter("id"));
        //删除对象
        commodityService.delCom_id(id);
        //回转页面
        response.sendRedirect("CommodityServlet?action=searComs_manage");
    }

    protected void updCom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数
        Commodity commodity = CommonUtils.MaptoBean(request.getParameterMap(), new Commodity());
        //更新对象
        commodityService.updCom(commodity);
        //回转页面
        response.sendRedirect("CommodityServlet?action=searComs_manage");
    }

    protected void searCom_id(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //获取参数 -- id
        int id = CommonUtils.phaseInt(request.getParameter("id"));
        //查找对象
        //System.out.println(id);
        Commodity commodity = commodityService.searCom_id(id);
        //System.out.println(commodity);
        //保存数据到页面中
        request.setAttribute("commodity", commodity);
        //回转页面
        if (request.getParameter("com_edit").equals("true")) {
            User user = (User) request.getSession().getAttribute("user");
            //管理员跳转
            if (user.getId() == 1) {
                request.getRequestDispatcher("pages/basic/com_edit.jsp").forward(request, response);
            }
            //销售人员管理
            if (user.getId() == 2) {
                request.getRequestDispatcher("pages/basic/com_manage.jsp").forward(request, response);
            }

        } else {
            request.getRequestDispatcher("pages/mall/mall.jsp").forward(request, response);
        }

    }

    protected void searComs_manage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //查找所有对象
        List<Commodity> commodities = commodityService.searComs();
        //保存数据到页面中
        request.setAttribute("commodities", commodities);
        //回转页面
        User user = (User) request.getSession().getAttribute("user");
        //管理员跳转
        if (user.getId() == 1) {
            request.getRequestDispatcher("pages/admin/com_manage.jsp").forward(request, response);
        }
        //销售人员跳转
        if (user.getId() == 2) {
            request.getRequestDispatcher("pages/sales/com_manage.jsp").forward(request, response);
        }
    }

    protected void searComs_mall(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //查找所有对象
        List<Commodity> commodities = commodityService.searComs();
        //保存数据到页面中
        request.setAttribute("commodities", commodities);
        //回转页面
        request.getRequestDispatcher("pages/mall/mall.jsp").forward(request, response);
    }

    protected void searCom_id_det(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int comId = CommonUtils.phaseInt(request.getParameter("comId"));
        Commodity commodity = commodityService.searCom_id(comId);
        request.setAttribute("commodity", commodity);
        request.getRequestDispatcher("pages/mall/com_det.jsp").forward(request, response);
    }
}
