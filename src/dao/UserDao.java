package dao;

import pojo.User;

import java.util.List;

public interface UserDao {

    /**
     * 通过 用户名 查找用户
     *
     * @return null--用户不存在 else--用户已存在
     */
    User searchUserByName(String username);

    /**
     * 通过 用户名和密码 查找用户
     *
     * @return null--用户名或密码错误 else--正确
     */
    User searchUserByNameAndPassword(String username, String password);

    /**
     * 保存用户
     *
     * @return -1--更新失败 else--更新行数
     */
    int saveUser(User user);

    int updUserLevel(Integer level, Integer id);

    int updUserPass(Integer pass, Integer id);

    List<User> searSales();

    User searUser_id(Integer id);
}
