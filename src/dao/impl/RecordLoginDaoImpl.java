package dao.impl;

import dao.BaseDao;
import dao.RecordLoginDao;
import pojo.RecordLogin;

import java.util.List;

public class RecordLoginDaoImpl extends BaseDao implements RecordLoginDao {
    @Override
    public void addRecLogin(RecordLogin recordLogin) {
        String sql = "insert into recordlogin(`userId`,`ip`,`level`) values(?,?,?)";
        update(sql, recordLogin.getUserId(), recordLogin.getIp(), recordLogin.getLevel());
    }

    @Override
    public void updRecLogin(RecordLogin recordLogin) {
        String sql = "update recordlogin set `logoutTime` = current_timestamp() where id = ?";
        update(sql, recordLogin.getId());
    }

    @Override
    public int getRecLogin_id(int userId) {
        String sql ="select max(id) from recordlogin where userId = ?";
        String id_s = queryForValue(sql,userId).toString();
        return Integer.parseInt(id_s);
    }

    @Override
    public List<RecordLogin> searRecLogin_all() {
        String sql ="select `id`,`loginTime`,`logoutTime`,`userId`,`ip`,`level` from recordlogin";
        return queryForBeans(RecordLogin.class,sql);
    }
}
