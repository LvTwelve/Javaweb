package dao;

import pojo.User;

public interface UserDao {

    /**
     * 通过 用户名 查找用户
     * @param username
     * @return null--用户不存在 else--用户已存在
     */
    public User searchUserByName(String username);

    /**
     * 通过 用户名和密码 查找用户
     * @param username
     * @param password
     * @return null--用户名或密码错误 else--正确
     */
    public User searchUserByNameAndPassword(String username, String password);

    /**
     * 保存用户
     * @param user
     * @return
     */
    public int saveUser(User user);

}
