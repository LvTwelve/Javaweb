package dao;

import pojo.Record;

import java.util.List;

public interface RecordDao {

    int addRec(Record record);

    List<Record> searRec_id(Integer id);

    List<Record> searRec_all();
}
