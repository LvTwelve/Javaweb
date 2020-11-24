package test;

import org.junit.Test;
import utils.JdbcUtils;

import java.sql.Connection;

public class jdbctest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 10; i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
//        String orderId = System.currentTimeMillis()+""+"userId";
//        System.out.println(orderId);
    }
}
