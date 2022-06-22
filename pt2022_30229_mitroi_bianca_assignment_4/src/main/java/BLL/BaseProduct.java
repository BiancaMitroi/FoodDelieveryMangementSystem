package BLL;

import java.io.Serializable;

public class BaseProduct extends MenuItem {
    public BaseProduct(String title, Double rating, Integer calories, Integer protein, Integer fat, Integer sodium, Integer price, Integer orderCounter) {
        super(title, rating, calories, protein, fat, sodium, price, orderCounter);
    }

    @Override
    public int compareTo(MenuItem o) {
        return this.title.compareTo(o.getTitle());
    }

    public String toString(){
        return this.title + ' ' + this.rating + ' ' + this.calories + ' ' + this.protein + ' ' + this.fat + ' ' + this.sodium + ' ' + this.price + '\n';
    }
}
