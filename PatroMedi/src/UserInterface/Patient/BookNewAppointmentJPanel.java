/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Patient;

import Buisness.EcoSystem;
import Buisness.Enterprise.Enterprise;
import Buisness.Network.Network;
import Buisness.Organisation.Organisation;
import Buisness.UserAccount.UserAccount;
import Buisness.UserInfo.PatientInfo;
import Buisness.WorkQueue.PatientBookedWorkQueue;
import Buisness.WorkQueue.ReceptionistAddSlotsWorkQueue;
import Buisness.WorkQueue.WorkRequest;
import Business.Hospital.Organisation.ReceptionistOrganisation;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sarthakgoel
 */
public class BookNewAppointmentJPanel extends javax.swing.JPanel 
{
    private JPanel displayJPanel;
    private EcoSystem system;
    private UserAccount account;
    private Organisation organisation;
    /**
     * Creates new form BookNewAppointmentJPanel
     */
    public BookNewAppointmentJPanel(JPanel displayJPanel,UserAccount account,Organisation organisation ,EcoSystem system) 
    {
        initComponents();
        this.displayJPanel = displayJPanel;
        this.system = system;
        this.organisation = organisation;
        this.account = account;
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
        DefaultTableModel model = (DefaultTableModel) ScheduleJTable.getModel();
        
        model.setRowCount(0);
        for(WorkRequest request :system.getPatientDir().getWorkQueue().getWorkRequestList()){
            ReceptionistAddSlotsWorkQueue t = new ReceptionistAddSlotsWorkQueue();
            t = (ReceptionistAddSlotsWorkQueue)request;
            if(network.getName().equals(t.getCity()))
            {
            Object[] row = new Object[4];
            row[0] = t;
            row[1] = t.getDoctor();
            row[2] = t.getSlot();
            row[3] = request.getStatus();
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

        lblTitle = new javax.swing.JLabel();
        cityJComboBox = new javax.swing.JComboBox<>();
        lblCity = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ScheduleJTable = new javax.swing.JTable();
        btmBook = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder("Book Doctor Appointment"));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblTitle.setText("BOOK DOCTOR APPOINTMENT");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, -1, -1));

        cityJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityJComboBoxActionPerformed(evt);
            }
        });
        add(cityJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 59, -1, -1));

        lblCity.setText("City :");
        add(lblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 63, -1, -1));

        ScheduleJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Hospital", "Doctor", "date", "test"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ScheduleJTable);
        if (ScheduleJTable.getColumnModel().getColumnCount() > 0) {
            ScheduleJTable.getColumnModel().getColumn(0).setResizable(false);
            ScheduleJTable.getColumnModel().getColumn(1).setResizable(false);
            ScheduleJTable.getColumnModel().getColumn(2).setResizable(false);
            ScheduleJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 104, 646, 135));

        btmBook.setText("Book>>");
        btmBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmBookActionPerformed(evt);
            }
        });
        add(btmBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 285, -1, -1));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 285, -1, -1));
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

    private void btmBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmBookActionPerformed
        DefaultTableModel model = (DefaultTableModel) ScheduleJTable.getModel();
        int selectedRow = ScheduleJTable.getSelectedRow();
         if (selectedRow < 0){
            return;
        }
        ReceptionistAddSlotsWorkQueue request = (ReceptionistAddSlotsWorkQueue)ScheduleJTable.getValueAt(selectedRow,0);
        if(request.getStatus().equals("Booked")){
            JOptionPane.showMessageDialog(null,"Select Valid Slot");
        }
        else{
        request.setStatus("Booked");
        Network net = (Network) cityJComboBox.getSelectedItem();
        populateTable(net);
        PatientBookedWorkQueue req = new PatientBookedWorkQueue();
            PatientInfo p = null;
            for(PatientInfo f : system.getPatientDir().getPatientDirectory()){
                if(f.getUsername().equals(account.getUsername()))
                {
                    p = f;
                    break;
                }
            }
            req.setPatient(p);
            req.setSender(account);
            req.setStatus("Booked");
            req.setCity(request.getCity());
            req.setDoctor(request.getDoctor());
            req.setHospitalName(request.getHospitalName());
            Enterprise d = null;
            for(Network n: system.getNetworkList() ){
                for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                    if(e.getName().equalsIgnoreCase(request.getHospitalName()))
                    {
                        d = e;
                        break;
                    }
                }
            }
            ReceptionistOrganisation org = null;
            for (Organisation o : d.getOrganizationDirectory().getOrganizationList()){
                if(o instanceof ReceptionistOrganisation)
                {
                    org = (ReceptionistOrganisation)o;
                    break;
                }
            }
           org.getIncomingPatients().getWorkRequestList().add(req);
            account.getWorkQueue().getWorkRequestList().add(req);
        }
        
    }//GEN-LAST:event_btmBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ScheduleJTable;
    private javax.swing.JButton btmBook;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<Object> cityJComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}