package pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Order {
    private String orderId;
    private Timestamp createTime;
    private BigDecimal price;
    private Integer status = 0;     //0-未完成 1-已完成 2-售后处理中
    private Integer userId;

    public Order() {
    }

    public Order(String orderId, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public Order(String orderId, Timestamp createTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
