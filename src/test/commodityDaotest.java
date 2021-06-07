package test;

import dao.CommodityDao;
import dao.impl.CommodityDaoImpl;
import org.junit.Test;
import pojo.Commodity;

import java.math.BigDecimal;

public class commodityDaotest {
    private CommodityDao commodityDao = new CommodityDaoImpl();

    @Test
    public void addCom(){
        commodityDao.addCom(new Commodity(null,"java",new BigDecimal(9999),"kangkang",1,10,null));
    }
    @Test
    public void delCom(){
        commodityDao.delCom_id(2);
    }
    @Test
    public void updCom(){
        commodityDao.updCom(new Commodity(3,"C++",new BigDecimal(999),"kangkang",1,10,null));
    }
    @Test
    public void seaCom(){
        System.out.println(commodityDao.searCom_id(1));
    }

    @Test
    public void seaComs(){
        System.out.println(commodityDao.searComs());
    }

    @Test
    public void commenComs(){
        System.out.println(commodityDao.commendCom(6));
    }
}
