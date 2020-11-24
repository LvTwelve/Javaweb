package dao.impl;

import dao.BaseDao;
import dao.RecordDao;
import pojo.Record;

import java.util.List;

public class RecordDaoImpl extends BaseDao implements RecordDao {
    @Override
    public int addRec(Record record) {
        String sql = "insert into recordsear(`comId`,`comName`,`userId`) values(?,?,?)";
        return update(sql,record.getComId(),record.getComName(),record.getUserId());
    }

    @Override
    public List<Record> searRec_id(Integer id) {
        String sql ="select `id`,`createTime`,`comId`,`comName`,`userId` from recordsear where userId = ?";
        return queryForBeans(Record.class,sql,id);
    }

    @Override
    public List<Record> searRec_all() {
        String sql ="select `id`,`createTime`,`comId`,`comName`,`userId` from recordsear";
        return queryForBeans(Record.class,sql);
    }
}
