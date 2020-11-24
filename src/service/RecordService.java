package service;

import pojo.Record;

import java.util.List;

public interface RecordService {

    void addRec(Record record);

    List<Record> searRec_id(Integer id);

    List<Record> searRec_all();
}
