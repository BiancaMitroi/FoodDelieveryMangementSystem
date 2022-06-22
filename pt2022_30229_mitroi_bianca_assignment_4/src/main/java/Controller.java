import BLL.*;
import DAO.FileWriterDAO;
import DAO.Serializator;
import GUI.AdministratorGUI;
import GUI.ClientGUI;
import GUI.EmployeeGUI;
import GUI.LoginGUI;
import MODEL.User;
import MODEL.UserType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Controller {
    LoginGUI loginGUI = new LoginGUI();
    AdministratorGUI adimistratorGUI = new AdministratorGUI();
    EmployeeGUI employeeGUI = new EmployeeGUI();
    ClientGUI clientGUI = new ClientGUI();
    ArrayList<MenuItem> menu = BLLClass.readMenuItems();
    ArrayList<MenuItem> search = new ArrayList<>();
    ArrayList<MenuItem> clientOrder = new ArrayList<>();
    CompositeProduct newProduct = new CompositeProduct();
    DeliveryService ds = new DeliveryService();
    int indexOfItemToModify = 0;
    int orderId = BLLClass.readOrderId();

    public Controller(){
        this.loginGUI.addActionListenerOnloginButton(new LoginButton());
        this.loginGUI.addActionListenerOnregisterButton(new RegisterButton());
        this.adimistratorGUI.addActionListenerOnCreateProductButton(new CreateProductButton());
        this.adimistratorGUI.addActionListenerOnupdateProductButton(new UpdateProductButton());
        this.adimistratorGUI.addActionListenerOngenerateReportButton(new GenerateReportButton());
        this.adimistratorGUI.addActionListenerOnImportProductsListener(new ImportProductButton());
        this.adimistratorGUI.addActionListenerOnbackFromAdminButton(new BackFromAdminButton());
        this.adimistratorGUI.addActionListenerOnbackFromCreateProductButton(new BackFromCreateProductButton());
        this.adimistratorGUI.addActionListenerOnbackFromGenerateReportButton(new BackFromGenerateReportButton());
        this.adimistratorGUI.addActionListenerOnbackFromUpdateProductButton(new BackFromUpdateProductButton());
        this.adimistratorGUI.addActionListenerOnModifyProductButton(new ModifyProductButton());
        this.adimistratorGUI.addSelectUpdateButton(new SelectUpdateButton());
        this.clientGUI.addActionListenerOnbackFromClientButton(new BackFromClientButton());
        this.clientGUI.addActionListenerOnaddToOrderButton(new AddToOrderButton());
        this.clientGUI.addActionListenerOndeleteFromOrderButton(new DeleteFromOrderButton());
        this.clientGUI.addActionListenerOnplaceOrderButton(new PlaceOrderButton());
        this.clientGUI.addActionListenerOnsearchButton(new SearchButton());
        this.adimistratorGUI.addActionListenerOnAddToProductButton(new AddProductButton());
        this.adimistratorGUI.addActionListenerOnDeleteFromProductButton(new DeleteFromProductButton());
        this.adimistratorGUI.addActionListenerOnFinishProductButton(new FinishProductButton());
        this.adimistratorGUI.addActionListenerOndeleteProductFromMenuButton(new DeleteProductFromMenuButton());
        this.adimistratorGUI.addActionListenerOnAddBaseProductButton(new AddBaseProductButton());

        this.adimistratorGUI.addActionListenerOngenerateAfterTimeButton(new GenerateAfterTimeButton());
        this.adimistratorGUI.addActionListenerOngenerateAfterNumberOrdersPerProductButton(new GenerateAfterNumberOrdersPerProductButton());
        this.adimistratorGUI.addActionListenerOngenerateAfterClientsAndPriceButton(new GenerateAfterClientsAndPriceButton());
        this.adimistratorGUI.addActionListenerOngenerateAfterDateButton(new GenerateAfterDateButton());
        this.employeeGUI.addActionListenerOnBackFromEmployeeButton(new BackFromEmployeeListener());
        this.employeeGUI.addActionListenerOnOrderDoneButton(new OrderDoneListener());

        this.loginGUI.getFrame().setVisible(true);

    }
    public class LoginButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            assert BLLClass.validate(loginGUI.getusername(), loginGUI.getRole()) : "Username-ul, parola sau rolul sunt incorecte!\n Incercati din nou!";
            if(loginGUI.getRole().equals(UserType.ADMIN)){
                loginGUI.getFrame().setVisible(false);
                adimistratorGUI.getAdminFrame().setVisible(true);
            }else if(loginGUI.getRole().equals(UserType.CLIENT)){
                loginGUI.getFrame().setVisible(false);
                clientGUI.getFrame().setVisible(true);
                clientGUI.setClientTable(FileWriterDAO.createMenuTable(menu));
            }else if(loginGUI.getRole().equals(UserType.EMPLOYEE)){
                loginGUI.getFrame().setVisible(false);
                employeeGUI.getFrame().setVisible(true);
                Observer.AnounceEmployee(employeeGUI);
            }
        }

    } // terminat
    public class RegisterButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            BLLClass.registerUser(loginGUI.getusername(), loginGUI.getpassword(), loginGUI.getRole());
            loginGUI.setusername("");
            loginGUI.setpassword("");
        }
    } // terminat
    public class CreateProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adimistratorGUI.getAdminFrame().setVisible(false);
            adimistratorGUI.getCreateProductframe().setVisible(true);
            adimistratorGUI.setCreateItemTable(FileWriterDAO.createMenuTable(menu));
        }
    } // terminat
    public class UpdateProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adimistratorGUI.getAdminFrame().setVisible(false);
            adimistratorGUI.getUpdateProductframe().setVisible(true);
            adimistratorGUI.setUpdateItemTable(FileWriterDAO.createMenuTable(menu));
        }
    } // terminat
    public class GenerateReportButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adimistratorGUI.getAdminFrame().setVisible(false);
            adimistratorGUI.getGenerateReportframe().setVisible(true);
        }
    } // terminat
    public class BackFromAdminButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adimistratorGUI.getAdminFrame().setVisible(false);
            loginGUI.getFrame().setVisible(true);
        }
    } // terminat
    public class BackFromCreateProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adimistratorGUI.getCreateProductframe().setVisible(false);
            adimistratorGUI.getAdminFrame().setVisible(true);
        }
    } // terminat
    public class BackFromGenerateReportButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adimistratorGUI.getGenerateReportframe().setVisible(false);
            adimistratorGUI.getAdminFrame().setVisible(true);
        }
    } // terminat
    public class BackFromUpdateProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adimistratorGUI.getUpdateProductframe().setVisible(false);
            adimistratorGUI.getAdminFrame().setVisible(true);
        }
    } // terminat
    public class ModifyProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            HashMap<Order, ArrayList<MenuItem>> orders = Serializator.deserializeOrders("orders.txt");
            ds.updateProducts(menu, indexOfItemToModify, adimistratorGUI);
            BLLClass.writeMenu(menu);
            orders.clear();
            Serializator.serializeOrders("orders.txt", orders);
            Serializator.serializeOrders("ordersForGenerate.txt", orders);
        }
    } // terminat
    public class SelectUpdateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            indexOfItemToModify = adimistratorGUI.getUpdateItemTable().getSelectedRow();
            adimistratorGUI.setUpdateFields();
        }
    } // terminat
    public class BackFromClientButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientGUI.getFrame().setVisible(false);
            loginGUI.getFrame().setVisible(true);
        }
    } // terminat
    public class ImportProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adimistratorGUI.getAdminFrame().setVisible(true);
            menu = ds.importProducts();
            BLLClass.writeMenu(menu);
        }
    } // terminat

    public class AddToOrderButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(search.size() == 0)
                clientOrder.add(menu.get(clientGUI.getClientTable().getSelectedRow()));
            else
                clientOrder.add(search.get(clientGUI.getClientTable().getSelectedRow()));
            clientGUI.setClientTable_1(FileWriterDAO.createMenuTable(clientOrder));
        }
    } // terminat
    public class DeleteFromOrderButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientOrder.remove(clientGUI.getClientTable_1().getSelectedRow());
            clientGUI.setClientTable_1(FileWriterDAO.createMenuTable(clientOrder));
        }
    } // terminat
    public class PlaceOrderButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Integer price = 0;
            for(int i = 0; i < clientOrder.size(); i++){
                menu.get(menu.indexOf(clientOrder.get(i))).setOrderCounter(menu.get(menu.indexOf(clientOrder.get(i))).getOrderCounter() + 1);
                price += clientOrder.get(i).getPrice();
            }
            User u = null;
            ArrayList<User> users = Serializator.deserializeUsers("file.txt");
            for(User user : users)
                if(user.getUsername().equals(loginGUI.getusername())){
                    user.setOrderCounter(user.getOrderCounter() + 1);
                    u = user;
                }
            Order order = new Order(++orderId, u, price);
            BLLClass.writeOrderId(orderId);
            ds.createOrder(order, clientOrder); // generare factura
            BLLClass.placeOrder(order, clientOrder); // inregistrare comanda
            BLLClass.writeMenu(menu);
            Serializator.serializeUsers(users, "file.txt");
        }
    } // de terminat
    public class SearchButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> list = (ArrayList<MenuItem>) menu.stream().
                    filter(t -> t.getTitle().toLowerCase().contains(clientGUI.getSearchTextField().toLowerCase()) ||
                            clientGUI.getSearchTextField().toLowerCase().contains("rating") && clientGUI.getSearchTextField().toLowerCase().contains(t.getRating().toString())
                    || clientGUI.getSearchTextField().toLowerCase().contains("calories") && clientGUI.getSearchTextField().toLowerCase().contains(t.getCalories().toString())
                     || clientGUI.getSearchTextField().toLowerCase().contains("protein") && clientGUI.getSearchTextField().toLowerCase().contains(t.getProtein().toString())
                     || clientGUI.getSearchTextField().toLowerCase().contains("fat") && clientGUI.getSearchTextField().toLowerCase().contains(t.getFat().toString())
                     || clientGUI.getSearchTextField().toLowerCase().contains("sodium") && clientGUI.getSearchTextField().toLowerCase().contains(t.getSodium().toString())
                     || clientGUI.getSearchTextField().toLowerCase().contains("price") && clientGUI.getSearchTextField().toLowerCase().contains(t.getPrice().toString())).collect(toList());
            search.clear();
            search.addAll(list);
            clientGUI.setClientTable(FileWriterDAO.createMenuTable(list));
        }
    } // terminat
    public class AddProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            newProduct.getMenuItems().add(new BaseProduct(adimistratorGUI.getSelectedTitle(), adimistratorGUI.getSelectedRating(), adimistratorGUI.getSelectedCalories(), adimistratorGUI.getSelectedProtein(), adimistratorGUI.getSelectedFat(), adimistratorGUI.getSelectedSodium(), adimistratorGUI.getSelectedPrice(), 0));
            adimistratorGUI.setCreateProductTable_1(FileWriterDAO.createMenuTable(newProduct.getMenuItems()));
            clientGUI.setClientTable(FileWriterDAO.createMenuTable(menu));
        }
    } // terminat
    public class DeleteFromProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            newProduct.getMenuItems().remove(adimistratorGUI.getCreateProductTable_1().getSelectedRow());
            adimistratorGUI.setCreateProductTable_1(FileWriterDAO.createMenuTable(newProduct.getMenuItems()));
        }
    } // terminat
    public class DeleteProductFromMenuButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            menu.remove(adimistratorGUI.getUpdateItemTable().getSelectedRow());
            BLLClass.writeMenu(menu);
            adimistratorGUI.setUpdateItemTable(FileWriterDAO.createMenuTable(menu));
        }
    } // terminat
    public class FinishProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ds.createProduct(newProduct);
            menu.add(newProduct);
            BLLClass.writeMenu(menu);
            adimistratorGUI.setCreateProductTable(FileWriterDAO.createMenuTable(menu));
        }
    } // terminat
    public class GenerateAfterTimeButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ds.generateReport1((int)adimistratorGUI.getStartTimeComboBox().getSelectedItem(), (int)adimistratorGUI.getEndTimeComboBox().getSelectedItem(), adimistratorGUI);
        }
    } // terminat
    public class GenerateAfterNumberOrdersPerProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ds.generateReport2(adimistratorGUI.getnumberOrdersPerProductTextField(), adimistratorGUI, menu);
        }
    }
    public class GenerateAfterClientsAndPriceButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ds.generateReport3(adimistratorGUI.getNumberClientsTextField(), adimistratorGUI.getOrderPriceTextField(), adimistratorGUI);
        }
    }
    public class GenerateAfterDateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ds.generateReport4((int)adimistratorGUI.getDayComboBox(), (int)adimistratorGUI.getMonthComboBox(), (int)adimistratorGUI.getYearComboBox(), adimistratorGUI);
        }
    } // terminat
    public class BackFromEmployeeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            employeeGUI.getFrame().setVisible(false);
            loginGUI.getFrame().setVisible(true);
        }
    } // terminat
    public class OrderDoneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            BLLClass.deleteOrder(employeeGUI);
        }
    } // terminat
    public class AddBaseProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            menu.add(new BaseProduct(adimistratorGUI.getTitleTextField(), adimistratorGUI.getRatingTextField(), adimistratorGUI.getCaloriesTextField(), adimistratorGUI.getProteinTextField(), adimistratorGUI.getFatTextField(), adimistratorGUI.getSodiumTextField(), adimistratorGUI.getPriceTextField(), 0));
            BLLClass.writeMenu(menu);
            adimistratorGUI.setUpdateItemTable(FileWriterDAO.createMenuTable(menu));
            clientGUI.setClientTable(FileWriterDAO.createMenuTable(menu));
        }
    } // terminat
}
