package service.impl;

import dao.RecordDao;
import dao.RecordLoginDao;
import dao.impl.RecordDaoImpl;
import dao.impl.RecordLoginDaoImpl;
import pojo.Record;
import pojo.RecordLogin;
import service.RecordLoginService;
import service.RecordService;

import java.util.List;

public class RecordLoginServiceImpl implements RecordLoginService {

    private RecordLoginDao recordLoginDao = new RecordLoginDaoImpl();

    @Override
    public void addRecLogin(RecordLogin recordLogin) {
        recordLoginDao.addRecLogin(recordLogin);
    }

    @Override
    public void updRecLogin(RecordLogin recordLogin) {
        recordLoginDao.updRecLogin(recordLogin);
    }

    @Override
    public int getRecLogin_id(int userId) {
        return recordLoginDao.getRecLogin_id(userId);
    }

    @Override
    public List<RecordLogin> searRecLogin_all() {
        return recordLoginDao.searRecLogin_all();
    }
}
