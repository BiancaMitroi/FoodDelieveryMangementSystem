package BLL;

import MODEL.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Order implements Serializable {
    private Integer id;
    private LocalDateTime date;
    private User user;
    private Integer orderPrice;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setClientUsername(User clientUsername) {
        this.user = clientUsername;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(Integer id, User user, Integer orderPrice){
        this.id = id;
        this.date = LocalDateTime.now();
        this.user = user;
        this.orderPrice = orderPrice;
    }
    public Integer getId(){
        return this.id;
    }
    public LocalDateTime getDate(){
        return this.date;
    }
    public User getClientUsername(){
        return this.user;
    }
    @Override
    public int hashCode(){
        return this.date.hashCode() + this.id;
    }
}
