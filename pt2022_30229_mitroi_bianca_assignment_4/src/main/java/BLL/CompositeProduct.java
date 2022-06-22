package BLL;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem{
    private ArrayList<MenuItem> menuItems;
    public CompositeProduct(){
        this.menuItems = new ArrayList<>();
    }
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
    public void setMenuItems(MenuItem menuItem){
        menuItems.add(menuItem);
    }
    public void setComponents(){
        this.setPrice(0);
        this.setTitle(new String(""));
        this.setRating(0.0);
        this.setCalories(0);
        this.setProtein(0);
        this.setFat(0);
        this.setSodium(0);
        this.setOrderCounter(0);
    }

    @Override
    public void setPrice(Integer i) {
        Integer price = 0;
        for (MenuItem m : menuItems) {
            price += m.getPrice();
        }
        Integer newPrice = (int)(price * 0.9);
        super.price = newPrice;
    }
    @Override
    public void setTitle(String t){
        String title = "";
        for(MenuItem m : menuItems){
            title += ' ' + m.getTitle();
        }
        super.title = title;
    }
    @Override
    public void setRating(Double r) {
        super.rating = r;
    }
    @Override
    public void setCalories(Integer c) {
        Integer calories = 0;
        for(MenuItem m : menuItems){
            calories += m.getCalories();
        }
        super.calories = calories;
    }
    @Override
    public void setFat(Integer c) {
        Integer fat = 0;
        for(MenuItem m : menuItems){
            fat += m.getFat();
        }
        super.fat = fat;
    }
    @Override
    public void setSodium(Integer c) {
        Integer sodium = 0;
        for(MenuItem m : menuItems){
            sodium += m.getSodium();
        }
        super.sodium = sodium;
    }
    @Override
    public void setProtein(Integer c) {
        Integer protein = 0;
        for(MenuItem m : menuItems){
            protein += m.getProtein();
        }
        super.protein = protein;
    }

    @Override
    public int compareTo(MenuItem o) {
        return this.title.compareTo(o.getTitle());
    }

    public String toString(){
        return this.title + ' ' + this.rating + ' ' + this.calories + ' ' + this.protein + ' ' + this.fat + ' ' + this.sodium + ' ' + this.price + '\n';
    }
}
