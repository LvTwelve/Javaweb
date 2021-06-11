package test;

import org.junit.Test;
import pojo.Commodity;
import service.CommodityService;
import service.impl.CommodityServiceImpl;

import java.math.BigDecimal;

public class CommodityServicetest {
    private final CommodityService commodityService = new CommodityServiceImpl();

    @Test
    public void addCom(){
        commodityService.addCom(new Commodity(null,"matlab",new BigDecimal(9),"kangkang",10,10,null));
    }
    @Test
    public void delCom(){
        commodityService.delCom_id(2);
    }
    @Test
    public void updCom(){
        commodityService.updCom(new Commodity(4,"matlab",new BigDecimal(99),"kangkang",11,10,null));
    }
    @Test
    public void seaCom(){
        System.out.println(commodityService.searCom_id(4));
    }

    @Test
    public void seaComs(){
        System.out.println(commodityService.searComs());
    }

    @Test
    public void commenComs(){

    }
}
