package dao;

import pojo.Commodity;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

public interface CommodityDao {

    void addCom(Commodity commodity);

    int delCom_id(Integer id);

    Commodity searCom_id(Integer id);

    List<Commodity> searComs();

    void updCom(Commodity commodity);

    List<Integer> commendCom(Integer userId);

}
