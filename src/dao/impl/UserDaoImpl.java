package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import pojo.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User searchUserByName(String username) {
        String sql = "select `id`,`username`,`password`,`email`,`level` from user where username = ?";
        return queryForBean(User.class, sql, username);
    }

    @Override
    public User searchUserByNameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email`,`level` from user where username = ? and password = ?";
        return queryForBean(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public int updUserPass(Integer pass,Integer id) {
        String sql = "update user set `password`=? where id = ?";
        return update(sql, pass, id);
    }

    @Override
    public int updUserLevel(Integer level,Integer id) {
        String sql = "update user set `level`=? where id = ?";
        return update(sql, level, id);
    }

    @Override
    public List<User> searSales(){
        String sql = "select `id`,`username`,`password`,`email`,`level` from user where level = 2 ";
        return queryForBeans(User.class,sql);
    }

    @Override
    public User searUser_id(Integer id) {
        String sql = "select `id`,`username`,`password`,`email`,`level` from user where id = ? ";
        return queryForBean(User.class, sql, id);
    }
}
