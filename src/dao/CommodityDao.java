package dao;

import pojo.Commodity;

import java.util.List;

public interface CommodityDao {

    int addCom(Commodity commodity);

    int delCom_id(Integer id);

    Commodity searCom_id(Integer id);

    List<Commodity> searComs();

    int updCom(Commodity commodity);


}
