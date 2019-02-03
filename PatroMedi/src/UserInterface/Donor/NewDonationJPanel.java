/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Donor;

import Buisness.EcoSystem;
import Buisness.Enterprise.Enterprise;
import Buisness.Network.Network;
import Buisness.UserAccount.UserAccount;
import Buisness.UserInfo.DonorInfo;
import Business.Charity.Donation.DonationDetails;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sarthakgoel
 */
public class NewDonationJPanel extends javax.swing.JPanel 
{
    private JPanel displayJPanel;
    private EcoSystem system;
    private UserAccount ua;
    
    /**
     * Creates new form NewDonationJPanel
     */
    public NewDonationJPanel(JPanel displayJPanel, EcoSystem system, UserAccount account) 
    {
        initComponents();
        this.displayJPanel = displayJPanel;
        this.system = system;
        this.ua = account;
        populateComboBox();
    }
    
    public void populateComboBox()
    {
        cityJComboBox.removeAllItems();
        
        for(Network network : system.getNetworkList())
        {
            cityJComboBox.addItem(network);
        }
    }
    
    public void populateTable(Network network)
    {
        DefaultTableModel model = (DefaultTableModel) charityJTable.getModel();

        model.setRowCount(0);
        
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList())
        {
            if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Charity))
            {
                Object[] row = new Object[2];
                row[0] = enterprise.getName();
                row[1] = network.getName();    
                
                model.addRow(row);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProceed = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        charityJTable = new javax.swing.JTable();
        lblCity = new javax.swing.JLabel();
        cityJComboBox = new javax.swing.JComboBox<>();
        lblTitle = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder("Make New Donation"));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProceed.setText("Proceed>>");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });
        add(btnProceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 319, -1, -1));

        charityJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Charity", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(charityJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 104, 646, 135));

        lblCity.setText("City :");
        add(lblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 63, -1, -1));

        cityJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityJComboBoxActionPerformed(evt);
            }
        });
        add(cityJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 59, -1, -1));

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblTitle.setText("DONATE FUNDS");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, -1, -1));

        lblAmount.setText("Donation Amount:");
        add(lblAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 262, -1, -1));
        add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 257, 169, -1));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 319, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cityJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityJComboBoxActionPerformed
        Network network = (Network) cityJComboBox.getSelectedItem();
        if (network != null)
        {
            populateTable(network);
        }
    }//GEN-LAST:event_cityJComboBoxActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        displayJPanel.remove(this);
        CardLayout layout = (CardLayout) displayJPanel.getLayout();
        layout.previous(displayJPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        int selectedRow = charityJTable.getSelectedRow();
        
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please Select any charity to proceed with the donation","Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        else
        {
            try
            {
                float am = Float.parseFloat(txtAmount.getText());
            
                if(txtAmount.getText() != "" || txtAmount.getText() != null)
                {
                    DonationDetails dd = system.getDonationDirectory().addDonation();
                    dd.setDonationDate(new Date());
                    dd.setCharityName(charityJTable.getValueAt(selectedRow, 0).toString());
                    dd.setCharityCity(charityJTable.getValueAt(selectedRow, 1).toString());
                    dd.setDonationAmount(txtAmount.getText());
            
                    for(DonorInfo donor : system.getDonorDir().getDonorDirectory())
                    {
                        if(donor.getUsername().equalsIgnoreCase(ua.getUsername()))
                        {
                            dd.setDonor(donor);
                        }
                    }
                
                    JOptionPane.showMessageDialog(null, "Donation amount forwarded to the charity", "Success", JOptionPane.INFORMATION_MESSAGE);
                    txtAmount.setText("");
                }
            
                else
                {
                    JOptionPane.showMessageDialog(null, " Please specify the donation amount", "Success", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Please enter the valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnProceedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProceed;
    private javax.swing.JTable charityJTable;
    private javax.swing.JComboBox<Object> cityJComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables
}
