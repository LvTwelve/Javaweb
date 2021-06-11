package pojo;

import java.sql.Timestamp;

public class Record {
    private Integer id;
    private Timestamp createTime;
    private Integer comId;
    private String comName;
    private Integer userId;

    public Record() {
    }

    public Record(Integer id, Timestamp createTime, Integer comId, String comName, Integer userId) {
        this.id = id;
        this.createTime = createTime;
        this.comId = comId;
        this.comName = comName;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", comId=" + comId +
                ", comName='" + comName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
