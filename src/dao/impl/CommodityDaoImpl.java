package dao.impl;

import dao.BaseDao;
import dao.CommodityDao;
import pojo.Commodity;

import java.util.List;

public class CommodityDaoImpl extends BaseDao implements CommodityDao {
    @Override
    public int addCom(Commodity commodity) {
        String sql="insert into commodity(`name`,`price`,`business`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(sql,commodity.getName(),commodity.getPrice(),commodity.getBusiness(),commodity.getSales(),commodity.getStock(),commodity.getImgPath());
    }

    @Override
    public int delCom_id(Integer id) {
        String sql = "delete from commodity where id = ?";
        return update(sql, id);
    }

    @Override
    public Commodity searCom_id(Integer id) {
        String sql = "select `id` , `name` ,`price` , `business`,`sales` , `stock` , `img_path` from commodity where id = ?";
        return queryForBean(Commodity.class, sql,id);
    }

    @Override
    public List<Commodity> searComs() {
        String sql = "select `id` , `name` ,`price` , `business`,`sales` , `stock` , `img_path` from commodity";
        return queryForBeans(Commodity.class, sql);
    }

    @Override
    public int updCom(Commodity commodity) {
        String sql = "update commodity set `name`=?,`price`=?,`business`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql,commodity.getName(),commodity.getPrice(),commodity.getBusiness(),commodity.getSales(),commodity.getStock(),commodity.getImgPath(),commodity.getId());
    }
}
