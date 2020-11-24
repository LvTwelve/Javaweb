package servlet;

import pojo.Commodity;
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

    protected void addCom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数
        Commodity commodity = CommonUtils.MaptoBean(req.getParameterMap(),new Commodity());
        //保存对象
        commodityService.addCom(commodity);
        //回转页面
        resp.sendRedirect("CommodityServlet?action=searComs_manage");
    }

    protected void delCom(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //获取参数 -- id
        int id = CommonUtils.phaseInt(req.getParameter("id"));
        //删除对象
        commodityService.delCom_id(id);
        //回转页面
        resp.sendRedirect("CommodityServlet?action=searComs_manage");
    }

    protected void updCom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数
        Commodity commodity =CommonUtils.MaptoBean(req.getParameterMap(),new Commodity());
        //更新对象
        commodityService.updCom(commodity);
        //回转页面
        resp.sendRedirect("CommodityServlet?action=searComs_manage");
    }

    protected void searCom_id(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取参数 -- id
        int id = CommonUtils.phaseInt(req.getParameter("id"));
        //查找对象
        //System.out.println(id);
        Commodity commodity = commodityService.searCom_id(id);
        //System.out.println(commodity);
        //保存数据到页面中
        req.setAttribute("commodity",commodity);
        //回转页面
        if(req.getParameter("com_edit").equals("true"))
        {
            req.getRequestDispatcher("pages/admin/com_edit.jsp").forward(req,resp);
        }
        req.getRequestDispatcher("pages/mall/mall.jsp").forward(req,resp);
    }

    protected void searComs_manage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //查找所有对象
        List<Commodity> commodities = commodityService.searComs();
        //保存数据到页面中
        req.setAttribute("commodities",commodities);
        //回转页面
        req.getRequestDispatcher("pages/admin/com_manage.jsp").forward(req,resp);
    }

    protected void searComs_mall(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //查找所有对象
        List<Commodity> commodities = commodityService.searComs();
        //保存数据到页面中
        req.setAttribute("commodities",commodities);
        //回转页面
        req.getRequestDispatcher("pages/mall/mall.jsp").forward(req,resp);
    }

    protected void searCom_id_det(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int comId = CommonUtils.phaseInt(req.getParameter("comId"));
        Commodity commodity = commodityService.searCom_id(comId);
        req.setAttribute("commodity",commodity);
        req.getRequestDispatcher("pages/mall/com_det.jsp").forward(req,resp);
    }
}
