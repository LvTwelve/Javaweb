package service;

import pojo.Commodity;
import pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 注册用户
     */
    void regist(User user);

    /**
     * 登录
     * @return null--登录失败 esle--登录成功
     */
    User login(User user);

    /**
     * 用户名检查
     * @return true--用户名已存在 false--用户名不存在 可用
     */
    boolean existsUsername(String username);

    User searUserName(String username);

    void updUserLevel(Integer level,Integer id);

    void updUserPass(Integer pass,Integer id);

    User searUserId(Integer id);

    List<User> searSales();

}
