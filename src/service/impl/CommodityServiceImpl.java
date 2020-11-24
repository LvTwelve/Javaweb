package service.impl;

import dao.CommodityDao;
import dao.impl.CommodityDaoImpl;
import pojo.Commodity;
import service.CommodityService;

import java.util.List;

public class CommodityServiceImpl implements CommodityService {

    private CommodityDao commodityDao = new CommodityDaoImpl();

    @Override
    public void addCom(Commodity commodity) {
        commodityDao.addCom(commodity);
    }

    @Override
    public void delCom_id(Integer id) {
        commodityDao.delCom_id(id);
    }

    @Override
    public Commodity searCom_id(Integer id) {
        return commodityDao.searCom_id(id);
    }

    @Override
    public List<Commodity> searComs() {
        return commodityDao.searComs();
    }

    @Override
    public void updCom(Commodity commodity) {
        commodityDao.updCom(commodity);
    }
}
