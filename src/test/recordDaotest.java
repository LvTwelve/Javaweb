package test;

import dao.RecordDao;
import dao.impl.RecordDaoImpl;
import org.junit.Test;

public class recordDaotest {
    @Test
    public void seaRecord_id() {
        RecordDao recordDao = new RecordDaoImpl();
        System.out.println(recordDao.searRec_id(2));
    }

    @Test
    public void seaRecord_all() {
        RecordDao recordDao = new RecordDaoImpl();
        System.out.println(recordDao.searRec_all());
    }
}
