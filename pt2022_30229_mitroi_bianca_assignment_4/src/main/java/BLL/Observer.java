package BLL;

import DAO.FileWriterDAO;
import DAO.Serializator;
import GUI.EmployeeGUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.stream.Collectors;

public class Observer extends Observable {
    public static void AnounceEmployee(EmployeeGUI employeeGUI){
        String filename = "orders.txt";
        HashMap<Order, ArrayList<MenuItem>> orders = Serializator.deserializeOrders(filename);
        ArrayList<Map.Entry<Order, ArrayList<MenuItem>>> list = (ArrayList<Map.Entry<Order, ArrayList<MenuItem>>>) orders.entrySet().stream().collect(Collectors.toList());
        employeeGUI.setTable(FileWriterDAO.createOrderTable(list));
        JOptionPane.showMessageDialog(employeeGUI.getFrame(), "There are " + list.size() + " orders!");
    }
}
