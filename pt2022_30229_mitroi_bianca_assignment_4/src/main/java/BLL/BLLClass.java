package BLL;

import DAO.FileWriterDAO;
import DAO.Serializator;
import GUI.EmployeeGUI;
import MODEL.User;
import MODEL.UserType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BLLClass {

    public static boolean validate(String username, UserType userType){
        String filename = "file.txt";
        ArrayList<User> users = Serializator.deserializeUsers(filename);
        boolean ok = false;
        for(User arrayUser : users){
            if(username.equals(arrayUser.getUsername()) && userType.equals(arrayUser.getUserType())){
                ok = true;
                break;
            }
        }
        return ok;
    }
    /**
     * //@pre Checks if the user has already an account and if he`s not, checks if the username is valid
     * //@post Checks if the user has been registered successfully
     * */
    public static void registerUser(String username, String password, UserType userType){
        String filename = "file.txt";
        ArrayList<User> users = Serializator.deserializeUsers(filename);
        User user = new User(username, password, userType, 0);
        boolean ok = false;
        for(User arrayUser : users){
            if(user.getUsername().equals(arrayUser.getUsername())){
                ok = true;
                break;
            }
        }
        assert ok == false : "Aveti deja cont!";
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$");
        Matcher matcher = pattern.matcher(username);
        assert matcher.matches() == true : "Username-ul este invalid!";
        users.add(user);
        Serializator.serializeUsers(users, filename);
        assert users != null : "Eroare in inregistrarea utilizatorului!";
        JOptionPane.showMessageDialog(null, "Inregistrarea s-a realizat cu succes!");
    }
    public static void writeMenu(ArrayList<MenuItem> menuItems){
        String filemane = "menu.txt";
        Serializator.serializeMenuItems(filemane, menuItems);
    }
    public static ArrayList<MenuItem> readMenuItems(){
        String filemane = "menu.txt";
        ArrayList<MenuItem> menuItems = Serializator.deserializeMenuItems(filemane);
        return menuItems;
    }
    public static void placeOrder(Order order, ArrayList<MenuItem> menuItems){
        String filename = "orders.txt";
        String filename1 = "ordersForGenerate.txt";
        HashMap<Order, ArrayList<MenuItem>> orders = Serializator.deserializeOrders(filename);
        orders.put(order, menuItems);
        Serializator.serializeOrders(filename,orders);
        Serializator.serializeOrders(filename1,orders);
    }
    public static void deleteOrder(EmployeeGUI employeeGUI){
        String filename = "orders.txt";
        HashMap<Order, ArrayList<MenuItem>> orders = Serializator.deserializeOrders(filename);
        ArrayList<Map.Entry<Order, ArrayList<MenuItem>>> list = (ArrayList<Map.Entry<Order, ArrayList<MenuItem>>>) orders.entrySet().stream().collect(Collectors.toList());
        orders.remove(list.get(employeeGUI.getTable().getSelectedRow()).getKey());
        list.remove(employeeGUI.getTable().getSelectedRow());
        employeeGUI.setTable(FileWriterDAO.createOrderTable(list));
        Serializator.serializeOrders(filename,orders);
    }
    public static Integer readOrderId(){
        String filemane = "orderId.txt";
        Integer orderId = Serializator.deserializeOrderId(filemane);
        return orderId;
    }
    public static void writeOrderId(Integer orderId){
        String filemane = "orderId.txt";
        Serializator.serializeOrderId(filemane, orderId);
    }
}
