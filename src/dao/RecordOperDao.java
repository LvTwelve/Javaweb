package dao;

import pojo.RecordLogin;
import pojo.RecordOper;

import java.util.List;

public interface RecordOperDao {

    int addRecOper(RecordOper recordOper);

    List<RecordOper> searRecOper_all();
}
