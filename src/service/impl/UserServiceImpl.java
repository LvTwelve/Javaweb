package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;
import pojo.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void regist(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.searchUserByNameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.searchUserByName(username) == null)
            return false;
        else
            return true;
    }

    @Override
    public User searUserName(String username) {
        return userDao.searchUserByName(username);
    }
}
