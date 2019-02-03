/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminWorkArea;

import Buisness.EcoSystem;
import Business.Charity.Donation.DonationDetails;
import Business.Hospital.Appointment.AppointmentDetails;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sarthakgoel
 */
public class SystemAdminAnalyticsJPanel extends javax.swing.JPanel 
{
    private JPanel displayJPanel;
    private EcoSystem ecosystem;
    /**
     * Creates new form SystemAdminAnalyticsJPanel
     */
    public SystemAdminAnalyticsJPanel(JPanel displayJPanel, EcoSystem system) 
    {
        initComponents();
        this.displayJPanel = displayJPanel;
        this.ecosystem = system;
          
    }
    
    private void populateJTable(String name, float value)
    {
        DefaultTableModel model = (DefaultTableModel) displayJTable.getModel();
        model.setRowCount(0);
        
        Object[] row = new Object[2];
        row[0] = name;
        row[1] = value;
                
        model.addRow(row);
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
        btnTopDonatedCharity = new javax.swing.JButton();
        btnMostVisitedHospital = new javax.swing.JButton();
        btnTopDonor = new javax.swing.JButton();
        btnMostActivePatient = new javax.swing.JButton();
        btnMostVistedDoctor = new javax.swing.JButton();
        btnMostDonatedCharity = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayJTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder("Analytics Function"));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblTitle.setText("ANALYTICS");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 35, -1, -1));

        btnTopDonatedCharity.setText("Top Donated Charity");
        btnTopDonatedCharity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopDonatedCharityActionPerformed(evt);
            }
        });
        add(btnTopDonatedCharity, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 349, 181, -1));

        btnMostVisitedHospital.setText("Most Visited Hospital");
        btnMostVisitedHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostVisitedHospitalActionPerformed(evt);
            }
        });
        add(btnMostVisitedHospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 255, 158, -1));

        btnTopDonor.setText("Top Donor");
        btnTopDonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopDonorActionPerformed(evt);
            }
        });
        add(btnTopDonor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 302, 181, -1));

        btnMostActivePatient.setText("Most Active Patient");
        btnMostActivePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostActivePatientActionPerformed(evt);
            }
        });
        add(btnMostActivePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 302, 158, -1));

        btnMostVistedDoctor.setText("Most visited Doctor");
        btnMostVistedDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostVistedDoctorActionPerformed(evt);
            }
        });
        add(btnMostVistedDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 349, 158, -1));

        btnMostDonatedCharity.setText("Most Donated Charity");
        btnMostDonatedCharity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostDonatedCharityActionPerformed(evt);
            }
        });
        add(btnMostDonatedCharity, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 255, -1, -1));

        displayJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(displayJTable);
        if (displayJTable.getColumnModel().getColumnCount() > 0) {
            displayJTable.getColumnModel().getColumn(0).setResizable(false);
            displayJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 86, 649, 107));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnTopDonatedCharityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopDonatedCharityActionPerformed
        topCharity();
    }//GEN-LAST:event_btnTopDonatedCharityActionPerformed

    private void btnMostVisitedHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostVisitedHospitalActionPerformed
        topHospital();
    }//GEN-LAST:event_btnMostVisitedHospitalActionPerformed

    private void btnTopDonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopDonorActionPerformed
        topDonator();
    }//GEN-LAST:event_btnTopDonorActionPerformed

    private void btnMostActivePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostActivePatientActionPerformed
        topPatient();
    }//GEN-LAST:event_btnMostActivePatientActionPerformed

    private void btnMostVistedDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostVistedDoctorActionPerformed
        topDoctor();
    }//GEN-LAST:event_btnMostVistedDoctorActionPerformed

    private void btnMostDonatedCharityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostDonatedCharityActionPerformed
        mostCharity();
    }//GEN-LAST:event_btnMostDonatedCharityActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        displayJPanel.remove(this);
        CardLayout layout = (CardLayout) displayJPanel.getLayout();
        layout.previous(displayJPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void topDonator()
    {
        Map<String,Float> donator = new HashMap<String, Float>();
        for(DonationDetails d: ecosystem.getDonationDirectory().getDonationDirectory())
        {
            String name  = d.getDonor().getUsername();
            float money = 0;
        
            if(donator.containsKey(d.getDonor().getUsername()))
            {
                money = donator.get(d.getDonor().getUsername());
            }
        
            money = money + Float.parseFloat(d.getDonationAmount());
            donator.put(name, money);    
        }
        float max =0;
        String donorName = new String();
        for(String s : donator.keySet()){
            if(donator.get(s) > max){
                max = donator.get(s);
                donorName = s;
            }
        }
        
        populateJTable("Top Donor: "+donorName, max);
        //JOptionPane.showMessageDialog(null,"Top donator: "+ maxId+": Amount: " + max);
    }
    
    private void topPatient()
    {
        Map<String,Integer> patient = new HashMap<String, Integer>();
        for(AppointmentDetails a: ecosystem.getAppointmentDirectory().getAppointmentDirectory())
        {
            String name  = a.getPatient().getUsername();
            int  visit = 0;
        
            if(patient.containsKey(a.getPatient().getUsername()))
            {
                visit = patient.get(a.getPatient().getUsername());
            }
        
            visit = visit + 1;
            patient.put(name, visit);    
        }
        
        float max =0;
        String patName = new String();
        
        for(String s : patient.keySet())
        {
            if(patient.get(s) > max)
            {
                max = patient.get(s);
                patName = s;
            }
        }
        
        populateJTable("Most Active patient: "+patName, max);
        //JOptionPane.showMessageDialog(null,"Top Patient: "+ maxId+": Visits: " + max);
    }
    
    private void topHospital()
    {
        Map<String,Integer> patient = new HashMap<String, Integer>();
    
        for(AppointmentDetails a: ecosystem.getAppointmentDirectory().getAppointmentDirectory())
        {
            String name  = a.getHospitalName();
            int  visit = 0;
            if(patient.containsKey(a.getHospitalName()))
            {
                visit = patient.get(a.getHospitalName());
            }
            visit = visit + 1;
            patient.put(name, visit);    
        }
        
        float max =0;
        String hospName = new String();
    
        for(String s : patient.keySet())
        {
            if(patient.get(s) > max)
            {
                max = patient.get(s);
                hospName = s;
            }
        }
   
        populateJTable("Most Visited Hospital: "+hospName, max);
        //JOptionPane.showMessageDialog(null,"Top Hospital "+ maxId+": Visits: " + max);
    }

    private void topDoctor()
    {
        Map<String,Integer> doctor = new HashMap<String, Integer>();
        
        for(AppointmentDetails a: ecosystem.getAppointmentDirectory().getAppointmentDirectory())
        {
            String name  = a.getDoctorName();
            int  visit = 0;
            
            if(doctor.containsKey(a.getDoctorName()))
            {
                visit = doctor.get(a.getDoctorName());
            }
            
            visit = visit + 1;
            doctor.put(name, visit);    
        }
        
        float max =0;
        String docName = new String();
        for(String s : doctor.keySet())
        {
            if(doctor.get(s) > max)
            {
                max = doctor.get(s);
                docName = s;
            }
        }
        
        populateJTable("Most visted doctor: "+docName, max);
        //JOptionPane.showMessageDialog(null,"Top Doctor "+ maxId+": Visits: " + max);
    }

    private void topCharity()
    {
        Map<String,Float> charity = new HashMap<String, Float>();
        for(DonationDetails d: ecosystem.getDonationDirectory().getDonationDirectory())
        {
            String name  = d.getCharityName();
            float money = 0;
        
            if(charity.containsKey(name))
            {
                money = charity.get(name);
            }
            
            money = money + Float.parseFloat(d.getDonationAmount());
            charity.put(name, money);    
        }
        
        float max =0;
        String charityName = new String();
        for(String s : charity.keySet())
        {
            if(charity.get(s) > max){
                max = charity.get(s);
                charityName = s;
            }
        }
        
        populateJTable("Charity with maximum funds : " + charityName, max);
        //JOptionPane.showMessageDialog(null,"Top donated Charity: "+ maxId+": Amount: " + max);
    }

    private void mostCharity()
    {
        Map<String,Integer> mostCharity = new HashMap<String, Integer>();
        for(DonationDetails d: ecosystem.getDonationDirectory().getDonationDirectory())
        {
            String name  = d.getCharityName();
            int number = 0;
            if(mostCharity.containsKey(name))
            {
                number = mostCharity.get(name);
            }
            number = number + 1;
            mostCharity.put(name, number);    
        }
        
        float max =0;
        String charityName = new String();
        for(String s : mostCharity.keySet())
        {
            if(mostCharity.get(s) > max)
            {
                max = mostCharity.get(s);
                charityName = s;
            }
        }
        
        populateJTable("Mosted Funded Charity by Donors: " + charityName , max);
        //JOptionPane.showMessageDialog(null,"Top donated Charity: "+ maxId+": Amount: " + max);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMostActivePatient;
    private javax.swing.JButton btnMostDonatedCharity;
    private javax.swing.JButton btnMostVisitedHospital;
    private javax.swing.JButton btnMostVistedDoctor;
    private javax.swing.JButton btnTopDonatedCharity;
    private javax.swing.JButton btnTopDonor;
    private javax.swing.JTable displayJTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
