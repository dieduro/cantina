/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;
import java.awt.Component;
import java.awt.List;
import static java.lang.Integer.parseInt;
import javax.swing.DefaultListModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import programa.Conectar;
import programa.FrmListarArticulos;

/**
 *
 * @author PC07
 */
public class FrmListarRubros extends javax.swing.JInternalFrame {

    /**
     * Creates new form listarRubros
     */
    public FrmListarRubros() {
            initComponents();
           
            //capaEdit.setVisible(false);
            txt_nombre.setVisible(false);
            lbl_nombre.setVisible(false);
            btn_actualizar.setVisible(false);
            btnguardar.setVisible(false);
            llenarTablaR();
    }
    
        public final void llenarTablaR(){
         try {
            Statement st = cn.createStatement();
            DefaultTableModel modeloTabla = new DefaultTableModel();
            //creando encabea de Tabla
            modeloTabla.setColumnIdentifiers(new Object[]{"id","nombre"});
            
            Table_rubro.setModel(modeloTabla);
            
            //Consultando a la DB para llenar de DATA los campos de la TABLA
            String sql2 = "SELECT r.id, r.nombre FROM rubros r WHERE r.activo = '1'";
            ResultSet rsTabla = st.executeQuery(sql2);
            
            while (rsTabla.next()) {
               
                modeloTabla.addRow(new Object[]{rsTabla.getString("r.id"),rsTabla.getString("r.nombre")});
            } 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmListarArticulos.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_rubro = new javax.swing.JTable();
        btneditRubro = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        txt_nombre = new javax.swing.JTextField();
        btn_actualizar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        lbl_nombre = new javax.swing.JLabel();

        Table_rubro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table_rubro);

        btneditRubro.setText("Editar Rubro");
        btneditRubro.setAlignmentY(0.0F);
        btneditRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditRubroActionPerformed(evt);
            }
        });

        btn_borrar.setText("Borrar");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        lbl_nombre.setText("     Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btneditRubro, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(btn_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_actualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnguardar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(329, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btn_borrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btneditRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_actualizar)
                            .addComponent(btnguardar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnnuevo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(265, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditRubroActionPerformed
        // TODO add your handling code here:
       

        int row = Table_rubro.getSelectedRow();
        if(row>=0){
            //capaEdit.setVisible(true);
            txt_nombre.setVisible(true);
            lbl_nombre.setVisible(true);
            btn_actualizar.setVisible(true);
            
            String nombre = Table_rubro.getValueAt(row, 1).toString();
            txt_nombre.setText(nombre);
            
        }
    }//GEN-LAST:event_btneditRubroActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        int row = Table_rubro.getSelectedRow();
        String id_string =Table_rubro.getValueAt(row, 0).toString();
        int id= parseInt(id_string);
        String nombre = txt_nombre.getText();

        try {

            String sql="UPDATE rubros SET nombre = '"+nombre+"' WHERE id = '"+id+"';";

            
            Statement st = cn.prepareStatement(sql);
            int filasModificadas = st.executeUpdate(sql);
            System.out.println(filasModificadas);
        } catch (SQLException ex) {
            Logger.getLogger(FrmListarArticulos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No pudimos editar el rubro.");
        }
        JOptionPane.showMessageDialog(null, "Información de #rubro actualizada.");
        llenarTablaR();
        //capaEdit.setVisible(false);
        txt_nombre.setVisible(false);
        lbl_nombre.setVisible(false);
        btn_actualizar.setVisible(false);
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed

      int row = Table_rubro.getSelectedRow();
        if(row>=0){
        
        String id_string =Table_rubro.getValueAt(row, 0).toString();
        int id= parseInt(id_string);

         
        try {

            String sql="UPDATE rubros SET activo = 0 WHERE id = '"+id+"';";

            
            Statement st = cn.prepareStatement(sql);
            int filasModificadas = st.executeUpdate(sql);
            System.out.println(filasModificadas);
        } catch (SQLException ex) {
            Logger.getLogger(FrmListarArticulos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No pudimos eliminar el rubro.");
        }
        JOptionPane.showMessageDialog(null, "Información de rubro actualizada.");
        llenarTablaR();
        //capaEdit.setVisible(false);
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        String nombre = txt_nombre.getText();

        try {

            String sql="INSERT INTO rubros (nombre) VALUES ('"+nombre+"');";

            
            Statement st = cn.prepareStatement(sql);
            int filasModificadas = st.executeUpdate(sql);
            System.out.println(filasModificadas);
        } catch (SQLException ex) {
            Logger.getLogger(FrmListarArticulos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No pudimos insertar el rubro.");
        }
        JOptionPane.showMessageDialog(null, "Información de rubro actualizada.");
        llenarTablaR();
        //capaEdit.setVisible(false);
        txt_nombre.setVisible(false);
        lbl_nombre.setVisible(false);
        btnguardar.setVisible(false);
        
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        
        
            //capaEdit.setVisible(true);
            txt_nombre.setVisible(true);
            lbl_nombre.setVisible(true);
            btnguardar.setVisible(true);
           
                   
    }//GEN-LAST:event_btnnuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_rubro;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btneditRubro;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    Conectar cc = new Conectar();
    Connection cn = cc.conexion();
}
