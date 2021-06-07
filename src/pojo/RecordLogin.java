package pojo;

import java.sql.Timestamp;

public class RecordLogin {
    private Integer id;
    private Timestamp loginTime;
    private Timestamp logoutTime;
    private Integer userId;
    private String ip;
    private Integer level;

    public RecordLogin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public Timestamp getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Timestamp logoutTime) {
        this.logoutTime = logoutTime;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public RecordLogin(Integer id, Timestamp loginTime, Timestamp logoutTime, Integer userId, String ip, Integer level) {
        this.id = id;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.userId = userId;
        this.ip = ip;
        this.level = level;
    }

    @Override
    public String toString() {
        return "RecordLogin{" +
                "id=" + id +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", userId=" + userId +
                ", ip='" + ip + '\'' +
                ", level=" + level +
                '}';
    }
}
