package ch01.ex05;

/**
 * jdk1.8.0_112 sample/webservices/EbayClient/src/ebay/client/MainGUIApp.java
 * ラムダ式に置き換え
 * Created by mary-mogreen.
 */
/*
 * MainGUIApp.java
 *
 * Created on August 2, 2006, 8:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

// package ebay.client;

/**
 *
 * @author Elancheran
 */

//import ebay.apis.*;
//import ebay.client.handler.RequesterCredentials;
//
//import javax.swing.*;
//import javax.xml.ws.BindingProvider;
//import javax.xml.ws.handler.Handler;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//import java.util.Properties;
//import java.util.Vector;
//
//public class MainGUIApp2 extends JFrame{
//
//    private static final String baseURL = "https://api.ebay.com/wsapi?";
//
//    private static final String localURL = "http://localhost:7070/Ebay";
//
//    private static final String sandboxURL = "https://api.sandbox.ebay.com/wsapi?";
//    private static Properties props = new Properties();
//    private static CustomSecurityHeaderType header;
//
//
//    private java.awt.image.BufferedImage image = null;
//    private String itemDetailString;
//    private String itemId;
//    private String[] details = new String[5];
//    private String[] values = new String[5];
//    private String desc;
//
//    private boolean multiTabView = false;
//
//
//    /** Creates a new instance of MainGUIApp */
//    public MainGUIApp2() {
//        super("Web Services Ebay Client");
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            if(System.getProperty("http.proxyHost") != null &&
//                    System.getProperty("http.proxyPort") != null)
//            {
//                this.proxyHostString = System.getProperty("http.proxyHost");
//                this.proxyPortString = System.getProperty("http.proxyPort");
//            }
//
//        }catch(Exception e) {
//        }
//
//        initComponents();
//    }
//
//    public static ItemType getItem(String endpointToUse, String itemId) {
//        boolean error = false;
//        String endpointURL = "";
//        EBayAPIInterfaceService svc = new EBayAPIInterfaceService();
//        EBayAPIInterface port = svc.getEBayAPI();
//
//
//        BindingProvider bp = (BindingProvider) port;
//        if (endpointToUse.equalsIgnoreCase("ebay")) {
//            endpointURL =  baseURL + "callname=GetItem&siteid=0&appid=" +
//                    (String)props.get("appID") + "&version=455&Routing=new";
//            List<Handler> handlerChain = new Vector();
//            handlerChain.add(new RequesterCredentials());
//            bp.getBinding().setHandlerChain(handlerChain);
//        }
//        else if(endpointToUse.equalsIgnoreCase("local")) {
//            endpointURL = localURL;
//        }
//        else {
//            System.exit(1);
//        }
//        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
//                endpointURL);
//        GetItemRequestType itemRequest = new GetItemRequestType();
//        itemRequest.setVersion("455");
//
//        itemRequest.setItemID(itemId);
//        itemRequest.setErrorLanguage("en_US");
//        GetItemResponseType itemResponse = null;
//        try {
//            itemResponse = port.getItem(itemRequest);
//        }catch (Exception e) {
//            error = true;
//        }
//        if (error) {
//            return null;
//        }
//        else
//            return itemResponse.getItem();
//
//    }
//
//    public static void setProxyHost(String proxyHost){
//        proxyHostString = proxyHost;
//    }
//
//    public static void setProxyPort(String proxyPort){
//        proxyPortString = proxyPort;
//    }
//
//    public static String getProxyPort() {
//        return proxyPortString;
//    }
//
//    public static String getProxyHost() {
//        return proxyHostString;
//    }
//
//    private void initComponents() {
//        jPanel2 = new JPanel();
//        jPanel2.setBackground(new java.awt.Color(236,233,216));
//        jTextField1 = new JTextField();
//        jComboBox1 = new JComboBox();
//        jLabel1 = new JLabel();
//        jLabel2 = new JLabel();
//        jPanel3 = new JPanel();
//        jPanel3.setBackground(new java.awt.Color(236,233,216));
//        jButton1 = new JButton();
//        jMenuBar1 = new JMenuBar();
//        jMenu1 = new JMenu();
//        jMenu2 = new JMenu();
//        jMenuItem1 = new JMenuItem();
//        jMenu3 = new JMenu();
//        jMenuItem2 = new JMenuItem();
//
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setResizable(false);
//        getContentPane().setBackground(new java.awt.Color(236, 233, 216));
//
//        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 12));
//        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Ebay Server", "Local Server" }));
//        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12));
//        jLabel1.setText("Item Id");
//        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12));
//        jLabel2.setText("Server");
//
//        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
//        jPanel2.setLayout(jPanel2Layout);
//        jPanel2Layout.setHorizontalGroup(
//                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
//                                .addGap(50, 50, 50)
//                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
//                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                        .addComponent(jComboBox1, 0, 113, Short.MAX_VALUE)
//                                        .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
//                                .addContainerGap())
//        );
//        jPanel2Layout.setVerticalGroup(
//                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel2Layout.createSequentialGroup()
//                                .addGap(23, 23, 23)
//                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jLabel1)
//                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                                .addGap(15, 15, 15)
//                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jLabel2)
//                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//                                .addContainerGap(22, Short.MAX_VALUE))
//        );
//
//        jButton1.setFont(new java.awt.Font("Verdana", 0, 12));
//        jButton1.setText("Get Details");
//        jButton1.setMnemonic('G');
//        jButton1.addActionListener(this::jButton1ActionPerformed); // ここ
//
//        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
//        jPanel3.setLayout(jPanel3Layout);
//        jPanel3Layout.setHorizontalGroup(
//                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel3Layout.createSequentialGroup()
//                                .addGap(164, 164, 164)
//                                .addComponent(jButton1)
//                                .addContainerGap(164, Short.MAX_VALUE))
//        );
//        jPanel3Layout.setVerticalGroup(
//                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel3Layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(jButton1)
//                                .addContainerGap(86, Short.MAX_VALUE))
//        );
//
//        jMenu1.setText("File");
//        jMenu1.setMnemonic('F');
//
//        jMenuItem1.setText("Exit");
//        jMenu1.add(jMenuItem1);
//        jMenuItem1.setMnemonic('x');
//
//        jMenuItem1.addActionListener(ae -> exitApplication()); // ここ
//
//        jMenuBar1.add(jMenu1);
//
//        jMenu3.setText("Edit");
//        jMenu3.setMnemonic('E');
//        jMenuItem2.setText("Preferences");
//        jMenuItem2.setMnemonic('P');
//        jMenuItem2.addActionListener(ae -> showPreferencesDialog()); // ここ
//
//        jMenu3.add(jMenuItem2);
//        jMenuBar1.add(jMenu3);
//        setJMenuBar(jMenuBar1);
//
//        GroupLayout layout = new GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGap(76, 76, 76)
//                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(93, Short.MAX_VALUE))
//                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGap(80, 80, 80)
//                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//        );
//        pack();
//    }// </editor-fold>
//
//    public static void showMessageDialog(final java.awt.Container parent,
//                                         final String msg, final String title) {
//        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(parent, msg, title,
//                        JOptionPane.WARNING_MESSAGE)); // ここ
//    }
//
//    private void jButton1ActionPerformed(ActionEvent evt) {
//        // TODO add your handling code here:
//        String currency = null;
//
//        Object source = evt.getSource();
//        if( source == jButton1 ) {
//            String str = (String) jComboBox1.getSelectedItem();
//            if( str.equals("Ebay Server")){
//                if( this.proxyHostString != null && this.proxyPortString != null ){
//                    System.setProperty("http.proxyHost", this.proxyHostString);
//                    System.setProperty("http.proxyPort", this.proxyPortString);
//                    System.setProperty("https.proxyHost", this.proxyHostString);
//                    System.setProperty("https.proxyPort", this.proxyPortString);
//                }
//            }
//
//            String itemId = jTextField1.getText();
//            if(itemId == null || itemId.equals("")) {
//                showMessageDialog(jPanel2, "Please enter the ItemId...", "ItemId Required...");
//            } else {
//                this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
//                if(str.equals("Ebay Server"))
//                    str = "ebay";
//                else
//                    str = "local";
//
//                ItemType item = getItem(str, itemId.trim());
//                if (item == null) {
//                    showMessageDialog(jPanel2, "Sorry there is no item found...", "Item Not Found...");
//                } else {
//                    new ViewItemDetails(itemId, item);
//                    jTextField1.setText("");
//                }
//                this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
//            }
//        }
//    }
//
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(() -> new MainGUIApp2().setVisible(true));
//    }
//
//    public void exitApplication() {
//        dispose();
//        System.exit(0);
//    }
//
//    public void showPreferencesDialog() {
//        SwingUtilities.invokeLater(() -> new SettingsDialog().setVisible(true));
//    }
//
//    class SettingsDialog extends JDialog
//            implements ActionListener {
//
//        public SettingsDialog() {
//            super((JFrame)MainGUIApp2.this, "Preferences...", true);
//            setLocationRelativeTo((JFrame)MainGUIApp2.this);
//            initComponents();
//            createGUI();
//        }
//
//        private void initComponents(){
//
//            jTabbedPane1 = new JTabbedPane();
//            proxySettingsPanel = new JPanel();
//            directRadioButton = new JRadioButton();
//            proxyRadioButton = new JRadioButton();
//            proxyHostLabel = new JLabel();
//            proxyHostTxtField = new JTextField();
//            proxyPortLabel = new JLabel();
//            proxyPortTxtField = new JTextField();
//
//            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//            setResizable(false);
//
//            proxyHostLabel.setFont(new java.awt.Font("Verdana", 0, 12));
//            proxyPortLabel.setFont(new java.awt.Font("Verdana", 0, 12));
//            directRadioButton.setFont(new java.awt.Font("Verdana", 0, 12));
//            proxyRadioButton.setFont(new java.awt.Font("Verdana", 0, 12));
//
//            if(MainGUIApp2.getProxyHost() != null
//                    && MainGUIApp2.getProxyPort() != null) {
//                proxyRadioButton.setSelected(true);
//                proxyHostTxtField.setText(MainGUIApp2.getProxyHost());
//                proxyPortTxtField.setText(MainGUIApp2.getProxyPort());
//            } else {
//                directRadioButton.setSelected(true);
//                proxyPortTxtField.setEnabled(false);
//                proxyHostTxtField.setEnabled(false);
//            }
//
//            jTabbedPane1.setToolTipText("Proxy Settings...");
//            jTabbedPane1.setName("Network");
//            directRadioButton.setText("Direct Internet Connection");
//            //directRadioButton.setSelected(true);
//            directRadioButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
//            directRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
//            directRadioButton.addActionListener(this);
//
//            proxyRadioButton.setText("User Network HTTP Proxy Settings");
//            proxyRadioButton.setToolTipText("Network Proxy Required...");
//            proxyRadioButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
//            proxyRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
//            proxyRadioButton.setName("proxyRadioButton");
//            proxyRadioButton.addActionListener(this);
//
//            ButtonGroup networkButtonGroup = new ButtonGroup();
//            networkButtonGroup.add(directRadioButton);
//            networkButtonGroup.add(proxyRadioButton);
//
//            proxyHostLabel.setText("Proxy Host");
//
//            proxyPortLabel.setText("Port");
//
//            bottomPanel = new JPanel();
//            cancel = new JButton();
//            ok = new JButton();
//            cancel.setText("Cancel");
//            cancel.setMnemonic('C');
//            ok.setText("Ok");
//            ok.setMnemonic('O');
//
//            ok.addActionListener(this);
//            cancel.addActionListener(this);
//
//        }
//
//        private void createGUI() {
//
//            GroupLayout proxySettingsPanelLayout = new GroupLayout(proxySettingsPanel);
//            proxySettingsPanel.setLayout(proxySettingsPanelLayout);
//            proxySettingsPanelLayout.setHorizontalGroup(
//                    proxySettingsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                            .addGroup(proxySettingsPanelLayout.createSequentialGroup()
//                                    .addGap(38, 38, 38)
//                                    .addGroup(proxySettingsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                            .addGroup(proxySettingsPanelLayout.createSequentialGroup()
//                                                    .addGroup(proxySettingsPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
//                                                            .addComponent(proxyPortLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                            .addComponent(proxyHostLabel, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
//                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                                    .addGroup(proxySettingsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                                            .addComponent(proxyPortTxtField, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
//                                                            .addComponent(proxyHostTxtField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
//                                            .addComponent(proxyRadioButton)
//                                            .addComponent(directRadioButton))
//                                    .addContainerGap(54, Short.MAX_VALUE))
//            );
//            proxySettingsPanelLayout.setVerticalGroup(
//                    proxySettingsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                            .addGroup(proxySettingsPanelLayout.createSequentialGroup()
//                                    .addGap(19, 19, 19)
//                                    .addComponent(directRadioButton)
//                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                                    .addComponent(proxyRadioButton)
//                                    .addGap(18, 18, 18)
//                                    .addGroup(proxySettingsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                            .addComponent(proxyHostTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                            .addComponent(proxyHostLabel))
//                                    .addGap(14, 14, 14)
//                                    .addGroup(proxySettingsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                            .addComponent(proxyPortTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                            .addComponent(proxyPortLabel))
//                                    .addContainerGap(38, Short.MAX_VALUE))
//            );
//            jTabbedPane1.addTab("Network", proxySettingsPanel);
//
//            getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
//            jTabbedPane1.getAccessibleContext().setAccessibleName("Widnow Settings");
//
//            GroupLayout bottomPanelLayout = new GroupLayout(bottomPanel);
//            bottomPanel.setLayout(bottomPanelLayout);
//            bottomPanelLayout.setHorizontalGroup(
//                    bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                            .addGroup(GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
//                                    .addContainerGap(175, Short.MAX_VALUE)
//                                    .addComponent(ok)
//                                    .addGap(14, 14, 14)
//                                    .addComponent(cancel)
//                                    .addContainerGap())
//            );
//            bottomPanelLayout.setVerticalGroup(
//                    bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                            .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                    .addComponent(ok, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
//            );
//            getContentPane().add(bottomPanel, java.awt.BorderLayout.SOUTH);
//            pack();
//        }// </editor-fold>
//
//        public void actionPerformed(ActionEvent ae) {
//            Object source = ae.getSource();
//            if(ok == source && proxyRadioButton.isSelected()) {
//                String hostName = proxyHostTxtField.getText();
//                String port = proxyPortTxtField.getText();
//                if( hostName.equals("") || port.equals("")) {
//                    MainGUIApp2.showMessageDialog(this,
//                            "Enter the proxy host/port properly...",
//                            "Proxy Details Required...");
//                } else {
//                    MainGUIApp2.setProxyHost(hostName.trim());
//                    MainGUIApp2.setProxyPort(port.trim());
//                    System.setProperty("http.proxyHost", hostName.trim());
//                    System.setProperty("http.proxyPort", port.trim());
//                    System.setProperty("https.proxyHost", hostName.trim());
//                    System.setProperty("https.proxyPort", port.trim());
//                    dispose();
//                }
//                //dispose();
//            } else if( source == ok) {
//                dispose();
//            }
//
//            if( cancel == source ) {
//                dispose();
//            }
//            if(source == directRadioButton) {
//                proxyPortTxtField.setEnabled(false);
//                proxyHostTxtField.setEnabled(false);
//                System.setProperty("http.proxyHost", "");
//                System.setProperty("http.proxyPort", "");
//            }
//
//            if(source == proxyRadioButton){
//                proxyPortTxtField.setEnabled(true);
//                proxyHostTxtField.setEnabled(true);
//            }
//
//        }
//        //Settings Dialog Variables
//        private JRadioButton directRadioButton;
//        private JPanel proxySettingsPanel;
//        private JTabbedPane jTabbedPane1;
//        private JLabel proxyHostLabel;
//        private JTextField proxyHostTxtField;
//        private JLabel proxyPortLabel;
//        private JTextField proxyPortTxtField;
//        private JRadioButton proxyRadioButton;
//        private JPanel bottomPanel;
//        private JButton cancel;
//        private JButton ok;
//
//    }
//    // Variables declaration - do not modify
//    private JMenu jMenu1;
//    private JMenu jMenu2;
//    private JMenu jMenu3;
//    private JMenuBar jMenuBar1;
//    private JMenuItem jMenuItem1;
//    private JMenuItem jMenuItem2;
//    private JButton jButton1;
//    private JComboBox jComboBox1;
//    private JLabel jLabel1;
//    private JLabel jLabel2;
//    private JPanel jPanel2;
//    private JPanel jPanel3;
//    private JTextField jTextField1;
//    // End of variables declaration
//
//    private static String proxyHostString = null;
//    private static String proxyPortString = null;
//
//}

