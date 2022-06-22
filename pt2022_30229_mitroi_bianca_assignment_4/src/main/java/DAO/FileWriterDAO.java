package DAO;

import BLL.BaseProduct;
import BLL.MenuItem;
import BLL.Order;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class FileWriterDAO {
    public static ArrayList<MenuItem> extractProducts(String filepath){
        List<MenuItem> menu = new ArrayList<>();
        try {
            menu = Files.lines(Path.of(filepath)).skip(1).map(
                    line->{
                        String[] p = line.split(",");
                        String title = p[0];
                        double rating = Double.parseDouble(p[1]);
                        int calories = Integer.parseInt(p[2]);
                        int protein = Integer.parseInt(p[3]);
                        int fat = Integer.parseInt(p[4]);
                        int sodium = Integer.parseInt(p[5]);
                        int price =Integer.parseInt(p[6]);
                        Integer orderCounter = 0;
                        MenuItem item = new BaseProduct(title, rating, calories, protein, fat, sodium, price, orderCounter);
                        return item;
                    }
            ).collect(Collectors.toList());
            TreeSet<MenuItem> treeSet = new TreeSet<>();
            treeSet.addAll(menu);
            menu.clear();
            menu.addAll(treeSet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (ArrayList<MenuItem>) menu;

    }
    public static TableModel createMenuTable(ArrayList<MenuItem> menuItems){
        String[] header = new String[7];
        String[][] data = new String[menuItems.size()][7];
        header[0] = "title";
        header[1] = "rating";
        header[2] = "calories";
        header[3] = "protein";
        header[4] = "fat";
        header[5] = "sodium";
        header[6] = "price";
        for(int i = 0; i < menuItems.size(); i++){
            data[i][0] = menuItems.get(i).getTitle();
            data[i][1] = String.valueOf(menuItems.get(i).getRating());
            data[i][2] = String.valueOf(menuItems.get(i).getCalories());
            data[i][3] = String.valueOf(menuItems.get(i).getProtein());
            data[i][4] = String.valueOf(menuItems.get(i).getFat());
            data[i][5] = String.valueOf(menuItems.get(i).getSodium());
            data[i][6] = String.valueOf(menuItems.get(i).getPrice());
        }
        TableModel tm = new DefaultTableModel(data, header);
        return tm;
    }
    public static TableModel createOrderTable(ArrayList<Map.Entry<Order, ArrayList<MenuItem>>> list){
        String[] header = new String[3];
        String[][] data = new String[list.size()][3];
        header[0] = "ClientUsername";
        header[1] = "Date";
        header[2] = "Products";
        for(int i = 0; i < list.size(); i++){
            data[i][0] = list.get(i).getKey().getClientUsername().getUsername();
            data[i][1] = list.get(i).getKey().getDate().toString();
            data[i][2] = list.get(i).getValue().toString();
        }
       TableModel tm = new DefaultTableModel(data, header);
        return tm;
    }
    public static void printBill(Order order,ArrayList<MenuItem> menuItems){
        try {
            FileWriter fileWriter = new FileWriter("bill.txt");
            Integer totalPrice = 0;
            for(MenuItem mi : menuItems){
                totalPrice += mi.getPrice();
            }
            fileWriter.write("Order id: " + order.getId() + "\nClient username: " + order.getClientUsername() + "\nOrder date: " + order.getDate() + "\nOrdered items:\ntitle rating calories protein fat sodiun price\n" + menuItems.toString() + "\n Total price: " + totalPrice);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

