package service.impl;

import dao.RecordLoginDao;
import dao.RecordOperDao;
import dao.impl.RecordLoginDaoImpl;
import dao.impl.RecordOperDaoImpl;
import pojo.RecordLogin;
import pojo.RecordOper;
import service.RecordLoginService;
import service.RecordOperService;

import java.util.List;

public class RecordOPerServiceImpl implements RecordOperService {

    private final RecordOperDao recordOperDao = new RecordOperDaoImpl();

    @Override
    public void addRecOper(RecordOper recordOper) {
        recordOperDao.addRecOper(recordOper);
    }

    @Override
    public List<RecordOper> searRecOper_all() {
        return recordOperDao.searRecOper_all();
    }
}
