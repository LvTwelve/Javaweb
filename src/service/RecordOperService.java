package service;

import pojo.RecordOper;

import java.util.List;

public interface RecordOperService {

    void addRecOper(RecordOper recordOper);

    List<RecordOper> searRecOper_all();
}
