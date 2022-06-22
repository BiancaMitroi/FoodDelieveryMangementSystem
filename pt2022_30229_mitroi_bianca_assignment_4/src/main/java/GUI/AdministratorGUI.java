package GUI;

//de adaugat ascultatori pe toate butoanele!!
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

public class AdministratorGUI {

//----------------------------------------ADMIN_FRAME-------------------------------------------------
    private JFrame adminFrame;
    private JButton createProductButton;
    private JButton updateProductButton;
    private JButton generateReportButton;
    private JButton backFromAdminButton;
    private JButton importProductsButton;
//----------------------------------------CREATE_PRODUCT_FRAME-------------------------------------------------
    private JFrame createProductframe;
    private JScrollPane createProductscrollPane;
    private JScrollPane createProductscrollPane_1;
    private JButton addToProductButton;
    private  JButton deleteFromProductButton;
    private JButton finishProductButton;
    private JButton backFromCreateProductButton;
    private JTable createProductTable;
    private JTable createProductTable_1;
//----------------------------------------UPDATE_PRODUCT_FRAME-------------------------------------------------
    private JFrame updateProductframe;
    private JTextField titleTextField;
    private JTextField ratingTextField;
    private JTextField proteinTextField;
    private JTextField caloriesTextField;
    private JTextField sodiumTextField;
    private JTextField fatTextField;
    private JTextField priceTextField;
    private JScrollPane updateProductScrollPane;
    private JButton modifyProductButton;
    private JButton backFromUpdateProductButton;
    private JTable updateItemTable;
    private JButton selectUpdateButton;
    private JButton deleteProductFromMenuButton;
    private JButton addBaseProductButton;
//----------------------------------------GENERATE_REPORT_FRAME-------------------------------------------------
    private JFrame generateReportframe;
    private JTextField numberOrdersPerProductTextField;
    private JTextField numberClientsTextField;
    private JTextField priceOrderTextField;
    private JScrollPane generateReportScrollPane;
    private JButton generateAfterDateButton;
    private  JComboBox yearComboBox;
    private JComboBox monthComboBox;
    private JComboBox dayComboBox;
    private JButton generateAfterClientsAndPriceButton;
    private JButton generateAfterNumberOrdersPerProductButton;
    private JButton generateAfterTimeButton;
    private JComboBox endTimeComboBox;
    private JComboBox startTimeComboBox;
    private JButton backFromGenerateReportButton;
    private JTable generateReportTable;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    AdministratorGUI window = new AdministratorGUI();
//                    window.adminFrame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the application.
     */
    public AdministratorGUI() {
//----------------------------------------ADMIN_FRAME-------------------------------------------------
        //initialization------------------------------------------------------------------------------
        {
            adminFrame = new JFrame();
            adminFrame.setBounds(100, 100, 267, 218);
            adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            adminFrame.getContentPane().setLayout(null);

            createProductButton = new JButton("Create to new product");
            createProductButton.setBounds(10, 36, 233, 23);
            adminFrame.getContentPane().add(createProductButton);

            updateProductButton = new JButton("Update an existing product");
            updateProductButton.setBounds(10, 70, 233, 23);
            adminFrame.getContentPane().add(updateProductButton);

            JLabel lblNewLabel_3_3 = new JLabel("");
            lblNewLabel_3_3.setBounds(172, 172, 49, 14);
            adminFrame.getContentPane().add(lblNewLabel_3_3);

            JLabel lblNewLabell = new JLabel("As the admin, what do you want to do?");
            lblNewLabell.setBounds(10, 11, 233, 14);
            adminFrame.getContentPane().add(lblNewLabell);

            generateReportButton = new JButton("Generate report");
            generateReportButton.setBounds(10, 104, 233, 23);
            adminFrame.getContentPane().add(generateReportButton);

            importProductsButton = new JButton("Import products from file");
            importProductsButton.setBounds(10, 147, 174, 23);
            adminFrame.getContentPane().add(importProductsButton);

            backFromAdminButton = new JButton("<-");
            backFromAdminButton.setBounds(194, 147, 49, 23);
            adminFrame.getContentPane().add(backFromAdminButton);
        }

//----------------------------------------CREATE_PRODUCT_FRAME-------------------------------------------------
        //initialization------------------------------------------------------------------------------
        {
            createProductframe = new JFrame();
            createProductframe.setBounds(100, 100, 419, 386);
            createProductframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            createProductframe.getContentPane().setLayout(null);

            JLabel lblNewLabel = new JLabel("Please select an existing product to add to your new one:");
            lblNewLabel.setBounds(10, 11, 354, 14);
            createProductframe.getContentPane().add(lblNewLabel);

            JLabel lblNewLabel_1 = new JLabel("This is the available ");
            lblNewLabel_1.setBounds(10, 36, 189, 14);
            createProductframe.getContentPane().add(lblNewLabel_1);

            JLabel lblNewLabel_2 = new JLabel("This is the product ");
            lblNewLabel_2.setBounds(207, 36, 219, 14);
            createProductframe.getContentPane().add(lblNewLabel_2);

            createProductscrollPane = new JScrollPane();
            createProductscrollPane.setBounds(10, 74, 189, 191);
            createProductframe.getContentPane().add(createProductscrollPane);

            createProductTable = new JTable();
            createProductTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            createProductscrollPane.setViewportView(createProductTable);

            createProductscrollPane_1 = new JScrollPane();
            createProductscrollPane_1.setBounds(207, 74, 189, 191);
            createProductframe.getContentPane().add(createProductscrollPane_1);

            createProductTable_1 = new JTable();
            createProductTable_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            createProductscrollPane_1.setViewportView(createProductTable_1);

            addToProductButton = new JButton("Add to my product");
            addToProductButton.setBounds(10, 276, 189, 23);
            createProductframe.getContentPane().add(addToProductButton);

            deleteFromProductButton = new JButton("Delete from my product");
            deleteFromProductButton.setBounds(207, 276, 189, 23);
            createProductframe.getContentPane().add(deleteFromProductButton);

            finishProductButton = new JButton("Finish");
            finishProductButton.setBounds(10, 316, 89, 23);
            createProductframe.getContentPane().add(finishProductButton);

            backFromCreateProductButton = new JButton("<-");
            backFromCreateProductButton.setBounds(350, 32, 45, 23);
            createProductframe.getContentPane().add(backFromCreateProductButton);

            JLabel lblNewLabel_3 = new JLabel("list of products:");
            lblNewLabel_3.setBounds(10, 49, 108, 14);
            createProductframe.getContentPane().add(lblNewLabel_3);

            JLabel lblNewLabel_3_1 = new JLabel("you have created:");
            lblNewLabel_3_1.setBounds(206, 49, 134, 14);
            createProductframe.getContentPane().add(lblNewLabel_3_1);
        }

//----------------------------------------UPDATE_PRODUCT_FRAME-------------------------------------------------
        //initialization------------------------------------------------------------------------------
        {
            updateProductframe = new JFrame();
            updateProductframe.setBounds(100, 100, 545, 300);
            updateProductframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            updateProductframe.getContentPane().setLayout(null);

            updateProductScrollPane = new JScrollPane();
            updateProductScrollPane.setBounds(10, 63, 187, 189);
            updateProductframe.getContentPane().add(updateProductScrollPane);

            updateItemTable = new JTable();
            updateItemTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            updateProductScrollPane.setViewportView(updateItemTable);

            JLabel lblNewLabelll = new JLabel("What do you want to modify in the menu?");
            lblNewLabelll.setBounds(10, 11, 402, 14);
            updateProductframe.getContentPane().add(lblNewLabelll);

            JLabel lblNewLabelll_1 = new JLabel("Please select the product you want to modify from the available list of products:");
            lblNewLabelll_1.setBounds(10, 36, 492, 14);
            updateProductframe.getContentPane().add(lblNewLabelll_1);

            JLabel lblNewLabelll_2 = new JLabel("The product you have selected:");
            lblNewLabelll_2.setBounds(207, 63, 205, 14);
            updateProductframe.getContentPane().add(lblNewLabelll_2);

            JLabel theProductToUpdate = new JLabel("");
            theProductToUpdate.setBounds(207, 88, 295, 14);
            updateProductframe.getContentPane().add(theProductToUpdate);

            JLabel lblNewLabelll_4 = new JLabel("Title:");
            lblNewLabelll_4.setBounds(207, 113, 49, 14);
            updateProductframe.getContentPane().add(lblNewLabelll_4);

            JLabel lblNewLabelll_4_1 = new JLabel("Rating:");
            lblNewLabelll_4_1.setBounds(207, 138, 49, 14);
            updateProductframe.getContentPane().add(lblNewLabelll_4_1);

            JLabel lblNewLabelll_4_2 = new JLabel("Calories:");
            lblNewLabelll_4_2.setBounds(207, 163, 62, 14);
            updateProductframe.getContentPane().add(lblNewLabelll_4_2);

            JLabel lblNewLabelll_4_3 = new JLabel("Protein:");
            lblNewLabelll_4_3.setBounds(207, 188, 49, 14);
            updateProductframe.getContentPane().add(lblNewLabelll_4_3);

            JLabel lblNewLabelll_4_4 = new JLabel("Fat:");
            lblNewLabelll_4_4.setBounds(363, 113, 49, 14);
            updateProductframe.getContentPane().add(lblNewLabelll_4_4);

            JLabel lblNewLabelll_4_5 = new JLabel("Sodium:");
            lblNewLabelll_4_5.setBounds(363, 138, 49, 14);
            updateProductframe.getContentPane().add(lblNewLabelll_4_5);

            JLabel lblNewLabelll_4_6 = new JLabel("Price:");
            lblNewLabelll_4_6.setBounds(363, 163, 49, 14);
            updateProductframe.getContentPane().add(lblNewLabelll_4_6);

            titleTextField = new JTextField();
            titleTextField.setBounds(266, 113, 96, 20);
            updateProductframe.getContentPane().add(titleTextField);
            titleTextField.setColumns(10);

            ratingTextField = new JTextField();
            ratingTextField.setColumns(10);
            ratingTextField.setBounds(266, 135, 96, 20);
            updateProductframe.getContentPane().add(ratingTextField);

            proteinTextField = new JTextField();
            proteinTextField.setColumns(10);
            proteinTextField.setBounds(266, 182, 96, 20);
            updateProductframe.getContentPane().add(proteinTextField);

            caloriesTextField = new JTextField();
            caloriesTextField.setColumns(10);
            caloriesTextField.setBounds(266, 160, 96, 20);
            updateProductframe.getContentPane().add(caloriesTextField);

            sodiumTextField = new JTextField();
            sodiumTextField.setColumns(10);
            sodiumTextField.setBounds(422, 135, 96, 20);
            updateProductframe.getContentPane().add(sodiumTextField);

            fatTextField = new JTextField();
            fatTextField.setColumns(10);
            fatTextField.setBounds(422, 110, 96, 20);
            updateProductframe.getContentPane().add(fatTextField);

            priceTextField = new JTextField();
            priceTextField.setColumns(10);
            priceTextField.setBounds(422, 160, 96, 20);
            updateProductframe.getContentPane().add(priceTextField);

            modifyProductButton = new JButton("Modify");
            modifyProductButton.setBounds(432, 187, 89, 23);
            updateProductframe.getContentPane().add(modifyProductButton);

            backFromUpdateProductButton = new JButton("<-");
            backFromUpdateProductButton.setBounds(472, 7, 49, 23);
            updateProductframe.getContentPane().add(backFromUpdateProductButton);

            selectUpdateButton = new JButton("Select");
            selectUpdateButton.setBounds(207, 213, 89, 23);
            updateProductframe.getContentPane().add(selectUpdateButton);

            deleteProductFromMenuButton = new JButton("Delete");
            deleteProductFromMenuButton.setBounds(429, 221, 89, 23);
            updateProductframe.getContentPane().add(deleteProductFromMenuButton);

            addBaseProductButton = new JButton("Add");
            addBaseProductButton.setBounds(306, 213, 89, 23);
            updateProductframe.getContentPane().add(addBaseProductButton);
        }

//----------------------------------------GENERATE_REPORT_FRAME-------------------------------------------------
        //initialization------------------------------------------------------------------------------
        {
            generateReportframe = new JFrame();
            generateReportframe.setBounds(100, 100, 771, 211);
            generateReportframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            generateReportframe.getContentPane().setLayout(null);

            JLabel lblNewLabellll = new JLabel("What is the criteria of your report?");
            lblNewLabellll.setBounds(10, 11, 416, 14);
            generateReportframe.getContentPane().add(lblNewLabellll);

            JLabel lblNewLabellll_1 = new JLabel("Time interval:");
            lblNewLabellll_1.setBounds(10, 36, 98, 14);
            generateReportframe.getContentPane().add(lblNewLabellll_1);

            startTimeComboBox = new JComboBox();
            startTimeComboBox.setBounds(102, 32, 52, 22);
            generateReportframe.getContentPane().add(startTimeComboBox);

            endTimeComboBox = new JComboBox();
            endTimeComboBox.setBounds(194, 32, 52, 22);
            generateReportframe.getContentPane().add(endTimeComboBox);
            for(int i = 0; i < 24; i++){
                startTimeComboBox.addItem(i);
                endTimeComboBox.addItem(i);
            }

            JLabel lblNewLabellll_2 = new JLabel("to");
            lblNewLabellll_2.setBounds(164, 36, 49, 14);
            generateReportframe.getContentPane().add(lblNewLabellll_2);

            JLabel lblNewLabellll_3 = new JLabel("Products ordered more than ");
            lblNewLabellll_3.setBounds(10, 64, 187, 14);
            generateReportframe.getContentPane().add(lblNewLabellll_3);

            numberOrdersPerProductTextField = new JTextField();
            numberOrdersPerProductTextField.setBounds(212, 61, 34, 20);
            generateReportframe.getContentPane().add(numberOrdersPerProductTextField);
            numberOrdersPerProductTextField.setColumns(10);

            generateAfterTimeButton = new JButton("Generate");
            generateAfterTimeButton.setBounds(256, 32, 88, 23);
            generateReportframe.getContentPane().add(generateAfterTimeButton);

            generateAfterNumberOrdersPerProductButton = new JButton("Generate");
            generateAfterNumberOrdersPerProductButton.setBounds(256, 60, 88, 23);
            generateReportframe.getContentPane().add(generateAfterNumberOrdersPerProductButton);

            JLabel lblNewLabellll_4 = new JLabel("Clients that ordered more than");
            lblNewLabellll_4.setBounds(10, 92, 187, 14);
            generateReportframe.getContentPane().add(lblNewLabellll_4);

            numberClientsTextField = new JTextField();
            numberClientsTextField.setColumns(10);
            numberClientsTextField.setBounds(212, 89, 34, 20);
            generateReportframe.getContentPane().add(numberClientsTextField);

            JLabel lblNewLabellll_5 = new JLabel("and order price was higher than");
            lblNewLabellll_5.setBounds(10, 117, 215, 14);
            generateReportframe.getContentPane().add(lblNewLabellll_5);

            priceOrderTextField = new JTextField();
            priceOrderTextField.setColumns(10);
            priceOrderTextField.setBounds(212, 114, 34, 20);
            generateReportframe.getContentPane().add(priceOrderTextField);

            generateAfterClientsAndPriceButton = new JButton("Generate");
            generateAfterClientsAndPriceButton.setBounds(256, 113, 88, 23);
            generateReportframe.getContentPane().add(generateAfterClientsAndPriceButton);

            JLabel lblNewLabellll_6 = new JLabel("Date of order:");
            lblNewLabellll_6.setBounds(10, 142, 124, 14);
            generateReportframe.getContentPane().add(lblNewLabellll_6);

            dayComboBox = new JComboBox();
            dayComboBox.setBounds(102, 138, 42, 22);
            generateReportframe.getContentPane().add(dayComboBox);
            for(int i = 1; i < 32; i++){
                dayComboBox.addItem(i);
            }

            monthComboBox = new JComboBox();
            monthComboBox.setBounds(144, 138, 42, 22);
            generateReportframe.getContentPane().add(monthComboBox);
            for(int i = 1; i < 13; i++){
                monthComboBox.addItem(i);
            }

            yearComboBox = new JComboBox();
            yearComboBox.setBounds(186, 138, 60, 22);
            generateReportframe.getContentPane().add(yearComboBox);
            for(int i = 2000; i < 2023; i++){
                yearComboBox.addItem(i);
            }

            generateAfterDateButton = new JButton("Generate");
            generateAfterDateButton.setBounds(256, 138, 88, 23);
            generateReportframe.getContentPane().add(generateAfterDateButton);

            generateReportScrollPane = new JScrollPane();
            generateReportScrollPane.setBounds(354, 11, 393, 149);
            generateReportframe.getContentPane().add(generateReportScrollPane);

            generateReportTable = new JTable();
            generateReportTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            generateReportScrollPane.setViewportView(generateReportTable);

            backFromGenerateReportButton = new JButton("<-");
            backFromGenerateReportButton.setBounds(295, 7, 49, 23);
            generateReportframe.getContentPane().add(backFromGenerateReportButton);
        }
    }
    //methods_for_ADMIN_FRAME------------------------------------------------------------------------------
    public void addActionListenerOnCreateProductButton(ActionListener actionLstener){
        createProductButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnupdateProductButton(ActionListener actionLstener){
        updateProductButton.addActionListener(actionLstener);
    }
    public void addActionListenerOngenerateReportButton(ActionListener actionLstener){
        generateReportButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnbackFromAdminButton(ActionListener actionLstener){
        backFromAdminButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnImportProductsListener(ActionListener actionLstener){
        importProductsButton.addActionListener(actionLstener);
    }

    public JFrame getAdminFrame(){
        return this.adminFrame;
    }
    public JFrame getCreateProductframe(){
        return this.createProductframe;
    }
    public JFrame getUpdateProductframe(){
        return this.updateProductframe;
    }
    public JFrame getGenerateReportframe(){
        return this.generateReportframe;
    }

    //methods_for_CREATE_PRODUCT_FRAME------------------------------------------------------------------------------
    public void addActionListenerOnbackFromCreateProductButton(ActionListener actionLstener){
        backFromCreateProductButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnAddToProductButton(ActionListener actionLstener){
        addToProductButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnDeleteFromProductButton(ActionListener actionLstener){
        deleteFromProductButton.addActionListener(actionLstener);
    }

    public void addActionListenerOnFinishProductButton(ActionListener actionLstener){
        finishProductButton.addActionListener(actionLstener);
    }

    public String getSelectedTitle(){
        return this.createProductTable.getModel().getValueAt(createProductTable.getSelectedRow(), 0).toString();
    }
    public Double getSelectedRating(){
        return Double.parseDouble(this.createProductTable.getModel().getValueAt(createProductTable.getSelectedRow(), 1).toString());
    }
    public Integer getSelectedCalories(){
        return Integer.parseInt(this.createProductTable.getModel().getValueAt(createProductTable.getSelectedRow(), 2).toString());
    }
    public Integer getSelectedProtein(){
        return Integer.parseInt(this.createProductTable.getModel().getValueAt(createProductTable.getSelectedRow(), 3).toString());
    }
    public Integer getSelectedFat(){
        return Integer.parseInt(this.createProductTable.getModel().getValueAt(createProductTable.getSelectedRow(), 4).toString());
    }
    public Integer getSelectedSodium(){
        return Integer.parseInt(this.createProductTable.getModel().getValueAt(createProductTable.getSelectedRow(), 5).toString());
    }
    public Integer getSelectedPrice(){
        return Integer.parseInt(this.createProductTable.getModel().getValueAt(createProductTable.getSelectedRow(), 6).toString());
    }

    public String getSelectedTitle_1(){
        return this.createProductTable_1.getModel().getValueAt(createProductTable_1.getSelectedRow(), 0).toString();
    }
    public Double getSelectedRating_1(){
        return Double.parseDouble(this.createProductTable_1.getModel().getValueAt(createProductTable_1.getSelectedRow(), 1).toString());
    }
    public Integer getSelectedCalories_1(){
        return Integer.parseInt(this.createProductTable_1.getModel().getValueAt(createProductTable_1.getSelectedRow(), 2).toString());
    }
    public Integer getSelectedProtein_1(){
        return Integer.parseInt(this.createProductTable_1.getModel().getValueAt(createProductTable_1.getSelectedRow(), 3).toString());
    }
    public Integer getSelectedFat_1(){
        return Integer.parseInt(this.createProductTable_1.getModel().getValueAt(createProductTable_1.getSelectedRow(), 4).toString());
    }
    public Integer getSelectedSodium_1(){
        return Integer.parseInt(this.createProductTable_1.getModel().getValueAt(createProductTable_1.getSelectedRow(), 5).toString());
    }
    public Integer getSelectedPrice_1(){
        return Integer.parseInt(this.createProductTable_1.getModel().getValueAt(createProductTable_1.getSelectedRow(), 6).toString());
    }

    public void setCreateItemTable(TableModel tm){
        createProductTable.setModel(tm);
    }
    //methods_for_UPDATE_PRODUCT_FRAME--------------------------------------------------------------------------
    public void addActionListenerOnbackFromUpdateProductButton(ActionListener actionLstener){
        backFromUpdateProductButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnAddBaseProductButton(ActionListener actionLstener){
        addBaseProductButton.addActionListener(actionLstener);
    }
    public void addActionListenerOndeleteProductFromMenuButton(ActionListener actionLstener){
        deleteProductFromMenuButton.addActionListener(actionLstener);
    }
    public void addActionListenerOnModifyProductButton(ActionListener actionLstener){
        modifyProductButton.addActionListener(actionLstener);
    }
    public void setUpdateItemTable(TableModel tm){
        updateItemTable.setModel(tm);
    }

    //methods_for_GENERATE_REPORT_FRAME--------------------------------------------------------------------------
    public void addActionListenerOnbackFromGenerateReportButton(ActionListener actionLstener){
        backFromGenerateReportButton.addActionListener(actionLstener);
    }
    public void addActionListenerOngenerateAfterDateButton(ActionListener actionLstener){
        generateAfterDateButton.addActionListener(actionLstener);
    }
    public void addActionListenerOngenerateAfterClientsAndPriceButton(ActionListener actionLstener){
        generateAfterClientsAndPriceButton.addActionListener(actionLstener);
    }
    public void addActionListenerOngenerateAfterNumberOrdersPerProductButton(ActionListener actionLstener){
        generateAfterNumberOrdersPerProductButton.addActionListener(actionLstener);
    }
    public void addActionListenerOngenerateAfterTimeButton(ActionListener actionLstener){
        generateAfterTimeButton.addActionListener(actionLstener);
    }

    public JComboBox<Integer> getStartTimeComboBox(){
        return this.startTimeComboBox;
    }
    public JComboBox<Integer> getEndTimeComboBox(){
        return this.endTimeComboBox;
    }

    public void addSelectUpdateButton(ActionListener actionListener){
        selectUpdateButton.addActionListener(actionListener);
    }

    public Integer getnumberOrdersPerProductTextField(){
        return Integer.valueOf(numberOrdersPerProductTextField.getText());
    }
    //otherFunctions--------------------------------------------------------------------------------------------

    public JTable getUpdateItemTable(){
        return this.updateItemTable;
    }

    public JTable getCreateProductTable_1(){
        return this.createProductTable_1;
    }

    public JTable getCreateProductTable(){
        return this.createProductTable;
    }

    public void setCreateProductTable(TableModel tm){
        this.createProductTable.setModel(tm);
    }

    public void setCreateProductTable_1(TableModel tm){
        this.createProductTable_1.setModel(tm);
    }

    public String getTitleTextField() {
        return titleTextField.getText();
    }

    public void setTitleTextField(String titleTextField) {
        this.titleTextField.setText(titleTextField);
    }

    public double getRatingTextField() {
        return Double.parseDouble(ratingTextField.getText());
    }

    public void setRatingTextField(double ratingTextField) {
        this.ratingTextField.setText(String.valueOf(ratingTextField));
    }

    public int getProteinTextField() {
        return Integer.parseInt(proteinTextField.getText());
    }

    public void setProteinTextField(int proteinTextField) {
        this.proteinTextField.setText(String.valueOf(proteinTextField));
    }

    public int getCaloriesTextField() {
        return Integer.parseInt(caloriesTextField.getText());
    }

    public void setCaloriesTextField(int caloriesTextField) {
        this.caloriesTextField.setText(String.valueOf(caloriesTextField));
    }

    public int getSodiumTextField() {
        return Integer.parseInt(sodiumTextField.getText());
    }

    public void setSodiumTextField(int sodiumTextField) {
        this.sodiumTextField.setText(String.valueOf(sodiumTextField));
    }

    public int getFatTextField() {
        return Integer.parseInt(fatTextField.getText());
    }

    public void setFatTextField(int fatTextField) {
        this.fatTextField.setText(String.valueOf(fatTextField));
    }

    public int getPriceTextField() {
        return Integer.parseInt(priceTextField.getText());
    }

    public int getNumberClientsTextField() {
        return Integer.parseInt(numberClientsTextField.getText());
    }

    public Integer getOrderPriceTextField() {
        return Integer.parseInt(priceOrderTextField.getText().equals("") ? "0" : priceOrderTextField.getText());
    }

    public void setPriceTextField(int priceTextField) {
        this.priceTextField.setText(String.valueOf(priceTextField));
    }

    public void setUpdateFields(){
        this.setTitleTextField(updateItemTable.getModel().getValueAt(updateItemTable.getSelectedRow(), 0).toString());
        this.setRatingTextField(Double.parseDouble(updateItemTable.getModel().getValueAt(updateItemTable.getSelectedRow(), 1).toString()));
        this.setCaloriesTextField(Integer.parseInt(updateItemTable.getModel().getValueAt(updateItemTable.getSelectedRow(), 2).toString()));
        this.setProteinTextField(Integer.parseInt(updateItemTable.getModel().getValueAt(updateItemTable.getSelectedRow(), 3).toString()));
        this.setFatTextField(Integer.parseInt(updateItemTable.getModel().getValueAt(updateItemTable.getSelectedRow(), 4).toString()));
        this.setSodiumTextField(Integer.parseInt(updateItemTable.getModel().getValueAt(updateItemTable.getSelectedRow(), 5).toString()));
        this.setPriceTextField(Integer.parseInt(updateItemTable.getModel().getValueAt(updateItemTable.getSelectedRow(), 6).toString()));
    }

    public JTable getGenerateReportTable(){
        return this.generateReportTable;
    }

    public void setGenerateReportTable(TableModel tm){
        this.generateReportTable.setModel(tm);
    }

    public Integer getDayComboBox(){
        return (Integer) this.dayComboBox.getSelectedItem();
    }
    public Integer getMonthComboBox(){
        return (Integer) this.monthComboBox.getSelectedItem();
    }
    public Integer getYearComboBox(){
        return (Integer) this.yearComboBox.getSelectedItem();
    }

}

