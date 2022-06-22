package DAO;
import BLL.MenuItem;
import BLL.Order;
import MODEL.User;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Serializator implements Serializable {
    public static void serializeUsers(ArrayList<User> users, String filename){
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(users);
            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<User> deserializeUsers(String filename){
        ArrayList<User> users = new ArrayList<>();
        try {
            FileInputStream file1 = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file1);
            users = (ArrayList<User>) in.readObject();
            //System.out.println(users.toString());
            in.close();
            file1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(EOFException e){
            JOptionPane.showMessageDialog(null, "Nu mai exista alti utilizatori in aplicatie!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
    public static void serializeMenuItems(String filename, ArrayList<MenuItem> menuItems){
        try {
            FileOutputStream file1 = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file1);
            out.writeObject(menuItems);
            out.close();
            file1.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<MenuItem> deserializeMenuItems(String filename){
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        try {
            FileInputStream file1 = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file1);
            menuItems = (ArrayList<MenuItem>) in.readObject();
            //System.out.println(users.toString());
            in.close();
            file1.close();
        } catch (EOFException e) {
            JOptionPane.showMessageDialog(null, "Nu exista produse in aplicatie!");
            //e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(WriteAbortedException e){
            JOptionPane.showMessageDialog(null, "Nu exista produse in aplicatie!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return menuItems;
    }

    public static void serializeOrders(String filename, HashMap<Order, ArrayList<MenuItem>> orders){
        try {
            FileOutputStream file1 = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file1);
            out.writeObject(orders);
            out.close();
            file1.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static HashMap<Order, ArrayList<MenuItem>> deserializeOrders(String filename){
        HashMap<Order, ArrayList<MenuItem>> orders = new HashMap<Order, ArrayList<MenuItem>>();
        try {
            FileInputStream file1 = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file1);
            orders = (HashMap<Order, ArrayList<MenuItem>>) in.readObject();
            in.close();
            file1.close();
        } catch (EOFException e) {
            JOptionPane.showMessageDialog(null, "Nu exista comenzi in aplicatie!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Nu s-a putut gasi fisierul de comenzi!");
        } catch(WriteAbortedException e){
            JOptionPane.showMessageDialog(null, "Nu exista comenzi in aplicatie!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }
    public static Integer deserializeOrderId(String filename){
        Integer i = 0;
        try {
            FileInputStream file1 = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file1);
            i = (Integer) in.readObject();
            //System.out.println(users.toString());
            in.close();
            file1.close();
        } catch (EOFException e) {
            JOptionPane.showMessageDialog(null, "Nu s-a cumparat niciun produs pana acum!");
            //e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(WriteAbortedException e){
            JOptionPane.showMessageDialog(null, "Nu s-a cumparat niciun produs pana acum!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }
    public static void serializeOrderId(String filename, Integer orderId){
        try {
            FileOutputStream file1 = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file1);
            out.writeObject(orderId);
            out.close();
            file1.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
