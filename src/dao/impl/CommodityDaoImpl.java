package dao.impl;

import dao.BaseDao;
import dao.CommodityDao;
import pojo.Commodity;

import java.util.ArrayList;
import java.util.List;

public class CommodityDaoImpl extends BaseDao implements CommodityDao {
    @Override
    public void addCom(Commodity commodity) {
        String sql="insert into commodity(`name`,`price`,`business`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        update(sql, commodity.getName(), commodity.getPrice(), commodity.getBusiness(), commodity.getSales(), commodity.getStock(), commodity.getImgPath());
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
    public void updCom(Commodity commodity) {
        String sql = "update commodity set `name`=?,`price`=?,`business`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        update(sql, commodity.getName(), commodity.getPrice(), commodity.getBusiness(), commodity.getSales(), commodity.getStock(), commodity.getImgPath(), commodity.getId());
    }

    @Override
    public List<Integer> commendCom(Integer userId) {
        @SuppressWarnings("all")
        String sql1 = "SELECT DISTINCT count( * ) AS count  FROM recordsear  where userId = ? GROUP BY comId  ORDER BY count DESC  LIMIT 3";
        List<Integer> result1 = (List<Integer>) queryForValues(sql1,userId);
        List<Integer> result2 = new ArrayList<>();
        for(int i = 0 ;i<result1.size();i++){
            String sql2 ="select `comId` from recordsear group by comName having count(*) = ?";
            Integer comId = (Integer) queryForValue(sql2,result1.get(i));
            result2.add(comId);
        }
        return result2;
    }


}
