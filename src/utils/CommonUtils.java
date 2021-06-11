package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

public class CommonUtils {

    /**
     * 将Map中的数据注入到Bean中
     * @return Bean对象
     */
    public static <T> T MaptoBean(Map<String, String[]> map,T bean){

        try {
            BeanUtils.populate(bean,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return bean;

    }

    /**
     * 将string类型转为int
     * @return int类型数据 异常则返回0
     */
    public static int phaseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception ignored) {
        }
        return 0;
    }

    public static String timestampToString(Timestamp timestamp){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(timestamp);
    }
}
