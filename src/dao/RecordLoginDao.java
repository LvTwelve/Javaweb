package dao;

import pojo.RecordLogin;

import java.util.List;

public interface RecordLoginDao {

    int addRecLogin(RecordLogin recordLogin);

    int updRecLogin(RecordLogin recordLogin);

    int getRecLogin_id(int userId);

    List<RecordLogin> searRecLogin_all();
}
