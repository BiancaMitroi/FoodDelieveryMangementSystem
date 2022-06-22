package BLL;

import DAO.FileWriterDAO;
import DAO.Serializator;
import GUI.AdministratorGUI;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService implements IDeliveryServiceProcessing{

    @Override
    public ArrayList<MenuItem> importProducts() {
        ArrayList<MenuItem> menu = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV File", "csv");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File("."));
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
            menu = FileWriterDAO.extractProducts(fileChooser.getSelectedFile().getAbsolutePath());
        }
        return menu;
    }

    @Override
    public void createProduct(CompositeProduct cp) {
        cp.setComponents();
    }

    @Override
    public void updateProducts(ArrayList<MenuItem> menu, int indexOfItemToModify, AdministratorGUI adimistratorGUI) {
        menu.get(indexOfItemToModify).setTitle(adimistratorGUI.getTitleTextField());
        menu.get(indexOfItemToModify).setRating(adimistratorGUI.getRatingTextField());
        menu.get(indexOfItemToModify).setCalories(adimistratorGUI.getCaloriesTextField());
        menu.get(indexOfItemToModify).setProtein(adimistratorGUI.getProteinTextField());
        menu.get(indexOfItemToModify).setFat(adimistratorGUI.getFatTextField());
        menu.get(indexOfItemToModify).setSodium(adimistratorGUI.getSodiumTextField());
        menu.get(indexOfItemToModify).setPrice(adimistratorGUI.getPriceTextField());
        menu.get(indexOfItemToModify).setOrderCounter(0);
        adimistratorGUI.setUpdateItemTable(FileWriterDAO.createMenuTable(menu));
        BLLClass.writeMenu(menu);
    }
    public void updateOrders(String orders, String generate, HashMap<Order, ArrayList<MenuItem>> ordersArray, MenuItem menuItem) {
        for(Map.Entry<Order, ArrayList<MenuItem>> entry : ordersArray.entrySet()){
            if(entry.getValue().contains(menuItem)){
                ordersArray.remove(entry);
            }
        }
        Serializator.serializeOrders(orders, ordersArray);
        Serializator.serializeOrders(generate, ordersArray);
    }

    @Override
    public void generateReport1(int start, int end, AdministratorGUI administratorGUI) {
        if(start >= end){
            JOptionPane.showMessageDialog(null, "Filtrul este invalid!");
        }else{
            String filename = "ordersForGenerate.txt";
            HashMap<Order, ArrayList<MenuItem>> orders = Serializator.deserializeOrders(filename);
            ArrayList<Map.Entry<Order, ArrayList<MenuItem>>> list = (ArrayList<Map.Entry<Order, ArrayList<MenuItem>>>) orders.entrySet().stream().filter(t -> t.getKey().getDate().getHour() >= start).filter(t -> t.getKey().getDate().getHour() <= end).collect(Collectors.toList());
            administratorGUI.setGenerateReportTable(FileWriterDAO.createOrderTable(list));
        }
    }

    @Override
    public void generateReport2(Integer nr, AdministratorGUI administratorGUI, ArrayList<MenuItem> menu) {
        if(nr < 0){
            JOptionPane.showMessageDialog(null, "Filtrul este invalid!");
        }else{
            ArrayList<MenuItem> list = (ArrayList<MenuItem>) menu.stream().filter(t -> menu.get(menu.indexOf(t)).getOrderCounter() >= nr).collect(Collectors.toList());
            administratorGUI.setGenerateReportTable(FileWriterDAO.createMenuTable(list));
        }
    }

    @Override
    public void generateReport3(int numberClient, int priceOrder, AdministratorGUI administratorGUI) {
        String filename = "ordersForGenerate.txt";
        HashMap<Order, ArrayList<MenuItem>> orders = Serializator.deserializeOrders(filename);
        ArrayList<Map.Entry<Order, ArrayList<MenuItem>>> list = (ArrayList<Map.Entry<Order, ArrayList<MenuItem>>>) orders.entrySet().stream().filter(t -> t.getKey().getClientUsername().getOrderCounter() >= numberClient).filter(t -> t.getKey().getOrderPrice() >= priceOrder).collect(Collectors.toList());
        administratorGUI.setGenerateReportTable(FileWriterDAO.createOrderTable(list));
    }

    @Override
    public void generateReport4(int day, int month, int year, AdministratorGUI administratorGUI) {
        String filename = "ordersForGenerate.txt";
        HashMap<Order, ArrayList<MenuItem>> orders = Serializator.deserializeOrders(filename);
        ArrayList<Map.Entry<Order, ArrayList<MenuItem>>> list = (ArrayList<Map.Entry<Order, ArrayList<MenuItem>>>) orders.entrySet().stream().filter(t -> t.getKey().getDate().getDayOfMonth() == day).filter(t -> t.getKey().getDate().getMonthValue() == month).filter(t -> t.getKey().getDate().getYear() == year).collect(Collectors.toList());
        administratorGUI.setGenerateReportTable(FileWriterDAO.createOrderTable(list));
    }


    @Override
    public void createOrder(Order order, ArrayList<MenuItem> clientOrder) {
        FileWriterDAO.printBill(order, clientOrder);
    }
}
