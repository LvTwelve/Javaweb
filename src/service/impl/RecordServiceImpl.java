package service.impl;

import dao.RecordDao;
import dao.impl.RecordDaoImpl;
import pojo.Record;
import service.RecordService;

import java.util.List;

public class RecordServiceImpl implements RecordService {

    private final RecordDao recordDao = new RecordDaoImpl();

    @Override
    public void addRec(Record record) {
        recordDao.addRec(record);
    }

    @Override
    public List<Record> searRec_id(Integer id) {
        return recordDao.searRec_id(id);
    }

    @Override
    public List<Record> searRec_all() {
        return recordDao.searRec_all();
    }
}
