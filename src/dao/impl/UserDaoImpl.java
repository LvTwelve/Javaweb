package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import org.junit.Test;
import pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User searchUserByName(String username) {
        String sql = "select `id`,`username`,`password`,`email` from user where username = ?";
        return queryForBean(User.class, sql, username);
    }

    @Override
    public User searchUserByNameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from user where username = ? and password = ?";
        return queryForBean(User.class, sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getEmail());
    }
}
