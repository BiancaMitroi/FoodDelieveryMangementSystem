package GUI;
import MODEL.UserType;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class LoginGUI {

    private JFrame frame;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JComboBox roleComboBox;
    private JButton loginButton;
    private JButton registerButton;

    public LoginGUI() {
        frame = new JFrame();
        frame.setBounds(100, 100, 275, 177);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Please login or register!");
        lblNewLabel.setBounds(10, 11, 241, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Username:");
        lblNewLabel_1.setBounds(10, 36, 84, 14);
        frame.getContentPane().add(lblNewLabel_1);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(80, 33, 171, 20);
        frame.getContentPane().add(usernameTextField);
        usernameTextField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Password:");
        lblNewLabel_2.setBounds(10, 61, 84, 14);
        frame.getContentPane().add(lblNewLabel_2);

        passwordField = new JPasswordField();
        passwordField.setBounds(80, 58, 171, 20);
        frame.getContentPane().add(passwordField);

        JLabel lblNewLabel_3 = new JLabel("Please select your role:");
        lblNewLabel_3.setBounds(10, 86, 144, 14);
        frame.getContentPane().add(lblNewLabel_3);

        roleComboBox = new JComboBox();
        roleComboBox.setBounds(164, 82, 87, 22);
        frame.getContentPane().add(roleComboBox);
        roleComboBox.addItem(UserType.ADMIN);
        roleComboBox.addItem(UserType.CLIENT);
        roleComboBox.addItem(UserType.EMPLOYEE);


        loginButton = new JButton("Login");
        loginButton.setBounds(5, 111, 89, 23);
        frame.getContentPane().add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(104, 111, 89, 23);
        frame.getContentPane().add(registerButton);
    }

    public JFrame getFrame(){
        return this.frame;
    }

    public UserType getRole(){
        return (UserType) this.roleComboBox.getSelectedItem();
    }

    public void addActionListenerOnloginButton(ActionListener actionLstener){
        loginButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnregisterButton(ActionListener actionLstener){
        registerButton.addActionListener(actionLstener);
    }

    public String getusername(){
        return usernameTextField.getText();
    }
    public String getpassword(){
        return String.valueOf(passwordField.getPassword());
    }

    public void setusername(String s){
        usernameTextField.setText(s);
    }
    public void setpassword(String s){
        passwordField.setText(s);
    }
}
