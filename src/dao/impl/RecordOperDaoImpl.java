package dao.impl;

import dao.BaseDao;
import dao.RecordLoginDao;
import dao.RecordOperDao;
import pojo.RecordLogin;
import pojo.RecordOper;

import java.util.List;

public class RecordOperDaoImpl extends BaseDao implements RecordOperDao {
    @Override
    public int addRecOper(RecordOper recordOper) {
        String sql = "insert into recordoper(`userId`,`ip`,`content`,`level`) values(?,?,?,?)";
        return update(sql,recordOper.getUserId(),recordOper.getIp(),recordOper.getContent(),recordOper.getLevel());
    }

    @Override
    public List<RecordOper> searRecOper_all() {
        String sql ="select `id`,`operTime`,`userId`,`ip`,`content`,`level` from recordoper";
        return queryForBeans(RecordOper.class,sql);
    }
}
