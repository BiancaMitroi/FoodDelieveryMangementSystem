package BLL;

import GUI.AdministratorGUI;

import javax.swing.table.TableModel;
import java.util.ArrayList;

public interface IDeliveryServiceProcessing {
    ArrayList<MenuItem> importProducts();
    void createProduct(CompositeProduct cp);
    void updateProducts(ArrayList<MenuItem> menu, int indexOfItemToModify, AdministratorGUI adimistratorGUI);
    void generateReport1(int start, int end, AdministratorGUI administratorGUI);
    void generateReport2(Integer nr, AdministratorGUI administratorGUI, ArrayList<MenuItem> menu);
    void generateReport3(int numberClient, int priceOrder, AdministratorGUI administratorGUI);
    void generateReport4(int day, int month, int year, AdministratorGUI administratorGUI);
    void createOrder(Order order, ArrayList<MenuItem> clientOrder);
}
