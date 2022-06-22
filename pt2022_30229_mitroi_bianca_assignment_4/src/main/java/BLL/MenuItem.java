package BLL;

import java.io.Serializable;

public abstract class MenuItem implements Serializable, Comparable<MenuItem> {
    String title;
    Double rating;
    Integer calories;
    Integer protein;
    Integer fat;
    Integer sodium;
    Integer price;
    Integer orderCounter;

    public Integer getOrderCounter() {
        return orderCounter;
    }

    public void setOrderCounter(Integer orderCounter) {
        this.orderCounter = orderCounter;
    }

    public MenuItem(){}

    public MenuItem(String title, Double rating, Integer calories, Integer protein, Integer fat, Integer sodium, Integer price, Integer orderCounter) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
        this.orderCounter = orderCounter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getSodium() {
        return sodium;
    }

    public void setSodium(Integer sodium) {
        this.sodium = sodium;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String toString(){
        return this.title + ' ' + this.rating + ' ' + this.calories + ' ' + this.protein + ' ' + this.fat + ' ' + this.sodium + ' ' + this.price + '\n';
    }
}
