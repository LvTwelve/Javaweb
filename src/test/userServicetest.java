package test;

import org.junit.Test;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class userServicetest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.regist(new User(null, "bbj168", "666666", "bbj168@qq.com"));
        userService.regist(new User(null, "abc168", "666666", "abc168@qq.com"));
    }
    @Test
    public void login() {
        System.out.println( userService.login(new User(null, "admin", "123", null)) );
    }
    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzg16888")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}
