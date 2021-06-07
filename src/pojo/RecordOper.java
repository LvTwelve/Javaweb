package pojo;

import java.sql.Timestamp;

public class RecordOper {
    private Integer id;
    private Timestamp operTime;
    private Integer userId;
    private String ip;
    private String content;
    private Integer level;

    public RecordOper() {
    }

    public RecordOper(Integer id, Timestamp operTime, Integer userId, String ip, String content, Integer level) {
        this.id = id;
        this.operTime = operTime;
        this.userId = userId;
        this.ip = ip;
        this.content = content;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getOperTime() {
        return operTime;
    }

    public void setOperTime(Timestamp operTime) {
        this.operTime = operTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "RecordOper{" +
                "id=" + id +
                ", operTime=" + operTime +
                ", userId=" + userId +
                ", ip='" + ip + '\'' +
                ", content='" + content + '\'' +
                ", level=" + level +
                '}';
    }
}
