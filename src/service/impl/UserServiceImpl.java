package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;
import pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void regist(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.searchUserByNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.searchUserByName(username) == null)
            return false;
        else
            return true;
    }

    @Override
    public User searUserName(String username) {
        return userDao.searchUserByName(username);
    }

    @Override
    public void updUserLevel(Integer level, Integer id) {
        userDao.updUserLevel(level, id);
    }

    @Override
    public void updUserPass(Integer pass, Integer id) {
        userDao.updUserPass(pass, id);
    }

    @Override
    public List<User> searSales() {
        return userDao.searSales();
    }

    @Override
    public User searUserId(Integer id) {
        return userDao.searUser_id(id);
    }
}
