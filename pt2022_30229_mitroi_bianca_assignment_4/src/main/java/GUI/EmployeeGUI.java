package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableModel;

public class EmployeeGUI {

    private JFrame frame;
    private JTable table;
    private JButton backFromEmployeeButton;
    private JButton orderDoneButton;
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    EmployeeGUI window = new EmployeeGUI();
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
    public EmployeeGUI() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 416, 206);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane.setViewportView(table);

        orderDoneButton = new JButton("Done");
        orderDoneButton.setBounds(337, 229, 89, 23);
        frame.getContentPane().add(orderDoneButton);

        backFromEmployeeButton = new JButton("<-");
        backFromEmployeeButton.setBounds(10, 229, 89, 23);
        frame.getContentPane().add(backFromEmployeeButton);
    }
    public JFrame getFrame(){
        return this.frame;
    }

    public JTable getTable(){
        return this.table;
    }

    public void setTable(TableModel tm){
        this.table.setModel(tm);
    }

    public void addActionListenerOnOrderDoneButton(ActionListener actionListener){
        orderDoneButton.addActionListener(actionListener);
    }

    public void addActionListenerOnBackFromEmployeeButton(ActionListener actionListener){
        backFromEmployeeButton.addActionListener(actionListener);
    }
}
