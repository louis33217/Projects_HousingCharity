/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.EcoSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Lingfeng
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private CardLayout layout;
    private EcoSystem system;
    private Network network;
    private Network clientNetwork;
    private Enterprise enterprise;
    private Organization organization;
    private int type = 0;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    public MainJFrame() {
        initComponents();
        system = dB4OUtil.retrieveSystem();
        this.setSize(1500, 800);
        clientNetwork = system.getClientNetwork();
        populateTree();
        layout=(CardLayout)container.getLayout();
    }

    public void populateTree() {
        DefaultTreeModel model=(DefaultTreeModel)networkTree.getModel();
        ArrayList<Network> networkList=system.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        
        root.insert(new DefaultMutableTreeNode(clientNetwork), 0);
        for(int i=0;i<networkList.size();i++){
            network=networkList.get(i);
            networkNode=new DefaultMutableTreeNode(network);
            root.insert(networkNode, i+1);
            
            enterpriseList=network.getEnterpriseDirectory().getEnterpriseList();
            for(int j=0; j<enterpriseList.size();j++){
                enterprise=enterpriseList.get(j);
                enterpriseNode=new DefaultMutableTreeNode(enterprise);
                networkNode.insert(enterpriseNode, j);
                
                organizationList=enterprise.getOrganizationDirectory().getOrganizationList();
                for(int k=0;k<organizationList.size();k++){
                    organization=organizationList.get(k);
                    organizationNode=new DefaultMutableTreeNode(organization);
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
        model.reload();
    }
    
    public void loginPerform() {
        loginJButton.setEnabled(false);
        loginJButton.setBorderPainted(false);
        logoutJButton.setEnabled(true);
        registerButton.setEnabled(false);
        userNameJTextField.setEnabled(false);
        passwordField.setEnabled(false);
        networkTree.setEnabled(false);
    }
    
    public void logoutPerform() {
        System.out.println("userinterface.MainJFrame.logoutPerform()");
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);
        loginJButton.setBorderPainted(true);
        registerButton.setEnabled(true);
        networkTree.setEnabled(true);
        logoutJButton.setText("Logout");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        loginJButton = new javax.swing.JButton();
        userNameJTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginJLabel = new javax.swing.JLabel();
        logoutJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        networkTree = new javax.swing.JTree(new DefaultMutableTreeNode("Networks"));
        registerButton = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        defaultjPanel = new javax.swing.JPanel();
        welcomeLable = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TeamName final project application demo ");
        setIconImages(null);
        setLocation(new java.awt.Point(300, 150));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));

        jSplitPane1.setDividerLocation(190);
        jSplitPane1.setDividerSize(3);
        jSplitPane1.setMaximumSize(new java.awt.Dimension(800, 500));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(200, 800));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(200, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 800));

        loginJButton.setBackground(new java.awt.Color(204, 255, 204));
        loginJButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        loginJButton.setText("Login");
        loginJButton.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 255, 51)));
        loginJButton.setContentAreaFilled(false);
        loginJButton.setMaximumSize(new java.awt.Dimension(100, 100));
        loginJButton.setMinimumSize(new java.awt.Dimension(100, 100));
        loginJButton.setOpaque(true);
        loginJButton.setPreferredSize(new java.awt.Dimension(100, 100));
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password :");

        logoutJButton.setBackground(new java.awt.Color(255, 51, 51));
        logoutJButton.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        networkTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                networkTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(networkTree);

        registerButton.setBackground(new java.awt.Color(0, 153, 255));
        registerButton.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        registerButton.setText("Sign Up");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(userNameJTextField)
                        .addComponent(passwordField)
                        .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(loginJLabel)
                    .addComponent(logoutJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(logoutJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(registerButton)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);

        container.setBackground(new java.awt.Color(153, 153, 153));
        container.setMaximumSize(new java.awt.Dimension(650, 650));
        container.setLayout(new java.awt.CardLayout());

        defaultjPanel.setBackground(new java.awt.Color(204, 204, 255));
        defaultjPanel.setMaximumSize(new java.awt.Dimension(1300, 800));
        defaultjPanel.setMinimumSize(new java.awt.Dimension(1300, 800));
        defaultjPanel.setPreferredSize(new java.awt.Dimension(1300, 800));

        welcomeLable.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        welcomeLable.setText("Hi, are you new to our service? ");

        jTextArea1.setBackground(new java.awt.Color(204, 255, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("This is a matching system for patients who can't afford housing while looking for long or short term medical treatment \nRooms are provided by lovely people at no cost.\n\nYou might want to sign up an account for applying a free room.\n\nRoom provided will be under approval.\nOnce approved, your room will be in the matching waitlist.");
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout defaultjPanelLayout = new javax.swing.GroupLayout(defaultjPanel);
        defaultjPanel.setLayout(defaultjPanelLayout);
        defaultjPanelLayout.setHorizontalGroup(
            defaultjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultjPanelLayout.createSequentialGroup()
                .addGroup(defaultjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(defaultjPanelLayout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(welcomeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(defaultjPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(318, Short.MAX_VALUE))
        );
        defaultjPanelLayout.setVerticalGroup(
            defaultjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultjPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(welcomeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
        );

        container.add(defaultjPanel, "card2");

        jSplitPane1.setRightComponent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // Get user name
        String userName = userNameJTextField.getText();
        // Get Password
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        UserAccount userAccount = null;
        Enterprise inEnterprise=null;
        Organization inOrganization=null;
        if (type == 1) {
            userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
            inEnterprise = enterprise;
        } else if (type == 2) {
            userAccount=organization.getUserAccountDirectory().authenticateUser(userName, password);
            inEnterprise = enterprise;
            inOrganization = organization;
        } else if (type == 3) {
            userAccount=organization.getUserAccountDirectory().authenticateUser(userName, password);
            inEnterprise = enterprise;
            inOrganization = organization;
        } else {
            userAccount=system.getUserAccountDirectory().authenticateUser(userName, password);
        }
//        int selectedType = typeJComboBox.getSelectedIndex();
//        
//        if (selectedType == 0) {
//            userAccount=system.getUserAccountDirectory().authenticateUser(userName, password);
//        }
//        
//        if(userAccount==null){
//            //Step 2: Go inside each network and check each enterprise
//            for(Network network:system.getNetworkList()){
//                //Step 2.a: check against each enterprise
//                for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
//                        userAccount=enterprise.getUserAccountDirectory().authenticateUser(userName, password);
//
//                    if(userAccount==null){
//                       //Step 3:check against each organization for each enterprise
//                       for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
//                                userAccount=organization.getUserAccountDirectory().authenticateUser("rrr", "rrr");
//                           if(userAccount!=null){
//                               inEnterprise=enterprise;
//                               inOrganization=organization;
//                               break;
//                           }
//                       }
//                    }
//                    else{
//                       inEnterprise=enterprise;
//                       break;
//                    }
//                    if(inOrganization!=null){
//                        break;
//                    }
//                }
//                if(inEnterprise!=null){
//                    break;
//                }
//            }
//        }
        
        if(userAccount==null){
            JOptionPane.showMessageDialog(null, "Invalid credentials");
            return;
        }
        else{
            container.add("workArea",userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, system, network));
            layout.next(container);
        }
        
        loginPerform();
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutPerform();
        userNameJTextField.setText("");
        passwordField.setText("");

        container.removeAll();
        container.add("defaultjPanel", defaultjPanel);
        layout.next(container);
        dB4OUtil.storeSystem(system);
        populateTree();
    }//GEN-LAST:event_logoutJButtonActionPerformed

    private void networkTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_networkTreeValueChanged
        // TODO add your handling code here:
        welcomeLable.setText("");
        DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)networkTree.getLastSelectedPathComponent();
        if (selectedNode == null) {
            return;
        }
        Object o = selectedNode.getUserObject();
        String welcome = "Welcome ";
        if (o.equals(clientNetwork)) {
            network = clientNetwork;
            enterprise = network.getEnterpriseDirectory().getEnterpriseList().get(0);
            organization = enterprise.getOrganizationDirectory().getOrganizationList().get(0);
            welcome += "Client";
            type = 3;
        } else if (o instanceof Enterprise) {
            enterprise = (Enterprise) o;
            welcome += "Enterprise Admin";
            type = 1;
        } else if (o instanceof Organization) {
            organization = (Organization) o;
            DefaultMutableTreeNode organizationParent = (DefaultMutableTreeNode)selectedNode.getParent();
            enterprise = (Enterprise) organizationParent.getUserObject();
            DefaultMutableTreeNode enterpriseParent = (DefaultMutableTreeNode)organizationParent.getParent();
            network = (Network) enterpriseParent.getUserObject();
            welcome += "Enterprise Employee";
            type = 2;
        } else {
            welcome += "System Admin";
            type = 0;
        }
        welcomeLable.setText(welcome);
    }//GEN-LAST:event_networkTreeValueChanged

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        loginPerform();
        logoutJButton.setText("Cancel");
        CardLayout layout = (CardLayout) container.getLayout();
        container.add("NewClientJPanel", new NewClientJPanel(container, clientNetwork, logoutJButton));
        layout.next(container);
    }//GEN-LAST:event_registerButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JPanel defaultjPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton loginJButton;
    private javax.swing.JLabel loginJLabel;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JTree networkTree;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField userNameJTextField;
    private javax.swing.JLabel welcomeLable;
    // End of variables declaration//GEN-END:variables
}
