package service;

import pojo.RecordLogin;

import java.util.List;

public interface RecordLoginService {

    void addRecLogin(RecordLogin recordLogin);

    void updRecLogin(RecordLogin recordLogin);

    int getRecLogin_id(int userId);

    List<RecordLogin> searRecLogin_all();
}
