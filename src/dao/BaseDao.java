package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public  abstract class BaseDao {

    //实现数据库的基本操作

    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * 数据更新 用于数据库的增删改
     * @return -1--更新失败 else--更新行数
     */
    public int update(String sql,Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }

        return -1;
    }

    /**
     * 查找数据库 返回一个对象
     * @return null--不存在 else--存在
     */
    public <T> T queryForBean(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    /**
     * 查找数据库 返回一组对象
     * @return null--不存在 else--存在
     */
    public <T> List<T> queryForBeans(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    /**
     * 查找数据库 返回对象值
     * @return 结果集的第一个数据
     */
    public Object queryForValue(String sql,Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    /**
     * 查找数据库 返回对象值
     * @return 返回“count”列的值
     */
    public Object queryForValues(String sql,Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ColumnListHandler("count"),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }
}
