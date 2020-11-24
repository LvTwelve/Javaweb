package service;

import pojo.Commodity;

import java.util.List;

public interface CommodityService {

    void addCom(Commodity commodity);

    void delCom_id(Integer id);

    Commodity searCom_id(Integer id);

    List<Commodity> searComs();

    void updCom(Commodity commodity);

}
