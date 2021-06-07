package servlet;

import pojo.Commodity;
import pojo.RecordOper;
import pojo.User;
import service.CommodityService;
import service.RecordOperService;
import service.impl.CommodityServiceImpl;
import service.impl.RecordOPerServiceImpl;
import utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CommodityServlet")
public class CommodityServlet extends BaseServlet {

    private final CommodityService commodityService = new CommodityServiceImpl();
    private final RecordOperService recordOperService = new RecordOPerServiceImpl();

    protected void addCom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数
        Commodity commodity = CommonUtils.MaptoBean(request.getParameterMap(), new Commodity());
        //保存对象
        commodityService.addCom(commodity);
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
        recordOperService.addRecOper(new RecordOper(null,null,user.getId(),ip,"addCom",user.getLevel()));
        //回转页面
        response.sendRedirect("CommodityServlet?action=searComs_manage");
    }

    protected void delCom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数 -- id
        int id = CommonUtils.phaseInt(request.getParameter("id"));
        //删除对象
        commodityService.delCom_id(id);
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
        recordOperService.addRecOper(new RecordOper(null,null,user.getId(),ip,"delCom",user.getLevel()));
        //回转页面
        response.sendRedirect("CommodityServlet?action=searComs_manage");
    }

    protected void updCom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数
        Commodity commodity = CommonUtils.MaptoBean(request.getParameterMap(), new Commodity());
        //更新对象
        commodityService.updCom(commodity);
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
        recordOperService.addRecOper(new RecordOper(null,null,user.getId(),ip,"updCom",user.getLevel()));
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
            if (user.getLevel() == 1) {
                request.getRequestDispatcher("pages/basic/com_edit.jsp").forward(request, response);
            }
            //销售人员管理
            if (user.getLevel() == 2) {
                request.getRequestDispatcher("pages/basic/com_edit.jsp").forward(request, response);
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
        //操作日志记录
        //获取ip地址
        String ip;
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        } else {
            ip = request.getHeader("x-forwarded-for");
        }
        //获取user属性
        recordOperService.addRecOper(new RecordOper(null,null,user.getId(),ip,"searCom_manage",user.getLevel()));
        //管理员跳转
        if (user.getLevel() == 1) {
            request.getRequestDispatcher("pages/admin/com_manage.jsp").forward(request, response);
        }
        //销售人员跳转
        if (user.getLevel() == 2) {
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

    protected void commenComs(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //获取用户信息
        User user = (User) request.getSession().getAttribute("user");
        //System.out.println(user);
        //查找所有对象
        List<Commodity> commodities_all = commodityService.searComs();
        //System.out.println(commodities_all);
        //获取商品id
        List<Integer> comids = commodityService.commenCom(user.getId());
        //System.out.println(comids);
        //根据商品id获取商品信息
        List<Commodity> commodities = new ArrayList<>();
        for(int i = 0;i<comids.size();i++){
            commodities.add(commodityService.searCom_id(comids.get(i)));
        }
        System.out.println(commodities);
        while(commodities.size()<3){
            int i = (int)(Math.random() * (commodities_all.size()-6+1) + 6);
            commodities.add(commodityService.searCom_id(i));
        }
        System.out.println(commodities);
        //保存数据到页面中
        request.setAttribute("commodities", commodities);
        //回转页面
        request.getRequestDispatcher("pages/user/commen_com.jsp").forward(request, response);
    }
}
