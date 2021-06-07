package test;

import dao.BaseDao;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;

public class userDaotest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.searchUserByName("user") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.searchUserByNameAndPassword("user", "1234") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "user", "1234", "user@1234.com", 3)));
    }

    @Test
    public void updUserLevel() {
        Integer id = 3;
        Integer level = 3;
        System.out.println(userDao.updUserLevel(level, id));
    }

    @Test
    public void updUserPass() {
        Integer id = 3;
        Integer pass = 3;
        System.out.println(userDao.updUserPass(pass, id));
    }

    @Test
    public void searSales() {
        System.out.println(userDao.searSales());
    }

    @Test
    public void searUser_id() {
        Integer id = 5;
        System.out.println(userDao.searUser_id(id));
    }

    @Test
    public void commenComT() {
        Integer id = 5;
    }
}
