package service;

import pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    void regist(User user);

    /**
     * 登录
     * @param user
     * @return null--登录失败 esle--登录成功
     */
    User login(User user);

    /**
     * 用户名检查
     * @param username
     * @return true--用户名已存在 false--用户名不存在 可用
     */
    boolean existsUsername(String username);

    User searUserName(String username);
}
