package GUI;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientGUI {

    private JFrame frame;
    private JTextField searchTextField;
    private JButton backFromClientButton;
    private JButton placeOrderButton;
    private JButton deleteFromOrderButton;
    private JButton addToOrderButton;
    private JScrollPane scrollPane_1;
    private JScrollPane scrollPane;
    private JButton searchButton;
    private JTable clientTable;
    private JTable clientTable_1;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ClientGUI window = new ClientGUI();
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the application.
     */
    public ClientGUI() {
        frame = new JFrame();
        frame.setBounds(100, 100, 493, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("As a client, you can place an order or search a product");
        lblNewLabel.setBounds(10, 11, 416, 14);
        frame.getContentPane().add(lblNewLabel);

        searchTextField = new JTextField();
        searchTextField.setBounds(230, 33, 239, 20);
        frame.getContentPane().add(searchTextField);
        searchTextField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Type the product you want to search:");
        lblNewLabel_1.setBounds(10, 36, 234, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Please enter this button to start the search:");
        lblNewLabel_2.setBounds(10, 61, 264, 14);
        frame.getContentPane().add(lblNewLabel_2);

        searchButton = new JButton("Search");
        searchButton.setBounds(266, 57, 89, 23);
        frame.getContentPane().add(searchButton);

        JLabel lblNewLabel_3 = new JLabel("The search results will appear in the left table");
        lblNewLabel_3.setBounds(10, 86, 316, 14);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Please select the products ");
        lblNewLabel_4.setBounds(10, 111, 264, 14);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("If you want to delete a product please ");
        lblNewLabel_5.setBounds(248, 111, 228, 14);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("you want to add to your order:");
        lblNewLabel_6.setBounds(10, 127, 184, 14);
        frame.getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("select a product from this list:");
        lblNewLabel_7.setBounds(248, 127, 206, 14);
        frame.getContentPane().add(lblNewLabel_7);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 152, 222, 248);
        frame.getContentPane().add(scrollPane);

        clientTable = new JTable();
        clientTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane.setViewportView(clientTable);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(248, 152, 222, 248);
        frame.getContentPane().add(scrollPane_1);

        clientTable_1 = new JTable();
        clientTable_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane_1.setViewportView(clientTable_1);

        addToOrderButton = new JButton("Add to order");
        addToOrderButton.setBounds(10, 411, 140, 23);
        frame.getContentPane().add(addToOrderButton);

        deleteFromOrderButton = new JButton("Delete from order");
        deleteFromOrderButton.setBounds(247, 411, 140, 23);
        frame.getContentPane().add(deleteFromOrderButton);

        placeOrderButton = new JButton("Place the order");
        placeOrderButton.setBounds(327, 445, 140, 23);
        frame.getContentPane().add(placeOrderButton);

        JLabel lblNewLabel_8 = new JLabel("If you have finished, please click this button:");
        lblNewLabel_8.setBounds(10, 453, 307, 14);
        frame.getContentPane().add(lblNewLabel_8);

        backFromClientButton = new JButton("<-");
        backFromClientButton.setBounds(424, 7, 45, 23);
        frame.getContentPane().add(backFromClientButton);
    }

    public JFrame getFrame(){
        return this.frame;
    }

    public void addActionListenerOnbackFromClientButton(ActionListener actionLstener){
        backFromClientButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnaddToOrderButton(ActionListener actionLstener){
        addToOrderButton.addActionListener(actionLstener);
    }
    public void addActionListenerOndeleteFromOrderButton(ActionListener actionLstener){
        deleteFromOrderButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnplaceOrderButton(ActionListener actionLstener){
        placeOrderButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnsearchButton(ActionListener actionLstener){
        searchButton.addActionListener(actionLstener);
    }
    public JTable getClientTable(){
        return clientTable;
    }
    public JTable getClientTable_1(){
        return clientTable_1;
    }
    public void setClientTable(TableModel tm){
        this.clientTable.setModel(tm);
    }
    public void setClientTable_1(TableModel tm){
        this.clientTable_1.setModel(tm);
    }
    public String getSearchTextField(){
        return this.searchTextField.getText();
    }
}
