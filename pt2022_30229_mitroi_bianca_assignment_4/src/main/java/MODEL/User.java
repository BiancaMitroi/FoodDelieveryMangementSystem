package MODEL;

import BLL.IDeliveryServiceProcessing;
import BLL.Order;

import java.io.Serializable;

public class User implements Serializable {
    // campurile Utilizator sunt accesibile numai in clasele din acelasi packet, iar clasele care mostenesc clasa User sunt in acelasi packet cu aceasta
    private String username;
    private String password;
    private UserType userType;
    private Integer orderCounter;

    public Integer getOrderCounter() {
        return orderCounter;
    }

    public void setOrderCounter(Integer orderCounter) {
        this.orderCounter = orderCounter;
    }

    public User(String username, String password, UserType userType, Integer orderCounter) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.orderCounter = orderCounter;
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
